package com.carRentig.rentig.services.mapper.mapperUser;

import org.springframework.stereotype.Service;

import com.carRentig.rentig.dto.UserDto;
import com.carRentig.rentig.entity.UserEntity;

@Service
public class MapperServiceUserEntityToDtoImpl implements MapperServiceUserEntityToDto<UserEntity, UserDto>{

	@Override
	public UserDto map(UserEntity entity) {
		return new UserDto(entity.getId(), entity.getName());
	}

}
