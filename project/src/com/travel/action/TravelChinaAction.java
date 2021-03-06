package com.travel.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.travel.pak.dao.PackageDao;
import com.travel.pak.dto.TravelPak;

public class TravelChinaAction implements TravelPakProcess {

	@Override
	public ForwardService requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cNum = request.getParameter("cNum");
		ArrayList<TravelPak> travelList = null;
		
		PackageDao dao = PackageDao.getInstance();
		
		travelList = dao.codeStateList(Integer.parseInt(cNum));
		
		request.setAttribute("travelList", travelList);
		request.setAttribute("cNum", cNum);
		
		System.out.println("travelList : "+travelList);
		
		ForwardService forward = new ForwardService();	
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/index.jsp?body=travelpak/travelChinaView.jsp");
		return forward;
		
	}
}
