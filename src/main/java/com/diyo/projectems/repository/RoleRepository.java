package com.diyo.projectems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diyo.projectems.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{ 

	Role findByName(String name);
}
