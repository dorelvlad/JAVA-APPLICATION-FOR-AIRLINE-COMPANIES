package com.airline.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Airplane
 *
 */
@Entity

public class Airplane implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public Airplane() {
		super();
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String planeMake;
	private String planeModel;
	private Integer seatingCapacity;
	//iar in Airplane 
	
	@OneToOne(mappedBy="airplaneExtra")
	private Flight flight;//iau o referinta de tip Flight

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlaneMake() {
		return planeMake;
	}
	public void setPlaneMake(String planeMake) {
		this.planeMake = planeMake;
	}
	public String getPlaneModel() {
		return planeModel;
	}
	public void setPlaneModel(String planeModel) {
		this.planeModel = planeModel;
	}
	public Integer getSeatingCapacity() {
		return seatingCapacity;
	}
	public void setSeatingCapacity(Integer seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}
	@Override
	public String toString() {
		return "Airplane [id=" + id + ", planeMake=" + planeMake
				+ ", planeModel=" + planeModel + ", seatingCapacity="
				+ seatingCapacity + "]";
	}
	
	
   
}
