package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;

public class MLoginCommand implements MCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String remember = request.getParameter("remember");
		String userid = request.getParameter("userid");
		String userpass = request.getParameter("userpass");
		
		int count = 0; // userid와 userpass를 만족하는 user의 수 count
		
		MemberDAO dao = new MemberDAO();
		count = dao.login(userid, userpass);
		
		// count = 0이면 해당하는 user 없음
		if(count==0) {
			out.println("<script>"
					+ "alert('아이디와 비밀번호를 확인해주세요.');"
					+ "location.href='./b1login_view.login'"
					+ "</script>");
		} else {
			int age = 60*60*24;
			
			if(remember != null) {
				remember = "remember";
				
				Cookie cookie = new Cookie("remember",remember);
				cookie.setMaxAge(age);
				response.addCookie(cookie);
				
				Cookie cookie2 = new Cookie("userid",userid);
				cookie2.setMaxAge(age);
				response.addCookie(cookie2);
			} else {
				remember = "no_remember";
				
				Cookie cookie = new Cookie("remember",remember);
				cookie.setMaxAge(age);
				response.addCookie(cookie);
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("userid", userid);
		}
	}
	
	

}
