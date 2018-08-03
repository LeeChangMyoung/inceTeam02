package com.member.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.dao.MemberDao;



public class PassCheckAction implements AjaxProcess {

	@Override
	public void ajaxProcess(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		response.setContentType("text/html; charset=utf-8"); 
		//response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(id == null || pass == null) {
			
			/* 클라이언트에서 자바스크립트 문장으로 해석해 주는 
			 * eval() 함수를 사용하기 때문에 script 구문은 기술하지 않았다.
			 **/			
			out.println("	alert('정상적인 접근이 아닙니다.');");
			//out.println("	window.history.back();");			
			return;
		}
		
		MemberDao dao = MemberDao.getInstance();
		int result = dao.checkMember(id, pass);
		
		String message = "({ 'result' : '" + result + "' })";
		out.println(message);


	}

}
