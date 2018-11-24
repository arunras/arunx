package com.arunx.security;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.arunx.security.User;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long> {
	 User findByEmail(String email);
	 User findByConfirmationToken(String confirmationToken);
}