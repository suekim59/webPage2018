package board.controller2;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.Board2DAO;
import board.dto.Board2;

public class BListCommand2 implements BCommand2 {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. dao연결
		Board2DAO dao=new Board2DAO();
		//2. ArrayList<Board> b1listAll()
		ArrayList<Board2> dtos=dao.b2listAll();
		//listcount하기
		int listcount=dao.b2listCount(); 
		
		request.setAttribute("list2", dtos);
		request.setAttribute("listcount2", listcount);


	}

}
