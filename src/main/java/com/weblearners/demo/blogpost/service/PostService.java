package com.weblearners.demo.blogpost.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.weblearners.demo.blogpost.model.CommentModel;
import com.weblearners.demo.blogpost.model.PostsModel;
import com.weblearners.demo.blogpost.repository.CommentRepository;
import com.weblearners.demo.blogpost.repository.PostsRepository;





@Service
public class PostService {

	
	  @Autowired
	    private PostsRepository postRepository;
	  
	  @Autowired
	  private CommentRepository commentRepository;
	  
	  //crudpost
	public PostsModel createposts(PostsModel post)
			{
		
				return postRepository.save(post);
	
			}
	
	public List<PostsModel> getallposts()
	{
		return postRepository.findAll();
		
	}
	
	
	public PostsModel getpostByid(Long postId)
	{
	     Optional<PostsModel> post = postRepository.findById(postId);
	        if (post.isPresent()) {
	            return post.get();
	        } else {
	            return null;
	        }
		
	}
	
	
	
	public PostsModel updatePost(Long postId,PostsModel updatedPost)
	{
        Optional<PostsModel> existingPost = postRepository.findById(postId);

	       
        if (existingPost.isPresent()) {
        	PostsModel post = existingPost.get();

post.setPost(updatedPost.getPost());


postRepository.save(post);

return  postRepository.getById(postId);
} else {
return null;

}
	}
 	
	
	  public boolean deletepost(Long postId)
	  {
	      Optional<PostsModel> post = postRepository.findById(postId);
	        if (post.isPresent()) {
	            postRepository.delete(post.get());
	            return true;
	        } else {
	            return false;
	        }
	  }
	  
	  
	  
	   public PostsModel createComment(@PathVariable Long postId, @RequestBody CommentModel comment) {
	        Optional<PostsModel> post = postRepository.findById(postId);
	        if (post.isPresent()) {
	            comment.setPost(post.get());
	            
	            post.get().getComments().add(comment);
	            postRepository.save(post.get());
	            return post.get();
	        } else {
	            return null;
	        }
	    }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  public List<CommentModel> getCommentsForPost(Long postId)
	  {
		    Optional<PostsModel> post = postRepository.findById(postId);
	        if (post.isPresent()) {
	            return post.get().getComments();
	        } else {
	            return null;
	        }
	  }
	  
	  
	  public CommentModel updateComment(Long commentId,CommentModel updatedComment)
	  {
		    Optional<CommentModel> existingComment = commentRepository.findById(commentId);
	        if (existingComment.isPresent()) {
	        	CommentModel comment = existingComment.get();
	            comment.setComment(updatedComment.getComment());
	            // Update other fields as needed
	            commentRepository.save(comment);
	            return comment;
	        } else {
	            return null;
	        }
	  }
	  
	  
	  public boolean deleteComment(Long commentId)
	  {
		   Optional<CommentModel> comment = commentRepository.findById(commentId);
	        if (comment.isPresent()) {
	            commentRepository.delete(comment.get());
	            return true;
	        } else {
	            return false;
	        }  
	  }
	  
	  
	  
	   
	  

	  
}
