package com.skilldistillery.overflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.overflow.entities.Address;
import com.skilldistillery.overflow.respositories.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepo;

	@Override
	public List<Address> index() {
		return addressRepo.findAll();
	}

	@Override
	public Address show(int id) {
		return addressRepo.findById(id).get();
	}

	@Override
	public Address create(Address address) {
		return addressRepo.saveAndFlush(address);
	}

	@Override
	public Address replace(Address address, int id) {
		try {
			Address managedAddress = addressRepo.findById(id).get();
			managedAddress.setCity(address.getCity());
			managedAddress.setCountry(address.getCountry());
			managedAddress.setState(address.getState());
			managedAddress.setStreet(address.getStreet());
			managedAddress.setStreet2(address.getStreet2());
			managedAddress.setZip(address.getZip());

			addressRepo.saveAndFlush(managedAddress);
			return managedAddress;
		} catch (Exception e) {
			e.printStackTrace();
			return address;
		}
	}

	@Override
	public Address update(Address address, int id) {
		try {
			Address managedAddress = addressRepo.findById(id).get();
			if (address.getCity() != null && !address.getCity().equals("")) {
				managedAddress.setCity(address.getCity());
			}
			if (address.getCountry() != null && !address.getCountry().equals("")) {
				managedAddress.setCountry(address.getCountry());
			}
			if (address.getState() != null && !address.getState().equals("")) {
				managedAddress.setState(address.getState());
			}
			if (address.getStreet() != null && !address.getStreet().equals("")) {
				managedAddress.setStreet(address.getStreet());
			}
			if (address.getStreet2() != null && !address.getStreet2().equals("")) {
				managedAddress.setStreet2(address.getStreet2());
			}
			if (address.getZip() != null && !address.getZip().equals("")) {
				managedAddress.setZip(address.getZip());
			}
			addressRepo.save(managedAddress);
			return managedAddress;
		} catch (Exception e) {
			e.printStackTrace();
			return address;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			addressRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
