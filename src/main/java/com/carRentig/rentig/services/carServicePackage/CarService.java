package com.carRentig.rentig.services.carServicePackage;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.carRentig.rentig.entity.CarEntity;
import com.carRentig.rentig.exception.NotFoundException;
import com.carRentig.rentig.exception.NotYourCarException;

public interface CarService {
	/*
	 * Method that finds all cars froma a user
	 * @param pageable sets the number of elements and pages you want to return
	 * @param idUser ID from the user that owns the cars we are returning
	 * @throws IllegalArgumentException if pageable param is null
	 * @return a list of car entities encapsulated in a Page type
	 */
	public Page<CarEntity> findAll(Pageable pageable, Integer idUser) throws IllegalArgumentException;
	
	/*
	 * Method that finds a car search by it's ID
	 * @param idUser ID from the owners car
	 * @param id it's the ID from the car we are searching for
	 * @throws IllegalArgumentException if id param is null or negative
	 * @throws NotYourCarException if the user is not owner of the car we are searching for
	 * @return the hole car type we where searching by it's ID
	 */
	public CarEntity findByOne(final Integer idUser, final Integer id) throws NotFoundException, NotYourCarException;
	
	/*
	 * Method that finds a car search by it's ID
	 * @param id it's the ID from the car we are searching for
	 * @throws IllegalArgumentException if id param is null or negative
	 * @return the hole car type we where searching by it's ID
	 */
	public CarEntity findByOne(final Integer id) throws NotFoundException;
	
	/*
	 * Method that saves a car in a DB
	 * @param car the car we want to save in our DB
	 * @throws IllegalArgumentException if car param is null
	 * @throws NotFoundException if the users ID is null
	 * @return if everithing is ok, we return the car we saved
	 */
	public CarEntity save(final CarEntity car, final Integer idUser) throws IllegalArgumentException, NotFoundException;
	
	/*
	 * Method that deletes the car by an ID
	 * @param id the ID from the car we want to delete from our DB
	 */
	public void delete(final Integer id);
}
