package com.devsuperior.dspesquisa.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//THIS NOTATION MEANS THAT THE OBJECTS FROM THIS TYPE WILL BE MAPPED BY JPA
//WHEN YOU SAVE A OBJECT FROM THIS TYPE, YOU WILL SAVE A LOG IN THE DATABASE TABLE
@Entity

//NOTATION TO INFORM THE NAME OF THE TABLE GENRE IN THE DATABASE
@Table(name = "tb_record")
public class Record implements Serializable {
	private static final long serialVersionUID = 1L;

	// TO INFORM THAT IT'S AN ID
	@Id 
	// TO INFORM THAT THE ID IS SELF INCREMENTED
	// IN THE PARENTHESIS IS TO MAKE IT WORKS IN THE DATABASE "H2" AND IN POSTGRESQL
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private String name;
	private Integer age;
	private Instant moment;
	
	// INFORM THE FOREIGN KEY
	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game game;
	
	public Record() {
	}

	public Record(Long id, String name, Integer age, Instant moment, Game game) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.moment = moment;
		this.game = game;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
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
		Record other = (Record) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
