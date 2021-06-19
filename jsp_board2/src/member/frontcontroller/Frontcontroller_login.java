package member.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.controller.BUpdateCommand;
import board.controller.BUpdateViewCommand;
import board.dto.Board;
import member.controller.MCommand;
import member.controller.MDeleteCommand;
import member.controller.MJoinComCommand;
import member.controller.MJoinCommand;
import member.controller.MLoginCommand;
import member.controller.MLogoutCommand;
import member.controller.MPassCommand;
import member.controller.MUpdateCommand;
import member.controller.MidcheckCommand;
import memberdto.Members;

/**
 * Servlet implementation class Frontcontroller_login
 */
@WebServlet("*.login")
public class Frontcontroller_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Frontcontroller_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loginTest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loginTest(request,response);
	}
	
	private void loginTest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String uri=request.getRequestURI();
		System.out.println("1 : "+uri);
		String context=request.getContextPath();
		System.out.println("2: "+context);
		String command=uri.substring(context.length());
		System.out.println("3: "+command);
		
		
		//각각의 서블릿에서부터 어디로 이동하는지 sendredirect하기 
		MCommand controller = null;
		if(command.equals("/b1join_view.login")) {
			System.out.println(" JOIN_FORM ");
			
			
			response.sendRedirect(request.getContextPath() + "/login/join.jsp");
			
		}else if(command.equals("/b1join.login")) {
			System.out.println(" JOIN ");
			
			//회원가입 축하 페이지를 위해 회원정보 가져오는  서블릿 ( dao) controller
			//그 이후 회원가입 축하 페이지를 위한 jsp 페이지로 이동해야 함.
			
			//회원등록하기 ( join 처리하는 서블릿)
			controller=new MJoinCommand();
			controller.execute(request, response);
			
			// 5-2 joinCom.user로 넘어가기
			String userid = request.getParameter("userid");
			out.println("<script>location.href='"+context+"/joinCom.login?userid="+userid+"';</script>");
			//링크는 괜찮음.
		
		}else if (command.equals("/joincom.login")) {
			System.out.println("□ JOINCOM");
			
			// 5-1 dao: 회원 정보 가져오기
			controller = new MJoinComCommand();
			controller.execute(request, response);
			
			// 5-2 join2.jsp로 넘어가기
			RequestDispatcher rd = request.getRequestDispatcher("./login/join2.jsp");
			rd.forward(request, response);

	
		}else if (command.equals("/idcheck.login")) {
			System.out.println(" ID 중복 체크 ");
			
			//아작스로 처리해서 필요없나... (id_check 서블릿으로 처리..?)
			//아작스로 처리하면 아작스의 url 경로가 idcheck.login으로 된 이후
			//이 결과 값을 join.jsp로 다시 던져주어야 하나..?
			
			controller=new MidcheckCommand();
			
			controller.execute(request, response);
			
		
			
		}else if (command.equals("/b1login_view.login")) {
			System.out.println("□ LOGIN_FORM");
			
			RequestDispatcher rd = request.getRequestDispatcher("./login/login.jsp");
			rd.forward(request, response);
		}else if (command.equals("/b1login.login")) {
			System.out.println(" LOGIN ");
			
			//login처리하는 서블릿으로 이동(controller)
			controller=new MLoginCommand();
			controller.execute(request, response);
			
			out.println("<script>location.href='"+context+"/index.jsp';</script>");
			
		}else if(command.equals("/m1update_view.login")) {
			System.out.println(" UPDATE_FORM ");
			
			controller=new MJoinComCommand();
			controller.execute(request, response);
			
			// 10-2 update.jsp로 페이지 넘기기
			RequestDispatcher rd = request.getRequestDispatcher("./login/m1modify.jsp");
			rd.forward(request, response);
		
	 
		}else if (command.equals("/m1update.login")) {
			System.out.println(" UPDATE ");
			
			controller=new MUpdateCommand();
			controller.execute(request, response);
			
			String userid=request.getParameter("userid");
			
			out.println("<script>location.href='"+context+"/mypage.login?userid="+userid+"';</script>");
			
		}else if (command.equals("/mypage.login")) {
			System.out.println(" MYPAGE ");
			
			// 정보 다 가져오는 서블릿 가지고 오기
			//서블릿 가지고 와서 원하는 jsp 페이지로 보내기
			controller= new MJoinComCommand();
			controller.execute(request, response);
			
			
			// 6-2 mypage.jsp로 넘어가기
			RequestDispatcher rd = request.getRequestDispatcher("./login/mypage.jsp");
			rd.forward(request, response);
			
		}else if(command.equals("/pass_view.login")) {
			System.out.println(" PASS_FORM ");
			//1. dao : x
			// 2. 경로 
			String userid=request.getParameter("userid");
			String mcommand=request.getParameter("mcommand");
			request.setAttribute("userid", userid);
			request.setAttribute("mcommand",mcommand);
			
			out.println("<script>location.href='"+context+"/login/m1pass.jsp?mcommand="+mcommand+"';</script>");
			
		}else if (command.equals("m1check.login")) {
			System.out.println(" PASS CHECK ");
			
			controller=new MPassCommand();
			controller.execute(request, response);
			
			//command 받아와서 command가 있는 command로 던지면 됨.
			String mcommand=request.getParameter("mcommand");
			String userid=request.getParameter("userid");
		
			
			out.println("<script>location.href='"+context+"/"+mcommand+"?userid="+userid+"';</script>");
			
		}else if(command.equals("/logout.login")) {
			System.out.println(" LOGOUT ");
			
			
			controller =new MLogoutCommand();
			controller.execute(request, response);
			
			String viewpage="./login/login.jsp";
			RequestDispatcher dispatcher=request.getRequestDispatcher(viewpage);
			dispatcher.forward(request, response);
		
		}else if(command.equals("/delete.login") ) {
			System.out.println(" DELETE ");
			
			controller=new MDeleteCommand();
			controller.execute(request, response);
			
			out.println("<script>location.href='"+context+"/index.jsp';</script>");
		}
		
		
		
	}

}
