package com.carRentig.rentig.controller;

import java.util.ArrayList;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carRentig.rentig.dto.RentDto;
import com.carRentig.rentig.dto.ResultRentDto;
import com.carRentig.rentig.services.rentServicePackage.RentServiceImpl;

@RestController
@RequestMapping("user/{iduser}/car/{idcar}/rent")
public class RentController {
	@Autowired private RentServiceImpl rentService;
	
	@PostMapping
	public RentDto create(@RequestBody @Valid RentDto RentDto) {
		return new RentDto();
	}
	
	@GetMapping
	public Optional<ResultRentDto> carProfit(@PathVariable Integer idcar, @RequestParam(name="init",required=false) Integer init, 
			@RequestParam(name="end",required=false) Integer end) {
		return Optional.empty();
	}
}
