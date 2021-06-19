package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;

public class MJoinCommand implements MCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		String useremail = request.getParameter("useremail");
		
		MemberDAO dao = new MemberDAO();
		int result = dao.b1join(userid, username, userpass, useremail);
		
		if(result>0) {
			out.println("<script>alert('등록이 성공했습니다.');</script>");
		} else {
			out.println("<script>alert('등록이 실패했습니다.관리자에게 문의바랍니다.');</script>");
		}
		
	}
	
	

}
