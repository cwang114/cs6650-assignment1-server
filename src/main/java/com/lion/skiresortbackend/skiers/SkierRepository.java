package com.lion.skiresortbackend.skiers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lion.skiresortbackend.entity.Skier;

@Component
public class SkierRepository {
	
	List<Skier> skiers = buildFakeSkierList();
	
	public Skier findSkierById(int skierId) {
		for (Skier skier: skiers) {
			if (skier.getId() == skierId) {
				return skier;
			}
		}
		return null;
	}
	
	private List<Skier> buildFakeSkierList() {
		List<Skier> skiers = new ArrayList<>();
		skiers.add(new Skier(0, "Ana"));
		skiers.add(new Skier(1, "Mercy"));
		skiers.add(new Skier(2, "Lucio"));
		skiers.add(new Skier(3, "Zenyatta"));
		skiers.add(new Skier(4, "Baptiste"));
		skiers.add(new Skier(5, "Sigma"));
		skiers.add(new Skier(6, "D.Va"));
		skiers.add(new Skier(7, "Orisa"));
		skiers.add(new Skier(8, "Moira"));
		skiers.add(new Skier(9, "Reaper"));
		skiers.add(new Skier(10, "Hanzo"));
		return skiers;

	}
	
}
