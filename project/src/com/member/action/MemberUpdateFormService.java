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



public class MemberUpdateFormService implements TravelPakProcess {

	@Override
	public ForwardService requestProcess(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		
		HttpSession session =  request.getSession();
		String id = (String) session.getAttribute("id");
		
		MemberDao dao = MemberDao.getInstance();
		Member pmember = dao.getMember(id);
		System.out.println("updateFormService : no - " +pmember.getNo());
		session.setAttribute("pmember", pmember);
		
		ForwardService forward = new ForwardService();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/index.jsp?body=member/memberUpdateForm.jsp");		
		return forward;
	}

}
