package com.example.demo.config;

import java.util.List;

import com.example.demo.entities.User;

public interface IUserService {

	public User save(User u);
	public boolean authentificat(String username, String password);
	public List<User> alluser();
	public String authentificat2(String username, String password);

	
	
}
