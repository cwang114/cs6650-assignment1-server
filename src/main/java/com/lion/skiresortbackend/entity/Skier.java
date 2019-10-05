package com.lion.skiresortbackend.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Skier {
	int id;
	String username;
	
	@JsonIgnore
	List<LiftRide> liftRides;
	
	
	public Skier() {
		super();
	}

	public Skier(int id, String username) {
		super();
		this.id = id;
		this.username = username;
		this.liftRides = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public List<LiftRide> getLiftRides() {
		return liftRides;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLiftRides(List<LiftRide> liftRides) {
		this.liftRides = liftRides;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}	
}
