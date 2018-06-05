package com.skilldistillery.overflow.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilldistillery.overflow.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
	
	public Profile findByCohort (String cohort);
	
	@Query("SELECT u.profile FROM User u WHERE u.username = :username")
	public Profile findProfileByUserUsername(@Param("username")String username);
	
}
