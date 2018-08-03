package com.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.dao.MemberDao;
import com.member.dto.Member;
import com.travel.action.ForwardService;
import com.travel.action.TravelPakProcess;


public class MemberUpdateResultService implements TravelPakProcess {

	@Override
	public ForwardService requestProcess(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Member pmember = (Member) session.getAttribute("pmember");
		
		MemberDao dao =  MemberDao.getInstance();
		dao.updateMember(pmember);
		
		session.setAttribute("id", pmember.getId());
		
		session.removeAttribute("pmember");

		ForwardService forward = new ForwardService();
		forward.setRedirect(true);
		forward.setPath("*.mvc");
		return forward;
	}

}
