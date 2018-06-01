package com.skilldistillery.overflow.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.overflow.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
