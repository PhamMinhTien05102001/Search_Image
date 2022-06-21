package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.Model_BO;

@WebServlet("/XuLyLogin")
public class XuLyLogin extends HttpServlet {
	Model_BO model_BO = new Model_BO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if(email != null && password != null) {
			String nameGroup = model_BO.CheckAccount(email, password);
			if(nameGroup != null) {
				if(nameGroup.equals("Admin")) {
					response.sendRedirect("Admin");					
				}
				else if(nameGroup.equals("User")) {
					String username = model_BO.GetUsernameByEmail(email);
					request.setAttribute("username", username);
					request.setAttribute("email", email);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/UserSearch.jsp");
					rd.forward(request, response);
				}
			}
			else {
				response.sendRedirect("index.jsp?error=Invalid email or password");
			}
		}
		else {
			response.sendRedirect("index.jsp?error=Invalid email or password");
		}
	}

}
