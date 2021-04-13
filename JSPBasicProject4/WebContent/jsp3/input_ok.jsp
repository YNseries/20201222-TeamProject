<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.oreilly.servlet.*,com.oreilly.servlet.multipart.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	String s=application.getRealPath("/jsp3");  // 톰캣이 읽어가는 실제 경로명
	//String path="C:\\webDev\\webStudy\\JSPBasicProject4\\WebContent\\jsp3";
	String path=s;  // 위와같이 직접적으로 경로를 주지 않고 application.getRealPath() 사용
	String enctype="UTF-8";  // 한글 파일명
	int size=1024*1024*100;  // 100MB까지 가능
	MultipartRequest mr=
		new MultipartRequest(request, path, size, enctype,
				new DefaultFileRenamePolicy());
	// new DefaultFileRenamePolicy()   
	// => aaa.jpeg => aaa1.jpeg => aaa2.jpeg 이름이 같을 때 뒤에 숫자를 붙여 파일명이 충돌되지 않도록 다르게 만들어줌
	String name=mr.getOriginalFileName("upload");
	response.sendRedirect("output.jsp?file="+name);
%>
