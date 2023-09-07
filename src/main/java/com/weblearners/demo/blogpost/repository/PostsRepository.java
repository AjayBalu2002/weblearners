package com.weblearners.demo.blogpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weblearners.demo.blogpost.model.PostsModel;



public interface PostsRepository extends JpaRepository<PostsModel, Long>{

}
