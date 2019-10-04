package com.carRentig.rentig.services.carServicePackage;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.carRentig.rentig.entity.CarEntity;
import com.carRentig.rentig.exception.NotFoundException;

@Service
public class CarServiceImpl implements CarService{

	@Override
	public Page<Optional<CarEntity>> findAll(Pageable pageable) throws IllegalArgumentException{
		return null;
	}

	@Override
	public Optional<CarEntity> findByOne(Integer id) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CarEntity> save(CarEntity car) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) throws NotFoundException{
		// TODO Auto-generated method stub
		
	}

}
