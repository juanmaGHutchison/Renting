package com.carRentig.rentig.repository.carRepositoryPackage;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.carRentig.rentig.entity.CarEntity;
import com.carRentig.rentig.entity.UserEntity;

public interface CarRepository extends JpaRepository<CarEntity, Integer>{
	Page<CarEntity> findByUserEntity(Pageable pageable, UserEntity userEntity);
}
