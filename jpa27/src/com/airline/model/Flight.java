 package com.airline.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Flight
 *
 */
@Entity
@NamedQuery(name="FindFlightById", query="SELECT f FROM Flight f WHERE f.id=:id")

public class Flight implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public Flight() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private FlightDestinations flightOrigin;
	
	@Enumerated(EnumType.STRING)
	private FlightDestinations flightDestination;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date flightTime;
	
	private Integer price;
	
	//aici voi spuna JPA Entity ca avem o legatura de tip OneToOne cu Airplane JPA Entity
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name="airplane_fk")//si stabilesc coloana extra de legatura cu id Airplane
	private Airplane airplaneExtra;//cu o referinta la Airplane JPA Entity
	
	@OneToMany(mappedBy="flightExtra")
	private List<Pilot> pilots;
	
	@ManyToMany
	@JoinTable(name="f_p_join",joinColumns=@JoinColumn(name = "flight_fk"),inverseJoinColumns = @JoinColumn(name="passenger_fk"))
	private List<Passenger> passengers;//lista de pasageri pe care zborul o are
	
	






	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FlightDestinations getFlightOrigin() {
		return flightOrigin;
	}

	public void setFlightOrigin(FlightDestinations flightOrigin) {
		this.flightOrigin = flightOrigin;
	}

	public FlightDestinations getFlightDestination() {
		return flightDestination;
	}

	public void setFlightDestination(FlightDestinations flightDestination) {
		this.flightDestination = flightDestination;
	}

	public Date getFlightTime() {
		return flightTime;
	}

	public void setFlightTime(Date flightTime) {
		this.flightTime = flightTime;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Airplane getAirplaneExtra() {
		return airplaneExtra;
	}

	public void setAirplaneExtra(Airplane airplaneExtra) {
		this.airplaneExtra = airplaneExtra;
	}

	public List<Pilot> getPilots() {
		return pilots;
	}

	public void setPilots(List<Pilot> pilots) {
		this.pilots = pilots;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightOrigin=" + flightOrigin
				+ ", flightDestination=" + flightDestination + ", flightTime="
				+ flightTime + ", price=" + price + ", airplaneExtra="
				+ airplaneExtra + ", lpilots=" + pilots + "]";
	}



	
	
	
   
}
