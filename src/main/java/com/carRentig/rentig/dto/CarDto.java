package com.carRentig.rentig.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public final class CarDto {
	private Integer id;
	private String model;
	private String brand;
}
