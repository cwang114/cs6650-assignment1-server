package com.lion.skiresortbackend.repository;

import java.util.List;
import com.lion.skiresortbackend.entity.LiftRideWrite;

public interface LiftRideWriteRepository {
	
	int[] batchInsert(List<LiftRideWrite> liftRideWrites);
	List<LiftRideWrite> findBySkierIdAndResortId(int skierId, int resortId);
	List<LiftRideWrite> findBySkierIdAndResortIdAndSeason(int skierId, int resortId, int season);

}
