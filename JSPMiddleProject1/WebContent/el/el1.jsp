<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	  EL: 화면 출력 => ${}
	      out.println("")
	      <%= %>
	      목적: 자바/HTML 분리 ==> MV패턴
	                           Model: 자바
	                           View : HTML(JSP)
	                       ==> MVC패턴
	                           Model: 자바
	                           View : HTML(JSP)
	                           Controller: 자바와 JSP를 연결
	  EL
	   연산자 처리
	   메소드 처리
	   처리 영역
	   ${일반 변수 출력이 아니다}
	   예)
	      String name="홍길동";
	      ${name}  (x)
	      request.getAttribute("name");
	      session.getAttribute("");
 --%>
<%
 	String name="홍길동";
	request.setAttribute("name",name);
	// ${requestScope.name } 
	//                ==== key명
	session.setAttribute("nick","심청이");
	// 우선 순위 => request > session > application(잘 안씀)
	// 자바에서 데이터를 보낸다(방법 2가지) 
	//     => request(한 번 쓰고 페이지에서 버림) / session(모든곳에서 쓸 수 있음)에 담는 방법
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  이름:${name },{requestScope.name}   <!-- 우선순위가 request --><br>
  <%= request.getAttribute("name")%><br>
  ${sessionScope.name },${nick }
</body>
</html>