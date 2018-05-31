package com.skilldistillery.overflow.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="comment_vote")
public class CommentVote {

	@EmbeddedId
	private CommentVoteKey id;
	
	private boolean vote;

	public boolean isVote() {
		return vote;
	}

	public void setVote(boolean vote) {
		this.vote = vote;
	}

	public CommentVoteKey getId() {
		return id;
	}
	
	
	
}
