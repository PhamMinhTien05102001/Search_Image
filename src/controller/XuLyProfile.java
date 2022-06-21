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

@WebServlet("/XuLyProfile")
public class XuLyProfile extends HttpServlet {
	Model_BO model_BO = new Model_BO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password_confirm = request.getParameter("password_confirm");
		String mess = "/Profile.jsp?";
		boolean invalid = false;
		
		if(username.isEmpty()) {
			invalid = true;
			mess+= "&user_error=Username not null";
		}
		if(password.isEmpty()) {
			invalid = true;
			mess+= "&password_error=Password not null";
		}
		if(password_confirm.isEmpty()) {
			invalid = true;
			mess+= "&password_confirm_error=Password confirm not null";
		}
		if(!password.equals(password_confirm)) {
			invalid = true;
			mess+= "&check=Password false";
		}
		if(invalid) {
			Account account = model_BO.GetAccountByEmail(email);
			request.setAttribute("account", account);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(mess);
			rd.forward(request, response);
		}
		else {
			Account acc = new Account(email, password, username);
			model_BO.EditProfile(acc);
			
			String username_new = model_BO.GetUsernameByEmail(email);
			request.setAttribute("username", username_new);
			request.setAttribute("email", email);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/UserSearch.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
