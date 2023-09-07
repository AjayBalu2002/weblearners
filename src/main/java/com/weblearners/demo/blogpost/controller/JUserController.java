package com.weblearners.demo.blogpost.controller;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weblearners.demo.blogpost.Dto.AuthRequest;
import com.weblearners.demo.blogpost.model.UserInfo;
import com.weblearners.demo.blogpost.service.JUserService;
import com.weblearners.demo.blogpost.service.JwtService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class JUserController {

	@Autowired
	private JUserService service;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/new")
	public String addNewUser(@RequestBody UserInfo userInfo) {
		userInfo.setRoles("ROLE_USER"); 
		return service.addUser(userInfo);
	}

	@GetMapping("/usernew")
//	@PreAuthorize("hasAuthority('ROLE_USER')")
	@CrossOrigin(origins = "http://localhost:3000")
	public String getUserDtoById() {
		return "Iam userr";
	}

//	@CrossOrigin(origins = "http://localhost:3000")
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/login")
	public Map<Object,Object> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getEmail());
		} else {
			throw new UsernameNotFoundException("invalid user request !");
		}

	}
	
	
	@PostMapping("/getuserid")
	public  UserInfo getuserId(@RequestBody UserInfo email)
	{
		
		
		
	return	service.getuserid(email);
		
		
	}
	
	
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/getusername/{id}")
	public String username(@PathVariable int id) {
	    return service.geththeusername(id);
	}

	
	
	
	
	
	
	
	
	
}