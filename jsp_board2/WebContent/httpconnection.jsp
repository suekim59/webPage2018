<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<%@page import="java.net.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<%
		//1. AJAX
		String param="name=" + URLEncoder.encode("sally","UTF-8");
		//1. URL 경로
		URL url =new URL("http://localhost:8080/jsp_board2/HttpConnecton002_view.jsp"+
		  "?"+param);
	

		// 2. OPENCONNECTION
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoInput(true);	// 입력스트림사용
		conn.setDoOutput(true);	// 출력스트림사용	// 캐시사용안함
		conn.setRequestMethod("GET");	// GET OR POST
				
		// 3. READLINE으로 한줄씩 읽어들이기
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
		for(;;) {
					String line = br.readLine();		
					if(line == null) {		
						break;
					}
				sb.append(line+"\n");
				}
		br.close();
		conn.disconnect();
				
		String getXml = sb.toString();
		System.out.println(sb.toString());
			%>
			<%=sb.toString() %>
		</body>


</body>
</html>