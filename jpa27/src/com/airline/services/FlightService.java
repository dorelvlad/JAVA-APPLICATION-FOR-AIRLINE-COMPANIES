package com.airline.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.airline.model.Airplane;
import com.airline.model.Flight;
import com.airline.model.Passenger;
import com.airline.model.Pilot;

/**
 * Session Bean implementation class FlightService
 */
@Stateless
@LocalBean
public class FlightService {

	/**
	 * Default constructor.
	 */
	public FlightService() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "airline")
	EntityManager em;

	public void addFlights(Flight f, Airplane a) {
		em.persist(f);
		//em.persist(a);--propagated and cascaded from flight and saved automatically
		System.out.println("Adaugare in BAza de Date facuta cu succes!");

	}

	// vom lua rezultate din BD pe baza de id pentru Pilot si Flight
	// INTEROGHEZ BAZA DE DATE PENTRU id-urile specifice unor anumite zboruri si
	// piloti
	public void addPilotToFlight(String pId, String fId){
	   
	   TypedQuery<Pilot> pQuery=em.createNamedQuery("FindPilotsById", Pilot.class);//aici prac
	   //tic facem cererea in baza de date pentru coloana id la Pilot
	   pQuery.setParameter("id", Integer.parseInt(pId));//setam parametrul id la argumentul meu din metoda pt pilot
	 Pilot p =  pQuery.getSingleResult();//si aici voi lua unicul rezultat care se potriveste cu argumentul meu 
	   
	   TypedQuery<Flight> fQuery =em.createNamedQuery("FindFlightById",Flight.class);
	   fQuery.setParameter("id", Integer.parseInt(fId));
	  Flight f =  fQuery.getSingleResult();//unicul rezultat din BD care se potriveste cu argumentul dat
	   
	   //acum imi iau intr-o variabila oarecare lista mea de piloti actuala din Flights
	   List<Pilot> pList =  f.getPilots();
	   pList.add(p);//adaug rezultatul query Pilot by id 
	   f.setPilots(pList);//setez lista la noua valoare pList
	   
	   p.setFlightExtra(f);//aici le-am legat ManyToOne   
   }
	public void addPassengerToFlight(String passengerId, String flightId){
		//Getting passenger by Id
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Passenger> cqPassenger = builder.createQuery(Passenger.class);
		Root<Passenger> pRoot = cqPassenger.from(Passenger.class);
		cqPassenger.select(pRoot).where(builder.equal(pRoot.get("id").as(Integer.class), passengerId));		
		TypedQuery<Passenger> pQuery = em.createQuery(cqPassenger);
		Passenger p = pQuery.getSingleResult();
		
		//Getting flight by id
		builder = em.getCriteriaBuilder();
		CriteriaQuery<Flight> cqFlight = builder.createQuery(Flight.class);
		Root<Flight> fRoot = cqFlight.from(Flight.class);
		cqFlight.select(fRoot).where(builder.equal(fRoot.get("id").as(Integer.class),flightId ));
		TypedQuery<Flight> fQuery = em.createQuery(cqFlight);
		Flight f = fQuery.getSingleResult();
		System.out.println("Succsessfully applied criteria Query for id!");
		
		//Associate the passenger with the flight
		List<Passenger> pList = f.getPassengers();
		pList.add(p);//adaugam pasagerul la lista de pasageri din flight
		f.setPassengers(pList);
		p.getFlights().add(f);//si adaugam si flight la zborurile pe care passagerul le are	
	}
	 public List<Flight> getFlights(){//returnez o lista de tip Flight objects din tabela Flights
		 TypedQuery<Flight> queryFlights = (TypedQuery<Flight>) em.createQuery("SELECT f FROM Flight f", Flight.class);//fac query la BD pentru toata tabela Flight
		 List<Flight> flights = (List<Flight>)queryFlights.getResultList();//intoarce rezultaul query-ului in obiecte de tip Flight(Lista)
		 return flights;//returnez lisat de tip flights		 
	 }
}
