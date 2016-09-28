package com.airline.webservices.rest;

import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.airline.model.Flight;
import com.airline.model.Passenger;
import com.airline.services.FlightService;
import com.airline.services.PassengerService;

@Path("/passengers")
public class PassengerWebService {

	@PersistenceContext(unitName="airline")
	EntityManager em;
	
	@EJB
	PassengerService ps;
	
	@Context
	UriInfo pUriInfo;
	
	public PassengerWebService() {
	}
	//airlineservices/rest/passengers --URL path 
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Passenger> getPassengers() {
		List<Passenger> pList = ps.getPassengers();
		return pList;

	}
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("{passenger_id}")
	public Passenger getPassenger(@PathParam("passenger_id")Integer passengerId){
		//http://localhost:8080/jaxrs3/airlineservices/rest/flights/8
		Passenger p = ps.getPassenger(passengerId);
		
		if(p==null){
			throw new NotFoundException("The passenger with an id of "+ passengerId+ " was not found");
			
		}
		return p;
		
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPassenger(Passenger p){
		p = ps.addPassenger(p);
		UriBuilder pUriBuilder = pUriInfo.getAbsolutePathBuilder();
		URI pUri = pUriBuilder.path(String.valueOf(p.getId())).build();
		return Response.created(pUri).build();	
	}
}
 