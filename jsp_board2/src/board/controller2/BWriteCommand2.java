package board.controller2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.dao.Board2DAO;

public class BWriteCommand2 implements BCommand2 {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		
		int uploadFileSizeLimit=5*1024*1024;
		String uploadFilePath="/usr/local/upload";
		//String uploadFilePath="/upload";
		MultipartRequest multi=new MultipartRequest(request, uploadFilePath,uploadFileSizeLimit,"utf-8",new DefaultFileRenamePolicy());
		String bfile=multi.getFilesystemName("uploadFile");
		String bname=multi.getParameter("bname");
		String bpass=multi.getParameter("bpass");
		String btitle=multi.getParameter("btitle");
		String bcontent=multi.getParameter("bcontent");
		
		System.out.println(bfile+"입니다.!!!!!");
		
		//2. dao 연결 (bwritecommand)
		Board2DAO dao=new Board2DAO();
		//3. b1write(String bname, String bpass, String btitle, String bcontent) 
		int result=dao.b2write(bname, bpass, btitle, bcontent,bfile);
		//4. 성공여부 처리 ( 성공 -list.jsp / 실패 - write_view.do )
		if(result==1) {
			out.println("<script>alert('글쓰기 성공!'); location.href='list2.do'; </script>");
		}else {
			
			out.println("<script>alert('글쓰기 실패!'); history.go(-1); </script>");
		}
		
		
		
	}

}
