package com.lion.skiresortbackend.resort;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.lion.skiresortbackend.entity.Resort;

@Component
public class ResortRepository {
	
	List<Resort> resorts = buildFakeResortList();
	
	public List<Resort> findAll() {
		return resorts;
	}
	
	public Resort findResortByResortId(int resortId) {
		for (Resort resort: resorts) {
			if (resort.getResortId() == resortId) {
				return resort;
			}
		}
		return null;
	}
	
	public Resort findIdByResortName(String resortName ) {
		for (Resort resort: resorts) {
			if (resort.getResortName().equals(resortName)) {
				return resort;
			}
		}
		return null;
	}
	
	
	private List<Resort> buildFakeResortList() {
		List<Resort> resorts = new ArrayList<>();
		resorts.add(new Resort("Bulbasaur", 0));
		resorts.add(new Resort("Charmander", 1));
		resorts.add(new Resort("Squirtle", 2));
		resorts.add(new Resort("Pikachu", 3));
		resorts.add(new Resort("Riolu", 4));
		resorts.add(new Resort("Zubat", 5));
		resorts.add(new Resort("Charizard", 6));
		resorts.add(new Resort("Slakoth", 7));
		resorts.add(new Resort("Regirock", 8));
		resorts.add(new Resort("Registeel", 9));
		resorts.add(new Resort("Regiice", 10));
		return resorts;
	}

}
