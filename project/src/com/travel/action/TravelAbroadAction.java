package com.travel.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TravelAbroadAction implements TravelPakProcess {

	@Override
	public ForwardService requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ForwardService forward = new ForwardService();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/index.jsp?body=travelpak/travelPakListView.jsp&side=1");
		return forward;
	}
}
