package jspstudy.ajaxcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.travel.pak.dao.TravelDao;
import com.travel.pak.dto.Reply;



public class ReplyDeleteProcess implements AjaxProcess {

	@Override
	public void ajaxProcess(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		String bbsNo = request.getParameter("bbsNo");
		String no = request.getParameter("no");
		System.out.println(" ReplyDelete - no : " + no + ", bbsNo : " + bbsNo);
		
		TravelDao dao = TravelDao.getInstance();
		dao.replyDelete(Integer.parseInt(no));
		ArrayList<Reply> replys = dao.getReplyList(Integer.parseInt(bbsNo));
		
		Gson gson = new Gson();
		String result = gson.toJson(replys);
		
		response.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		out.println(result);
	}

}
