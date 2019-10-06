package com.carRentig.rentig.services.carServicePackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.carRentig.rentig.entity.CarEntity;
import com.carRentig.rentig.entity.UserEntity;
import com.carRentig.rentig.exception.NotFoundException;
import com.carRentig.rentig.exception.NotYourCarException;
import com.carRentig.rentig.repository.carRepositoryPackage.CarRepository;
import com.carRentig.rentig.repository.userRepositoryPackage.UserRepository;
import com.carRentig.rentig.services.userServicePackage.UserService;

@Service
public class CarServiceImpl implements CarService{
	@Autowired CarRepository carRepository;
	@Autowired UserRepository userRepository;
	
	@Override
	public Page<CarEntity> findAll(Pageable pageable, Integer idUser) throws IllegalArgumentException{
		UserEntity userEntity = userRepository.findById(idUser).get();
		return carRepository.findByUserEntity(pageable, userEntity);
	}

	@Override
	public CarEntity findByOne(Integer idUser, Integer id) throws NotFoundException, NotYourCarException{
		UserEntity userEntity = userRepository.findById(idUser)
				.orElseThrow(() -> new NotFoundException("El usuario con id " + idUser + " no existe"));
		
		CarEntity carEntity = carRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("El coche con id " + id + " no existe"));
		
		if(carEntity.getUserEntity() != userEntity)
				throw new NotYourCarException("El coche con id " + id + " no pertenece al usuario con id " + idUser);
		
		return carEntity;
	}
	
	

	@Override
	public CarEntity save(CarEntity car, Integer idUser) throws IllegalArgumentException, NotFoundException{
		UserEntity user = userRepository.findById(idUser)
				.orElseThrow(() -> new NotFoundException("El usuario con el id " + idUser + " no existe"));
		if(car == null) throw new IllegalArgumentException("El coche introducido no tiene valores");
		
		car.setUserEntity(user);
		user.getCars().add(car);
		userRepository.save(user);
		
		return carRepository.save(car);
	}

	@Override
	public void delete(Integer id) {
		CarEntity carEntity = carRepository.findById(id).get();
		UserEntity userEntity = userRepository.findById(carEntity.getUserEntity().getId()).get();
		
		userEntity.getCars().remove(carEntity);
		userRepository.save(userEntity);
		
		carRepository.deleteById(id);
	}

	@Override
	public CarEntity findByOne(Integer id) throws NotFoundException {
		return carRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("El coche con id " + id + " no existe"));
	}

}
