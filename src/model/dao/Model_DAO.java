package model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.bean.Account;
import model.bean.Search;

public class Model_DAO {
	Connection con;

	public Model_DAO() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3307/search_image", "root", "");
		}catch(Exception e){
		 	System.out.print(e);
		}
	}
	
	public String CheckAccount(String email, String pass) {
		int idGroup = -1;
		try {
			Statement sm1 = con.createStatement();
			String sql1 = "select * from account";
			ResultSet rs1 = sm1.executeQuery(sql1);
			while(rs1.next()) {
				if(email.equals(rs1.getString(2)) && pass.equals(rs1.getString(3))) {
					idGroup = rs1.getInt(5); 
				}
			}
			
			Statement sm2 = con.createStatement();
			String sql2 = "select * from group_acc";
			ResultSet rs2 = sm2.executeQuery(sql2);
			while(rs2.next()) {
				if(idGroup == rs2.getInt(1)) {
					return rs2.getString(2);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void CreateAccount(Account acc) {
		try {
			Statement sm = con.createStatement();
			String sql = "insert into account (Email, Password, Username, GroupId) values ('"+acc.getEmail()+"', '"+acc.getPassword()+"', '"+acc.getUsername()+"', '"+2+"')";
			sm.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<Search> GetAllSearch(){
		ArrayList<Search> data = new ArrayList<Search>();
		
		try {
			Statement sm = con.createStatement();
			String sql = "select * from search ORDER BY TimeSearch DESC";
			ResultSet rs = sm.executeQuery(sql);
			while(rs.next()) {
				Search s = new Search();
				s.setIdSearch(rs.getInt(1));
				s.setKeyWord(rs.getString(2));
				s.setTimeSearch(rs.getTimestamp(3));
				s.setResult(rs.getString(4));
				s.setAccountId(rs.getInt(5));
				
				data.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public ArrayList<Account> GetAllAccount(){
		ArrayList<Account> data = new ArrayList<Account>();
		
		try {
			Statement sm = con.createStatement();
			String sql = "select * from account";
			ResultSet rs = sm.executeQuery(sql);
			while(rs.next()) {
				Account acc = new Account();
				acc.setIdAccount(rs.getInt(1));
				acc.setEmail(rs.getString(2));
				acc.setPassword(rs.getString(3));
				acc.setUsername(rs.getString(4));
				acc.setGroupId(rs.getInt(5));
				
				data.add(acc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}
	
	public void DeleteSearch(String idSeach) {
		try {
			Statement sm = con.createStatement();
			String sql = "delete from search where IdSearch='"+idSeach+"'";
			sm.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void EditProfile(Account acc) {
		try {
			Statement sm = con.createStatement();
			String sql = "update account set Password='"+acc.getPassword()+"', Username='"+acc.getUsername()+"' where Email='"+acc.getEmail()+"'";
			sm.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void CreateSearch(Search s) {
		try {
			Statement sm = con.createStatement();
			String sql = "insert into search (KeyWord, TimeSearch, Result, AccountId) values ('"+s.getKeyWord()+"', '"+s.getTimeSearch()+"', '"+s.getResult()+"', '"+s.getAccountId()+"')";
			sm.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
