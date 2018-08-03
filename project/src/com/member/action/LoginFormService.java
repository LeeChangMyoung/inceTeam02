package com.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.travel.action.ForwardService;
import com.travel.action.TravelPakProcess;

public class LoginFormService implements TravelPakProcess {

	@Override
	public ForwardService requestProcess(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

		ForwardService forward = new ForwardService();
		forward.setPath("/WEB-INF/index.jsp?body=member/loginForm.jsp");
		return forward;
	}
}
