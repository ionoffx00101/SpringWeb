package org.kdea.spring.simpleboard;

public class BoardVO {
	
	private int bnum;
	private String title;
	private String bcontents;
	private String author;
	private java.sql.Date wdate;
	private int bref;
	private int page;
	
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBcontents() {
		return bcontents;
	}
	public void setBcontents(String bcontents) {
		this.bcontents = bcontents;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public java.sql.Date getWdate() {
		return wdate;
	}
	public void setWdate(java.sql.Date wdate) {
		this.wdate = wdate;
	}
	public int getBref() {
		return bref;
	}
	public void setBref(int bref) {
		this.bref = bref;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	


}
