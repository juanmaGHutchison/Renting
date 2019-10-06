package com.carRentig.rentig.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carRentig.rentig.dto.CarDto;
import com.carRentig.rentig.entity.CarEntity;
import com.carRentig.rentig.exception.NotFoundException;
import com.carRentig.rentig.exception.NotYourCarException;
import com.carRentig.rentig.services.carServicePackage.CarServiceImpl;
import com.carRentig.rentig.services.mapper.mapperCar.MapperServiceCarDtoToEntityImpl;
import com.carRentig.rentig.services.mapper.mapperCar.MapperServiceCarEntityToDtoImpl;

@RestController
@RequestMapping("user/{iduser}/car")
public class CarController {
	@Autowired private CarServiceImpl carService;
	
	@Autowired private MapperServiceCarDtoToEntityImpl carDtoToEntity;
	@Autowired private MapperServiceCarEntityToDtoImpl carEntityToDto;
	
	@GetMapping
	Page<CarDto> findAll(@PathVariable("iduser") Integer idUser){
		Pageable carPageable = PageRequest.of(0, 10, Sort.Direction.ASC, "brand");
		
		return carService.findAll(carPageable, idUser).map(carEntityToDto::map);
	}
	
	@GetMapping("/{id}")
	public CarDto findByOne(@PathVariable("iduser") Integer idUser, @PathVariable("id") Integer id) throws NotFoundException, NotYourCarException{
		return carEntityToDto.map(carService.findByOne(idUser, id));
	}
	
	@PostMapping
	public CarDto create(@PathVariable("iduser") Integer idUser, @RequestBody @Valid CarDto carDto) throws IllegalArgumentException, NotFoundException {		
		return carEntityToDto.map(
				carService.save(
						carDtoToEntity.map(carDto), idUser)); 
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("id") Integer id, @RequestBody CarDto carDto) throws NotFoundException {
		CarEntity carEntity = carService.findByOne(id);
		carEntity.setBrand(carDto.getBrand());
		carEntity.setModel(carDto.getModel());
		
		carService.save(carEntity, carEntity.getUserEntity().getId());
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws NotFoundException {
		carService.delete(id);
	}
}
