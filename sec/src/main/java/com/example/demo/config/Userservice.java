package com.example.demo.config;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.example.demo.entities.Role;
import com.example.demo.entities.User;

import com.example.demo.repositories.IRole;
import com.example.demo.repositories.IUser;

@Service
public class Userservice implements IUserService{

	@Autowired
	IUser urepo;
	@Autowired
	PasswordEncoder passEncoder;
	@Autowired
	IRole rrepo;	
	
	
	@Autowired
	AuthenticationManager authm;
	
	@Override
	public User save(User u) {		
		System.out.println(u.getPassword());
		u.setPassword(passEncoder.encode(u.getPassword()));		
		return urepo.save(u);
	}

	@Override
	public boolean authentificat(String username, String password) {		
		Authentication authentication = authm.authenticate(new UsernamePasswordAuthenticationToken(
                username, password));
        System.out.println(authentication.toString());
        SecurityContextHolder.getContext().setAuthentication(authentication);     
        return authentication.isAuthenticated();
	}
	
	@Override
	public String authentificat2(String username, String password) {
		 
		 System.out.println("tttttttttttttttttt");
		Authentication authentication = authm.authenticate(new UsernamePasswordAuthenticationToken(
                username, password));
        System.out.println(authentication.toString());
        SecurityContextHolder.getContext().setAuthentication(authentication);
      return "connect";
	}

	@Override
	public List<User> alluser() {
		// TODO Auto-generated method stub
		return urepo.findAll();
	}

	
}
