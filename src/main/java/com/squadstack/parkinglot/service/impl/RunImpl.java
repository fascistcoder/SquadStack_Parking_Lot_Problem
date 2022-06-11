package com.squadstack.parkinglot.service.impl;

import com.squadstack.parkinglot.service.Run;
import com.squadstack.parkinglot.util.ParkingLotCommandUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 11/06/22
 */
@AllArgsConstructor
@Service
public class RunImpl implements Run {

	private final ParkingLotCommandUtil parkingLotCommandUtil;

	@Override public void executeApplication(String input) {
		parkingLotCommandUtil.commandsOfParkingLot(input);
	}
}

