package com.squadstack.parkinglot;

import com.squadstack.parkinglot.service.Run;
import com.squadstack.parkinglot.service.impl.ParkingSlotServiceImpl;
import com.squadstack.parkinglot.service.impl.RunImpl;
import com.squadstack.parkinglot.util.ParkingLotCommandUtil;
import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;

@AllArgsConstructor public class ParkingLotApplication {

	public static void main(String[] args) throws Exception {

		Run run = new RunImpl(new ParkingLotCommandUtil(new ParkingSlotServiceImpl()));

		System.out.println("\n\n\n\n\n");
		System.out.println("===============================================  PARKING LOT ===============================================");

		String input;
		BufferedReader bufferReader = new BufferedReader(new FileReader("./input.txt"));

		while ((input = bufferReader.readLine()) != null) {
			input = input.trim();
			run.executeApplication(input);
		}
	}
}

