package com.member.ajax;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ajax 요청을 처리하는 Controller 클래스 
@WebServlet(name="ajaxController", 
	urlPatterns="*.ajax", initParams=@WebInitParam(
			name="ajaxCommand", value="/WEB-INF/ajaxCommand.properties"))
public class AjaxController extends HttpServlet {
	
	// ajax 요청 명령어와 명령어를 처리할 클래스의 인스턴스를 저장할 Map 객체 생성하고 있다.
	Map<String, AjaxProcess> ajaxMap = 
			new HashMap<String, AjaxProcess>();

	@Override
	public void init() throws ServletException {
		
		String ajaxCommand = getInitParameter("ajaxCommand");
		
		Properties prop = new Properties();
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		try {
			// ajaxCommand.properties의 절대 경로를 구한다.
			String realPath = getServletContext().getRealPath(ajaxCommand);
			
			fis = new FileInputStream(realPath);
			bis = new BufferedInputStream(fis);
			
			prop.load(bis);
			
		} catch(IOException e) {			
			throw new ServletException();
			
		} finally {			
			try {				
				// 보조 스트림을 먼저 닫고 기반 스트림을 닫는다.
				if(bis != null) bis.close();
				if(fis != null) fis.close();
				
			} catch(IOException ioe) { }
		}
		
		Iterator<Object> keyIter = prop.keySet().iterator();
		
		while(keyIter.hasNext()) {
			
			String command = (String) keyIter.next();
			String className = (String) prop.getProperty(command);
			System.out.println("command : " 
					+ command + ", className : " + className);
			
			try {
				
				Class<?> commandClass = Class.forName(className);
				
				AjaxProcess ajaxProcess = 
						(AjaxProcess) commandClass.newInstance();
				
				ajaxMap.put(command, ajaxProcess);
				
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
				throw new ServletException();
				
			} catch(InstantiationException e) {
				e.printStackTrace();
				throw new ServletException();
				
			} catch(IllegalAccessException e) {
				e.printStackTrace();
				throw new ServletException();
			}
		}
	}
	
	public void doAjax(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
	
		AjaxProcess ajaxProcess = null;
		
		// Request 객체로 부터 요청 URI를 구한다.
		String command = request.getRequestURI();
		
		// 요청 URI에서 ContextPath를 제외한 요청 명령어를 추출 한다. 
		command = command.substring(request.getContextPath().length());	
		System.out.println("command : " + command);
		
		ajaxProcess = ajaxMap.get(command);
		System.out.println("command : " + command 
				+ ", commandPro : " + ajaxProcess);
		
		if(ajaxProcess != null) {
			ajaxProcess.ajaxProcess(request, response);
		}
		
	}
	
	@Override
	public void doGet(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
		doAjax(request, response);
	}
	
	@Override
	public void doPost(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
		doAjax(request, response);
	}
}
