package com.sanmina.demo.util;

public class RestResponse {
	private Integer responseCode;
	private String messege;
	
	public RestResponse(Integer responseCode) {
		super();
		this.responseCode=responseCode;
	}
	public RestResponse(Integer responseCode, String message) {
		super();
		this.responseCode=responseCode;
		this.messege=message;
	}
	public Integer getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}
}
