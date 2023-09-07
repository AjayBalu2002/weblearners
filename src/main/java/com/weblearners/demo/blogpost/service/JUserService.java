package com.weblearners.demo.blogpost.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.weblearners.demo.blogpost.model.UserInfo;
import com.weblearners.demo.blogpost.repository.UserInfoRepository;



@Service
public class JUserService {

	@Autowired
	private UserInfoRepository repository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	    public String addUser(UserInfo userInfo) {
	    	  String email = userInfo.getEmail();
	          
	          if (repository.findByEmail(email) != null) {
	        	  return "Email already Registered ";
	          }
	        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
	        repository.save(userInfo);
	        return "User added to system. User name: " + userInfo.getName();
	     
	    }
	    
	    
	 public UserInfo getuserid(UserInfo email)
	 {
		 List<UserInfo> tempinfo = repository.findAll();
	
	
		 for(int i=0;i<tempinfo.size();i++)
		 {
			 String dummy = tempinfo.get(i).getEmail().trim();
			 if(dummy.equals(email.getEmail()))
			 {
				 return tempinfo.get(i) ;
			 }
			
		 }

return null;
	 }
	 
	 public String geththeusername(int id)
	 {
	   Optional<UserInfo> temvar = repository.findById(id);
		return temvar.get().getName();
	 }
	 
	 
	 
	 }

	   