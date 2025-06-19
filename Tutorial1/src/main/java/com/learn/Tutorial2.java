package com.learn;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@SuppressWarnings("serial")
public class Tutorial2 extends GenericServlet{

	@Override
	public void service(ServletRequest res, ServletResponse req) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setContentType("Text/html");
		System.out.println("Service has started");
		req.getWriter().println("This is the resquested page for tutorial 2");
	}
}
