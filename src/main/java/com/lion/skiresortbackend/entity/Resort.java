package com.lion.skiresortbackend.entity;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Represent a single ski resort.
 * @author lion
 *
 */

public class Resort {
	
	private String resortName;
	
	@Min(0)@Max(10)
	private int resortId;
	
	@JsonIgnore
	private List<Integer> seasons;
	
	
	public Resort(String resortName, int resortId) {
		super();
		this.resortName = resortName;
		this.resortId = resortId;
		this.seasons = new ArrayList<>();
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
	public List<Integer> getSeasons() {
		return seasons;
	}
	public void setSeasons(List<Integer> seasons) {
		this.seasons = seasons;
	}
	
	
	
}
