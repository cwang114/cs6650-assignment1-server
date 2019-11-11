package com.lion.skiresortbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


/**
 * Represents a single lift ride information.
 * @author lion
 *
 */

@Entity
@Table(name = "liftrideread")
@EntityListeners(AuditingEntityListener.class)

public class LiftRideRead {

	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="liftid")
	private int liftId;

	@Column(name="timeinmin")
	private int time;
	
	@Column(name="vertical")
	private int vertical;
	
	
	public LiftRideRead() {
		
	}


	public LiftRideRead(int resortId, int season, int dayId, int skierId, int liftId, int time) {
		super();
		this.id = formLiftRideReadStringId(resortId, season, dayId, skierId);
		this.liftId = liftId;
		this.time = time;
		this.vertical = liftId * 10;
	}
	
	public LiftRideRead(String id, int liftId, int time, int vertical) {
		this.id = id;
		this.liftId = liftId;
		this.time = time;
		this.vertical = vertical;
	}


	private String formLiftRideReadStringId(int resortId, int season, int dayId, int skierId) {
		return resortId + "-" + season + "-" + dayId + "-" + skierId;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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
