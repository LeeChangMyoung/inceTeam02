package com.travel.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.travel.action.ForwardService;
import com.travel.action.TravelPakProcess;


public class TravelPakController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<String, TravelPakProcess> cmdMap = new HashMap<String,TravelPakProcess>();
	
	
	//서블릿 초기화
	public void init() throws ServletException{
		
		String uriCommand = getInitParameter("uriCommand");
		
		ServletContext sc = getServletContext();
		String uploadDir = sc.getInitParameter("uploadDir");
		String realPath = sc.getRealPath(uploadDir);
		File parentFile = new File(realPath);
		
		if(!(parentFile.exists()&&parentFile.isDirectory())) {
			parentFile.mkdir();
		}
		
		Properties prop = new Properties();
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		try {
			String propPath = sc.getRealPath(uriCommand);
			fis = new FileInputStream(propPath);
			bis = new BufferedInputStream(fis);
			prop.load(bis);
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(bis != null) bis.close();
				if(fis != null) fis.close();
			}catch(IOException e) {e.printStackTrace();}
		}
		
		Iterator<Object> keyIter = prop.keySet().iterator();
		
		while(keyIter.hasNext()) {
			String cmd = (String) keyIter.next();
			String className = prop.getProperty(cmd) ;
			
			try {
				
				Class<?> commandClass = Class.forName(className);
					
				TravelPakProcess service = 
						(TravelPakProcess) commandClass.newInstance();

				cmdMap.put(cmd, service);
				
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			} catch(InstantiationException e) {
				e.printStackTrace();
			} catch(IllegalAccessException e) {
				e.printStackTrace();
			}
			
			sc.setAttribute("uploadDir", uploadDir);
			sc.setAttribute("parentFile", parentFile);
		}	
			
	}
	
	
	protected void doProcess(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
		// 요청 정보를 담고 있는 Uri
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmd = requestURI.substring(contextPath.length());
		
		TravelPakProcess service = cmdMap.get(cmd);
		ForwardService forward =  service.requestProcess(request, response);
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
				
			} else {
				RequestDispatcher rd = 
						request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}	
		
	}
	
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doProcess(request, response);
	}

}
