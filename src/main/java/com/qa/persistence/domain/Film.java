package com.qa.persistence.domain;

import javax.persistence.*;


@Entity
public class Film {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String title;
	private String genre;
	private String ageRating;

	
	public Film() {}
	
	public Film(String title, String genre, String ageRating) {
		setTitle(title);
		setGenre(genre);
		setAgeRating(ageRating);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAgeRating() {
		return ageRating;
	}

	public void setAgeRating(String ageRating) {
		this.ageRating = ageRating;
	}

}
