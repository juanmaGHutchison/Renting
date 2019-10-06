package com.carRentig.rentig.controller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carRentig.rentig.dto.RentDto;
import com.carRentig.rentig.exception.NotFoundException;
import com.carRentig.rentig.services.mapper.mapperRent.MapperServiceRentDtoToEntityImpl;
import com.carRentig.rentig.services.mapper.mapperRent.MapperServiceRentEntityToDtoImpl;
import com.carRentig.rentig.services.rentServicePackage.RentServiceImpl;

@RestController
@RequestMapping("/rent")
public class RentController {
	@Autowired private RentServiceImpl rentService;
	
	@Autowired private MapperServiceRentDtoToEntityImpl rentDtoToEntity;
	@Autowired private MapperServiceRentEntityToDtoImpl rentEntityToDto;
	
	@GetMapping
	public Page<RentDto> findAll(){
		Pageable pageableUser = PageRequest.of(0,10);
		return rentService.findAll(pageableUser).map(rentEntityToDto::map);
	}
	
	@PostMapping
	public RentDto create(@RequestParam(name = "iduser", required = true) Integer idUser,
			@RequestParam(name = "idcar", required = true) Integer idCar, 
			@RequestBody RentDto rentDto) throws NotFoundException {
		return rentEntityToDto.map(
				rentService.save(idUser, idCar,
						rentDtoToEntity.map(rentDto)));
	}
	
	@GetMapping("/profit/{idcar}")
	public Optional<Double> carProfit(@PathVariable("idcar") Integer idCar, 
			@RequestParam(name="init",required=true) long init, 
			@RequestParam(name="end",required=true) long end) throws NotFoundException {
		LocalDate initDate = LocalDate.ofEpochDay(init);
		LocalDate endDate = LocalDate.ofEpochDay(end);
		
		return rentService.profit(idCar, initDate, endDate);
	}
}
