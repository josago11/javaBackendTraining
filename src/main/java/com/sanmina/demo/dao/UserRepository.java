package com.sanmina.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanmina.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@SuppressWarnings("unchecked")
	User save(User user);
}
