package com.skilldistillery.overflow.services;

import java.util.List;

import com.skilldistillery.overflow.entities.Address;

public interface AddressService {
	
	public List<Address> index();
	public Address show(int id);
	public Address create(Address address);
	public Address replace(Address address, int id);
	public Address update(Address address, int id);
	public boolean delete(int id);

}
