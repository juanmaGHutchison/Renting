package com.carRentig.rentig.repository.rentRepositoryPackage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carRentig.rentig.entity.CarEntity;
import com.carRentig.rentig.entity.RentEntity;

public interface RentRepository extends JpaRepository<RentEntity, Integer>{
	List<RentEntity> findByCarEntity(CarEntity car);
}
