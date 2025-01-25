package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Role;

public interface IRole extends JpaRepository<Role, Long>{

	public Role findByLibelle(String lib);
}
