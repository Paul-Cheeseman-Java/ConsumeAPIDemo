package com.consumepicsapi.demo;

public class ImgDetails {
		
	String url;
	String name;
	String description;
	
	public ImgDetails(String url, String name, String description) {
		super();
		this.url = url;
		this.name = name;
		this.description = description;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	
}
