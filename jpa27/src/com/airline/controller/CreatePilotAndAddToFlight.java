package com.airline.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.model.Pilot;
import com.airline.model.PilotRank;
import com.airline.services.PilotService;

/**
 * Servlet implementation class CreatePilotAndAddToFlight
 */
@WebServlet("/CreatePilotAndAddToFlight")
public class CreatePilotAndAddToFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	PilotService ps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePilotAndAddToFlight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("first_name"); 
		String lastName = request.getParameter("last_name"); 
		Integer license = Integer.parseInt(request.getParameter("license")); 
		String pilotRank = request.getParameter("pilot_rank");
		
		String fId=request.getParameter("fId");
		
		Pilot p = new Pilot();
		p.setFirstName(firstName);
		p.setLastName(lastName);
		p.setLicense(license);
		p.setPilotRank(PilotRank.valueOf(pilotRank));
		
		ps.addNewPilotToFlight(p, fId);
		
		response.sendRedirect("getFlights");
		
		
	}

}
