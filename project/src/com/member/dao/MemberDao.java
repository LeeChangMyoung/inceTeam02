package com.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.member.dto.Member;
import com.travel.pak.dao.DBManager;

	public class MemberDao {
		
		private Connection conn = null;
		private PreparedStatement pstmt = null;
		private ResultSet rs = null;	
		
		private static MemberDao instance = new MemberDao();
		
		
		private MemberDao() { }
		
		public static MemberDao getInstance() {
			return instance;
		}
		
		public int checkMember1(String id, String pass) {
			
			String loginSql = "SELECT pass FROM pmember WHERE id = ?";
			
			int result = -1;
			String password = "";
			
			try {
				// DBCP로 부터 Connection을 대여한다.
				conn = DBManager.getConnection();
				
				pstmt = conn.prepareStatement(loginSql);
				
				// loginSql 쿼리의 플레이스홀더(?)에 대응하는 데이터를 설정한다.
				pstmt.setString(1, id);
				
				// DB에 쿼리를 전송하여 결과를 ResultSet으로 받는다.
				rs = pstmt.executeQuery();
				
				
				if(rs.next()) {				
					
					password = rs.getString("pass");
				} else {
					return result;
				}
				
				
				if(password.equals(pass)) {
					result = 1;				
				} else {
					result = 0;
				}			
			} catch(Exception e) {				
				e.printStackTrace();			
			} finally {		
				DBManager.close(conn, pstmt, rs);
			}		
			return result;
		}
		
	public void joinMember(Member pmember) {
		
		String joinSql = "INSERT INTO pmember VALUES(pmember_seq.NEXTVAL,?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(joinSql);
			
			pstmt.setString(1, pmember.getId());
			pstmt.setString(2, pmember.getName());
			pstmt.setString(3, pmember.getPass());
			pstmt.setString(4, pmember.getEmail());
			pstmt.setString(5, pmember.getMobile());
			pstmt.setString(6, pmember.getZipcode());
			pstmt.setString(7, pmember.getAddr1());
			pstmt.setString(8, pmember.getAddr2());
			
			pstmt.executeUpdate();
		
		} catch(Exception e) {
			e.printStackTrace();
		
		} finally {
			
			DBManager.close(conn, pstmt);
		}
	}
	
	public boolean overlapIdCheck(String id) {
		
		String overlapSql = "SELECT id FROM pmember WHERE id = ?";
		boolean result = false;
		
		try {
			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(overlapSql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = true;
			}
			System.out.println("overlapIdCheck(String id)");
			
		} catch(Exception e) {
			e.printStackTrace();
		
		} finally {
			
			DBManager.close(conn, pstmt, rs);
		}
		return result;
		
	}
	
public int checkMember(String id, String pass) {
		
		String loginSql = "SELECT pass FROM pmember WHERE id = ?";
		
		int result = -1;
		String password = "";
		
		try {
			
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(loginSql);
			
		
			pstmt.setString(1, id);
			

			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {				
			
				password = rs.getString("pass");
			} else {
				return result;
			}
			
			if(password.equals(pass)) {
				result = 1;				
			} else {
				result = 0;
			}			
		} catch(Exception e) {				
			e.printStackTrace();			
		} finally {		
			DBManager.close(conn, pstmt, rs);
		}		
		return result;
	}
	public Member getMember(String id) {
		String selectMember = "SELECT * FROM pmember WHERE id = ?";
		Member pmember = null;
		
		try {
			
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(selectMember);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pmember = new Member();
				pmember.setNo(rs.getInt("no"));
				pmember.setId(rs.getString("id"));
				pmember.setName(rs.getString("name"));
				pmember.setPass(rs.getString("pass"));
				pmember.setEmail(rs.getString("email"));
				pmember.setMobile(rs.getString("mobile"));
				pmember.setZipcode(rs.getString("zipcode"));
				pmember.setAddr1(rs.getString("addr1"));
				pmember.setAddr2(rs.getString("addr2"));		
			}
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return pmember;
	}
	
	public void updateMember(Member pmember) {
		
		String joinSql = "UPDATE pmember SET id=?, pass=?, email=?, mobile=?, "
				+ "zipcode=?, addr1=?, addr2=? WHERE no=?";
		System.out.println("updateMember - no : " + pmember.getNo());
		try {
			conn = DBManager.getConnection();
			
			pstmt = conn.prepareStatement(joinSql);
			
			pstmt.setString(1, pmember.getId());
			pstmt.setString(2, pmember.getPass());
			pstmt.setString(3, pmember.getEmail());
			pstmt.setString(4, pmember.getMobile());
			pstmt.setString(5, pmember.getZipcode());
			pstmt.setString(6, pmember.getAddr1());
			pstmt.setString(7, pmember.getAddr2());
			pstmt.setInt(8, pmember.getNo());
			
			pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		
		} finally {
			
			DBManager.close(conn, pstmt);
		}
		
	}

}
