package model.bean;

public class Account {
	private int IdAccount;
	private String Email;
	private String Password;
	private String Username;
	private int GroupId;
	
	public Account() {
	}
	
	public Account(String email, String password, String username) {
		Email = email;
		Password = password;
		Username = username;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public int getIdAccount() {
		return IdAccount;
	}

	public void setIdAccount(int idAccount) {
		IdAccount = idAccount;
	}

	public int getGroupId() {
		return GroupId;
	}

	public void setGroupId(int groupId) {
		GroupId = groupId;
	}
	
	
}
