package com.skilldistillery.overflow.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.overflow.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
