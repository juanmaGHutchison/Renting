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

import com.carRentig.rentig.entity.CarEntity;
import com.carRentig.rentig.entity.RentEntity;
import com.carRentig.rentig.entity.UserEntity;
import com.carRentig.rentig.exception.IllegalArgumentException;
import com.carRentig.rentig.repository.rentRepositoryPackage.RentRepository;
import com.carRentig.rentig.services.rentServicePackage.RentService;
import com.carRentig.rentig.services.rentServicePackage.RentServiceImpl;



@RunWith(MockitoJUnitRunner.class)
public class RentServiceTest {
	@InjectMocks RentService rentService = new RentServiceImpl();
	@Mock RentRepository rentRepository;
	
	private static final Integer ID_RENT1 = 1;
	private static final LocalDate INITDATE1 = LocalDate.of(2012, 12, 2);
	private static final LocalDate ENDDATE1 = LocalDate.of(2013, 2, 15);
	private static final Integer ID_RENT2 = 2;
	private static final LocalDate INITDATE2 = LocalDate.of(2016, 9, 10);
	private static final LocalDate ENDDATE2 = LocalDate.of(2017, 3, 30);
	private static final UserEntity USER1 = new UserEntity(1, "Juanito", new ArrayList<CarEntity>(), new ArrayList<RentEntity>());
	private static final CarEntity CAR1 = new CarEntity(1, "Seat", "Leon", new ArrayList<RentEntity>(), USER1);
	private static final UserEntity USER2 = new UserEntity(2, "Pepito", new ArrayList<CarEntity>(), new ArrayList<RentEntity>());
	private static final CarEntity CAR2 = new CarEntity(2, "Seat", "Córdoba", new ArrayList<RentEntity>(), USER1);
	
	//public Optional<RentEntity> save(RentEntity rentEntity) throws IllegalArgumentException;
	@Test
	public void whenRentParameterIsValidThenShouldInvokeToSave() throws IllegalArgumentException {
		//GIVEN
		final RentEntity rent1 = new RentEntity(ID_RENT1, USER1, CAR2, INITDATE1, ENDDATE1, 300.0);
		//WHEN
		Mockito.when(rentRepository.save(rent1)).thenReturn(rent1);
		//THEN
		final Optional<RentEntity> rentReturned = rentService.save(rent1);
		
		Assert.assertEquals(rentReturned.get(), rent1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenRentEntityParameterIsNullShouldThrowIllegalArgumentException() throws IllegalArgumentException {
		//GIVEN
		final RentEntity rent = null;
		//WHEN
		Mockito.when(rentRepository.save(rent)).thenReturn(rent);
		//THEN
		final Optional<RentEntity> rentReturned = rentService.save(rent);
	}
}
