package com.carRentig.rentig.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultRentDto {
	private String title;
	private LocalDate init;
	private LocalDate end;
	private Double price;
}
