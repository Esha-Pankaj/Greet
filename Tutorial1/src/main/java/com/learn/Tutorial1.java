package com.learn;

import java.io.IOException;

import jakarta.servlet.*;

public class Tutorial1 implements Servlet{
   


	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Servlet is being destroyed");
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Servlet is being initialized");
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter().println("Hi i'm the response");
		
	}
}
