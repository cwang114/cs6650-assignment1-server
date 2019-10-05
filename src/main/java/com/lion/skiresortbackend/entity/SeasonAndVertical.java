package com.lion.skiresortbackend.entity;

public class SeasonAndVertical {
	
	String seasonID;
	int totalVert;
	
	public SeasonAndVertical(String seasonID, int totalVert) {
		super();
		this.seasonID = seasonID;
		this.totalVert = totalVert;
	}
	
	public String getSeasonID() {
		return seasonID;
	}
	public int getTotalVert() {
		return totalVert;
	}
	public void setSeasonID(String seasonID) {
		this.seasonID = seasonID;
	}
	public void setTotalVert(int totalVert) {
		this.totalVert = totalVert;
	}
	
}
