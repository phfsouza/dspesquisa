package com.devsuperior.dspesquisa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.devsuperior.dspesquisa.entities.enums.Platform;

//THIS NOTATION MEANS THAT THE OBJECTS FROM THIS TYPE WILL BE MAPPED BY JPA
//WHEN YOU SAVE A OBJECT FROM THIS TYPE, YOU WILL SAVE A LOG IN THE DATABASE TABLE
@Entity

//NOTATION TO INFORM THE NAME OF THE TABLE GENRE IN THE DATABASE
@Table(name = "tb_game")
public class Game implements Serializable {
	private static final long serialVersionUID = 1L;

	// TO INFORM THAT IT'S AN ID
	@Id 
	// TO INFORM THAT THE ID IS SELF INCREMENTED
	// IN THE PARENTHESIS IS TO MAKE IT WORKS IN THE DATABASE "H2" AND IN POSTGRESQL
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String title;
	private Platform platform;
	
	// INFORM THE FOREIGN KEY
	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Genre genre;
	
	// TO INFORM THE "BACK" FOREING KEY 
	@OneToMany(mappedBy = "game")
	private List<Record> records = new ArrayList<>();
	
	public Game() {
	}

	public Game(Long id, String title, Platform platform, Genre genre) {
		super();
		this.id = id;
		this.title = title;
		this.platform = platform;
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public List<Record> getRecords() {
		return records;
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
		Game other = (Game) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
