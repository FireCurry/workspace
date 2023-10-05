package edu.kh.jsp.jspl.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jstl/condition")
public class ConditionServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/jstl/condition.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
		
	}
}
