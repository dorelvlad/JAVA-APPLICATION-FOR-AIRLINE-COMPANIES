package com.airline.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.model.Flight;
import com.airline.services.FlightService;

/**
 * Servlet implementation class getFlights
 */
@WebServlet("/getFlights")
public class getFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private FlightService fs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getFlights() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Flight> flights = fs.getFlights();//iau rezultatul din ejb intr-o lista de obiecte Flight
		request.setAttribute("flight_list", flights);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/flight_list.jsp");
        dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
