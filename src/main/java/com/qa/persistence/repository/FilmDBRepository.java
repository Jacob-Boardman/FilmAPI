package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.business.service.FilmService;
import com.qa.persistence.domain.Film;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class FilmDBRepository implements FilmRepository{

	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	
	public String getAllFilms() {
		Query query = manager.createQuery("SELECT a FROM Film a");
		@SuppressWarnings("unchecked")
		Collection<Film> films = (Collection<Film>) query.getResultList();
		return util.getJSONForObject(films);
	}

	@Transactional(REQUIRED)
	public String addFilm(String film) {
		Film newFilm = util.getObjectForJSON(film, Film.class);
		manager.persist(newFilm);
		
		return "{\"message\": \"film added\"}";
	}

	
	@Transactional(REQUIRED)
	public String removeFilmByID(int id) {
		Film f = findFilm(id);
		 if (f != null) {
			 manager.remove(f);
			 return "{\"message\": \"film removed\"}"; 
		 }
		 return "{\"message\": \"film not found\"}";
	}

	private Film findFilm(int id) {
		
		return manager.find(Film.class, id);
	}


}
