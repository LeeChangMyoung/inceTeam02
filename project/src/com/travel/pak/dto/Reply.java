package com.travel.pak.dto;

import java.sql.Timestamp;

public class Reply {
	private int no; // travel
	private int bbsNo;
	private String reply;
	private String writer;
	private Timestamp regDate;
	
	public Reply() {}
	public Reply(int bbsNo, String reply, String writer) {
		this.bbsNo = bbsNo;
		this.reply=reply;
		this.writer=writer;
	}
	public Reply(int no, int bbsNo, String reply, String writer, Timestamp regDate) {
		this.no=no;
		this.bbsNo=bbsNo;
		this.reply=reply;
		this.writer=writer;
		this.regDate=regDate;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBbsNo() {
		return bbsNo;
	}
	public void setBbsNo(int bbsNo) {
		this.bbsNo = bbsNo;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
}
