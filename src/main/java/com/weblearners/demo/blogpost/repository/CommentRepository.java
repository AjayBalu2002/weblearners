package com.weblearners.demo.blogpost.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weblearners.demo.blogpost.model.CommentModel;


public interface CommentRepository extends JpaRepository<CommentModel, Long> {

}
