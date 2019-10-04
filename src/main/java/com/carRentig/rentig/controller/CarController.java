package com.carRentig.rentig.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carRentig.rentig.dto.CarDto;
import com.carRentig.rentig.dto.UserDto;

@RestController
@RequestMapping("user/{iduser}/car")
public class CarController {
	@Autowired private CarServiceImpl carService;
	
	@GetMapping
	Page<CarDto> findAll(){
		return new PageImpl<CarDto>(new ArrayList<CarDto>());
	}
	
	@GetMapping("/{id}")
	public CarDto findByOne(@PathVariable("id") Integer id) {
		
	}
	
	@PostMapping
	public CarDto create(@RequestBody @Valid CarDto userDto) {
		return new CarDto();
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("id") Integer id, @RequestBody CarDto carDto) {
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		
	}
}
