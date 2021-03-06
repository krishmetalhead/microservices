package io.javabrains.moviecatalogservice.models;

public class User {
	
	private int userId;
	private String userName;
	private String userSurname;
	private String location;
	private String incomeGroup;
	private String creditScore;
	
	public String getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(String creditScore) {
		this.creditScore = creditScore;
	}
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
