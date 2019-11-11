package com.lion.skiresortbackend.entity;


import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "Skier")
@EntityListeners(AuditingEntityListener.class)
public class Skier {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="skierid")
	int skierId;
		
	public Skier() {
	}

	public int getSkierId() {
		return skierId;
	}


	public void setSkierId(int skierId) {
		this.skierId = skierId;
	}
	
}
