package com.example.restFull;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {

	AlienRepository repo = new AlienRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Alien> getAliens() {
		
		System.out.println("gets calllled");
		
		return repo.getAliens();
	}
	
	@GET
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien getAlien(@PathParam("id") int id) {
		
		System.out.println("gets cled");
		
		Alien out = repo.getAlien(id);
		
		if(out != null) {
			return out;
		}else {
			return new Alien();
		}
	}
	
	@POST
	@Path("alien")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien createAlien(Alien a1) {
		
		Alien newest = (Alien)a1;
		System.out.println("created");
		repo.createAlien(newest);
		return a1;
	}
	
	@PUT
	@Path("alien")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien updateAlien(Alien a1) {
		
		Alien newest = (Alien)a1;
		if(repo.getAlien(newest.getId())==null) {
			repo.createAlien(newest);
		}else {
			System.out.println("updated");
			repo.updateAlien(newest);
		}
		return a1;
	}
	
	
	@DELETE
	@Path("alien/{id}")
	public Alien updateAlien(@PathParam("id") int id) {
		
		if(repo.getAlien(id)==null) {
			System.out.println("No such field inthe table");//should be send as the response to the user(client)
		}else {
			Alien toReturn = repo.getAlien(id);
			System.out.println("deleted");
			repo.deleteAlien(id);
			return toReturn;
		}
		return null;
	}
	
	
//	@RequestMapping(value = "/api/signup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	public long signUp(@ModelAttribute ApiMemberModel apiMember) {
//	    memberService = new MemberDetailsService();
//	    Member m = memberService.createMember(apiMember.getUsername(), apiMember.getPassword(), apiMember.getEmail(), "");
//	    return m.getId();
//	}
}
