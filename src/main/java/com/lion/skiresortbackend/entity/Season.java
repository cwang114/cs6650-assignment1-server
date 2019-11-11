package com.lion.skiresortbackend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "Season")
@EntityListeners(AuditingEntityListener.class)
public class Season {

	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="seasonid")
	private int season;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "resortid")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Resort resort;

	public Season() {
		super();
	}

	public Season(int season, Resort resort) {
		super();
		this.season = season;
		this.resort = resort;
	}

	public int getSeason() {
		return season;
	}

	public Resort getResort() {
		return resort;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public void setResort(Resort resort) {
		this.resort = resort;
	}
	
	

}
