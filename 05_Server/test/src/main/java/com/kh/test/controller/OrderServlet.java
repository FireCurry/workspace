package com.kh.test.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/orderProduct")
public class OrderServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		int blackPen = Integer.parseInt( req.getParameter("blackPen"));
		int redPen = Integer.parseInt( req.getParameter("redPen"));
		int bluePen = Integer.parseInt( req.getParameter("bluePen"));
		int white = Integer.parseInt( req.getParameter("white"));
		
		int total = 500 * blackPen + 700 * redPen + 700 * bluePen + 1000 * white;
		if(total != 0) {
			req.setAttribute("total", total);
			String path = "/WEB-INF/views/resultPage.jsp";
			
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, resp);
		} else {
			resp.sendRedirect("/error");
		}
	
	}
}
