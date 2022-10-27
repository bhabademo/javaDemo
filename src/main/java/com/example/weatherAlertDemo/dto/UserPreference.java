package com.example.weatherAlertDemo.dto;

public class UserPreference {

    private String userName;
    private String mobileNo;
    private String emailId;
    private String userCity;
    private String cityPreference;
    private int tempraturePreference;
    private String criteria;
    private String notificationType;
    
    public UserPreference(){

    }

    public UserPreference(String userName, String mobileNo, String emailId, String userCity, String cityPreference, int tempraturePreference, String criteria, String notificationType) {
        this.userName = userName;
        this.mobileNo = mobileNo;
        this.emailId = emailId;
        this.userCity = userCity;
        this.cityPreference = cityPreference;
        this.tempraturePreference = tempraturePreference;
        this.criteria = criteria;
        this.notificationType = notificationType;
    }

    public String getUserName() {
        return userName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getUserCity() {
        return userCity;
    }

    public String getCityPreference() {
        return cityPreference;
    }

    public int getTempraturePreference() {
        return tempraturePreference;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public void setCityPreference(String cityPreference) {
        this.cityPreference = cityPreference;
    }

    public void setTempraturePreference(int tempraturePreference) {
        this.tempraturePreference = tempraturePreference;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	@Override
	public String toString() {
		return "UserPreference [userName=" + userName + ", mobileNo=" + mobileNo + ", emailId=" + emailId
				+ ", userCity=" + userCity + ", cityPreference=" + cityPreference + ", tempraturePreference="
				+ tempraturePreference + ", criteria=" + criteria + ", notificationType=" + notificationType + "]";
	}
}
