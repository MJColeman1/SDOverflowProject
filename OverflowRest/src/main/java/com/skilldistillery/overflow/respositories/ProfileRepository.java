package com.skilldistillery.overflow.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.overflow.entities.Post;
import com.skilldistillery.overflow.entities.Profile;
import com.skilldistillery.overflow.entities.User;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	
	public Profile findByCohort (String cohort);
	
	

}
