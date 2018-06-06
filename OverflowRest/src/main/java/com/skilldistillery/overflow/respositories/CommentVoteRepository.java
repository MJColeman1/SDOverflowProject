package com.skilldistillery.overflow.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.overflow.entities.CommentVote;

public interface CommentVoteRepository extends JpaRepository<CommentVote, Integer> {
	
	@Query("Select cv from CommentVote cv where cv.id.comment.id = :commentId AND cv.id.user.id = :userId")
	CommentVote findByCommentAndUser(@Param("commentId")int commentId, @Param("userId") int userId);

}
