package com.skilldistillery.overflow.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Employer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String hiring;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "address_id")
	private Address address;

	@ManyToMany(fetch=FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinTable(name = "employer_technology", joinColumns = @JoinColumn(name = "employer_id"), inverseJoinColumns = @JoinColumn(name = "technology_id"))
	private List<Technology> technologies;

	public Employer() {
	}

	public Employer(int id, String name, String hiring, Address address, List<Technology> technologies) {
		super();
		this.id = id;
		this.name = name;
		this.hiring = hiring;
		this.address = address;
		this.technologies = technologies;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHiring() {
		return hiring;
	}

	public void setHiring(String hiring) {
		this.hiring = hiring;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Technology> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<Technology> technologies) {
		this.technologies = technologies;
	}

	@Override
	public String toString() {
		return "Employer [id=" + id + ", name=" + name + ", hiring=" + hiring + ", address=" + address + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((hiring == null) ? 0 : hiring.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((technologies == null) ? 0 : technologies.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employer other = (Employer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (hiring == null) {
			if (other.hiring != null)
				return false;
		} else if (!hiring.equals(other.hiring))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (technologies == null) {
			if (other.technologies != null)
				return false;
		} else if (!technologies.equals(other.technologies))
			return false;
		return true;
	}

	public void addTechnology(Technology technology) {
		if (technologies == null)
			technologies = new ArrayList<>();
		if (!technologies.contains(technology)) {
			technologies.add(technology);
		}
	}

	public void deleteTechnology(Technology technology) {
		if (technologies != null) {
			technologies.remove(technology);
		}
	}
}
