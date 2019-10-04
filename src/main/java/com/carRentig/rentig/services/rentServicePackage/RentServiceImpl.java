package com.carRentig.rentig.services.rentServicePackage;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.carRentig.rentig.entity.RentEntity;

@Service
public class RentServiceImpl implements RentService{

	@Override
	public Optional<RentEntity> save(RentEntity rentEntity) throws IllegalArgumentException{
		return Optional.empty();
	}

}
