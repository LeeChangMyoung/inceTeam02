package com.travel.pak.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.travel.pak.dto.Reply;
import com.travel.pak.dto.Travel;



public class TravelDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private static TravelDao instance = new TravelDao();
	private TravelDao() {}
	
	public static TravelDao getInstance() {
		return instance;
	}
	
	// 한 페이지에 보여 질 게시 글 리스트
	public ArrayList<Travel> getTravelList(int startRow, int endRow) {
		ArrayList<Travel> tList = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM "
					+ "(SELECT ROWNUM num, no, title, writer, "
					+ "content, reg_date, read_count, pass, file1 FROM "
					+ "(SELECT * FROM travel ORDER BY no DESC)) "
					+ "WHERE num >= ? AND num <= ? ");
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				tList = new ArrayList<Travel>();
			
			do {
				Travel t = new Travel();
				t.setNo(rs.getInt("no"));
				t.setTitle(rs.getString("title"));
				t.setWriter(rs.getString("writer"));
				t.setContent(rs.getString("content"));
				t.setRegDate(rs.getTimestamp("reg_date"));
				t.setReadCount(rs.getInt("read_count"));
				t.setPass(rs.getString("pass"));
				t.setFile(rs.getString("file1"));
				
				tList.add(t);	

			}while(rs.next());
				// rs는 행의 데이터에서 컬럼의 데이터를 읽어올 수 있는 getter를 제공한다. get(1), getXXX("ID")
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn,pstmt,rs);
		}
		
		return tList;
	}
	
	public Travel getTravel(int no) {
		Travel t = new Travel();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM travel WHERE no = ? ");
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			while(rs.next()) {
			t.setNo(rs.getInt("no"));
			t.setTitle(rs.getString("title"));
			t.setContent(rs.getString("content"));
			t.setWriter(rs.getString("writer"));
			t.setRegDate(rs.getTimestamp("reg_date"));
			t.setReadCount(rs.getInt("read_count"));
			t.setPass(rs.getString("pass"));
			t.setFile(rs.getString("file1"));
			t.setRecommend(rs.getInt("recommend"));
			t.setThank(rs.getInt("thank"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				DBManager.close(conn,pstmt,rs);	
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return t;
	}
	// 게시 글 입력
	public int addTravel(Travel t) {
		int result = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO travel values "
					+ "(TRAVEL_NO.NEXTVAL,?,?,?,sysdate,0,?,?) ");
			pstmt.setString(1, t.getTitle());
			pstmt.setString(2, t.getWriter());
			pstmt.setString(3, t.getContent());
			pstmt.setString(4, t.getPass());
			pstmt.setString(5, t.getFile());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn,pstmt);
		}
		 
		return result;
	}
	// 삭제하기
	public void deleteTravel(int no) {
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("DELETE travel WHERE no = ?");
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			
		} finally {
			DBManager.close(conn,pstmt);
		}
		
	}
	//업데이트!
	public void upDateTravel(Travel t) {
		String sqlNoFileUpdate = "UPDATE travel SET title=?, writer=?, content=?, "
				+"reg_date=SYSDATE WHERE no=? ";
		String sqlFileUpdate = "UPDATE travel SET title=?, writer=?, content=?, "
				+"reg_date=SYSDATE, file1=? WHERE no =? ";
		try {
			conn = DBManager.getConnection();
			//파일없이 업로드
			System.out.println("no : " + t.getNo());
			System.out.println("no : content" + t.getContent());
			if(t.getFile()==null) {
				pstmt = conn.prepareStatement(sqlNoFileUpdate);
				pstmt.setString(1, t.getTitle());
				pstmt.setString(2, t.getWriter());
				pstmt.setString(3, t.getContent());
				pstmt.setInt(4, t.getNo());
			}else {
				pstmt = conn.prepareStatement(sqlFileUpdate);
				pstmt.setString(1, t.getTitle());
				pstmt.setString(2, t.getWriter());
				pstmt.setString(3, t.getContent());
				pstmt.setString(4, t.getFile());
				pstmt.setInt(5, t.getNo());
			}
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn,pstmt);
		}
	}
	// DB테이블에 등록된 모든 게시 글의 수를 반환
	// 페이징 처리 
	public int getTravelCount() {
		int count = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("SELECT COUNT(*) FROM travel");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn,pstmt,rs);
		}
		return count;
	}
	
	
	// 검색어에 해당하는 게시 글 수를 계산하기 위한 메서드
	// DB 테이블에 등록된 모든 게시 글의 수를 반환 하는 메서드
	public int getTravelCount(String type, String keyword) {
		int count = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("SELECT COUNT(*) FROM travel WHERE "
			+ type + " LIKE '%' || ? || '%'") ;
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}
	public ArrayList<Travel> searchList(
			String type, String keyword, int startRow, int endRow) {
		
		ArrayList<Travel> travelList = null;
		
		try{			
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM (SELECT ROWNUM num, no, title, "
				    + " writer, content, reg_date, read_count, pass, file1 FROM "
					+ " (SELECT * FROM travel WHERE " + type + " LIKE ? "
					+ " ORDER BY no DESC)) WHERE num >= ? AND num <= ?" );			
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				travelList = new ArrayList<Travel>();
				
				do {					
					Travel t = new Travel();
					t.setNo(rs.getInt("no"));
					t.setTitle(rs.getString("title"));
					t.setContent(rs.getString("content"));
					t.setWriter(rs.getString("writer"));							
					t.setRegDate(rs.getTimestamp("reg_date"));
					t.setReadCount(rs.getInt("read_count"));
					t.setPass(rs.getString("pass"));
					t.setFile(rs.getString("file1"));
					
					travelList.add(t);
				}while(rs.next());
			}
		} catch(Exception e) {			
			e.printStackTrace();
			
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return travelList;
	}
	public Travel getTravel(int no, boolean state) {
		String travelSql = "SELECT * FROM travel WHERE no = ? ";
		String countSql = "UPDATE travel SET read_count = read_count + 1 "
				+ "WHERE no = ? ";
		
		Travel travel = null;
		
		try {
			
			conn = DBManager.getConnection();
			DBManager.setAutoCommit(conn, false);
			
			if(state) {
				
				pstmt = conn.prepareStatement(countSql);
				pstmt.setInt(1, no);
				pstmt.executeUpdate();
				
			}
			
			pstmt = conn.prepareStatement(travelSql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				travel = new Travel();
				travel.setNo(rs.getInt("no"));
				travel.setTitle(rs.getString("title"));
				travel.setContent(rs.getString("content"));
				travel.setWriter(rs.getString("writer"));
				travel.setRegDate(rs.getTimestamp("reg_date"));
				travel.setReadCount(rs.getInt("read_count"));
				travel.setPass(rs.getString("pass"));
				travel.setFile(rs.getString("file1"));
			}
			DBManager.commit(conn);
		}catch(Exception e) {
			DBManager.rollback(conn);
			
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return travel;
	}
	public boolean isPassCheck(int no, String pass) {
		boolean isPass = false;
		String sqlPass = "SELECT pass FROM travel WHERE no = ? ";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sqlPass);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isPass = rs.getString(1).equals(pass);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return isPass;
	}
	// 특정 게시글에 해당하는 댓글 리스트를 반환
	public ArrayList<Reply> getReplyList(int bbsNo) {
		Reply reply = null;
		ArrayList<Reply> replyList = null;
		String replyListSql = "select * from reply where bbs_no=? " 
		+ "order by no desc" ;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(replyListSql);
			pstmt.setInt(1, bbsNo);
			rs = pstmt.executeQuery();

			replyList = new ArrayList<Reply>();
			while (rs.next()) {
				reply = new Reply();
				reply.setNo(rs.getInt("no"));
				reply.setBbsNo(rs.getInt("bbs_no"));
				reply.setReply(rs.getString("reply"));
				reply.setWriter(rs.getString("writer"));
				reply.setRegDate(rs.getTimestamp("reg_date"));

				replyList.add(reply);
			}
			System.out.println("들어오십니까?" + replyList);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return replyList;
	}
	// 게시 글 상세 보기에서 추천과 땡큐를 요청
	// 추천, 땡큐의 횟수를 1씩증가
	public HashMap<String, Integer> getRecommend(int no, String strThank){
		HashMap<String, Integer> map = null;
		
		String addCommendSql = "UPDATE travel SET recommend=recommend + 1 WHERE no= ? ";
		String addThankSql = "UPDATE travel SET thank=thank + 1 WHERE no= ? ";
		String selectResultSql = "SELECT recommend, thank from travel WHERE no = ? ";
		
		try {
			conn = DBManager.getConnection();
			DBManager.setAutoCommit(conn, false);
			if(strThank.equals("recommend")) { // 추천
				pstmt = conn.prepareStatement(addCommendSql);
				pstmt.setInt(1, no);
			}else if(strThank.equals("thank")) {
				pstmt = conn.prepareStatement(addThankSql);
				pstmt.setInt(1, no);
			}
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(selectResultSql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			map = new HashMap<String, Integer>();
			if(rs.next()) {
				map.put("recommend", rs.getInt("recommend"));
				map.put("thank",rs.getInt("thank"));
			}
			
		}catch(Exception e) {
			DBManager.rollback(conn);
			e.printStackTrace();
		}finally {
			try {
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBManager.close(conn, pstmt,rs);
		}
		return map;
	}
	public void addReply(Reply reply) {
		String addReplySQL = "INSERT INTO reply values(reply_seq.NEXTVAL,?,?,?,SYSDATE) ";
		try {
			
			conn = DBManager.getConnection();			
			pstmt = conn.prepareStatement(addReplySQL);
			pstmt.setInt(1, reply.getBbsNo());
			pstmt.setString(2, reply.getReply());
			pstmt.setString(3, reply.getWriter());
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	// 댓글 수정!
	public int updateReply(Reply r) {
		int result = 0;
		String updateSql = "UPDATE reply SET reply=? WHERE no = ? ";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(updateSql);
			pstmt.setString(1, r.getReply());
			pstmt.setInt(2, r.getNo());
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	public void replyDelete(int no) {
		String replyDeleteSql = "delete from reply where no= ? ";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(replyDeleteSql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
}
