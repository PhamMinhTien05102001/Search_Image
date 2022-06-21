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

import model.bean.Search;
import model.bean.SearchView;
import model.bo.Model_BO;

@WebServlet("/Admin")
public class Admin extends HttpServlet {
	Model_BO model_BO = new Model_BO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if(id != null) {
			model_BO.DeleteSearch(id);
		}
		
		ArrayList<SearchView> data = model_BO.GetAllSearchView();
		request.setAttribute("ListSearchView", data);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminHome.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
