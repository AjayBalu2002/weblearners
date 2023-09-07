package com.weblearners.demo.blogpost.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weblearners.demo.blogpost.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>  {
	
	 Optional<UserInfo> findByName(String username);
	 
	 Optional<UserInfo> findByEmailIgnoreCase(String username);
	 
	 <UserInfo> UserInfo findByEmail(String email);

	 
	  Optional<UserInfo> findById(Long id);
}

