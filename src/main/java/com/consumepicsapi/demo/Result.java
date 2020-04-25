package com.consumepicsapi.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

	private String description;
	private URL urls;
	private User user;
	
	public Result() {
		
	}

	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public URL getUrls() {
		return urls;
	}


	public void setUrls(URL urls) {
		this.urls = urls;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	
	



	
	
}
