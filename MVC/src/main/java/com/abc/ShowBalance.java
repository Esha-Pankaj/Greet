package com.abc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ShowBalance
 */
public class ShowBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBalance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BankCustomer customer= BankCustomer.getCustomer("id002");
		String address=null;
		if (customer == null) {
			//address = "UnknownCustomer.jsp";
		}else if (customer.getBalance() <0) {
			address = "NegativeBalance.jsp";
			request.setAttribute("badCustomer", customer);
		}else if (customer.getBalance()<1000) {
			//address="NormalBalance.jsp";
			//request.setAttribute("regularCustomer", customer);
		}
		else
		{
			//address="HighBalance.jsp";
			//request.setAttribute("eliteCustomer", customer);
		}
		RequestDispatcher d= request.getRequestDispatcher(address);
		d.forward(request, response);
	}

}
