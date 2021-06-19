package board.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.Board1DAO;
import board.dto.Board;

/**
 * Servlet implementation class testcontroller
 */
@WebServlet("*.test")
public class testcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionTest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionTest(request,response);
	}

	private void actionTest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		System.out.println("ACTIONTEST");
		
		String uri=request.getRequestURI();
		System.out.println("1 : "+uri);
		String context=request.getContextPath();
		System.out.println("2: "+context);
		String command=uri.substring(context.length());
		System.out.println("3: "+command);
		
		if(command.equals("/test.test")) {
			out.println("<br/> 1. result 값 <br/>");
			Board1DAO dao=new Board1DAO();
			int result=dao.b1update("asd","asd",5);
			
			
			
		/*	//ArrayList<Board> list=dao.b1listAll();
			Iterator<Board> iter=(dto).iterator();
			while(iter.hasNext()) {
				Board board=iter.next();
				out.println(board.getBname()+"<br/>");		*/	
			out.println("<br/>"+result+"<br/>");
		
		}					
		
	}
	
}
