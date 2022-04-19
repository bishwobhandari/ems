package com.diyo.projectems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diyo.projectems.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
}
