package com.carRentig.rentig.controller;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.carRentig.rentig.dto.UserDto;
import com.carRentig.rentig.exception.IllegalArgumentException;
import com.carRentig.rentig.exception.NotFoundException;
import com.carRentig.rentig.services.mapper.mapperUser.MapperServiceUserDtoToEntityImpl;
import com.carRentig.rentig.services.mapper.mapperUser.MapperServiceUserEntityToDtoImpl;
import com.carRentig.rentig.services.userServicePackage.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired private UserServiceImpl userService;
	@Autowired MapperServiceUserDtoToEntityImpl userDtoToEntity;
	@Autowired MapperServiceUserEntityToDtoImpl userEntityToDto;
	
	@GetMapping
	Page<UserDto> findAll(){
		Pageable pageableUser = PageRequest.of(0,10,Sort.Direction.ASC, "name");
		return userService.findAll(pageableUser).map(userEntityToDto::map);
	}
	
	@GetMapping("/{id}")
	public UserDto findByOne(@PathVariable("id") Integer id) throws NotFoundException {
		return userEntityToDto.map(userService.findByOne(id));
	}
	
	@PostMapping
	public UserDto create(@RequestBody @Valid UserDto userDto) throws IllegalArgumentException {
		return userEntityToDto.map(
				userService.save(
						userDtoToEntity.map(userDto)));
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("id") Integer id, @RequestBody UserDto userDto) throws IllegalArgumentException, NotFoundException {
		UserDto userDtoLocal = userEntityToDto.map(
										userService.findByOne(id));
		userDtoLocal.setName(userDto.getName());
		userService.save(
				userDtoToEntity.map(userDtoLocal));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) throws NotFoundException {
		UserDto userEntity = userEntityToDto.map(
									userService.findByOne(id));
		userService.delete(
				userDtoToEntity.map(userEntity));
	}
}
