package com.carRentig.rentig.services.rentServicePackage;

import org.springframework.stereotype.Service;

import com.carRentig.rentig.entity.RentEntity;

@Service
public class RentServiceImpl implements RentService{

	@Override
	public RentEntity save(Integer idUser, Integer idCar, RentEntity rentEntity) throws IllegalArgumentException{
		return new RentEntity();
	}

}
