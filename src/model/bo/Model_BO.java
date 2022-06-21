package model.bo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import model.bean.Account;
import model.bean.Search;
import model.bean.SearchView;
import model.dao.Model_DAO;

public class Model_BO {
	Model_DAO model_DAO = new Model_DAO();
	
	public String CheckAccount(String email, String pass) {
		return model_DAO.CheckAccount(email, pass);
	}
	
	public void CreateAccount(Account acc) {
		model_DAO.CreateAccount(acc);
	}
	
	public ArrayList<SearchView> GetAllSearchView(){
		ArrayList<Search> AllSearch = model_DAO.GetAllSearch();
		ArrayList<Account> AllAccount = model_DAO.GetAllAccount();
		ArrayList<SearchView> data = new ArrayList<SearchView>();
		
		for (Search search : AllSearch) {
			SearchView sv = new SearchView(search);
			for (Account acc : AllAccount) {
				if(search.getAccountId() == acc.getIdAccount()) {
					sv.setEmail(acc.getEmail());
					sv.setUsername(acc.getUsername());
					data.add(sv);
				}
			}
		}
		
		return data;
	}
	
	public void DeleteSearch(String idSeach) {
		model_DAO.DeleteSearch(idSeach);
	}
	
	public boolean CheckExistEmail(String email) {
		ArrayList<Account> AllAccount = model_DAO.GetAllAccount();
		
		for (Account acc : AllAccount) {
			if(acc.getEmail().equals(email)) {
				return true;
			}
		}
		
		return false;
	}
	
	public String GetUsernameByEmail(String email) {
		ArrayList<Account> AllAccount = model_DAO.GetAllAccount();
		
		for (Account acc : AllAccount) {
			if(acc.getEmail().equals(email)) {
				return acc.getUsername();
			}
		}
		
		return null;
	}
	
	public Account GetAccountByEmail(String email) {
		ArrayList<Account> AllAccount = model_DAO.GetAllAccount();
		
		for (Account acc : AllAccount) {
			if(acc.getEmail().equals(email)) {
				return acc;
			}
		}
		
		return null;
	}
	
	public void EditProfile(Account acc) {
		model_DAO.EditProfile(acc);
	}
	
	public void CreateSearch(Search s) {
		model_DAO.CreateSearch(s);
	}
}
