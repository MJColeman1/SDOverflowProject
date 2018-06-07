package com.skilldistillery.overflow.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.overflow.entities.CommentVote;

public interface CommentVoteRepository extends JpaRepository<CommentVote, Integer> {
	
	@Query("Select cv from CommentVote cv where cv.id.comment.id = :commentId AND cv.id.user.id = :userId")
	CommentVote findByCommentAndUser(@Param("commentId")int commentId, @Param("userId") int userId);
	
	@Query("Select Count(cv.vote) FROM CommentVote cv where cv.id.comment.id = :commentId AND cv.vote= :vote")
	int voteCount(@Param("commentId")int commentId, @Param("vote") boolean vote);
	
	@Modifying
	@Query("DELETE FROM CommentVote cv where cv.id.comment.id = :commentId")
	void deleteComment(@Param("commentId")int commentId);

}
