package com.squadstack.parkinglot.service;

import com.squadstack.parkinglot.model.Car;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 11/06/22
 */
public interface ParkingLotService {
	void createParkingLot(int capacity);

	void park(Car car);

	void leave(int slotNumber);

	void getRegistrationNoForAge(int age);

	void getSlotNumbersFromAge(int age);

	void getSlotNoFromRegistrationNo(String registrationNo);
}
