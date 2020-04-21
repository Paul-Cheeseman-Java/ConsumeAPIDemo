package com.spacepics.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImgOfDay {

	String copyright;
	String explanation;
	String hdurl;
	String media_type;
	String service_version;
	String title;
	String url;
	
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	public String getHdurl() {
		return hdurl;
	}
	public void setHdurl(String hdurl) {
		this.hdurl = hdurl;
	}
	public String getMedia_type() {
		return media_type;
	}
	public void setMedia_type(String media_type) {
		this.media_type = media_type;
	}
	public String getService_version() {
		return service_version;
	}
	public void setService_version(String service_version) {
		this.service_version = service_version;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "ImgOfDay [copyright=" + copyright + ", explanation=" + explanation + ", hdurl=" + hdurl
				+ ", media_type=" + media_type + ", service_version=" + service_version + ", title=" + title + ", url="
				+ url + "]";
	}
	
}
