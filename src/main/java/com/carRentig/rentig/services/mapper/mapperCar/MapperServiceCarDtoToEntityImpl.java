package com.carRentig.rentig.services.mapper.mapperCar;

import com.carRentig.rentig.entity.CarEntity;
import com.carRentig.rentig.entity.UserEntity;
import com.carRentig.rentig.entity.RentEntity;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.carRentig.rentig.dto.CarDto;

@Service
public class MapperServiceCarDtoToEntityImpl implements MapperServiceCarDtoToEntity<CarDto, CarEntity>{

	@Override
	public CarEntity map(CarDto dto) {
		return new CarEntity(dto.getId(), dto.getModel(), dto.getBrand(), new ArrayList<RentEntity>(), new UserEntity());
	}

}
