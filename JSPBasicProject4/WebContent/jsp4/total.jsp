<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
	  JSP에서 주로 사용하는 내장(기본) 객체
	  = request: getParameter(), getParameterValues()
	             setCharacterEncoding()
	  = response: setHeader(): 파일 다운로드, sendRedirect()
	  *** MVC할 때 자주 나올것임
	    = application: web.xml에 등록된 데이터 읽기(getInitParameter())
	                   실제 경로명 읽어올 때(getRealPath())
	  = out: println()
	  = pageContext: include, forward
	      7장에 다시 나옴 => <jsp:include> <jsp:forward>
	  = session VS cookie
	  
	  사용자가 보낸 데이터 활용
	  = 받은 jsp에서만 사용: request => 화면이 변경되면 사라짐(초기화)
	  = 데이터를 모든 JSP에서 사용: session
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>