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




public class ReplyUpdateProcess implements AjaxProcess {

	@Override
	public void ajaxProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String bbsNo = request.getParameter("bbsNo");
		String writer = request.getParameter("replyWriter");
		String content = request.getParameter("replyContent");
		String replyno = request.getParameter("replyno");
		
		Reply reply = new Reply();
		reply.setBbsNo(Integer.parseInt(bbsNo));
		reply.setWriter(writer);
		reply.setReply(content);
		reply.setNo(Integer.parseInt(replyno));
		TravelDao dao = TravelDao.getInstance();
		System.out.println("맞지??");
		int result = dao.updateReply(reply);
		System.out.println("수정이됐냐??" + result);		
		
		ArrayList<Reply> replys = dao.getReplyList(Integer.parseInt(bbsNo));
		
		Gson gson = new Gson();
		String resResult = gson.toJson(replys);
		
		response.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		out.println(resResult);
		
		
	}

}
