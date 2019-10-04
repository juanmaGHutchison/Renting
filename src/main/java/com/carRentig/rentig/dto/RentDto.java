package com.carRentig.rentig.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class RentDto {
	private UserDto user;
	private CarDto car;
	private LocalDate initDate;
	private LocalDate finalDate;
	private Double price;
}
