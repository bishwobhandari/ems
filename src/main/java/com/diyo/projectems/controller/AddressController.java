package com.diyo.projectems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diyo.projectems.entity.Address;
import com.diyo.projectems.repository.AddressRepository;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	
	@Autowired
	private AddressRepository addressRepo;
	
	
	
	@GetMapping("/all")
	public List<Address> getAllAddress(){
		return addressRepo.findAll();
	}

}
