package com.skilldistillery.overflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.overflow.entities.Technology;
import com.skilldistillery.overflow.respositories.TechnologyRepository;

@Service
public class TechnologyServiceImpl implements TechnologyService{

	@Autowired
	private TechnologyRepository techRepo;
	
	@Override
	public List<Technology> index() {
		return techRepo.findAll();
	}

	@Override
	public Technology findById(int techId) {
		return techRepo.findById(techId).get();
	}

	@Override
	public Technology create(Technology tech) {
		return techRepo.saveAndFlush(tech);
	}

	@Override
	public Technology update(Technology tech, int techId) {
		Technology managed = techRepo.findById(techId).get();
		managed.setName(tech.getName());
		managed.setDescription(tech.getDescription());
		managed.setPayscale(tech.getPayscale());
		
		return techRepo.saveAndFlush(managed);
	}

	@Override
	public boolean destroy(int techId) {
		Technology tech = techRepo.findById(techId).get();
		try {
			techRepo.delete(tech);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}
