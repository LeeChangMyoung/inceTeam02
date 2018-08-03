package com.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.dao.MemberDao;
import com.travel.action.ForwardService;
import com.travel.action.TravelPakProcess;


public class OverlapIdCheckService implements TravelPakProcess {

	@Override
	public ForwardService requestProcess(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		
		String id = request.getParameter("id");
		
		MemberDao dao =  MemberDao.getInstance();		
		boolean overlap = dao.overlapIdCheck(id);
		
		request.setAttribute("id", id);
		request.setAttribute("overlap", overlap);
		
		ForwardService forward = new ForwardService();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/member/overlapIdCheck.jsp");

		return forward;
	}

}
