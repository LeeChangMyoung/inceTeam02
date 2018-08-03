package com.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.travel.action.ForwardService;
import com.travel.action.TravelPakProcess;



public class JoinFormService implements TravelPakProcess {

	@Override
	public ForwardService requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		ForwardService forward =  new ForwardService();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/index.jsp?body=member/memberJoinForm.jsp");
		
		return forward;
	}

}
