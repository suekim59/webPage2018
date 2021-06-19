package board.controller2;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.Board2DAO;
import board.dto.Board2;

public class BListpagingCommand2 implements BCommand2 {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 전체 글 갯수
		Board2DAO dao = new Board2DAO();
		int listcount = dao.b2listCount();
		
		// 2. 한페이지에 보여줄 게시물의 수
		double onepagelimit = 8;
		
		// 3. 총페이지 계산
		// 전체글(listcount) / 한페이지에 보여줄 게시물의 수(onepagelimit)
		// 112/10 = 11.2 = 12개
		// round / ceil / floor
		double pagetotal = (int) Math.ceil(listcount / onepagelimit);
		
		// 4. 하단에 페이지 나누기 수
		// <= 1 2 3 4 5 6 7 8 9 10 =>
		double bottomlist = 10;
		
		// 5. 페이지의 스타트번호 지정: 최신글부터 불러오기
		int pstartno = 0;
		if(request.getParameter("pstartno") != null) {
			pstartno = (int) Float.parseFloat(request.getParameter("pstartno"));
		}
		
		// 1  0 -  9
		// 2 10 - 19
		// 3 20 - 29
		// 6. 최신글부터 10개씩 보여주기
		dao = new Board2DAO();
		ArrayList<Board2> boards2 = dao.b2list10((int)pstartno, (int) onepagelimit);
		System.out.println("?4545"+boards2);
		// 7. 하단 index: 현재 페이지 0~9 => 1페이지를 의미
		/*	현재 페이지 1: - 최신글부터 10개:  0~ 9
		 	현재 페이지 2: - 최신글부터 10개: 10~19
		 	현재 페이지 3: - 최신글부터 10개: 20~29
		 	11 12 13 14 15 16 [17] 18 19 20	*/
		
		/*
		 	110-119
		 	( 0 + 1)		=  1	=>  1/10	=> 0.1	=> Math.ceil(0.1) = 1
		 	( 9 + 1)		= 10	=> 10/10	=> 1.0	=> Math.ceil(1.0) = 1
		 	
		 	(10 + 1)		= 11	=> 11/10	=> 1.1	=> Math.ceil(1.1) = 2
		 	(19 + 1)		= 20	=> 20/10	=> 2.0	=> Math.ceil(2.0) = 2
		 	
		 */
		double current_page = 0;
		//double current_page2 = 0;
		current_page = Math.ceil((pstartno+1)/onepagelimit);
		//current_page2 = (pstartno/onepagelimit)+1;
		
		// 8. 하단 index: 시작페이지
		/*	 1-10 => 1
		 	11-20 => 2	(17) - 11
		 	21-20 => 3
		 	
		 	17/10 = 1.7 = floor(1.7) = 1 / 1*10 + 1
		 	11			17			20
	1) 1/10	1.1			1.7			2.0			(/bottomlist)
	2)		floor(1.1)	floor(1.7)	floor(2.0)
	3)		1			1			2
	
		 	11			17			20
	0) -1	10			16			19
	1) 1/10	1.0			1.6			1.9
	2)		floor(1.0)	floor(1.6)	floor(1.9)
	3)		1			1			1
	4) *10	10			10			10			(*bottomlist)
	5) +1	11			11			11							*/
		double start_page = Math.floor((current_page-1)/bottomlist) * bottomlist+1;
		
		// 9. 하단 index: 마지막페이지
		double end_page = start_page+(bottomlist-1);
		
		// 게시글이 없는 페이지번호가 없도록 처리
		if(end_page>pagetotal) {
			end_page=pagetotal;
		}
		
		/*System.out.println("1 - 350: "+listcount);
		System.out.println("2 -  10: "+onepagelimit);
		System.out.println("3 -  35: "+pagetotal);
		System.out.println("4: "+pstartno);
		System.out.println("5 -  0: "+current_page);
		//System.out.println("5(2) -  0: "+current_page2);
		System.out.println("6 -  0: "+start_page);
		System.out.println("7 -  0: "+end_page);*/
		
		request.setAttribute("pagetotal", pagetotal);
		request.setAttribute("boards2", boards2);
		request.setAttribute("current_page", current_page);
		request.setAttribute("start_page", start_page);
		request.setAttribute("end_page", end_page);
	}

}



