package com.carRentig.rentig.services.carServicePackage;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.carRentig.rentig.entity.CarEntity;
import com.carRentig.rentig.exception.NotFoundException;

public interface CarService {
	/*
	 * Method that finds all cars
	 * @param pageable sets the number of elements and pages you want to return
	 * @throws IllegalArgumentException if pageable param is null
	 * @return a list of car entities encapsulated in a Page type
	 */
	public Page<Optional<CarEntity>> findAll(Pageable pageable) throws IllegalArgumentException;
	
	/*
	 * Method that finds a car search by it's ID
	 * @param id it's the ID from the car we are searching for
	 * @throws IllegalArgumentException if id param is null or negative
	 * @return the hole car type we where searching by it's ID
	 */
	public Optional<CarEntity> findByOne(final Integer id) throws IllegalArgumentException;
	
	/*
	 * Method that saves a car in a DB
	 * @param car the car we want to save in our DB
	 * @throws IllegalArgumentException if car param is null
	 * @return if everithing is ok, we return the car we saved
	 */
	public Optional<CarEntity> save(final CarEntity car)throws IllegalArgumentException;
	
	/*
	 * Method that deletes the car by an ID
	 * @param id the ID from the car we want to delete from our DB
	 * @throws NotFoundException if ID doesn't exist
	 */
	public void delete(final Integer id) throws NotFoundException;
}
