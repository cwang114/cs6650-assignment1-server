package com.lion.skiresortbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Represent a single ski resort.
 * @author lion
 *
 */
@Entity
@Table(name = "Resort")
@EntityListeners(AuditingEntityListener.class)
public class Resort {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="resortid")
	private int resortId;
	
	@Column(name="resortname")
	private String resortName;
	
	public Resort() {
	}
	
	public Resort(String resortName) {
		super();
		this.resortName = resortName;
	}
	
	public String getResortName() {
		return resortName;
	}
	public int getResortId() {
		return resortId;
	}
	public void setResortName(String resortName) {
		this.resortName = resortName;
	}
	public void setResortId(int resortId) {
		this.resortId = resortId;
	}
	
	
}
