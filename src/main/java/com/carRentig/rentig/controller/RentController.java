package com.carRentig.rentig.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carRentig.rentig.dto.RentDto;
import com.carRentig.rentig.dto.ResultRentDto;

@RestController
@RequestMapping("user/{iduser}/car/{idcar}/rent")
public class RentController {
	@Autowired private RentServiceImpl rentService;
	
	@PostMapping
	public RentDto create(@RequestBody @Valid RentDto RentDto) {
		new RentDto();
	}
	
	@GetMapping
	public Page<ResultRentDto> carProfit(@RequestParam(name="init",required=false) Integer init, 
			@RequestParam(name="end",required=false) Integer end) {
		return new PageImpl<ResultRentDto>(new ArrayList<ResultRentDto>());
	}
}
