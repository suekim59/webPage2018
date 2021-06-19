package board.controller2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSplitPaneUI;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.dao.Board2DAO;
import board.dto.Board2;

public class BDetailCommand2 implements BCommand2 {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			
			int bno=Integer.parseInt(request.getParameter("bno"));
			System.out.println(bno);
			// 1. dao 연결 ( b1getInfo)
			Board2DAO dao=new Board2DAO();
			// 2. b1getInfo(int bno)
			int result=dao.b2hit(bno);
			if(result != 1) {
				System.out.println("조회수 올리기 실패!");
			}
			Board2 dto=new Board2();
			dto=dao.b2getInfo(bno);
			System.out.println("확인1 : "+dto.getBname());
			System.out.println("확인2 : "+dto.getBfile());
			
			// 3. 성공 여부 처리 ( 성공 시 - /board1/detail.jsp , 실패시 - list.jsp )
			request.setAttribute("dto",dto);
			
			//RequestDispatcher dispatcher=request.getRequestDispatcher("/board1/Detail.jsp");
			//dispatcher.forward(request,response);	
	}

}
