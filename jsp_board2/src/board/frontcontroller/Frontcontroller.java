	package board.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.controller.BCommand;
import board.controller.BDeleteCommand;
import board.controller.BDetailCommand;
import board.controller.BListCommand;
import board.controller.BPassCommand;
import board.controller.BSearchCommand;
import board.controller.BUpdateCommand;
import board.controller.BUpdateViewCommand;
import board.controller.BWriteCommand;
import board.controller.Contactme;
import board.controller2.BCommand2;
import board.controller2.BDeleteCommand2;
import board.controller2.BDetailCommand2;
import board.controller2.BListCommand2;
import board.controller2.BListpagingCommand2;
import board.controller2.BPassCommand2;
import board.controller2.BSearchCommand2;
import board.controller2.BUpdateCommand2;
import board.controller2.BUpdateViewCommand2;
import board.controller2.BWriteCommand2;
import board.dao.Board1DAO;
import board.dao.Board2DAO;
import board.dto.Board;
import board.dto.Board2;

/**
 * Servlet implementation class Frontcontroller
 */
@WebServlet("*.do")
public class Frontcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Frontcontroller() {
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
	
	private void actionTest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//url : uniform resource locator 정형화된 리소스 위치표시
		//uri : uniform resource 	identifier
		//모든 url은 uri이다. ( uri=url + urn )
		String uri=request.getRequestURI();
		System.out.println("1 : "+uri);
		String context=request.getContextPath();
		System.out.println("2: "+context);
		String command=uri.substring(context.length());
		System.out.println("3: "+command);
		
		BCommand controller=null;
		BCommand2 controller2=null;
		
