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

import com.airline.model.Flight;
import com.airline.model.Passenger;

/**
 * Session Bean implementation class FlightService
 */
@Stateless
@LocalBean
public class PassengerService {

    /**
     * Default constructor. 
     */
    public PassengerService() {
        // TODO Auto-generated constructor stub
    }
   @PersistenceContext(unitName = "airline")//inject entityManager prin Context Independency Injection
    private EntityManager em;//iau obiect de tip EntityManager care comunica cu BD
   
   //si apoi imi creez  o metoda care sa faca adaugare in BD
   
   public void addPassenger(Passenger p){
	   em.persist(p);
	   
   }
   public void addFlightTicketToPassenger(String flightId, String passengerId){
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
	 		
	 		//Associate the flight with the passenger
	 		List<Flight> fList = p.getFlights();
	 		fList.add(f);//adaugam flight la lista de flight din passenger entity
	 		p.setFlights(fList);
	 		f.getPassengers().add(p);//si adaugam si pasager la lista de pasageri pe care zborul le are	
	   
   }
   
   public List<Passenger> getPassengers(){
	   TypedQuery<Passenger> query = em.createQuery("SELECT p FROM Passenger p", Passenger.class);
	   List<Passenger> pList = query.getResultList();//execut query si stochez intr-o lista de pasageri
	   return pList;
   }
   
   

}
