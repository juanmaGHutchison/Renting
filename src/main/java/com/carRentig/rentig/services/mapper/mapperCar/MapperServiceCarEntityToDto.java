package com.carRentig.rentig.services.mapper.mapperCar;

public interface MapperServiceCarEntityToDto<T, R> {
	public R map(T entity);
}
