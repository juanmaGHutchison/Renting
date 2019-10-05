package com.carRentig.rentig.services.mapper.mapperUser;

public interface MapperServiceUserDtoToEntity<T, R> {
	R map(T dto);
}
