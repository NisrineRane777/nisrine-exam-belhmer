package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.IUserService;
import com.example.demo.entities.User;


@RestController
@RequestMapping("/auth")
public class Auth {

	@Autowired
	IUserService service;
	
	
	@PostMapping("/users")
	public User adduser(@RequestBody User u)
	{
		System.err.println("*******"+u.getUsername()+"----"+u.getPassword());
		return service.save(u);
	}
}
