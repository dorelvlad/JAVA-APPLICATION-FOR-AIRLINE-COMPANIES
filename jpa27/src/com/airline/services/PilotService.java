package com.airline.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.airline.model.Flight;
import com.airline.model.Pilot;

/**
 * Session Bean implementation class PilotService
 */
@Stateless
@LocalBean
public class PilotService {

    /**
     * Default constructor. 
     */
    public PilotService() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="airline")
    EntityManager em;
    public void addNewPilotToFlight(Pilot p, String fId){
      
 	  em.persist(p);
 	   TypedQuery<Flight> fQuery =em.createNamedQuery("FindFlightById",Flight.class);
 	   fQuery.setParameter("id", Integer.parseInt(fId));
 	  Flight f =  fQuery.getSingleResult();//unicul rezultat din BD care se potriveste cu argumentul dat
 	   
 	   //acum imi iau intr-o variabila oarecare lista mea de piloti actuala din Flights
 	   List<Pilot> pList =  f.getPilots();
 	   pList.add(p);//adaug rezultatul query Pilot by id 
 	   f.setPilots(pList);;//setez lista la noua valoare pList
 	   
 	   p.setFlightExtra(f);//aici le-am legat ManyToOne   
    }
    //si in acelasi mod ca pina acum adaugam un pilot cu o metoda de adugare
    
    public void addPilot(Pilot p){
    	em.persist(p);
    }
    
    

}
