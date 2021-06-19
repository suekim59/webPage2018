package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.Board1DAO;
import board.dto.Board;

public class BUpdateViewCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		int bno=Integer.parseInt(request.getParameter("bno"));
		//1. dao 연결 (b1getInfo)
		Board1DAO dao=new Board1DAO();
		//2. b1getInfo(int bno)
		Board dto=new Board();
		dto=dao.b1getInfo(bno);
		//3. 성공여부 처리 (성공 : /board1/modify.jsp  )
		request.setAttribute("dto",dto);
		/*RequestDispatcher dispatcher=request.getRequestDispatcher("/board1/modify.jsp");
		dispatcher.forward(request,response);*/	
	}

}
