package com.carRentig.rentig.services.user;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
	public Page<UserEntity> findAll(Pageable pageable);
	public UserEntity findByOne(final Integer id);
	public UserEntity save(final UserEntity userEntity);
	public void delete(final Integer id);
}
