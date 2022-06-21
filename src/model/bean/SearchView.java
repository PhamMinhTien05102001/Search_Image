package model.bean;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class SearchView {
	private int IdSearch;
	private String KeyWord;
	private Timestamp TimeSearch;
	private String Result;
	private String Email;
	private String Username;
	
	public SearchView(Search s) {
		IdSearch = s.getIdSearch();
		KeyWord = s.getKeyWord();
		TimeSearch = s.getTimeSearch();
		Result = s.getResult();
	}
	
	public SearchView(int idSearch, String keyWord, Timestamp timeSearch, String result, String email, String username) {
		super();
		IdSearch = idSearch;
		KeyWord = keyWord;
		TimeSearch = timeSearch;
		Result = result;
		Email = email;
		Username = username;
	}

	public int getIdSearch() {
		return IdSearch;
	}

	public void setIdSearch(int idSearch) {
		IdSearch = idSearch;
	}

	public String getKeyWord() {
		return KeyWord;
	}

	public void setKeyWord(String keyWord) {
		KeyWord = keyWord;
	}

	public Timestamp getTimeSearch() {
		return TimeSearch;
	}

	public void setTimeSearch(Timestamp timeSearch) {
		TimeSearch = timeSearch;
	}

	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}
	
}
