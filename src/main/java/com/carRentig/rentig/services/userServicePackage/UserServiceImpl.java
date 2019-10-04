package com.carRentig.rentig.services.userServicePackage;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.carRentig.rentig.entity.UserEntity;
import com.carRentig.rentig.exception.IllegalArgumentException;
import com.carRentig.rentig.exception.NotFoundException;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public Page<Optional<UserEntity>> findAll(Pageable pageable) throws IllegalArgumentException{
		return null;
	}

	@Override
	public Optional<UserEntity> findByOne(Integer id) {
		return Optional.empty();
	}

	@Override
	public Optional<UserEntity> save(UserEntity userEntity) throws IllegalArgumentException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) throws NotFoundException{
		// TODO Auto-generated method stub
		
	}

}
