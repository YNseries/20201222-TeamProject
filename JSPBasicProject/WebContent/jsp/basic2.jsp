<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp" buffer="8kb"%>
<%-- 에러페이지를 지정해서 500,400 대신 나오게 할 수 있음. 페이지 지시자
	 다만 원래 페이지로만 URL이 나옴(forward)
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		int a=10/2;
	%>
</body>
</html>