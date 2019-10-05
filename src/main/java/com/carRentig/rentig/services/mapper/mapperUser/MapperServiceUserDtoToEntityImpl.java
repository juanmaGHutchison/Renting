package com.carRentig.rentig.services.mapper.mapperUser;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.carRentig.rentig.dto.UserDto;
import com.carRentig.rentig.entity.RentEntity;
import com.carRentig.rentig.entity.CarEntity;
import com.carRentig.rentig.entity.UserEntity;

@Service
public class MapperServiceUserDtoToEntityImpl implements MapperServiceUserDtoToEntity<UserDto, UserEntity>{

	@Override
	public UserEntity map(UserDto dto) {
		return new UserEntity(dto.getId(), dto.getName(), new ArrayList<CarEntity>(), new ArrayList<RentEntity>());
	}

}
