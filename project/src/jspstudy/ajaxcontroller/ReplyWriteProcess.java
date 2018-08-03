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



public class ReplyWriteProcess implements AjaxProcess {

	@Override
	public void ajaxProcess(
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		
			String bbsNo = request.getParameter("bbsNo");
			String replyWriter = request.getParameter("replyWriter");
			String replyContent = request.getParameter("replyContent");

			Reply reply = new Reply();
			reply.setBbsNo(Integer.parseInt(bbsNo));
			reply.setWriter(replyWriter);
			reply.setReply(replyContent);
			TravelDao dao = TravelDao.getInstance();
			dao.addReply(reply);

			ArrayList<Reply> replyList = dao.getReplyList(Integer.parseInt(bbsNo));
			Gson gson = new Gson();
			
			String result = gson.toJson(replyList);
			
			response.setContentType("text/html; charset=utf-8"); 
			PrintWriter out = response.getWriter();
			//{test: '테스트'}
			out.println(result);
			
	}

}
