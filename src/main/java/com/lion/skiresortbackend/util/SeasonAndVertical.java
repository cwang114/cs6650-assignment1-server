package com.lion.skiresortbackend.util;

public class SeasonAndVertical {
	
	int seasonID;
	int totalVert;
	
	public SeasonAndVertical(int seasonID, int totalVert) {
		super();
		this.seasonID = seasonID;
		this.totalVert = totalVert;
	}
	
	public int getSeasonID() {
		return seasonID;
	}
	public int getTotalVert() {
		return totalVert;
	}
	public void setSeasonID(int seasonID) {
		this.seasonID = seasonID;
	}
	public void setTotalVert(int totalVert) {
		this.totalVert = totalVert;
	}
	
}
