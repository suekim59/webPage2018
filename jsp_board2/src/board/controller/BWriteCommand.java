package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.Board1DAO;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//1. parameter 받아오기
		String bname=request.getParameter("bname");
		String bpass=request.getParameter("bpass");
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		//2. dao 연결 (bwritecommand)
		Board1DAO dao=new Board1DAO();
		//3. b1write(String bname, String bpass, String btitle, String bcontent) 
		int result=dao.b1write(bname, bpass, btitle, bcontent);
		//4. 성공여부 처리 ( 성공 -list.jsp / 실패 - write_view.do )
		if(result==1) {
			/*String viewpage=request.getContextPath() + "/list.do";
			RequestDispatcher dispatcher=request.getRequestDispatcher(viewpage);
			dispatcher.forward(request, response);*/
			out.println("<script>alert('글쓰기 성공!'); location.href='list.do'; </script>");
		}else {
			/*RequestDispatcher dispatcher=request.getRequestDispatcher("/write_view.do");
			dispatcher.forward(request, response);*/
			out.println("<script>alert('글쓰기 실패!'); history.go(-1); </script>");
		}
		
		
		
	}

}
