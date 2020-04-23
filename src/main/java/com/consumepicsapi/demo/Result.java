package com.consumepicsapi.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

	String id;
	URL urls;
	
	public Result() {
		
	}

		
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public URL getUrls() {
		return urls;
	}


	public void setUrls(URL urls) {
		this.urls = urls;
	}





	
	
}
