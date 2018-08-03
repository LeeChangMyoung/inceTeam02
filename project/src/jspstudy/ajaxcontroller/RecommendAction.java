package jspstudy.ajaxcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.travel.pak.dao.TravelDao;



public class RecommendAction implements AjaxProcess {
	
	@Override
	public void ajaxProcess(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {

			String recommend = request.getParameter("recommend");
			System.out.println("무슨값이 들어오는 겨?!?!?!?!?!" + recommend);
			String no = request.getParameter("no");
			
			TravelDao dao = TravelDao.getInstance();
			HashMap<String, Integer> map = dao.getRecommend(Integer.parseInt(no), recommend);
			
			PrintWriter out = response.getWriter();
			Gson gson = new Gson();
			String result = gson.toJson(map);
			out.print(result);
	}

}
