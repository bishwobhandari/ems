package com.diyo.projectems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diyo.projectems.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	

}
