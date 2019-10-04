package com.carRentig.rentig.repository.userRepositoryPackage;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carRentig.rentig.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
