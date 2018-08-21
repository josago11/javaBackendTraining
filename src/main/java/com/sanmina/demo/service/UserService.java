package com.sanmina.demo.service;

import java.util.List;

import com.sanmina.demo.model.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

	

}
