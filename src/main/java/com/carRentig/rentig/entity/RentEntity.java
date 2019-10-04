package com.carRentig.rentig.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public final class RentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final Integer id;
	@ManyToOne
	private final UserEntity userEntity;
	@ManyToOne
	private final CarEntity carEntity;
	
	private final LocalDate initDate;
	private final LocalDate endDate;
	private final Double price;
}
