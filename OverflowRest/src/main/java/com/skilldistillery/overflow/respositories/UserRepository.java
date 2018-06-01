package com.skilldistillery.overflow.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.overflow.entities.Comment;
import com.skilldistillery.overflow.entities.Post;
import com.skilldistillery.overflow.entities.User;

public interface UserRepository extends JpaRepository <User, Integer> {

	public User findByUsername (String username);
	

	
	
	
//	@Query("SELECT u.posts from User u JOIN FETCH u.posts where u.id = :id")
//	public List<Post>getPostsForUser(@Param("id")int id);
//	
//	@Query("SELECT u.comments from User u JOIN FETCH u.comments where u.id = :id")
//	public List<Comment>getCommentsforUser(@Param("id")int id);
//	
//	@Query("SELECT u from User u where u.username = :userName")
//	public List<User>isUserNameTaken(@Param("userName") String username);
	
	
	
}
