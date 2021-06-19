package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.Board1DAO;
import board.dto.Board;

public class BDetailCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			int bno=Integer.parseInt(request.getParameter("bno"));
			// 1. dao 연결 ( b1getInfo)
			Board1DAO dao=new Board1DAO();
			// 2. b1getInfo(int bno)
			int result=dao.b1hit(bno);
			if(result != 1) {
				System.out.println("조회수 올리기 실패!");
			}
			Board dto=new Board();
			dto=dao.b1getInfo(bno);
			
			// 3. 성공 여부 처리 ( 성공 시 - /board1/detail.jsp , 실패시 - list.jsp )
			request.setAttribute("dto",dto);
			//RequestDispatcher dispatcher=request.getRequestDispatcher("/board1/Detail.jsp");
			//dispatcher.forward(request,response);	
	}

}
