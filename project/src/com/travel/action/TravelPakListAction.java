package com.travel.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.travel.pak.dao.PackageDao;
import com.travel.pak.dto.TravelPak;

public class TravelPakListAction implements TravelPakProcess {
	@Override
	public ForwardService requestProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<TravelPak> pakList = null;

		PackageDao dao = PackageDao.getInstance();
		pakList = dao.pakList();
		
		request.setAttribute("pakList", pakList);

		ForwardService forward = new ForwardService();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/index.jsp?body=travelpak/travelPakListView.jsp");
		
		return forward;
	}
}
