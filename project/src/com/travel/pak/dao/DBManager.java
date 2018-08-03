package com.travel.pak.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// connection 객체 얻고 리소스 해제 기능 
public class DBManager {

	private static DataSource DS = null;
	private static Connection CONN = null;
	
	private DBManager() {}
	
	// static 초기화 블럭은 클래스가 메모리에 로딩된 직후에 실행된다.
	// static 초기화 블럭은 생성자 보다 먼저 실행된다.
	static {
		try {
			// 자바네이밍 서비스를 사용
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:comp/env");
		DS = (DataSource)envContext.lookup("jdbc/travelDBPool");
		}catch(Exception e) {e.printStackTrace();}
	}
	// Connection 객체를 반환하는 메서드!
	public static Connection getConnection() {
		try {
			CONN = DS.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return CONN;
	}
	// update,delete 리소스 해제
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if(pstmt != null) pstmt.close();
			if(conn !=null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//select 리소스 해제
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn !=null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Transaction 시작
		public static void setAutoCommit(Connection conn, boolean isAutoCommit) {		
			try {
				if(conn != null) conn.setAutoCommit(isAutoCommit);
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		// Transaction 종료
		public static void commit(Connection conn) {		
			try {
				if(conn != null) conn.commit();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		// Transaction 롤백
		public static void rollback(Connection conn) {		
			try {
				if(conn != null) conn.rollback();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}	
}
