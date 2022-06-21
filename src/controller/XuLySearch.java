package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import model.bean.Search;
import model.bo.Model_BO;

@WebServlet("/XuLySearch")
public class XuLySearch extends HttpServlet {
	Model_BO model_BO = new Model_BO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		String email = request.getParameter("email");
			
		if(keyword.isEmpty()) {
			request.setAttribute("username", model_BO.GetAccountByEmail(email).getUsername());
			request.setAttribute("email", email);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/UserSearch.jsp");
			rd.forward(request, response);
		}
		else {
			Date date = new Date();
			Timestamp timeSearch = new Timestamp(date.getTime());
			
			//Nhận dữ liệu từ backend
			String url = "http://localhost:3000/";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();


			con.setRequestMethod("POST");       
			con.setDoOutput(true);

			OutputStream os = con.getOutputStream();
			os.write(keyword.getBytes(StandardCharsets.UTF_8));
			os.flush();

			int httpResult = con.getResponseCode();
		    System.out.println("\nSending 'GET' request to URL : " + url);
		    System.out.println("Response Code : " + httpResult);
		    
		    BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line+"\n");
            }
            br.close();
            con.disconnect();
            System.out.println(sb.toString());
            
            
            JSONObject jsonObj = new JSONObject();
            try {
				jsonObj = new JSONObject(sb.toString());
				//System.out.println(jsonObj.get("links"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
            
			String result = sb.toString();
			
			Search s = new Search(keyword, timeSearch, result, model_BO.GetAccountByEmail(email).getIdAccount());
			model_BO.CreateSearch(s);
			request.setAttribute("keywordSearch", keyword);
			request.setAttribute("username", model_BO.GetAccountByEmail(email).getUsername());
			request.setAttribute("email", email);
			request.setAttribute("result", result);
			request.setAttribute("jsonResult",jsonObj);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/UserSearch.jsp");
			rd.forward(request, response);
		}
	}

}
