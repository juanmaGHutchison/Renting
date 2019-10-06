package com.carRentig.rentig.services.userServicePackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.carRentig.rentig.entity.UserEntity;
import com.carRentig.rentig.exception.IllegalArgumentException;
import com.carRentig.rentig.exception.NotFoundException;
import com.carRentig.rentig.repository.userRepositoryPackage.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired UserRepository userRepository;
	
	@Override
	public Page<UserEntity> findAll(Pageable pageable){
		return userRepository.findAll(pageable);
	}

	@Override
	public UserEntity findByOne(Integer id) throws NotFoundException {
		return userRepository.findById(id)
			.orElseThrow(() -> new NotFoundException("El usuario con el id " + id + " no existe"));
	}

	@Override
	public UserEntity save(UserEntity userEntity) throws IllegalArgumentException{
		if(userEntity == null) throw new IllegalArgumentException("Usuario vacío");
		return userRepository.save(userEntity);
	}

	@Override
	public void delete(Integer id){
		userRepository.deleteById(id);
	}

}
