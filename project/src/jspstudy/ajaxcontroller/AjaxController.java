package jspstudy.ajaxcontroller;

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

@WebServlet(name="ajaxController", 
urlPatterns="*.ajax", initParams=@WebInitParam(
		name="ajaxCommand", value="/WEB-INF/ajaxCommand.properties"))
public class AjaxController extends HttpServlet {
	Map<String, AjaxProcess> ajaxMap = new HashMap<String, AjaxProcess>();
	
	public void init() throws ServletException{
		String ajaxCommand = getInitParameter("ajaxCommand");
		
		Properties prop = new Properties();
		
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		
		try {
			String realPath = getServletContext().getRealPath(ajaxCommand);
			
			fis = new FileInputStream(realPath);
			bis = new BufferedInputStream(fis);
			
			prop.load(bis);
			
		}catch(IOException e) {
			
			e.printStackTrace();
		}finally {
			try {
			if(bis != null) bis.close();
			if(fis != null) fis.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		Iterator<Object> keyIter = prop.keySet().iterator();
		while(keyIter.hasNext()) {
		String command = (String)keyIter.next();
		String className = prop.getProperty(command);
		System.out.println("command : " + command + ", className :" + className);
		
		try {
		
			Class<?> commandClass = Class.forName(className);
			AjaxProcess ajaxProcess = (AjaxProcess) commandClass.newInstance();
		
			ajaxMap.put(command, ajaxProcess);
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(InstantiationException e) {
			e.printStackTrace();
		}catch(IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
}
	protected void doAjax(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
			AjaxProcess ajaxProcess = null;
			
			String command = request.getRequestURI();
			
			command = command.substring(request.getContextPath().length());
	
			System.out.println("command : " + command);
			
			ajaxProcess = ajaxMap.get(command);
			
			if(ajaxProcess !=null) {
				ajaxProcess.ajaxProcess(request, response);
			}
	
	}
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
				doAjax(request, response);
	}
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
				doAjax(request, response);
	}

}
