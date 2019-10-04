package com.carRentig.rentig.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public final class CarEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final Integer id;
	private final String model;
	private final String brand;
	@OneToMany(mappedBy = "carEntity")
	private final List<RentEntity> rents;
	@ManyToOne
	private final UserEntity userEntity;
	
}
