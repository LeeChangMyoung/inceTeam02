package com.travel.pak.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.travel.pak.dto.TravelPak;

public class PackageDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;	
	private static PackageDao instance = new PackageDao();
	private PackageDao() {};
	
	public static PackageDao getInstance() {
		return instance;
	}
	

//메인페이지 첫번쨰  상품 리스트 
public ArrayList<TravelPak> pakList(){

		String sql = "select * from travel_pak";
		ArrayList<TravelPak> pakList = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			pakList = new ArrayList<TravelPak>();
			
			while (rs.next()) {
				
				TravelPak travelpak = new TravelPak();
				travelpak.setPak_code(rs.getInt("pak_code"));
				travelpak.setPak_title(rs.getString("pak_title"));
				travelpak.setPak_cnum(rs.getInt("pak_cnum"));
				travelpak.setPak_local(rs.getString("pak_local"));
				travelpak.setPak_depart_local(rs.getString("pak_depart_local"));
				travelpak.setPak_price(rs.getString("pak_price"));
				travelpak.setPak_depart_date(rs.getTimestamp("pak_depart_date"));
				travelpak.setPak_arrival_date(rs.getTimestamp("pak_arrival_date"));
				travelpak.setPak_during_date(rs.getString("pak_during_date"));
				travelpak.setPak_reserve(rs.getString("pak_reserve"));
				travelpak.setPak_detail(rs.getString("pak_detail"));
				travelpak.setPak_image(rs.getString("pak_image"));
				
				pakList.add(travelpak);
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return pakList;
	}///// end

//국가 번호에 따라 여행 리스트 뽑아 오기.
public ArrayList<TravelPak> codeStateList(int countrynum){
	
	String sql = "select * from travel_pak where pak_cnum = ? ";
	ArrayList<TravelPak> travelList = null;
	
	try {
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, countrynum);
		rs = pstmt.executeQuery();
		travelList = new ArrayList<TravelPak>();
		
		while(rs.next()) {
			
			TravelPak travel = new TravelPak();
			
			travel.setPak_code(rs.getInt("pak_code"));
			travel.setPak_title(rs.getString("pak_title"));
			travel.setPak_cnum(rs.getInt("pak_cnum"));
			travel.setPak_local(rs.getString("pak_local"));
			travel.setPak_depart_local(rs.getString("pak_depart_local"));
			travel.setPak_price(rs.getString("pak_price"));
			travel.setPak_depart_date(rs.getTimestamp("pak_depart_date"));
			travel.setPak_arrival_date(rs.getTimestamp("pak_arrival_date"));
			travel.setPak_during_date(rs.getString("pak_during_date"));
			travel.setPak_reserve(rs.getString("pak_reserve"));
			travel.setPak_detail(rs.getString("pak_detail"));
			travel.setPak_image(rs.getString("pak_image"));
			
			travelList.add(travel);
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		DBManager.close(conn, pstmt, rs);
	}
	
	System.out.println("travelList"+ travelList);
	
	
	return travelList;
}



// 해당 패키지 Detail 목록
public TravelPak detailPak( int no ) {
	
	String sql = "select * from travel_pak where pak_code=?";
	 TravelPak detailPak = null;

	try {
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1 , no);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			detailPak = new TravelPak();
			detailPak.setPak_code(rs.getInt("pak_code"));
			detailPak.setPak_title(rs.getString("pak_title"));
			detailPak.setPak_local(rs.getString("pak_cnum"));
			detailPak.setPak_price(rs.getString("pak_price"));
			detailPak.setPak_depart_date(rs.getTimestamp("pak_depart_date"));
			detailPak.setPak_arrival_date(rs.getTimestamp("pak_arrival_date"));
			detailPak.setPak_during_date(rs.getString("pak_during_date"));
			detailPak.setPak_reserve(rs.getString("pak_reserve"));
			detailPak.setPak_detail(rs.getString("pak_detail"));
			detailPak.setPak_image(rs.getString("pak_image"));
		}

	} catch (SQLException e) {
		e.printStackTrace();

	} finally {
		DBManager.close(conn, pstmt, rs);
	}
	return detailPak;
}///// end

}

