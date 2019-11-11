package com.lion.skiresortbackend.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lion.skiresortbackend.stat.ApiStats;
import com.lion.skiresortbackend.stat.SingleEndpointStat;
import com.lion.skiresortbackend.stat.Stat;
import com.lion.skiresortbackend.stat.URLInfo;

@RestController
@RequestMapping(path="/statistics")
public class StatisticController {
	
	final static Logger logger = LoggerFactory.getLogger(StatisticController.class);
	Map<URLInfo, Stat> statMap = new HashMap<>();
	
	@GetMapping(path="")
	public ApiStats getStatistics() {
		ApiStats apiStats = new ApiStats();
		for (URLInfo urlInfo: statMap.keySet()) {
			Stat stat = statMap.get(urlInfo);
			apiStats.endpointStats.add(
					new SingleEndpointStat(urlInfo.getUrl(), 
										   urlInfo.getOperation(), 
										   stat.getMean(), 
										   stat.getMax()));
		}
		return apiStats;
		
	}


}
