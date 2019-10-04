package com.carRentig.rentig.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carRentig.rentig.dto.RentDto;

@RestController
@RequestMapping("user/{iduser}/car/{idcar}/rent")
public class RentController {
	@Autowired private RentService rentService;
	
	@PostMapping
	public RentDto create(@RequestBody @Valid RentDto RentDto) {
		
	}
}
