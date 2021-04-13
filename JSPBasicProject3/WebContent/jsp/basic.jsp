<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	 1. 3장
	    56page: page의 속성(파일에 대한 정보)
	    57page: contentType="text/html;charset="(EUC-KR|UTF-8)"
	    58page: import 속성
	            <%@ page import="java.util.*,java.sql.*"%>
	            <%@ page import="java.util.*"%>
	            <%@ page import="java.sql.*"%>
	    errorPage 지정: <%@ page errorPage="에러났을 때 이동할 파일"%>
	    65page: 스크립트 요소
	            =========
	            <% %>: 일반 자바내용: 제어문, 클래스 메소드 호출, 변수선언
	            <%= %>: 데이터 출력 System.out.println()
	    72page: request, response => 은퇴까지!(Spring에는 없음)
	            request: 사용자 요청 정보
	             = getParameter():낱개, getParameterValues():여러개
	             = setCharacterEncoding()
	             = getRequestURI()
	             = getContextPath()
	             = setAttribute(), getAttribute()
	             = getSession(), getCookies()
	            response: 응답 정보
	             = setHeader()
	             = sendRedirect()
	  2. 4장
	     JSP 처리 과정
	                    요청 
	     클라이언트 ================= 톰캣(WAS) ==================> JSP찾기
	     	|													 |
	     	|									             JSP를 클래스화(서블릿)
	     	|									                 | 컴파일
	     	|									             바이트 코드 변경(.class)
	     	|									                 | 실행
	     	|									             ===========
	     	|									               <html>
	     	|									               ==
	     	===============================================
	     										               ==
	     										               </html>
	     										             ============
	     			// => html:             
	     			/  => 루트
	     			../ => 상위로 한 개 이동(파일이 다른 폴더에 있을 때)
	     			====================	     
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <a href="../temp.jsp">이동</a> 
</body>
</html>