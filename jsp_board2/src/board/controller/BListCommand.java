package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.Board1DAO;
import board.dto.Board;

public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. dao연결
		Board1DAO dao=new Board1DAO();
		//2. ArrayList<Board> b1listAll()
		ArrayList<Board> dtos=dao.b1listAll();
		//listcount하기
		int listcount=dao.b1listCount(); 
		
		request.setAttribute("list1", dtos);
		request.setAttribute("listcount1", listcount);


	}

}
