package io.javabrains.movieinfoservice.models;

public class User {
	
	private int userId;
	private String userName;
	private String userSurname;
	private String location;
	private String incomeGroup;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSurname() {
		return userSurname;
	}
	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIncomeGroup() {
		return incomeGroup;
	}
	public void setIncomeGroup(String incomeGroup) {
		this.incomeGroup = incomeGroup;
	}
	

}
