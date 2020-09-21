package com.devsuperior.dspesquisa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// THIS NOTATION MEANS THAT THE OBJECTS FROM THIS TYPE WILL BE MAPPED BY JPA
// WHEN YOU SAVE A OBJECT FROM THIS TYPE, YOU WILL SAVE A LOG IN THE DATABASE TABLE
@Entity

// NOTATION TO INFORM THE NAME OF THE TABLE GENRE IN THE DATABASE
@Table(name = "tb_genre")
public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// TO INFORM THAT IT'S AN ID
	@Id 
	// TO INFORM THAT THE ID IS SELF INCREMENTED
	// IN THE PARENTHESIS IS TO MAKE IT WORKS IN THE DATABASE "H2" AND IN POSTGRESQL
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String name;
	
	// TO INFORM THE "BACK" FOREING KEY 
	@OneToMany(mappedBy = "genre")
	private List<Game> games = new ArrayList<>();
	
	public Genre() {
	}

	public Genre(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Game> getGames() {
		return games;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Genre other = (Genre) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
