package com.infostretch.network;

public class Arguments {
	private String UserName;
	private String Password;
	private String Longitude;
	private String Latitude;
	private String rememberme;
	private String membershipid;
	private String DeviceType;
	private String DeviceToken;
	
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserName() {
		return UserName;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getPassword() {
		return Password;
	}
	public void setLongitude(String longitude) {
		Longitude = longitude;
	}
	public String getLongitude() {
		return Longitude;
	}
	public void setLatitude(String latitude) {
		Latitude = latitude;
	}
	public String getLatitude() {
		return Latitude;
	}
	public void setRememberme(String rememberme) {
		this.rememberme = rememberme;
	}
	public String isRememberme() {
		return rememberme;
	}
	public void setMembershipid(String membershipid) {
		this.membershipid = membershipid;
	}
	public String getMembershipid() {
		return membershipid;
	}
	public void setDeviceType(String deviceType) {
		DeviceType = deviceType;
	}
	public String getDeviceType() {
		return DeviceType;
	}
	public void setDeviceToken(String deviceToken) {
		DeviceToken = deviceToken;
	}
	public String getDeviceToken() {
		return DeviceToken;
	}
	
}
