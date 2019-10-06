package com.carRentig.rentig.services.rentServicePackage;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.carRentig.rentig.entity.CarEntity;
import com.carRentig.rentig.entity.RentEntity;
import com.carRentig.rentig.entity.UserEntity;
import com.carRentig.rentig.exception.NotFoundException;
import com.carRentig.rentig.repository.carRepositoryPackage.CarRepository;
import com.carRentig.rentig.repository.rentRepositoryPackage.RentRepository;
import com.carRentig.rentig.repository.userRepositoryPackage.UserRepository;

@Service
public class RentServiceImpl implements RentService{
	@Autowired RentRepository rentRepository;
	@Autowired UserRepository userRepository;
	@Autowired CarRepository carRepository;
	@Override
	public RentEntity save(Integer idUser, Integer idCar, RentEntity rentEntity) throws NotFoundException{
		UserEntity user = userRepository.findById(idUser)
				.orElseThrow(() -> new NotFoundException("El usuario con el id " + idUser + " no existe"));
		CarEntity car = carRepository.findById(idCar)
				.orElseThrow(() -> new NotFoundException("El coche con el id " + idCar + " no existe"));
		
		rentEntity.setCarEntity(car);
		rentEntity.setUserEntity(user);
		
		user.getRents().add(rentEntity);
		car.getRents().add(rentEntity);
		
		userRepository.save(user);
		carRepository.save(car);
		
		return rentRepository.save(rentEntity);
	}
	@Override
	public Page<RentEntity> findAll(Pageable pageable) {
		return rentRepository.findAll(pageable);
	}
	@Override
	public Optional<Double> profit(Integer idCar, LocalDate init, LocalDate end) throws NotFoundException {
		CarEntity car = carRepository.findById(idCar)
				.orElseThrow(() -> new NotFoundException("El coche con id " + idCar + " no existe"));
		
		List<RentEntity> rentEntities = rentRepository.findByCarEntity(car);
		Double carProfit = new Double(0.0);
		
		for(RentEntity entity : rentEntities) {
			if(entity.getInitDate().isAfter(init) && entity.getEndDate().isBefore(end)) {
				carProfit += entity.getPrice();
				System.out.println(carProfit);
			}
		}
		
		return Optional.of(carProfit);
	}

}
