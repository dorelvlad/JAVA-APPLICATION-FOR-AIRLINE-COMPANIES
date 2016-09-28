package com.airline.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.model.FlightClass;
import com.airline.model.Gender;
import com.airline.model.Passenger;
import com.airline.services.PassengerService;

/**
 * Servlet implementation class AddPassenger
 */
@WebServlet("/AddPassenger")
public class AddPassenger extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB//injectam 
	private PassengerService ps;//clasa Entity Java Bean PassengerService
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPassenger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
         String firstName= request.getParameter("pfirst_name");
         String lastName=request.getParameter("plast_name" );
         String dob_raw=request.getParameter("dob");
         String gender = request.getParameter("gender");
         
         Passenger p = new Passenger();//cream obiect de tip JPA Entity Passenger
         
         p.setFirstName(firstName);
         p.setLastName(lastName);
         
         //separam stringul de data nastere in trei parti cu split
        String [] dobArr =  dob_raw.split("\\/");//separam cu forward slash si iau intr-un array
  
		//cream obiect de tip Date
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, Integer.parseInt(dobArr[1])-1);
		cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dobArr[0]));
		cal.set(Calendar.YEAR, Integer.parseInt(dobArr[2]));
		
		Date dob = cal.getTime();
		
		p.setDob(dob);
		p.setGender(Gender.valueOf(gender));
		
		
		//si in final cu referinta la clasa EJB
		System.out.println(p);
		ps.addPassenger(p);
		System.out.println("Adaugare facuta cu succes!");
		response.sendRedirect("getPassengers");
	}

}
