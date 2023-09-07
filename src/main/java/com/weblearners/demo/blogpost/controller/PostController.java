package com.weblearners.demo.blogpost.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.weblearners.demo.blogpost.model.CommentModel;
import com.weblearners.demo.blogpost.model.PostsModel;
import com.weblearners.demo.blogpost.repository.CommentRepository;
import com.weblearners.demo.blogpost.repository.PostsRepository;
import com.weblearners.demo.blogpost.service.PostService;


@RestController
public class PostController {

	  @Autowired
	    private PostsRepository postRepository;
	    
	    @Autowired
	    private CommentRepository commentRepository;
	    
	    
	    

	    @Autowired
	    private PostService postservice;
	    
	    
	   
	    @CrossOrigin(origins = "http://localhost:3000")
	    @PostMapping("/posts")
	    public PostsModel createPost(@RequestBody PostsModel post) {
	        return postservice.createposts(post);
	    }

	 
	    @CrossOrigin(origins = "http://localhost:3000")
	    @GetMapping("/posts")
	    public ResponseEntity<List<PostsModel>> getAllPosts() {
	        return ResponseEntity.ok(postservice.getallposts());
	    }
	    
	 
	 

	    
	    @CrossOrigin(origins = "http://localhost:3000")
	    @GetMapping("/posts/{postId}")
	    public ResponseEntity<PostsModel> getPostById(@PathVariable Long postId) {
	    	PostsModel temppost =  postservice.getpostByid(postId);
	        if (temppost != null) {
	            return ResponseEntity.ok(temppost);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }


	    @CrossOrigin(origins = "http://localhost:3000")
	    @PutMapping("/posts/{postId}")
	    public ResponseEntity<PostsModel> updatePost(@PathVariable Long postId, @RequestBody PostsModel updatedPost) {
           
	    	PostsModel tempost = postservice.updatePost(postId, updatedPost);

	    		       
	    		        	        if (tempost != null) {
	        	
	             return ResponseEntity.ok(  tempost);
	        } else {
	            return ResponseEntity.notFound().build();
	        	
	        }
	    }

	    @CrossOrigin(origins = "http://localhost:3000")
	    @DeleteMapping("/posts/{postId}")
	    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
	        boolean tempdelete  = postservice.deletepost(postId);
	        if (tempdelete) {
	            
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    
	    @CrossOrigin(origins = "http://localhost:3000")
	    @PostMapping("/posts/{postId}/comments")
	    public ResponseEntity<PostsModel> createComment(@PathVariable Long postId, @RequestBody CommentModel comment) {
	    	PostsModel temppost = postservice.createComment(postId, comment);
	        if (temppost != null) {
	          
	            return ResponseEntity.ok(temppost);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	   
	    @CrossOrigin(origins = "http://localhost:3000")
	    @GetMapping("/posts/{postId}/comments")
	    public ResponseEntity<List<CommentModel >> getCommentsForPost(@PathVariable Long postId) {
	        List<CommentModel > tempcomment = postservice.getCommentsForPost(postId);
	        
	            return ResponseEntity.ok(tempcomment);
	        
	    }


	    @CrossOrigin(origins = "http://localhost:3000")
	    @PutMapping("/comments/{commentId}")
	    public void updateComment(@PathVariable Long commentId, @RequestBody CommentModel  updatedComment) {
	     postservice.updateComment(commentId, updatedComment);
	    
	    }

	 
	    @CrossOrigin(origins = "http://localhost:3000")
	    @DeleteMapping("/comments/{commentId}")
	    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
	        Optional<CommentModel > comment = commentRepository.findById(commentId);
	        if (comment.isPresent()) {
	            commentRepository.delete(comment.get());
	            return ResponseEntity.noContent().build();
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	}

