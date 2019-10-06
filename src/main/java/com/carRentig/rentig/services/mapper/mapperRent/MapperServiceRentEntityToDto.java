package com.carRentig.rentig.services.mapper.mapperRent;

public interface MapperServiceRentEntityToDto<T, R> {
	public R map(T entity);
}
