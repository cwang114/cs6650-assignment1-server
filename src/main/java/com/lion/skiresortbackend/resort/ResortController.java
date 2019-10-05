package com.lion.skiresortbackend.resort;

import java.net.URI;
import java.util.List;


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
import com.lion.skiresortbackend.exception.InvalidSeasonException;
import com.lion.skiresortbackend.exception.ResortNotFoundException;


@RestController
@RequestMapping(path="/resorts")
public class ResortController {
	
	@Autowired
	private ResortRepository resortRepository;
	
	final static Logger logger = LoggerFactory.getLogger(ResortController.class);
	
	@GetMapping(path="")
	public List<Resort> getResorts() {
		logger.debug("Calling getResorts()");
		return resortRepository.findAll();
	}
	
	@GetMapping("/{resortId}/seasons")
    public List<Integer> getResortSeasons(@PathVariable(value = "resortId") int resortId) {
        Resort resort = resortRepository.findResortByResortId(resortId);
        if (resort == null) {
        	throw new ResortNotFoundException("No resort id: " + resortId);
        }
        return resort.getSeasons();
        
    }
	
	@PostMapping("/{resortId}/seasons")
    public ResponseEntity<?> addSeason(@PathVariable (value = "resortId") int resortId,
                          			   @RequestBody ObjectNode season) {
		Resort resort = resortRepository.findResortByResortId(resortId);
        if (resort == null) {
        	throw new ResortNotFoundException("No resort id: " + resortId);
        }
        List<Integer> seasons = resort.getSeasons();
        if (season.get("year") == null) {
        	throw new InvalidSeasonException("Invalid request of adding season.");
        }
        int year = season.get("year").asInt();
        seasons.add(year);
        resort.setSeasons(seasons);
        URI location = ServletUriComponentsBuilder
    			.fromCurrentRequest()
    			.buildAndExpand(resort.getResortId())
    			.toUri();
        return ResponseEntity.created(location).build();
     
    }
	
	
	
	

}
