package com.travel.pak.dto;

import java.sql.Timestamp;

public class TravelPak {

	private int pak_code;
	private String pak_title;
	private int pak_cnum;
	private String pak_local;
	private String pak_depart_local;
	private String pak_price;
	private Timestamp pak_depart_date;
	private Timestamp pak_arrival_date;
	private String pak_during_date;
	private String pak_reserve;
	private String pak_detail;
	private String pak_image;
	
	public TravelPak() {}

	public int getPak_code() {
		return pak_code;
	}

	public void setPak_code(int pak_code) {
		this.pak_code = pak_code;
	}

	public String getPak_title() {
		return pak_title;
	}

	public void setPak_title(String pak_title) {
		this.pak_title = pak_title;
	}

	public String getPak_local() {
		return pak_local;
	}

	public void setPak_local(String pak_local) {
		this.pak_local = pak_local;
	}

	public String getPak_depart_local() {
		return pak_depart_local;
	}

	public void setPak_depart_local(String pak_depart_local) {
		this.pak_depart_local = pak_depart_local;
	}

	public String getPak_price() {
		return pak_price;
	}

	public void setPak_price(String pak_price) {
		this.pak_price = pak_price;
	}

	public Timestamp getPak_depart_date() {
		return pak_depart_date;
	}

	public void setPak_depart_date(Timestamp pak_depart_date) {
		this.pak_depart_date = pak_depart_date;
	}

	public Timestamp getPak_arrival_date() {
		return pak_arrival_date;
	}

	public void setPak_arrival_date(Timestamp pak_arrival_date) {
		this.pak_arrival_date = pak_arrival_date;
	}

	public String getPak_during_date() {
		return pak_during_date;
	}

	public void setPak_during_date(String pak_during_date) {
		this.pak_during_date = pak_during_date;
	}

	public String getPak_reserve() {
		return pak_reserve;
	}

	public void setPak_reserve(String pak_reserve) {
		this.pak_reserve = pak_reserve;
	}

	public String getPak_detail() {
		return pak_detail;
	}

	public void setPak_detail(String pak_detail) {
		this.pak_detail = pak_detail;
	}

	public String getPak_image() {
		return pak_image;
	}

	public void setPak_image(String pak_image) {
		this.pak_image = pak_image;
	}

	public int getPak_cnum() {
		return pak_cnum;
	}

	public void setPak_cnum(int pak_cnum) {
		this.pak_cnum = pak_cnum;
	};

	
}
