package com.carRentig.rentig.services.mapper.mapperCar;

public interface MapperServiceCarDtoToEntity<T, R> {
	public R map(T dto);
}
