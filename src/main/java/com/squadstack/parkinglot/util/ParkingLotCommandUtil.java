package com.squadstack.parkinglot.util;

import com.squadstack.parkinglot.constants.Constants;
import com.squadstack.parkinglot.model.Car;
import com.squadstack.parkinglot.service.ParkingLotService;
import lombok.AllArgsConstructor;

import javax.validation.constraints.Size;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 11/06/22
 */

@AllArgsConstructor
public class ParkingLotCommandUtil {
	private final ParkingLotService parkingLotService;

	public void commandsOfParkingLot(String input) {

		String[] inputs = input.split(" ");
		String key = inputs[0];

		@Size(min = 18, message = "Minimum age required 18 to park the car as per Government Guidelines")
		int age;

		switch (key) {
			case Constants.CREATE_PARKING_LOT -> {
				int capacity = Integer.parseInt(inputs[1]);
				parkingLotService.createParkingLot(capacity);
			}

			case Constants.PARK -> {
				age = Integer.parseInt(inputs[3]);
				String registrationNo = inputs[1];
				parkingLotService.park(new Car(registrationNo, age));
			}

			case Constants.LEAVE -> {
				int slotNumber = Integer.parseInt(inputs[1]);
				parkingLotService.leave(slotNumber);
			}

			case Constants.REG_NUMBER_FOR_CARS_WITH_AGE -> {
				age = Integer.parseInt(inputs[1]);
				parkingLotService.getRegistrationNoForAge(age);
			}

			case Constants.SLOTS_NUMBER_FOR_CARS_WITH_AGE -> {
				age = Integer.parseInt(inputs[1]);
				parkingLotService.getSlotNumbersFromAge(age);
			}

			case Constants.SLOTS_NUMBER_FOR_REG_NUMBER -> parkingLotService.getSlotNoFromRegistrationNo(inputs[1]);

			default -> System.out.println("Input Command is Wrong");
		}
	}

}
