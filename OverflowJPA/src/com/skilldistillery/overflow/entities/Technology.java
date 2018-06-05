package com.skilldistillery.overflow.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Technology {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String description;

	private String payscale;

	@JsonIgnore
	@ManyToMany(mappedBy = "technologies")
	private List<Profile> profiles;

	@JsonIgnore
	@ManyToMany(mappedBy = "technologies")
	private List<Employer> employers;

	public Technology() {
	}

	public Technology(int id, String name, String description, String payscale, List<Profile> profiles,
			List<Employer> employers) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.payscale = payscale;
		this.profiles = profiles;
		this.employers = employers;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPayscale() {
		return payscale;
	}

	public void setPayscale(String payscale) {
		this.payscale = payscale;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	public List<Employer> getEmployers() {
		return employers;
	}

	public void setEmployers(List<Employer> employers) {
		this.employers = employers;
	}

	@Override
	public String toString() {
		return "Technology [id=" + id + ", name=" + name + ", description=" + description + ", payscale=" + payscale
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((employers == null) ? 0 : employers.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((payscale == null) ? 0 : payscale.hashCode());
		result = prime * result + ((profiles == null) ? 0 : profiles.hashCode());
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
		Technology other = (Technology) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (employers == null) {
			if (other.employers != null)
				return false;
		} else if (!employers.equals(other.employers))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (payscale == null) {
			if (other.payscale != null)
				return false;
		} else if (!payscale.equals(other.payscale))
			return false;
		if (profiles == null) {
			if (other.profiles != null)
				return false;
		} else if (!profiles.equals(other.profiles))
			return false;
		return true;
	}
	
	

}
