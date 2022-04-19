package com.diyo.projectems.controller;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diyo.projectems.entity.Employee;
import com.diyo.projectems.repository.EmployeeRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/employee") 
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getEmpolyeeList(){
		
		
		return  new ResponseEntity<>(empRepo.findAll(), HttpStatus.OK);
	}
	
	
	//employee/1
	@GetMapping("/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable Long id) {
		Optional<Employee> emp = empRepo.findById(id);
		
		if(emp.isPresent()) {
			System.out.println(emp.get().getBirthDate());
			
			LocalDate birthDate = emp.get().getBirthDate();
			
			//convert to date object in java
			//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			//LocalDate d1  = LocalDate.parse(birthDate, formatter);
			
			
			LocalDate today = LocalDate.now();
			
			Period p = Period.between(birthDate, today);
			
			System.out.println(p);
			System.out.println(p.getDays());

			System.out.println(p.getYears());

			System.out.println(p.getMonths());
			
//			emp.get().setAge(p.getYears());

		}
		
		
//		Optional<Employee> optional = employeeRepository.findById(id);
//		Employee employee = null;
//		if (optional.isPresent()) {
//			employee = optional.get();
//		} else {
//			throw new RuntimeException(" Employee not found for id :: " + id);
//		}
//		return employee;
		
		return emp;
	}
	
	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee emp) {
		
		return empRepo.save(emp);
		
	}
	
	@PutMapping("/update")
	public Employee UpdateEmployee(@RequestBody Employee emp) {
		
		return empRepo.save(emp);
		
	}
	

}
