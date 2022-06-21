package model.bean;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Search {
	private int IdSearch;
	private String KeyWord;
	private Timestamp TimeSearch;
	private String Result;
	private int AccountId;
	
	public Search() {
		
	}
	
	public Search(int idSearch, String keyWord, Timestamp timeSearch, String result, int accountId) {
		IdSearch = idSearch;
		KeyWord = keyWord;
		TimeSearch = timeSearch;
		Result = result;
		AccountId = accountId;
	}
	
	public Search(String keyWord, Timestamp timeSearch, String result, int accountId) {
		KeyWord = keyWord;
		TimeSearch = timeSearch;
		Result = result;
		AccountId = accountId;
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

	public int getAccountId() {
		return AccountId;
	}

	public void setAccountId(int accountId) {
		AccountId = accountId;
	}
}
