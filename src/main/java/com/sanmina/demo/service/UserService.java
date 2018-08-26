package com.sanmina.demo.service;

import java.util.List;

import com.sanmina.demo.model.User;

public interface UserService {

	/*
	 * Guarda un usuario
	 */
	User save(User user);
	/*
	 * Recupera la lista de usuarios
	 */
	List<User> findAll();
	/*
	 * elimina un usuario
	 */
	void deleteUser(Long id);

	

}
