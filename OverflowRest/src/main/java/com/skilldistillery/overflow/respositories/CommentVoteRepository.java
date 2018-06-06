package com.skilldistillery.overflow.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.overflow.entities.CommentVote;

public interface CommentVoteRepository extends JpaRepository<CommentVote, Integer> {

}
