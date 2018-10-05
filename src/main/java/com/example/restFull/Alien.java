package com.example.restFull;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alien {
	
	private int id;
	private String name;
	private int points;
	
	public Alien() {
		super();
		id = 0;
		name = "Unknown";
		points = 0;
	}
	
	public Alien(int id, String name, int points) {
		super();
		this.id = id;
		this.name = name;
		this.points = points;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
