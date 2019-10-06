package com.carRentig.rentig.services.mapper.mapperRent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carRentig.rentig.dto.RentDto;
import com.carRentig.rentig.entity.RentEntity;
import com.carRentig.rentig.services.mapper.mapperCar.MapperServiceCarDtoToEntityImpl;
import com.carRentig.rentig.services.mapper.mapperUser.MapperServiceUserDtoToEntityImpl;;

@Service
public class MapperServiceRentDtoToEntityImpl implements MapperServiceRentDtoToEntity<RentDto, RentEntity>{
	@Autowired private MapperServiceUserDtoToEntityImpl userDtoToEntity;
	@Autowired private MapperServiceCarDtoToEntityImpl carDtoToEntity;
	
	@Override
	public RentEntity map(RentDto dto) {
		return new RentEntity(null, 
				userDtoToEntity.map(dto.getUser()), 
				carDtoToEntity.map(dto.getCar()),
				dto.getInitDate(), dto.getFinalDate(), dto.getPrice());
	}

}
