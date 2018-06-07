package com.skilldistillery.overflow.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.overflow.entities.Comment;
import com.skilldistillery.overflow.entities.CommentVote;
import com.skilldistillery.overflow.entities.CommentVoteKey;
import com.skilldistillery.overflow.entities.Post;
import com.skilldistillery.overflow.entities.User;
import com.skilldistillery.overflow.respositories.CommentRepository;
import com.skilldistillery.overflow.respositories.CommentVoteRepository;
import com.skilldistillery.overflow.respositories.PostRepository;
import com.skilldistillery.overflow.respositories.UserRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired 
	private PostRepository postRepo;
	
	@Autowired
	private CommentVoteRepository cvRepo;

	@Override
	public List<Comment> getAllComments(int postId) {
		List<Comment> comments = commentRepo.getCommentsForPost(postId);
		return comments;
	}
	
	@Override
	public List<Comment> getCommentsByUserId(int userId) {
		List<Comment> comments = commentRepo.getCommentsforUser(userId);
		return comments;
	}

	@Override
	public Comment findCommentByPostId(int postId, int commentId) {
		Comment c = commentRepo.findById(commentId).get();
		if (c.getPost().getId() == postId) {
			return c;
		}
		else {
			return null;
		}
	}

	@Override
	public Comment createCommentByLoggedInUser(int postId, Comment comment, String username) {
		User u = userRepo.findByUsername(username);
		Post p = postRepo.findById(postId).get();
		comment.setUser(u);
		comment.setPost(p);
		return commentRepo.saveAndFlush(comment);
	}

	@Override
	public Comment updateCommentByLoggedInUser(int postId, Comment comment, String username, int commentId) {
		User u = userRepo.findByUsername(username);
		Post p = postRepo.findById(postId).get();
		Comment managed = commentRepo.findById(commentId).get();
		managed.setUser(u);
		managed.setPost(p);
		managed.setDescription(comment.getDescription());
		managed.setCreatedAt(comment.getCreatedAt());
		managed.setUpdatedAt(comment.getUpdatedAt());
		return commentRepo.saveAndFlush(managed);
	}

	@Override
	public boolean destroyCommentByLoggedInUser(int postId, int commentId, String username) {
		User u = userRepo.findByUsername(username);
		Post p = postRepo.findById(postId).get();
		Comment c = commentRepo.findById(commentId).get();
		c.setUser(u);
		c.setPost(p);
		try {
			commentRepo.delete(c);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public CommentVote createVote(int commentId, String username, Boolean vote) {
		Comment managedC = commentRepo.findById(commentId).get();
		User managedU = userRepo.findByUsername(username);
		CommentVoteKey cvk = new CommentVoteKey();
		cvk.setComment(managedC);
		cvk.setUser(managedU);
		
		CommentVote cv = new CommentVote();
		cv.setId(cvk);
		cv.setVote(vote);
		
		return cvRepo.saveAndFlush(cv);
	}

	@Override
	public CommentVote updateVote(int commentId, String username, Boolean vote) {
		Comment managedC = commentRepo.findById(commentId).get();
		User managedU = userRepo.findByUsername(username);
		
		CommentVote managed = cvRepo.findByCommentAndUser(managedC.getId(), managedU.getId());
		managed.setVote(vote);
		return cvRepo.saveAndFlush(managed);
	}

	@Override
	public int voteCount(int commentId, boolean vote) {
		return cvRepo.voteCount(commentId, vote);
	}
	
	public void deleteComment(int commentId) {
		cvRepo.deleteComment(commentId);
	}
	
}
