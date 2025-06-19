package com.advjava.bugapp.web;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.advjava.bugapp.dao.BugDao;
import com.advjava.bugapp.dao.BugDaoImpl;
import com.advjava.bugapp.model.Bug;

/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the todo.
 * 
 * @email Ramesh Fadatare
 */

@WebServlet("/")
public class BugController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BugDao bugDAO;

	public void init() {
		bugDAO = new BugDaoImpl();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertBug(request, response);
				break;
			case "/delete":
				deleteBug(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateBug(request, response);
				break;
			case "/list":
				listBug(request, response);
				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listBug(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Bug> listBug = bugDAO.selectAllBugs();
		request.setAttribute("listBug", listBug);
		RequestDispatcher dispatcher = request.getRequestDispatcher("bug/bug-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("bug/bug-add.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("ID = "+id);
		Bug existingBug = bugDAO.selectBug(id);
		System.out.println(existingBug);
		RequestDispatcher dispatcher = request.getRequestDispatcher("bug/bug-add.jsp");
		request.setAttribute("bug", existingBug);
		dispatcher.forward(request, response);

	}

	private void insertBug(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String title = request.getParameter("title");
		String username = request.getParameter("username");
		String userassign = request.getParameter("userassign");
		
		/*DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"),df);*/
		LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"));
		String isDone = String.valueOf(request.getParameter("isDone"));
		Bug newBug = new Bug(title, username, userassign, targetDate, isDone);
		System.out.println(userassign);
		bugDAO.insertBug(newBug);
		response.sendRedirect("list");
	}

	private void updateBug(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		String title = request.getParameter("title");
		String username = request.getParameter("username");
		String userassign = request.getParameter("userassign");
		//DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"));
		
		String isDone = String.valueOf(request.getParameter("isDone"));
		Bug updateBug = new Bug(id, title, username, userassign, targetDate, isDone);
		
		bugDAO.updateBug(updateBug);
		
		response.sendRedirect("list");
	}

	private void deleteBug(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		bugDAO.deleteBug(id);
		response.sendRedirect("list");
	}
}
