package com.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.dao.MemberDao;
import com.travel.action.ForwardService;
import com.travel.action.TravelPakProcess;


public class LoginService implements TravelPakProcess {

	@Override
	public ForwardService requestProcess(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
				
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		/*String currentUrl = request.getParameter("currentURL");*/
		// 주석		
		MemberDao dao = MemberDao.getInstance();
		int checkLogin = dao.checkMember(id, pass);
		
		if(checkLogin == -1) {
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();	
			out.println("<script>");
			out.println("	alert('" + id + "는 가입되지 않은 아이디 입니다.');");
			out.println("	window.history.back();");
			out.println("</script>");
			return null;
		} else if(checkLogin == 0) {		
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("	alert('비밀번호가 맞지 않습니다.');");
			out.println("	window.history.back();");
			out.println("</script>");
			return null;

	} else if(checkLogin == 1) {	
			
			HttpSession session =  request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("isLogin", true);
		}
		
	/*	if(currentUrl == null) {
			currentUrl = "*.mvc";
		}
		System.out.println("currentUrl : " + currentUrl);
	*/	
		ForwardService forward = new ForwardService();	
		forward.setRedirect(false);
		forward.setPath("*.mvc");
		
		return forward;
	}

}
