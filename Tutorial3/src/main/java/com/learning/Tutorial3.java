package com.learning;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;

public class Tutorial3 extends HttpServlet{
  public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
	  res.setContentType("text/html");
	  PrintWriter out=res.getWriter();
	  out.println("Form has been registered successfully");
	  out.println();
	  
	  String Name=req.getParameter("user_name");
	  String pass=req.getParameter("user_pass");
	  String email=req.getParameter("user_email");
	  String gender=req.getParameter("user_gen");
	  String course=req.getParameter("user_course");
	  String condition=req.getParameter("user_cond");
	  if(condition!=null) {
	  if(condition.equals("checked")) {
		  out.println("<h2> Name : "+Name+ "<h2>");
		  out.println("<h2> Password : "+pass+ "<h2>");
		  out.println("<h2> Email : "+email+ "<h2>");
		  out.println("<h2> Gender : "+gender+ "<h2>");
		  out.println("<h2> Course : "+course+ "<h2>");
		  RequestDispatcher red=((ServletRequest) res).getRequestDispatcher("Success");
	  }
	  }
	  else {
		  out.println("<h2>You have not registered<h2>");
		  
	  }
  }
  
}
