package com.consumepicsapi.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {

	private long total;
	private long total_pages;
	private Result[] results;
	
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public long getTotal_pages() {
		return total_pages;
	}
	public void setTotal_pages(long total_pages) {
		this.total_pages = total_pages;
	
	}
	public Result[] getResults() {
		return results;
	}
	public void setResults(Result[] results) {
		this.results = results;
	}

	

	
	
}
