package com.skilldistillery.overflow.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.overflow.entities.User;

public interface UserRepository extends JpaRepository <User, Integer> {

	public User findByUsername (String username);

}
