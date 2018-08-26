package com.sanmina.demo.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanmina.demo.model.User;
import com.sanmina.demo.service.UserService;
import com.sanmina.demo.util.RestResponse;

@RestController
public class UserController {
	
	@Autowired
	protected UserService userService;
	
	protected ObjectMapper mapper;
	
	@RequestMapping(value="/seveOrUpdate", method = RequestMethod.POST)
	public RestResponse seveOrUpdate(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException {
		
		this.mapper = new ObjectMapper();
		User user = this.mapper.readValue(userJson, User.class);
		
		if(!this.validate(user))
		{
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Llenar los campos obligatorios");
		}
		this.userService.save(user);
		return  new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
	}
	@RequestMapping(value="/getUsers", method = RequestMethod.GET)
	public List<User> gerUsers() {
		return this.userService.findAll();
	}
	@RequestMapping(value="/deleteUser", method = RequestMethod.POST)
	public void deleteUser(@RequestBody String userJson) throws Exception
	{
		this.mapper = new ObjectMapper();
		User user = this.mapper.readValue(userJson, User.class);
		
		if(user.getId()==null)
		{
			throw new Exception("El id esta nulo"); 
		}
		this.userService.deleteUser(user.getId());
	}
	private boolean validate(User user) {
		boolean isValid = true;
		
		if(stringValidate(user.getFirst_name()) == null)
		{
			isValid = false;
		}
		if(stringValidate(user.getFirst_surname()) == null)
		{
			isValid = false;
		}
		if(stringValidate(user.getAddres()) == null)
		{
			isValid = false;
		}
		return isValid;
	}
	private String stringValidate(String str)
	{
		str = str.trim();
		if(str.length()>1)
			return null;
		return str;
	}
}
