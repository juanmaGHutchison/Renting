package com.carRentig.rentig.services.mapper.mapperRent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carRentig.rentig.dto.RentDto;
import com.carRentig.rentig.entity.RentEntity;
import com.carRentig.rentig.services.mapper.mapperCar.MapperServiceCarEntityToDtoImpl;
import com.carRentig.rentig.services.mapper.mapperUser.MapperServiceUserEntityToDtoImpl;

@Service
public class MapperServiceRentEntityToDtoImpl implements MapperServiceRentEntityToDto<RentEntity, RentDto>{
	@Autowired private MapperServiceUserEntityToDtoImpl userEntityToDto;
	@Autowired private MapperServiceCarEntityToDtoImpl carEntityToDto;
	
	
	@Override
	public RentDto map(RentEntity entity) {
		return new RentDto(userEntityToDto.map(entity.getUserEntity()),
				carEntityToDto.map(entity.getCarEntity()), 
				entity.getInitDate(), entity.getEndDate(), entity.getPrice());
	}
	
}
