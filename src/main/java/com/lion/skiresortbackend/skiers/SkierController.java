package com.lion.skiresortbackend.skiers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.LRUMap;
import com.lion.skiresortbackend.entity.LiftRide;
import com.lion.skiresortbackend.entity.Resort;
import com.lion.skiresortbackend.entity.SeasonAndVertical;
import com.lion.skiresortbackend.entity.SeasonAndVerticalWrapper;
import com.lion.skiresortbackend.entity.Skier;
import com.lion.skiresortbackend.exception.InvalidLiftRideException;
import com.lion.skiresortbackend.exception.InvalidResortNameException;
import com.lion.skiresortbackend.exception.ResortNotFoundException;
import com.lion.skiresortbackend.exception.SkierNotFoundException;
import com.lion.skiresortbackend.resort.ResortRepository;


@RestController
@RequestMapping(path="/skiers")
public class SkierController {
	
	final static Logger logger = LoggerFactory.getLogger(SkierController.class);
	
	@Autowired
	private ResortRepository resortRepository;
	@Autowired
	private SkierRepository skierRepository;
	@Autowired
	private LiftRideRepository liftRideRepository;

	/**
	 * get the total vertical for the skier for the specified ski day.
	 * @param resortId
	 * @param seasonId
	 * @param daysId
	 * @param skierId
	 * @return
	 */
	@GetMapping(path="/{resortId}/seasons/{seasonId}/days/{daysId}/skiers/{skierId}")
	public int getTotalVerticalForSkier(@PathVariable(value = "resortId") int resortId,
										@PathVariable(value = "seasonId") int seasonId,
										@PathVariable(value = "daysId") int daysId,
										@PathVariable(value = "skierId") int skierId) {
		String season = Integer.toString(seasonId);
//        Skier skier = skierRepository.findSkierById(skierId);
//        List<LiftRide> liftRides = skier.getLiftRides();
		List<LiftRide> liftRides = liftRideRepository.liftRides;
        liftRides = liftRides.stream()
        				     .filter(liftRide -> liftRide.getResortId() == resortId && 
        				     					 liftRide.getSeasonId().equals(season) && 
        				     					 liftRide.getDayId() == daysId &&
        				     					 liftRide.getSkierId() == skierId)
        				     .collect(Collectors.toList());
        int totalVert = 0;
        for (LiftRide liftRide : liftRides) {
        	totalVert += liftRide.getVertical();
        }
        return totalVert;
        
    }
	
	/**
	 * Write a new lift ride under this skier. Stores new lift ride details in the data store.
	 * @param resortId ID of the resort the skier is at
	 * @param seasonId ID of the ski season
	 * @param daysId ID number of ski day in the ski season
	 * @param skierId ID of the skier riding the lift
	 * @param liftRide
	 */
	
	@PostMapping(path="/{resortId}/seasons/{seasonId}/days/{daysId}/skiers/{skierId}")
	public ResponseEntity writeNewLiftRide(@PathVariable(value = "resortId") int resortId,
									 @PathVariable(value = "seasonId") int seasonId,
									 @PathVariable(value = "daysId") @Size(min=1, max=366)int daysId,
									 @PathVariable(value = "skierId") int skierId,
									 @RequestBody ObjectNode liftRide) {

		int time = liftRide.get("time").asInt();
		int liftId = liftRide.get("liftID").asInt();
		String season = Integer.toString(seasonId);
		LiftRide newLiftRide = new LiftRide(time, liftId, resortId, season, daysId, skierId);
		
//        Skier skier = skierRepository.findSkierById(skierId);
//        List<LiftRide> liftRides = skier.getLiftRides();
        liftRideRepository.saveLiftRide(newLiftRide);
//        skier.setLiftRides(liftRides);
        URI location = ServletUriComponentsBuilder
    			.fromCurrentRequest()
    			.buildAndExpand(skierId)
    			.toUri();
        return ResponseEntity.created(location).build();		
		
		
	}
	
	/**
	 * Get the total vertical for the skier for specified seasons at the specified resort 
	 * @param skierId
	 * @param resortName
	 * @param season
	 * @return
	 */
	
	@GetMapping(path="/{skierId}/vertical")
	public SeasonAndVerticalWrapper getSkierDayVertical(@PathVariable(value="skierId") int skierId,
									@RequestParam(name = "resort") String resortName,
									@RequestParam(name = "season", required = false) String season) {
		List<LiftRide> liftRides = liftRideRepository.liftRides;
        liftRides = liftRides.stream()
        				     .filter(liftRide -> liftRide.getSkierId() == skierId)
        				     .collect(Collectors.toList());
		if (resortName == null) {
			throw new InvalidResortNameException("The resort name is required");
		}
		Resort resort = resortRepository.findIdByResortName(resortName);
		if (resort == null) {
			throw new ResortNotFoundException("Resort Not Found");
		}
		liftRides = liftRides.stream()
							 .filter(liftRide -> liftRide.getResortId() == resort.getResortId())
							 .collect(Collectors.toList());
		
		if (season != null) {
			liftRides = liftRides.stream()
								 .filter(liftRide -> liftRide.getSeasonId().equals(season))
								 .collect(Collectors.toList());
		}
		Map<String, Integer> map = liftRides.stream()
			          						.collect(Collectors.groupingBy(liftRide -> liftRide.getSeasonId(),
			          													   Collectors.summingInt(LiftRide::getVertical)));
		List<SeasonAndVertical> resorts = map.entrySet()
			       							 .stream()
			       							 .map(e -> new SeasonAndVertical(e.getKey(), e.getValue()))
			       							 .collect(Collectors.toList());
		SeasonAndVerticalWrapper wrapper = new SeasonAndVerticalWrapper(resorts);
		return wrapper;
	}
}
