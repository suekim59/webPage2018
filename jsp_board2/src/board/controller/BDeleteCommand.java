package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.Board1DAO;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		int bno=Integer.parseInt(request.getParameter("bno"));
		//1. dao 연결
		Board1DAO dao=new Board1DAO();
		//2. b1delete(int bno)
		int result=dao.b1delete(bno);
		//3. 성공 시 -list.jsp , 실패시 - /board1/detail.jsp
		System.out.println(result);
		if(result==1) {
			out.write("<script> alert ('삭제 성공!');</script>");
		}

	}

}
