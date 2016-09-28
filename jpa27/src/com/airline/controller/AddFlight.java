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

import com.airline.model.Airplane;
import com.airline.model.Flight;
import com.airline.model.FlightDestinations;
import com.airline.services.FlightService;

/**
 * Servlet implementation class AddFlight
 */
@WebServlet("/AddFlight")
public class AddFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private FlightService fs;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFlight() {
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
		Flight f = new Flight();
		String fromDestination = request.getParameter("from_destination");//iau valoarea din select intr-un string
		f.setFlightOrigin(FlightDestinations.valueOf(fromDestination));//setez plecarea cu val din enum corespunzatoare optiunii alese
		String toDestination = request.getParameter("to_destination");
		f.setFlightDestination(FlightDestinations.valueOf(toDestination));
		Integer price = Integer.parseInt(request.getParameter("price"));
		f.setPrice(price);
		
		Integer year = Integer.parseInt(request.getParameter("year"));
		Integer month = Integer.parseInt(request.getParameter("month"));
		Integer dayOfMonth = Integer.parseInt(request.getParameter("day_of_month"));
		Integer hourOfDay = Integer.parseInt(request.getParameter("hour_of_day"));
		Integer minute = Integer.parseInt(request.getParameter("minute"));
		 Calendar cal = Calendar.getInstance();
		 cal.set(Calendar.YEAR, year);
		 cal.set(Calendar.MONTH, month);
		 cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		 cal.set(Calendar.HOUR_OF_DAY, hourOfDay);
		 cal.set(Calendar.MINUTE, minute);
		 
		 Date flightTime = cal.getTime();
		 
		 f.setFlightTime(flightTime);
		 
		 Airplane a = new Airplane();
		 String planemake= request.getParameter("planemake");
		 a.setPlaneMake(planemake);
		 String planeModel = request.getParameter("model_name");
		 a.setPlaneModel(planeModel);
		 Integer seatingCapacity = Integer.parseInt(request.getParameter("seating_capacity"));
		 a.setSeatingCapacity(seatingCapacity);
		 
		 f.setAirplaneExtra(a);
		 System.out.println(f);
		 System.out.println(a);
		 System.out.println("Legatura OneToOne facuta cu succes!");
		 
		 fs.addFlights(f,a);
		 response.sendRedirect("getFlights");
	}

}
