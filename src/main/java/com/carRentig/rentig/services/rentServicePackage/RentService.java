package com.carRentig.rentig.services.rentServicePackage;

import java.util.Optional;

import com.carRentig.rentig.entity.RentEntity;
import com.carRentig.rentig.exception.IllegalArgumentException;

public interface RentService {
	/*
	 * Method that creates a new rent
	 * @param rentEntity the rent we are creating
	 * @throws IllegalArgumentException if rentEntity param is null
	 * @return if everithing is OK we return the rent we just made
	 */
	public Optional<RentEntity> save(RentEntity rentEntity) throws IllegalArgumentException;
}
