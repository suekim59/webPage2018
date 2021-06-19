<%@page import="java.io.*"%>
<%@page import="java.net.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head><meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>



</head>
<body>
	<%
		//1. URL 경로
		URL url=new URL("https://www.naver.com/");
		//2. OPENCONNECTION
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		conn.setDoInput(true);	//입력스트림사용
		conn.setDoOutput(true);	//출력스트림사용
		conn.setUseCaches(false);	//캐시사용 안함
		conn.setRequestMethod("GET");	//get or post
		
		//3. READLINE으로 한 줄씩 읽어들이기
		StringBuffer sb=new StringBuffer();
		BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
		for(;;) {
			String line=br.readLine();
			if(line == null) {
				break;
			}
			sb.append(line+"\n");
		}
		br.close();
		conn.disconnect();
		String getXml=sb.toString();
		System.out.println(sb.toString());	
	
	%>
	<%=sb.toString()%>
	
	




</body>
</html>