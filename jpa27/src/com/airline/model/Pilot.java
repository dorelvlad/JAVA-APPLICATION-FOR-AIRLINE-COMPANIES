package com.airline.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pilot
 *
 */
@NamedQuery(name="FindPilotsById", query="SELECT p FROM Pilot p WHERE p.id=:id")
@Entity

public class Pilot implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Pilot() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String firstName;
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	private PilotRank pilotRank;
	private Integer license;
	
	@ManyToOne
	@JoinColumn(name="flight_fk")
	private Flight flightExtra;



	public Integer getLicense() {
		return license;
	}

	public void setLicense(Integer license) {
		this.license = license;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public PilotRank getPilotRank() {
		return pilotRank;
	}

	public void setPilotRank(PilotRank pilotRank) {
		this.pilotRank = pilotRank;
	}

	public Flight getFlightExtra() {
		return flightExtra;
	}

	public void setFlightExtra(Flight flightExtra) {
		this.flightExtra = flightExtra;
	}

	@Override
	public String toString() {
		return "Pilot [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", pilotRank=" + pilotRank + ", flightExtra="
				+ flightExtra + "]";
	}
	
	
   
}