		if(command.equals("/main.do")) {
			System.out.println(" Main ");
			controller=new BListCommand();
			controller.execute(request, response);
			
			controller2=new BListpagingCommand2();
			controller2.execute(request,response);
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("./main.jsp");
			dispatcher.forward(request, response);
			
		}else if(command.equals("/list.do")) {
			System.out.println(" LIST ");
			controller=new BListCommand();
			controller.execute(request,response);
			//1. dao연결
			//2. ArrayList<Board> b1listAll()
			//3. 성공시 board/list.jsp
			request.setAttribute("list1", request.getAttribute("list1"));
			request.setAttribute("listcount1", request.getAttribute("listcount1"));
			
			String viewpage="./board1/list.jsp";
			RequestDispatcher dispatcher=request.getRequestDispatcher(viewpage);
			dispatcher.forward(request, response);
		}else if(command.equals("/write_view.do")) {
			System.out.println(" WRITE_FORM");
			//1. dao x
			//2. 경로  
			response.sendRedirect(request.getContextPath() + "/board1/write.jsp");
		}else if(command.equals("/write.do")) {
			System.out.println(" WRITE");
			//1. dao 글쓰기 -  
			controller=new BWriteCommand();
			controller.execute(request,response);
			//2. 경로
			//response.sendRedirect(request.getContextPath() + "/board1/list.jsp");
		}else if(command.equals("/detail.do")) {
			System.out.println(" DETAIL");
			controller=new BDetailCommand();
			controller.execute(request,response);
			// 1. dao 해당 글 번호 데이터 가져오기
			// 2. 경로
			Board b = (Board)request.getAttribute("dto");
			System.out.println(b.getBname());
			request.setAttribute("dto",b);
			
			String viewpage="./board1/detail.jsp";
			RequestDispatcher dispatcher=request.getRequestDispatcher(viewpage);
			dispatcher.forward(request, response);
			
		}else if(command.equals("/pass_view.do")) {
			System.out.println(" PASS_FORM ");
			//1. dao : x
			// 2. 경로 
			int bno=Integer.parseInt(request.getParameter("bno"));
			String bcommand=request.getParameter("bcommand");
			request.setAttribute("bno", bno);
			request.setAttribute("bcommand",bcommand);
			
			String viewpage="./board1/pass.jsp";
			RequestDispatcher dispatcher=request.getRequestDispatcher(viewpage);
			dispatcher.forward(request, response);
			//response.sendRedirect(request.getContextPath() + "/board1/pass.jsp?bno="+bno+"&"bcommand);
		}else if(command.equals("/pass.do")) {
			System.out.println(" USER_CONFIRM");
			
			request.setAttribute("bno", request.getParameter("bno"));
			
			controller=new BPassCommand();
			controller.execute(request, response);
			//1. dao : b1check
			// 2. 경로 
			/*String bcommand=request.getParameter("bcommand");
			RequestDispatcher dispatcher=request.getRequestDispatcher(bcommand);
			dispatcher.forward(request, response);*/
			//out.write("<meta http-equiv='refresh' content= '0; url=./list.do'>");
			//out.write("<meta http-equiv='refresh' content= '0; url=bcommand'>");

		}else if(command.equals("/delete.do")) {
			System.out.println(" DELETE ");
			request.setAttribute("bno", request.getParameter("bno"));
			controller=new BDeleteCommand();
			controller.execute(request, response);
			//1. dao : b1delete
			// 2. 경로 
			//response.sendRedirect(request.getContextPath() + "/list.do");
			out.write("<meta http-equiv='refresh' content= '0; url=./list.do'>");
		}else if(command.equals("/update_view.do")) {
			System.out.println(" UPDATE_FORM ");
			request.setAttribute("bno", request.getParameter("bno"));
			controller=new BUpdateViewCommand();
			controller.execute(request, response);
			//1. dao : 해당 글 가져와서 수정 가능하게 데이터 채우기 
			// 2. 경로 
			Board b = (Board)request.getAttribute("dto");
			System.out.println(b.getBname());
			System.out.println(b.getBno());
			request.setAttribute("dto", b);
			System.out.println("나오고 있음");
			
			String viewpage="./board1/modify.jsp";
			request.setAttribute("bno", request.getParameter("bno"));
			RequestDispatcher dispatcher=request.getRequestDispatcher(viewpage);
			dispatcher.forward(request, response);
			
		}else if(command.equals("/update.do")) {
			System.out.println(" UPDATE ");
			
			request.setAttribute("bno", request.getParameter("bno"));
			System.out.println("확인용1");
			controller=new BUpdateCommand();
			controller.execute(request, response);
			int bno=Integer.parseInt(request.getParameter("bno"));
		

			out.write("<meta http-equiv='refresh' content= '0; url=./detail.do?bno="+bno+"'>");
		}else if (command.equals("/contact.do")) {
			System.out.println(" Contact Me ");
			
			controller=new Contactme();
			controller.execute(request, response);
			
			/*String viewpage="../contactme.jsp";
			RequestDispatcher dispatcher=request.getRequestDispatcher(viewpage);
			dispatcher.forward(request, response);*/
			
		
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////board2
			
		} else if(command.equals("/list2.do")) {
			System.out.println(" LIST2 ");
			controller2=new BListpagingCommand2();
			controller2.execute(request,response);
		
			
			//1. dao연결
			//2. ArrayList<Board> b1listAll()
			//3. 성공시 board/list.jsp
			/*request.setAttribute("list", request.getAttribute("list"));
			request.setAttribute("listcount", request.getAttribute("listcount"));*/
			
			String viewpage="./board2/list.jsp";
			RequestDispatcher dispatcher=request.getRequestDispatcher(viewpage);
			dispatcher.forward(request, response);
			
		}else if(command.equals("/write_view2.do")) {
			System.out.println(" WRITE_FORM2 ");
			//1. dao x
			//2. 경로  
			response.sendRedirect(request.getContextPath() + "/board2/write.jsp");
			
		}else if(command.equals("/write2.do")) {
			System.out.println(" WRITE");
			//1. dao 글쓰기 -  
			controller2=new BWriteCommand2();
			controller2.execute(request,response);
			
			//2. 경로
			//response.sendRedirect(request.getContextPath() + "/board2/list.jsp");
		}else if(command.equals("/detail2.do")) {
			System.out.println(" DETAIL");
			controller2=new BDetailCommand2();
			controller2.execute(request,response);
			// 1. dao 해당 글 번호 데이터 가져오기
			// 2. 경로
/*			Board b = (Board)request.getAttribute("dto");
			System.out.println(b.getBname());
			request.setAttribute("dto",b);*/
			
			String viewpage="./board2/detail.jsp";
			RequestDispatcher dispatcher=request.getRequestDispatcher(viewpage);
			dispatcher.forward(request, response);
			
		}else if(command.equals("/pass_view2.do")) {
			System.out.println(" PASS_FORM2");
			//1. dao : x
			// 2. 경로 
			int bno=Integer.parseInt(request.getParameter("bno"));
			String bcommand=request.getParameter("bcommand");
			System.out.println("제대로 들어갔나 확인 : "+bcommand);
			request.setAttribute("bno", bno);
			request.setAttribute("bcommand",bcommand);
			
			String viewpage="./board2/pass.jsp";
			RequestDispatcher dispatcher=request.getRequestDispatcher(viewpage);
			dispatcher.forward(request, response);
			
		}else if(command.equals("/pass2.do")) {
			System.out.println(" USER_CONFIRM2");
			
			String bcommand=request.getParameter("bcommand");
			request.setAttribute("bno", request.getParameter("bno"));
			request.setAttribute("bcommand", request.getParameter("bcommand"));
			System.out.println("bcommand는?"+bcommand);
			controller2=new BPassCommand2();
			controller2.execute(request, response);
	
			
		}else if(command.equals("/delete2.do")) {
			System.out.println(" DELETE2 ");
			request.setAttribute("bno", request.getParameter("bno"));
			controller2=new BDeleteCommand2();
			controller2.execute(request, response);
			
			out.write("<meta http-equiv='refresh' content= '0; url=./list2.do'>");
		}else if(command.equals("/update_view2.do")) {
			
			System.out.println(" UPDATE_FORM2 ");
			String bno=request.getParameter("bno");
			request.setAttribute("bno", request.getParameter("bno"));
			System.out.println("제대로 확인 ! : "+bno);
			controller2=new BUpdateViewCommand2();
			controller2.execute(request, response);
			//1. dao : 해당 글 가져와서 수정 가능하게 데이터 채우기 
			// 2. 경로 
			Board2 b = (Board2)request.getAttribute("dto");
			System.out.println(b.getBname());
			System.out.println(b.getBno());
			request.setAttribute("dto", b);
			System.out.println("나오고 있음");
			
			String viewpage="./board2/modify.jsp";
			request.setAttribute("bno", request.getParameter("bno"));
			RequestDispatcher dispatcher=request.getRequestDispatcher(viewpage);
			dispatcher.forward(request, response);
			
		}else if(command.equals("/update2.do")) {
			System.out.println(" UPDATE2 ");
			
			request.setAttribute("bno", request.getParameter("bno"));
			System.out.println("확인용1");
			controller2=new BUpdateCommand2();
			controller2.execute(request, response);
			int bno=Integer.parseInt(request.getParameter("bno"));
		
			out.write("<meta http-equiv='refresh' content= '0; url=./detail2.do?bno="+bno+"'>");
			
		} else if(command.equals("/search1.do")) {
			
			System.out.println("□ Search");
			
			controller=new BSearchCommand();
			controller.execute(request, response);
			System.out.println(request.getAttribute("list1"));
			RequestDispatcher dispatcher=request.getRequestDispatcher("./board1/searchlist.jsp");
			dispatcher.forward(request, response);

		} else if (command.equals("/search2.do")) {
			System.out.println("□ Search2");
			
			controller2=new BSearchCommand2();
			controller2.execute(request,response);
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("./board2/searchlist.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		/*else if(command.equals("/test.do")) {
			Board1DAO dao=new Board1DAO();
			ArrayList<Board> boards=new ArrayList<>();
			
			int bno = request.geta;
			String bname = "asd";
			String bpass = "fgh";
			String btitle = "jkl";
			String bcontent = "zxc";

			out.println("1. 게시글 전체 리스트</br>");
			boards = dao.b1listAll();
			Iterator<Board> iterator = boards.iterator();
			while (iterator.hasNext()) {
				Board board = iterator.next();
				out.println(board.getBname() + "</br>");
			}

			dao = new Board1DAO();
			int cnt = dao.b1listCount();
			out.println("2. 게시글 총 개수: " + cnt + "</br>");
			
			dao = new Board1DAO();
			Board board = dao.b1getInfo(bno);
			out.println("3. bno=28인 게시글 bhit 증가시키기: " + board.getBhit() + "</br>");

			dao = new Board1DAO();
			dao.b1write(bname, bpass, btitle, bcontent);

			dao = new Board1DAO();
			bpass = dao.b1check(bno);
			out.println("4. 새로 생긴 보드의 비밀번호: " + bpass + "</br>");

			out.println("5. 새로 생긴 보드 수정</br>");
			btitle = "111";
			bcontent = "222";
			dao = new Board1DAO();
			dao.b1update(btitle, bcontent, bno);
		}

		}
*/
	}
		
	}


