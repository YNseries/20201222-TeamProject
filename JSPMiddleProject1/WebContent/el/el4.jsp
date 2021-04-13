<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%-- 산술연산자는 순수하게 산술 처리만 한다 --%>
<%--   10+20=${10+20}<br>
  "10"+"20"=${"10"+"20" }<br>
  "A"+"10"=${"A"+"10" } : 500 오류나옴
  10/3=${10/3}<br>
  ${10==20 }  ${"admin"!="hong" } <!-- 문자열 비교도 가능 --><br>
  ${10 eq 20}<br>
  ${10<10 and 10==10 } <!-- => && ||   * & --><br>
  ${10==10?'같다':'다르다' }<br> --%>
  <%--
  	  String name="";
  	  request.setAttribute("name", name);
  --%>
  <%--${empty name } --%>
</body>
</html>