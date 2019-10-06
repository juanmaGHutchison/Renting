package com.carRentig.rentig.services.rentServicePackage;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.carRentig.rentig.entity.RentEntity;
import com.carRentig.rentig.exception.NotFoundException;

public interface RentService {
	/*
	 * Method to view all rents
	 * @param pageable to define Page objects characteristics
	 * @return all rents in a paged type
	 */
	public Page<RentEntity> findAll(Pageable pageable);
	
	/*
	 * Method to calculate the profit from a car
	 * @param idCar ID from the car we want to calculate our profit
	 * @param init initial day we rent the car
	 * @param end ending day we return the car
	 * @throws NoFoundException if the ID from the car we are searching for doesn't exist in our DB
	 * @return the profit from a car in an specific date
	 */
	public Optional<Double> profit(Integer idCar, LocalDate init, LocalDate end) throws NotFoundException;
	
	/*
	 * Method that creates a new rent
	 * @param idUser user that is renting a car
	 * @param idCar car rented
	 * @param rentEntity the rent we are creating
	 * @throws NotFoundException if idUser or idCar does not exist
	 * @return if everithing is OK we return the rent we just made
	 */
	public RentEntity save(Integer idUser, Integer idCar, RentEntity rentEntity) throws NotFoundException;
}
