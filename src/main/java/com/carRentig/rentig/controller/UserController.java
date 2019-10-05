package com.carRentig.rentig.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carRentig.rentig.dto.UserDto;
import com.carRentig.rentig.services.userServicePackage.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired private UserServiceImpl userService;
	
	@GetMapping
	Page<UserDto> findAll(){
		//Pageable pageableUser = 
		//userService.findAll(pageable)
		return new PageImpl<UserDto>(new ArrayList<UserDto>());
	}
	
	@GetMapping("/{id}")
	public UserDto findByOne(@PathVariable("id") Integer id) {
		return new UserDto();
	}
	
	@PostMapping
	public UserDto create(@RequestBody @Valid UserDto userDto) {
		return new UserDto();
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("id") Integer id, @RequestBody UserDto userDto) {
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		
	}
}
