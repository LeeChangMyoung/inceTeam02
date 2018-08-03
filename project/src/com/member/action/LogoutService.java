package com.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.travel.action.ForwardService;
import com.travel.action.TravelPakProcess;



public class LogoutService implements TravelPakProcess {

	@Override
	public ForwardService requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session =  request.getSession();
		session.invalidate();
		
		ForwardService forward = new ForwardService();	
		forward.setRedirect(true);
		forward.setPath("*.mvc");
		return forward;
	}

}
