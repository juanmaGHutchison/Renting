package com.carRentig.rentig.services.mapper.mapperCar;

import org.springframework.stereotype.Service;

import com.carRentig.rentig.dto.CarDto;
import com.carRentig.rentig.entity.CarEntity;

@Service
public class MapperServiceCarEntityToDtoImpl implements MapperServiceCarEntityToDto<CarEntity, CarDto>{

	@Override
	public CarDto map(CarEntity entity) {
		return new CarDto(entity.getId(), entity.getModel(), entity.getBrand());
	}

}
