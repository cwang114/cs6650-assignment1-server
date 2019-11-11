package com.lion.skiresortbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lion.skiresortbackend.entity.Skier;

@Repository
public interface SkierRepository extends JpaRepository<Skier, Integer> {
	
}
