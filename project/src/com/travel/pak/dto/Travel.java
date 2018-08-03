package com.travel.pak.dto;

import java.sql.Timestamp;

public class Travel {
	private int no; //번호
	private String title; //제목
	private String writer; // 작성자
	private String content; //
	private Timestamp regDate; // 작성일
	private int readCount; // 조회수
	private String pass; // 비밀번호
	private String file; //파일
	private int recommend;
	private int thank;

	public Travel() {}
	
	public Travel(int no, String title, String writer, String content, Timestamp regDate, int readCount, String pass, String file) {
	this.no=no;
	this.title=title;
	this.content=content;
	this.regDate=regDate;
	this.readCount=readCount;
	this.pass=pass;
	this.file=file;
		
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public int getThank() {
		return thank;
	}

	public void setThank(int thank) {
		this.thank = thank;
	}
}
