package com.consumepicsapi.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

	private URL urls;
	private User user;
	
	public Result() {
		
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
