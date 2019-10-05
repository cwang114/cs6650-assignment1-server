package com.lion.skiresortbackend.entity;

import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Represents a single lift ride information.
 * @author lion
 *
 */
public class LiftRide {
	
	private int time;
	private int liftId;
	@JsonIgnore
	private int resortId;
	@JsonIgnore
	private String seasonId;
	@JsonIgnore
	private int dayId;
	@JsonIgnore
	private int skierId;
	@JsonIgnore
	private int vertical;
	
	
	public LiftRide() {
		super();
	}
	public LiftRide(int time, int liftId) {
		super();
		this.time = time;
		this.liftId = liftId;
	}
	public LiftRide(int time, int liftId, int resortId, String seasonId, int dayId, int skierId) {
		super();
		this.time = time;
		this.liftId = liftId;
		this.resortId = resortId;
		this.seasonId = seasonId;
		this.dayId = dayId;
		this.skierId = skierId;
		this.vertical = new Random().nextInt(500)+1;
	}
	public int getTime() {
		return time;
	}
	public int getLiftId() {
		return liftId;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public void setLiftId(int liftId) {
		this.liftId = liftId;
	}
	public int getResortId() {
		return resortId;
	}
	public String getSeasonId() {
		return seasonId;
	}
	public int getDayId() {
		return dayId;
	}
	public int getSkierId() {
		return skierId;
	}
	public void setResortId(int resortId) {
		this.resortId = resortId;
	}
	public void setSeasonId(String seasonId) {
		this.seasonId = seasonId;
	}
	public void setDayId(int dayId) {
		this.dayId = dayId;
	}
	public void setSkierId(int skierId) {
		this.skierId = skierId;
	}
	public int getVertical() {
		return vertical;
	}
	public void setVertical(int vertical) {
		this.vertical = vertical;
	}
	
	
	
	
	
}
