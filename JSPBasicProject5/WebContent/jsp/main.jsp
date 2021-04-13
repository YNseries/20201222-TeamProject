<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- errorPage="error.jsp" 에러페이지가 가장 우선으로 쓰이기 때문에 지워야 함--%>
<%--
	  web.xml: 톰캣에 전송
	  =======
	    1) 서블릿 등록하는 과정(스프링의 경우 반드시 등록해야 함/Annotation 없기 때문에)
	    2) 한글 변환코드를 등록(request를 사용하지 않음) => 대신 전송(하는 프로그램) Model클래스
	    3) 에러페이지 지정
	       Socket => Connection(안에 Socket이 구현되어 있는 것)
	       BufferedReader, OutputStream => PreparedStatement
	  1. errorPage: 모든 에러가 한 개의 파일로 처리 => jsp안에서 처리
	  2. 에러별 처리 => web.xml
	     web 에러
	     200: 정상 수행
	     ===================================
	     307: 임시 페이지로 이동(파밍)
	     400: 요청이 잘못된 경우
	     401: 접근 불허용
	     ***404: 파일이 없는 경우
	     405: 잘못된 데이터 전송 방식 POST(PST로 썼거나)
	     ***500: 자바 소스 에러
	     503: 일시 중지(서비스를) => 시스템 점검
	     =================================== 웹서버에서 만들어져 있다
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <% int a=10/0; %>
</body>
</html>