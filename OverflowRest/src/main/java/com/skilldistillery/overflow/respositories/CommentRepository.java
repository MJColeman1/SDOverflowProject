package com.skilldistillery.overflow.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.overflow.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
