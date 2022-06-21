package model.bean;

public class Group {
	private int IdGroup;
	private String NameGroup;
	
	public Group(int idGroup, String nameGroup) {
		IdGroup = idGroup;
		NameGroup = nameGroup;
	}

	public int getIdGroup() {
		return IdGroup;
	}

	public void setIdGroup(int idGroup) {
		IdGroup = idGroup;
	}

	public String getNameGroup() {
		return NameGroup;
	}

	public void setNameGroup(String nameGroup) {
		NameGroup = nameGroup;
	}
}
