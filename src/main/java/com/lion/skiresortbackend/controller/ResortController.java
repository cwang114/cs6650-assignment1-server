package com.lion.skiresortbackend.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.lion.skiresortbackend.entity.Resort;
import com.lion.skiresortbackend.entity.Season;
import com.lion.skiresortbackend.exception.InvalidSeasonException;
import com.lion.skiresortbackend.exception.ResortNotFoundException;
import com.lion.skiresortbackend.repository.ResortRepository;
import com.lion.skiresortbackend.repository.SeasonRepository;
import com.lion.skiresortbackend.util.SeasonListWrapper;


@RestController
@RequestMapping(path="/resorts")
public class ResortController {
	
	@Autowired
	private ResortRepository resortRepository;
	@Autowired
	private SeasonRepository seasonRepository;
	
	final static Logger logger = LoggerFactory.getLogger(ResortController.class);
	
	@GetMapping(path="")
	public List<Resort> getResorts() {
		logger.debug("Calling getResorts()");
		List<Resort> resorts = resortRepository.findAll();
		return resorts;
	}
	
	@PostMapping(path="")
	public ResponseEntity<?> addResort(@RequestBody Resort resort) {
		resortRepository.save(resort);
		URI location = ServletUriComponentsBuilder
    			.fromCurrentRequest()
    			.buildAndExpand(resort.getResortId())
    			.toUri();
        return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/{resortId}/seasons")
    public SeasonListWrapper getResortSeasons(@PathVariable(value = "resortId") int resortId) {
        if (!resortRepository.existsById(resortId)) {
        	throw new ResortNotFoundException("No resort id: " + resortId);
        }
        List<Season> seasonList = seasonRepository.findByResortResortId(resortId);
        List<Integer> seasons = seasonList.stream().map(season -> season.getSeason()).collect(Collectors.toList());
        SeasonListWrapper seasonWrapper = new SeasonListWrapper(seasons);
        return seasonWrapper;
        
    }
	
	@PostMapping("/{resortId}/seasons")
    public ResponseEntity<?> addSeason(@PathVariable (value = "resortId") int resortId,
                          			   @RequestBody ObjectNode seasonFromRequest) {
		
        if (!resortRepository.existsById(resortId)) {
        	throw new ResortNotFoundException("No resort id: " + resortId);
        }
        if (seasonFromRequest.get("year") == null) {
        	throw new InvalidSeasonException("Invalid request of adding season.");
        }
        int year = seasonFromRequest.get("year").asInt();
        Resort resort = resortRepository.findById(resortId).get();
        Season season = new Season(year, resort);
        seasonRepository.save(season);
        URI location = ServletUriComponentsBuilder
    			.fromCurrentRequest()
    			.buildAndExpand(resortId)
    			.toUri();
        return ResponseEntity.created(location).build();
     
    }
}
