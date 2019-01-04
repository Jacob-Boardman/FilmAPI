package com.qa.persistence.repository;

public interface ActorRepository {

	public String getAllActors();
	public String addActor(String actor);
	public String removeActor(int id);
	
	
}
