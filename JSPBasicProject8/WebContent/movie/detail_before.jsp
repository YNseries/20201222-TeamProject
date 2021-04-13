<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mno=request.getParameter("mno");
	
	// cookie 전송
	/*
		1. cookie 생성
		2. cookie 저장
		3. cookie 클라이언트로 전송
	*/
	// 1. 쿠키 생성(내장 객체가 아니다) / session은 내장객체
	Cookie cookie=new Cookie("m"+mno,mno);   // 쿠키 생성(키:영문으로 시작/중복되는 이름은 바꿈,값): map방식
	// 값은 문자열만 저장 가능
	cookie.setMaxAge(24*60*60);  // 저장 기간. 60*60: 1시간 *24: 24시간 = 1하루  ==> 기간을 정하고 출력해야 함
	response.addCookie(cookie);  // 클라이언트로 전송
	response.sendRedirect("detail.jsp?mno="+mno);
%>