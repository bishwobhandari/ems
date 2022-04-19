package com.diyo.projectems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diyo.projectems.entity.User;
import com.diyo.projectems.payload.LoginRequest;
import com.diyo.projectems.payload.LoginResponse;
import com.diyo.projectems.repository.RoleRepository;
import com.diyo.projectems.repository.UserRepository;
import com.diyo.projectems.security.JwtUtils;
import com.diyo.projectems.service.UserDetailsImpl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;


	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
		System.out.println("login request received in sign in api" + loginRequest);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		


		return ResponseEntity.ok(new LoginResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername()));
	}
	
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser( @RequestBody User user) {
		if (userRepository.findByUsername(user.getUsername()) != null) {
//			return ResponseEntity
//					.badRequest()
//					.body("Error: Username is already taken!");

			return new ResponseEntity("Error", HttpStatus.BAD_REQUEST);
		}
		
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
		return ResponseEntity.ok("successfully saved!!");
		
	}


}