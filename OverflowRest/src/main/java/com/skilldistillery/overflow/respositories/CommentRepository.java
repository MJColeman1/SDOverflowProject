package com.skilldistillery.overflow.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.overflow.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	@Query("SELECT c FROM Comment c WHERE c.user.id = :id")
	public List<Comment> getCommentsforUser(@Param("id") int id);
	
	@Query("SELECT c FROM Comment c WHERE c.post.id = :id")
	public List<Comment> getCommentsForPost(@Param("id") int id);
}
