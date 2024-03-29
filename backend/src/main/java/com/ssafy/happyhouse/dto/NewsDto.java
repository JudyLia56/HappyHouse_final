package com.ssafy.happyhouse.dto;

public class NewsDto {
	private String title;
	private String link;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public NewsDto(String title, String link) {
		super();
		this.title = title;
		this.link = link;
	}
	public NewsDto() {
		super();
	}
	@Override
	public String toString() {
		return "NewsDto [title=" + title + ", link=" + link + "]";
	}
	
	
}
