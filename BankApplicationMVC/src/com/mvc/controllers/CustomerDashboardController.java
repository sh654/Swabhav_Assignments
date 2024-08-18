package com.mvc.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.AccountOperationsDao;
import com.mvc.models.User;


/**
 * Servlet implementation class CustomerDashboardController
 */
@WebServlet("/customerdashboard")
public class CustomerDashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CustomerDashboardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getSession().getAttribute("role") + " This is role");
		
		if( ((User.Role) request.getSession().getAttribute("role")).equals(User.Role.ADMIN)){
			
			response.sendError(404);
			return;
		}
			
		
		List<String> accounts = AccountOperationsDao.getAccountIdByUserId((int) request.getSession().getAttribute("usersid"));
		request.setAttribute("accountsid", accounts);
		
		request.getRequestDispatcher("customerDashboard.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
