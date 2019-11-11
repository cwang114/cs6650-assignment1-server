package com.lion.skiresortbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lion.skiresortbackend.entity.Season;


@Repository
public interface SeasonRepository extends JpaRepository<Season, Integer> {
	
	List<Season> findByResortResortId(int resortId);
}
