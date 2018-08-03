package com.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.dto.Member;
import com.travel.action.ForwardService;
import com.travel.action.TravelPakProcess;



public class MemberUpdateInfoService implements TravelPakProcess {

	@Override
	public ForwardService requestProcess(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");		
		
		String id =  request.getParameter("id");
		String name = request.getParameter("name");		
		String pass = request.getParameter("pass1");
		String emailId = request.getParameter("emailId");
		String emailDomain = request.getParameter("emailDomain");
		String mobile1 = request.getParameter("mobile1");		
		String mobile2 = request.getParameter("mobile2");
		String mobile3 = request.getParameter("mobile3");
		String zipcode = request.getParameter("zipcode");		
		String addr1 = request.getParameter("address1");
		String addr2 = request.getParameter("address2");
		
		Member pmember = new Member();
		
		pmember.setId(id);
		pmember.setName(name);
		pmember.setPass(pass);
		pmember.setEmail(emailId + "@" + emailDomain);
		pmember.setMobile(mobile1 + "-" + mobile2 + "-" + mobile3);
		pmember.setZipcode(zipcode);
		pmember.setAddr1(addr1);
		pmember.setAddr2(addr2);
		
		
		HttpSession session = request.getSession(); 
		Member m = (Member) session.getAttribute("pmember");
		
		pmember.setNo(m.getNo());
		request.setAttribute("pmember", pmember);
		
		ForwardService forward = new ForwardService();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/index.jsp?body=member/memberUpdateInfo.jsp");
		return forward;
	}

}
