package com.carRentig.rentig.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public final class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private final Integer id;
	private final String name;
	@OneToMany(mappedBy = "userEntity")
	private final List<CarEntity> cars;
	@OneToMany(mappedBy = "userEntity")
	private final List<RentEntity> rents;
}
