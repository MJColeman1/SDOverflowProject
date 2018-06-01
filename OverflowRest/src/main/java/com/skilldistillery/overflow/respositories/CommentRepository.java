package com.skilldistillery.overflow.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.overflow.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	@Query("SELECT c FROM Comment c JOIN FETCH c.user where c.user.id = :id")
	public List<Comment> getCommentsforUser(@Param("id")int id);
	
}
