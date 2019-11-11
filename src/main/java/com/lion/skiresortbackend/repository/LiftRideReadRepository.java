package com.lion.skiresortbackend.repository;


import java.util.List;

import com.lion.skiresortbackend.entity.LiftRideRead;


public interface LiftRideReadRepository {
	
	int[] batchInsert(List<LiftRideRead> liftRideReads);
	
    List<LiftRideRead> findAll();

    LiftRideRead findById(String id);
	

}
