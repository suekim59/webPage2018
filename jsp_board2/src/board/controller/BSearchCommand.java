package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.Board1DAO;
import board.dto.Board;

public class BSearchCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
	/*	String btitle=request.getParameter("btitle");
		System.out.println(btitle);
		Board1DAO dao=new Board1DAO();
		*/
		ArrayList<Board> dto=new Board1DAO().b1search(request.getParameter("btitle"));
		request.setAttribute("list1", dto);
		
		
		
		
	}
	

}
