package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Account;
import model.bean.Search;
import model.bean.SearchView;
import model.bo.Model_BO;

@WebServlet("/User")
public class User extends HttpServlet {
	Model_BO model_BO = new Model_BO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		Account account = model_BO.GetAccountByEmail(email);
		
		request.setAttribute("account", account);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Profile.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
