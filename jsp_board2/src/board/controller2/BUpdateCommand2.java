package board.controller2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.dao.Board2DAO;

public class BUpdateCommand2 implements BCommand2 {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		System.out.println("확인용1");
		
		int uploadFileSizeLimit=5*1024*1024;
		String uploadFilePath="/usr/local/upload";
		//String uploadFilePath="/upload";
		MultipartRequest multi=new MultipartRequest(request, uploadFilePath,uploadFileSizeLimit,"utf-8",new DefaultFileRenamePolicy());
		String bfile=multi.getFilesystemName("uploadFile");
		//1. parameter 가져오기 
		int bno=Integer.parseInt(request.getParameter("bno"));
		System.out.println(bno);
		String btitle=multi.getParameter("btitle");
		String bcontent=multi.getParameter("bcontent");
		
		
		if( bfile == null) {
			bfile=request.getParameter("bfile");
		}
		
		System.out.println(bcontent);
		//2. dao 연결 (b1update)
		Board2DAO dao=new Board2DAO();
		//3. b1update(String btitle, String bcontent, int bno)
		int result=dao.b2update(btitle, bcontent, bfile, bno);
		//4. 성공시 - /board1/detail.jsp , 실패시 - /update_view.do
		if(result==1) {
			out.write("<script> alert ('업데이트 성공!' );</script>");
		}else {
			out.write("<script> alert ('업데이트 실패! 관리자에게 문의바랍니다.</script>");
		}
	}

}
