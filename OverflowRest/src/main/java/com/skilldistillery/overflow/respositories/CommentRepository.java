package com.skilldistillery.overflow.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.overflow.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

//	@Query("SELECT u.comments from User u JOIN FETCH u.comments where u.id = :id")
//	public List<Comment>getCommentsforUser(@Param("id")int id);
}
