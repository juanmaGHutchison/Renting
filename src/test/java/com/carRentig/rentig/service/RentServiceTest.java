package com.carRentig.rentig.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import com.carRentig.rentig.dto.ResultRentDto;
import com.carRentig.rentig.entity.CarEntity;
import com.carRentig.rentig.entity.RentEntity;
import com.carRentig.rentig.entity.UserEntity;
import com.carRentig.rentig.exception.NotFoundException;
import com.carRentig.rentig.repository.carRepositoryPackage.CarRepository;
import com.carRentig.rentig.repository.rentRepositoryPackage.RentRepository;
import com.carRentig.rentig.repository.userRepositoryPackage.UserRepository;
import com.carRentig.rentig.services.rentServicePackage.RentService;
import com.carRentig.rentig.services.rentServicePackage.RentServiceImpl;



@RunWith(MockitoJUnitRunner.class)
public class RentServiceTest {
	@InjectMocks RentService rentService = new RentServiceImpl();
	@Mock RentRepository rentRepository;
	@Mock UserRepository userRepository;
	@Mock CarRepository carRepository;
	
	private static final Integer ID_RENT1 = 1;
	private static final LocalDate INITDATE1 = LocalDate.of(2012, 12, 2);
	private static final LocalDate ENDDATE1 = LocalDate.of(2013, 2, 15);
	private static final Integer ID_RENT2 = 2;
	private static final LocalDate INITDATE2 = LocalDate.of(2016, 9, 10);
	private static final LocalDate ENDDATE2 = LocalDate.of(2017, 3, 30);
	private static final UserEntity USER1 = new UserEntity(1, "Juanito", new ArrayList<CarEntity>(), new ArrayList<RentEntity>());
	private static final UserEntity USER2 = new UserEntity(2, "Pepito", new ArrayList<CarEntity>(), new ArrayList<RentEntity>());
	private static final CarEntity CAR2 = new CarEntity(2, "Seat", "Córdoba", new ArrayList<RentEntity>(), USER1);
	
	/*
	 * public Page<RentEntity> findAll(Pageable pageable);
	 * public Optional<Double> profit(Integer idCar, LocalDate init, LocalDate end) throws NotFoundException;
	 * public Page<ResultRentDto> rentsByUser(Integer idUser, LocalDate init, LocalDate end) throws NotFoundException;
	 * public RentEntity save(Integer idUser, Integer idCar, RentEntity rentEntity) throws NotFoundException;
	 * */
	
	@Test
	public void whenRentParameterIsValidThenShouldInvokeToSaveMethodSave() throws NotFoundException {
		//GIVEN
		final RentEntity rent1 = new RentEntity(ID_RENT1, USER1, CAR2, INITDATE1, ENDDATE1, 300.0);
		//WHEN
		Mockito.when(rentRepository.save(rent1)).thenReturn(rent1);
		Mockito.when(userRepository.findById(USER1.getId())).thenReturn(Optional.of(USER1));
		Mockito.when(carRepository.findById(CAR2.getId())).thenReturn(Optional.of(CAR2));
		
		//THEN
		final RentEntity rentReturned = rentService.save(USER1.getId(), CAR2.getId(), rent1);
		
		Assert.assertEquals(rentReturned, rent1);
	}
	
	@Test(expected = NotFoundException.class)
	public void whenIDUSERDoesNotExistShouldThrowNotFoundExceptionMethodSave() throws NotFoundException {
		//GIVEN
		final RentEntity rent = new RentEntity(ID_RENT1, null, null, INITDATE1, ENDDATE1, 300.0);
		//WHEN
		Mockito.when(userRepository.findById(USER1.getId())).thenThrow(NotFoundException.class);		
		//THEN
		final RentEntity rentReturned = rentService.save(USER1.getId(), CAR2.getId(), rent);
	}
	
	@Test
	public void profitDoesNotReturnNullAndReturnsTheAddingCorrectly() throws NotFoundException {
		//GIVEN
		CarEntity CAR2 = new CarEntity(2, "Seat", "Córdoba", new ArrayList<RentEntity>(), USER1);

		final RentEntity rent = new RentEntity(ID_RENT1, USER1, CAR2, ENDDATE1, INITDATE2, 300.0);
		final RentEntity rent2 = new RentEntity(ID_RENT2, USER2, CAR2, ENDDATE1, INITDATE2, 300.0);;
		CAR2.getRents().add(rent);
		CAR2.getRents().add(rent2);
		//WHEN
		Mockito.when(rentRepository.save(rent)).thenReturn(rent);
		Mockito.when(rentRepository.save(rent2)).thenReturn(rent2);
		Mockito.when(carRepository.findById(CAR2.getId())).thenReturn(Optional.of(CAR2));
		Mockito.when(rentRepository.findByCarEntity(CAR2)).thenReturn(CAR2.getRents());
		//THEN
		Double d = rentService.profit(CAR2.getId(), INITDATE1, ENDDATE2).get();
		
		Assert.assertNotNull(d);
		Assert.assertEquals(d, new Double(600.0));
	}
	
	@Test
	public void rentsByUserShouldReturnPageOfResultRentDtoIfOK() throws NotFoundException {
		//GIVEN
		final RentEntity rent1 = new RentEntity(ID_RENT1, USER1, CAR2, ENDDATE1, INITDATE2, 300.0);
		USER1.getRents().add(rent1);
		//WHEN
		Mockito.when(userRepository.findById(USER1.getId())).thenReturn(Optional.of(USER1));
		//THEN
		Page<ResultRentDto> rr = rentService.rentsByUser(USER1.getId(), INITDATE1, ENDDATE2);
		Assert.assertEquals(rr.getTotalElements(), 1);
	}
	
	@Test
	public void rentsByUserShouldReturnPageOfResultRentDtoButEmptyBecauseOfOutOfRankDate() throws NotFoundException {
		//GIVEN
		UserEntity USER1 = new UserEntity(1, "Juanito", new ArrayList<CarEntity>(), new ArrayList<RentEntity>());
		
		final RentEntity rent1 = new RentEntity(ID_RENT1, USER1, CAR2, INITDATE1, ENDDATE1, 300.0);
		USER1.getRents().add(rent1);
		//WHEN
		Mockito.when(userRepository.findById(USER1.getId())).thenReturn(Optional.of(USER1));
		//THEN
		Page<ResultRentDto> rr = rentService.rentsByUser(USER1.getId(), INITDATE2, ENDDATE2);
		Assert.assertEquals(rr.getTotalElements(), 0);
	}
	
	
}
