package com.squadstack.parkinglot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 11/06/22
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {

	@Size(min = 13, max = 13)
	private String registrationNo;

	@Size(min = 18, message = "Minimum age required 18 to park the car as per Government Guidelines")
	private int age;
}
