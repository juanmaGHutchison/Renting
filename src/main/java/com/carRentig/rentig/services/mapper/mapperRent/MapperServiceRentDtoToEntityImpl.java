package com.carRentig.rentig.services.mapper.mapperRent;

import org.springframework.stereotype.Service;

import com.carRentig.rentig.dto.RentDto;
import com.carRentig.rentig.entity.RentEntity;;

@Service
public class MapperServiceRentDtoToEntityImpl implements MapperServiceRentDtoToEntity<RentDto, RentEntity>{
	@Override
	public RentEntity map(RentDto dto) {
		return new RentEntity(null, null, null, dto.getInitDate(), dto.getFinalDate(), dto.getPrice());
	}

}
