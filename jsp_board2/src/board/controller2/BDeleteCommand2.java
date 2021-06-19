package board.controller2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.Board2DAO;

public class BDeleteCommand2 implements BCommand2 {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		int bno=Integer.parseInt(request.getParameter("bno"));
		//1. dao 연결
		Board2DAO dao=new Board2DAO();
		//2. b1delete(int bno)
		int result=dao.b2delete(bno);
		//3. 성공 시 -list.jsp , 실패시 - /board1/detail.jsp
		System.out.println(result);
		if(result==1) {
			out.write("<script> alert ('삭제 성공!');</script>");
		}

	}

}
