package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.IUserService;
import com.example.demo.entities.User;

@RestController
@RequestMapping("/api")
public class Users {

	@Autowired
	IUserService service;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> allusers()
	{
		List<User> us = service.alluser();
		return new ResponseEntity<List<User>>(us,HttpStatus.OK);
	}
}
