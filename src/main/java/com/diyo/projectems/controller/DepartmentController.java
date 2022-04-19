package com.diyo.projectems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diyo.projectems.entity.Department;
import com.diyo.projectems.repository.DepartmentRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	
	@GetMapping("/all")
	public List<Department> getAllDepartment(){
		
		return departmentRepository.findAll();
		
	}
	
	
	@PostMapping("/save")
	public Department saveDepartment(@RequestBody 
			Department department){
		System.out.println(department.toString());
		return departmentRepository.save(department);
		
	}
	
	
	
	
	

}
