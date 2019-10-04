package com.carRentig.rentig.repository.carRepositoryPackage;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carRentig.rentig.entity.CarEntity;

public interface CarRepository extends JpaRepository<CarEntity, Integer>{

}
