<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	model2(MVC) 방식
	표현식: EL
	      ${}
	      ${값} => 자바의 일반 변수가 아님
	      ====
	       request.getAttribute(): 우선 순위
		   session.getAttribute(): 2번째 순위
		   application.getAttribute(): 3번째 순위
				
		  형식)
		      request.setAttribute("a1","aaa1")
		      session.setAttribute("a2","aaa2")
		      ${a} ==> aaa1
		      ${requestScope.a} => <%= request.getAttribute("a")%>
		      ${a2}
		  연산자
		    산술연산자(산술만 처리)
		      ${"1"+"2"} => 3
		      ${"1"+null} => 1 (null은 0으로 취급)
		      ${"1"+"a"} => 오류
		      ${"1"+="2"} => 12
		      ${3/2} => 1.5 실수
		  객체호출
		      ${vo.title} => ${vo.getTitle()}
	292page JSTL
	      core: 제어문, URL, 변수 설정
	        <c:if>: 조건문
	        <c:forEach>: 반복문
	        <c:choose>: 다중 조건문
	        <c:redirect>: sendRedirect()
	        <c:set>: request.setAttribute()
	      fmt: 변환(숫자, 날짜): 날짜변환
	                 <fmt:formatDate value="" pattern="yyyy-MM-dd">
	                 SimpleDateFormat()
	                 <fmt:formatNumber value="" pattern="000,000">
	      fn: String 메소드
	          ${fn:substring(값,0,10)}
	         
	13장 (x)
	14장 (데이터베이스)
	15장 (x)
	18장 반드시 정독 필요 
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