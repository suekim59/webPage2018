package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;
import memberdto.Members;

public class MJoinComCommand implements MCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String userid = request.getParameter("userid");
		
		MemberDAO dao = new MemberDAO();
		Members member = dao.mypage(userid);
		
		request.setAttribute("member", member);
		
		
	}
	
	

}
