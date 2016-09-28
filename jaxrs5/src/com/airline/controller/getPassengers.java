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

import com.airline.model.Passenger;
import com.airline.services.PassengerService;

/**
 * Servlet implementation class getPassengers
 */
@WebServlet("/getPassengers")
public class getPassengers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	PassengerService ps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getPassengers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Passenger> pList = (List<Passenger>)ps.getPassengers();//iau lista
		//acum o pot afisa
		
		request.setAttribute("passengers_list", pList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/passengers_list.jsp");
		dispatcher.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
