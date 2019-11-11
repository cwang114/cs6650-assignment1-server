package com.lion.skiresortbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "liftridewrite")
@EntityListeners(AuditingEntityListener.class)
public class LiftRideWrite {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	Integer id;
	
	@Column(name="resortid")
	int resortId;
	
	@Column(name="season")
	int season; 
	
	@Column(name="dayid")
	int dayId; 
	
	@Column(name="skierid")
	int skierId;
	
	@Column(name="liftid")
	private int liftId;

	@Column(name="timeinmin")
	private int time;
	
	@Column(name="vertical")
	private int vertical;
	

	public LiftRideWrite() {
		super();
	}

	public LiftRideWrite(int resortId, int season, int dayId, int skierId, int liftId, int time) {
		super();
		this.resortId = resortId;
		this.season = season;
		this.dayId = dayId;
		this.skierId = skierId;
		this.liftId = liftId;
		this.time = time;
		this.vertical = liftId * 10;
	}

	public int getResortId() {
		return resortId;
	}

	public int getSeason() {
		return season;
	}

	public int getDayId() {
		return dayId;
	}

	public int getSkierId() {
		return skierId;
	}

	public int getLiftId() {
		return liftId;
	}

	public int getTime() {
		return time;
	}

	public int getVertical() {
		return vertical;
	}

	public void setResortId(int resortId) {
		this.resortId = resortId;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public void setDayId(int dayId) {
		this.dayId = dayId;
	}

	public void setSkierId(int skierId) {
		this.skierId = skierId;
	}

	public void setLiftId(int liftId) {
		this.liftId = liftId;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void setVertical(int vertical) {
		this.vertical = vertical;
	}
	
}
