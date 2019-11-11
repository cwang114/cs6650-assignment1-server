package com.lion.skiresortbackend.stat;

import java.util.ArrayList;
import java.util.List;

public class ApiStats {
	public List<SingleEndpointStat> endpointStats;
	
	public ApiStats() {
		this.endpointStats = new ArrayList<>();
	}

	public List<SingleEndpointStat> getEndpointStats() {
		return endpointStats;
	}

	public void setEndpointStats(List<SingleEndpointStat> endpointStats) {
		this.endpointStats = endpointStats;
	}
	
	
	

}
