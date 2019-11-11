package com.lion.skiresortbackend.util;

import java.util.List;

public class SeasonListWrapper {
	private List<Integer> seasons;
	
	public SeasonListWrapper(List<Integer> seasons) {
		this.seasons = seasons;
	}

	public List<Integer> getSeasons() {
		return seasons;
	}

	public void setSeasons(List<Integer> seasons) {
		this.seasons = seasons;
	}
	
	
}
