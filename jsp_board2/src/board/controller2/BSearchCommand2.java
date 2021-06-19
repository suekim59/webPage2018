package board.controller2;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.Board1DAO;
import board.dao.Board2DAO;
import board.dto.Board;
import board.dto.Board2;

public class BSearchCommand2 implements BCommand2 {
	
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String btitle=request.getParameter("btitle");
		
		Board2DAO dao=new Board2DAO();
		
		ArrayList<Board2> dto=dao.b2search(btitle);
		
		request.setAttribute("list2", dto);

}

}