package com.carRentig.rentig.services.userServicePackage;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.carRentig.rentig.entity.UserEntity;
import com.carRentig.rentig.exception.IllegalArgumentException;
import com.carRentig.rentig.exception.NotFoundException;

public interface UserService {
	/*
	 * Method that finds al users of our system
	 * @param pageable sets the number of elements and pages you want to return
	 * @throws IllegalArgumentException if pageable param is null
	 * @return a list of user entities encapsulated in a Page type
	 */
	public Page<Optional<UserEntity>> findAll(Pageable pageable)throws IllegalArgumentException;
	
	/*
	 * Method that finds an especific user of our system by its ID
	 * @param id it's the ID from the user we are searching for
	 * @return the user we were searching by its ID
	 */
	public Optional<UserEntity> findByOne(final Integer id);
	
	/*
	 * Method that saves a user in our DB
	 * @param userEntity user we want to save in our DB
	 * @throws IllegalArgumentException if userEntity param is null
	 * @return if everything is OK we return the user we just saved else returns nothing
	 */
	public Optional<UserEntity> save(final UserEntity userEntity) throws IllegalArgumentException;
	
	/*
	 * Method that deletes a user by its ID
	 * @param id ID from the user we want to delete
	 * @throws NotFoundException if id doesn't exist
	 */
	public void delete(final Integer id) throws NotFoundException;
}
