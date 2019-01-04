package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Film;
import com.qa.persistence.repository.FilmRepository;
import com.qa.util.JSONUtil;

public class FilmServiceImpl implements FilmService{


	@Inject
	private FilmRepository repo;
	
	@Inject
	private JSONUtil util;
	
	public String getAllFilms() {
		return repo.getAllFilms();
	}

	public String addFilm(String film) {
		Film checkFilm = util.getObjectForJSON(film, Film.class);
		if (!checkFilm.getTitle().equals("Titanic")) {
			return repo.addFilm(film);
		}
		return "{\"message\": \"film too bad to add\"}";
	}


	public String removeFilmByID(int id) {
		return repo.removeFilmByID(id);
	}

	public void setRepo(FilmRepository repo) {
		this.repo = repo;
	}
}
