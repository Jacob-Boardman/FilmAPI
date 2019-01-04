package com.qa.persistence.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Actor {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	private String firstName;
	private String secondName;
	@Size(min = 1, max = 95)
	private int age;
	
	public Actor() {}

	public Actor(String firstName, String secondName, int age) {
		
		setFirstName(firstName);
		setSecondName(secondName);
		setAge(age);
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
