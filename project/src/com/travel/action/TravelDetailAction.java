package com.travel.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.travel.pak.dao.PackageDao;
import com.travel.pak.dto.TravelPak;

public class TravelDetailAction implements TravelPakProcess {

	@Override
	public ForwardService requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String no = request.getParameter("no");
		
		PackageDao dao = PackageDao.getInstance();
		TravelPak pakDetail = dao.detailPak(Integer.parseInt( no ));
		
		request.setAttribute("no", no);
		request.setAttribute("pakDetail", pakDetail);
	
		ForwardService forward = new ForwardService();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/index.jsp?body=travelpak/travelDetailView.jsp");
		
		return forward;
	}
}
