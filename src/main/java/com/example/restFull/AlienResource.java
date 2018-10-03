package com.example.restFull;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {

	AlienRepository repo = new AlienRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Alien> getAliens() {
		
		System.out.println("gets calllled");
		
		return repo.getAliens();
	}
	
	@GET
	@Path("/1")
	@Produces(MediaType.APPLICATION_XML)
	public Alien getAlien() {
		
		System.out.println("gets cled");
		
		return repo.getAlien(1);
	}
	
	@POST
	@Path("alien")
	public Alien createAlien(Alien a1) {
		
		System.out.println("created");
		repo.createAlien(a1);
		return a1;
	}
	
}
