package com.example.restFull;

import java.util.ArrayList;
import java.util.List;

public class AlienRepository {
	
	List<Alien> aliens;

	public AlienRepository() {
		super();
		aliens = new ArrayList<>();
		
		Alien a1 = new Alien();
		a1.setId(1);
		a1.setName("A1");
		a1.setPoints(60);

		Alien a2 = new Alien();
		a2.setId(2);
		a2.setName("A2");
		a2.setPoints(70);
		
		aliens.add(a1);
		aliens.add(a2);
	}
	
	public List<Alien> getAliens(){
		return aliens;
	}
	
	public Alien getAlien(int id) {
		
		for(Alien alien : aliens) {
			if(alien.getId()==id) {
				return alien;
			}
		}
		
		return null;
	}

	public void createAlien(Alien a1) {
		aliens.add(a1);
	}
	
}
