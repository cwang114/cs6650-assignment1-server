package com.lion.skiresortbackend.skiers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lion.skiresortbackend.entity.LiftRide;

@Component
public class LiftRideRepository {
	List<LiftRide> liftRides = new ArrayList<>();
	
	public void saveLiftRide(LiftRide liftRide) {
		liftRides.add(liftRide);
	}
	

}
