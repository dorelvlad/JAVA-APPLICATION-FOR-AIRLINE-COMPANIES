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
 * Servlet implementation class AddPilot
 */
@WebServlet("/AddPilot")
public class AddPilot extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private PilotService ps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPilot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pilot p = new Pilot();
		p.setFirstName("Matt");
		p.setLastName("Greenhood");
		p.setPilotRank(PilotRank.Captain);
		p.setLicense(1212321);
		
		
		ps.addPilot(p);
		System.out.println(p);
		System.out.println("Adaugare pilot facuta cu succes!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
