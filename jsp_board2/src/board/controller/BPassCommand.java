package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.Board1DAO;

public class BPassCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//1. parameter 가져오기 (pass)
		String bpasstocheck=request.getParameter("bpass");//가지고 오기
		int bno=Integer.parseInt(request.getParameter("bno"));
		String bcommand=request.getParameter("bcommand");
		System.out.println("입력한 비밀 번호 : "+bpasstocheck);
		System.out.println(bcommand);
		//2. dao 연결 ( b1check)
		Board1DAO dao=new Board1DAO();
		//3. b1check (int bno)
		String bpass=dao.b1check(bno);
		System.out.println("저장된 비밀 번호 : "+bpass);
		//4. 입력한 parameter와 동일한지 확인 (실패 시 /pass_view.do)
		//5. 확인 후 성공시 - /update.view.do 아니면 / delete.do
		
		if(bpasstocheck.equals(bpass)) {
			out.println("<script>location.href='"+bcommand+"?bno="+bno+"'; </script>");
			//out.println("<script>alert('비밀번호를 확인해주세요!'); history.go(-1); </script>");
		} else {
			out.println("<script>alert('비밀번호를 확인해주세요!'); history.go(-1); </script>");
		}
		/*if(bpasstocheck !=bpass) {
			response.sendRedirect(bcommand+"?bno="+bno);
			System.out.println(bcommand);
		}else {
			out.println("<script>alert('비밀번호를 확인해주세요!'); history.go(-1); </script>");
		}*/
		

	}

}
