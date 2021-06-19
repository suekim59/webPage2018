package board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Contactme implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String forme=request.getParameter("forme");
		//체크박스 했는지 안했는지 값 확인
		
		
		System.out.println(forme);
		String name=request.getParameter("sender_name");
    	System.out.println(name);
    	//이거 이름이 아니라 이메일입니다.
    	String title=request.getParameter("sender_title");
    	System.out.println(title);
    	String content=request.getParameter("sender_content");
    	String realcontent="보낸 사람 : "+name+"\n"+content;
    	System.out.println(content);
		
	    String  host = "smtp.naver.com";
		final  String user = "smile_59";
		final  String password = "soojung5959";
		
		/*  2) 받는 쪽의 메일 설정부분   */
		String to = "soojeong-kim@naver.com";
		//고객님이 나에게도 보내기를 체크했을 때 보낼 메일
		String to2= name;
		
		/*  3) 환경파일설정  */
		Properties props = new Properties();
		props.put("mail.smtp.host" , host);
		props.put("mail.smtp.auth" , "true");
		
	    Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
		   protected PasswordAuthentication getPasswordAuthentication() {
			   return new PasswordAuthentication(user, password);
		   }
		});
		/*  4) 보내기  */
	    try {
		   MimeMessage message = new MimeMessage(session);
		   message.setFrom(new InternetAddress(user));
		   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		   if(forme != null) {
			   
			   message.addRecipient(Message.RecipientType.TO, new InternetAddress(to2));
		   }
		   
	    	//// 메일제목
	    	message.setSubject(title);
	    	//// 메일내용
	    	message.setContent(realcontent,"text/html;charset=utf-8");
	    	
	    	
	    	Transport.send(message);
	    	System.out.println("success");
	    	
	   // out.write("<meta http-equiv='refresh' content='0;url=../contactme.jsp'>");
	    	
	    }catch(Exception e){}
	}
	
}
