package board.controller2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.Board2DAO;
import board.dto.Board2;

public class BUpdateViewCommand2 implements BCommand2 {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		int bno=Integer.parseInt(request.getParameter("bno"));
		System.out.println(bno);
		
		//1. dao 연결 (b1getInfo)
		Board2DAO dao=new Board2DAO();
		//2. b1getInfo(int bno)
		Board2 dto=new Board2();
		dto=dao.b2getInfo(bno);
		//dto 던지기 전에 replace 처리
		dto.setBcontent(dto.getBcontent().replace("<br>", "\r\n"));
		//3. 성공여부 처리 (성공 : /board1/modify.jsp  )
		request.setAttribute("dto",dto);
		
	}

}
