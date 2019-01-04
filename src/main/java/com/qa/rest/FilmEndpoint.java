package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.qa.business.service.FilmService;

@Path ("/film")
public class FilmEndpoint {

	@Inject FilmService service;	
	
	@Path ("/getAllFilms")
	@GET
	@Produces({ "application/json" })
	public String getAllFilms() {
		return service.getAllFilms();
	}
	
	@Path ("/addFilm")
	@POST
	@Produces({ "application/json" })
	public String addFilm(String film) {
		return service.addFilm(film);
	}
	

	@Path ("/removeFilmByID/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String removeFilmByID(@PathParam("id") int id) {
		return service.removeFilmByID(id);
	}
	
	public void setService(FilmService service) {
		this.service = service;
	}
	
	
}
