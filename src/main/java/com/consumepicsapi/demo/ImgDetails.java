package com.consumepicsapi.demo;

public class ImgDetails {
		
	private String url;
	private String name;
	private int number;
	
	public ImgDetails(String url, String name, int number) {
		super();
		this.url = url;
		this.name = name;
		this.number = number;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
		
}
