package com.carRentig.rentig.services.rentServicePackage;

import com.carRentig.rentig.entity.RentEntity;
import com.carRentig.rentig.exception.IllegalArgumentException;

public interface RentService {
	/*
	 * Method that creates a new rent
	 * @param idUser user that is renting a car
	 * @param idCar car rented
	 * @param rentEntity the rent we are creating
	 * @throws IllegalArgumentException if rentEntity param is null
	 * @return if everithing is OK we return the rent we just made
	 */
	public RentEntity save(Integer idUser, Integer idCar, RentEntity rentEntity) throws IllegalArgumentException;
}
