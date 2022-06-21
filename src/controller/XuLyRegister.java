package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Account;
import model.bo.Model_BO;

@WebServlet("/XuLyRegister")
public class XuLyRegister extends HttpServlet {
	Model_BO model_BO = new Model_BO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password_confirm = request.getParameter("password_confirm");

		String mess = "register.jsp?";
		boolean invalid = false;
		if(email.isEmpty()) {
			invalid = true;
			mess+= "&email_error=Email not null";
		}
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
		if(model_BO.CheckExistEmail(email)) {
			invalid = true;
			mess+= "&email_exist=Email is existed";
		}
		if(invalid) {
			response.sendRedirect(mess);
		}
		else {
			Account acc = new Account(email, password, username);
			model_BO.CreateAccount(acc);
			response.sendRedirect("index.jsp?register_success=Register success, please login!!!");
		}
	}

}
