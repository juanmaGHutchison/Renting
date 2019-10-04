package com.carRentig.rentig.service;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.carRentig.rentig.repository.rentRepositoryPackage.RentRepository;
import com.carRentig.rentig.services.rentServicePackage.RentService;

@RunWith(MockitoJUnitRunner.class)
public class RentServiceTest {
	@InjectMocks RentService rentService;
	@Mock RentRepository rentRepository;
}
