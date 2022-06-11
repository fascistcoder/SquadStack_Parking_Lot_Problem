package com.squadstack.parkinglot.service.impl;

import com.squadstack.parkinglot.model.Car;
import com.squadstack.parkinglot.service.ParkingLotService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 11/06/22
 */

@Service
public class ParkingSlotServiceImpl implements ParkingLotService {

	private ArrayList<Integer> slotsLeftInParkingLot;
	private int slotAllottedInParkingLot;
	private HashMap<Integer, Car> parkingLot = new HashMap<>();

	@Override public void createParkingLot(int capacity) {
		ArrayList<Integer> slotsInParkingLot = new ArrayList<>();

		for (int i = 1; i <= capacity; i++) {
			slotsInParkingLot.add(i);
		}

		slotsLeftInParkingLot = slotsInParkingLot;

		slotAllottedInParkingLot = capacity;

		System.out.println("Created parking of " + capacity + " slots");
	}

	@Override public void park(Car car) {

		ArrayList<Integer> totalSlotsLeftInParkingLot = slotsLeftInParkingLot;

		if (totalSlotsLeftInParkingLot.isEmpty()) {
			System.out.println("Parking Lot is full, Sorry for the inconvenience");
		} else {
			Integer parkingSlot = totalSlotsLeftInParkingLot.get(0);

			if (totalSlotsLeftInParkingLot.size() <= slotAllottedInParkingLot) {
				parkingLot.put(parkingSlot, car);
			}

			System.out.println("Car with vehicle registration number " + car.getRegistrationNo() + " has been parked at slot number " + parkingSlot);
			totalSlotsLeftInParkingLot.remove(0);
		}
	}

	@Override public void leave(int slotNumber) {
		if (parkingLot.isEmpty()) {
			return;
		}

		Car car = parkingLot.get(slotNumber);
		parkingLot.remove(slotNumber);

		System.out.println("Slot number " + slotNumber + " vacated, " + "the car with vehicle registration number " + car.getRegistrationNo()
				+ "the driver of the car was of age " + car.getAge());

		slotsLeftInParkingLot.add(slotNumber);
		Collections.sort(slotsLeftInParkingLot);
	}

	@Override public void getRegistrationNoForAge(int age) {
		if (parkingLot.isEmpty()) {
			return;
		}

		Collection<Car> allCarsInParkingLot = parkingLot.values();
		boolean flag = false;

		for (Car car : allCarsInParkingLot) {
			if (car.getAge() == age) {
				for (Map.Entry<Integer, Car> entry : parkingLot.entrySet()) {
					if (entry.getValue().equals(car)) {
						flag = true;
						System.out.println(
								"Car with vehicle registration number " + car.getRegistrationNo() + "has been parked at slot number " + entry.getKey()
										.toString());
					}
				}
			}
		}

		if(!flag){
			System.out.println("Car Not found In parking lot");
		}

	}

	@Override public void getSlotNumbersFromAge(int age) {
		if (parkingLot.isEmpty()) {
			return;
		}

		boolean flag = true;
		Collection<Car> allCarsInParkingLo = parkingLot.values();
		List<String> slotNum = new ArrayList<>();

		for (Car car : allCarsInParkingLo) {
			if (Objects.equals(car.getAge(), age)) {
				for (Map.Entry<Integer, Car> entry : parkingLot.entrySet()) {
					if (entry.getValue().equals(car)) {
						String key = entry.getKey().toString();
						slotNum.add(key);
					}
				}
			}
		}
		if (!flag) {
			System.out.print("Not found");
		} else {
			System.out.println(String.join(",", slotNum));
		}
	}

	@Override public void getSlotNoFromRegistrationNo(String registrationNo) {
		if (parkingLot.isEmpty()) {
			return;
		}

		boolean flag = false;
		Collection<Car> allCars = parkingLot.values();
		List<String> slotNum = new ArrayList<>();

		for (Car car : allCars) {
			if (car.getRegistrationNo().equals(registrationNo)) {
				for (Map.Entry<Integer, Car> entry : parkingLot.entrySet()) {
					if (entry.getValue().equals(car)) {
						flag = true;
						String key = entry.getKey().toString();
						slotNum.add(key);
					}
				}
			}
		}
		if (!flag) {
			System.out.print("Not found");
		} else {
			System.out.println(String.join(",", slotNum));
		}
	}
}

