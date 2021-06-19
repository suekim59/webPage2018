package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;

public class MPassCommand implements MCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String userid = request.getParameter("userid");
		String userpass = request.getParameter("userpass");
		String mcommand = request.getParameter("mcommand");
		
		MemberDAO dao = new MemberDAO();
		int count = dao.login(userid, userpass);
		
		// count가 0이면 비밀번호 오류
		if(count == 0) {
			out.println("<script>"
					+ "alert('비밀번호가 틀렸습니다. 다시 입력해주세요.');"
					+ "location.href='./pass_view.login?mcommand="+mcommand+"';"
					+ "</script>");
		}
		
		
	}
	
	

}
