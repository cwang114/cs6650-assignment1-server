package com.lion.skiresortbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lion.skiresortbackend.entity.Resort;

@Repository
public interface ResortRepository extends JpaRepository<Resort, Integer> {
	Optional<Resort> findByResortName(String resortName);

}
