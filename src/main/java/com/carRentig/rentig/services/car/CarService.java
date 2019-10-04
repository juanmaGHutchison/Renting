package com.carRentig.rentig.services.car;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {
	public Page<CarEntity> findAll(Pageable pageable);
	public CarEntity findByOne(final Integer id);
	public CarEntity save(final CarEntity car);
	public void delete(final Integer id);
}
