package com.weblearners.demo.blogpost.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table
public class CommentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private Long commentatorId;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "posst_id")
    @JsonBackReference
    private PostsModel post;

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Long getCommentatorId() {
		return commentatorId;
	}

	public void setCommentatorId(Long commentatorId) {
		this.commentatorId = commentatorId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public PostsModel getPost() {
		return post;
	}

	public void setPost(PostsModel post) {
		this.post = post;
	}

 
}
