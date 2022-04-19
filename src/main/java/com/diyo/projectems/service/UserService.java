package com.diyo.projectems.service;

import java.util.List;

import com.diyo.projectems.entity.Role;
import com.diyo.projectems.entity.User;

public interface UserService {
	
	User saveUser(User user);

	
	User getUser(String username);
	
	List<User> getUsers();
	

}
