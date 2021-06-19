package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDAO;

public class MDeleteCommand implements MCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		String userid = request.getParameter("userid");
		
		MemberDAO dao = new MemberDAO();
		int result = dao.m1delete(userid);
		
		if(result>0) {
			out.println("<script>"
					+ "alert('삭제처리가 완료되었습니다.');"
					+ "</script>");
		} else {
			out.println("<script>"
					+ "alert('삭제처리가 실패했습니다. 관리자에게 문의바랍니다.');"
					+ "location.href='javascript:history.go(-3)';"
					+ "</script>");
		}
		
	}
	
	

}
