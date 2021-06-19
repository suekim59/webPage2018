package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.Board1DAO;

public class BUpdateCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		System.out.println("확인용1");
		//1. parameter 가져오기 
		int bno=Integer.parseInt(request.getParameter("bno"));
		System.out.println(bno);
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		
		System.out.println(bcontent);
		//2. dao 연결 (b1update)
		Board1DAO dao=new Board1DAO();
		//3. b1update(String btitle, String bcontent, int bno)
		int result=dao.b1update(btitle, bcontent, bno);
		//4. 성공시 - /board1/detail.jsp , 실패시 - /update_view.do
		if(result==1) {
			out.write("<script> alert ('업데이트 성공!' );</script>");
		}else {
			out.write("<script> alert ('업데이트 실패! 관리자에게 문의바랍니다.</script>");
		}
	}

}
