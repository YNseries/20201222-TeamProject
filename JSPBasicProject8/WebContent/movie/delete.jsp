<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 쿠키 삭제
	Cookie[] cookies=request.getCookies();
	if(cookies!=null && cookies.length>0)
	{
		for(int i=0;i<cookies.length;i++){
			if(cookies[i].getName().startsWith("m")){  // m으로 시작하는 데이터(쿠키로 저장된 모든 데이터)를
				cookies[i].setMaxAge(0);               // 삭제(저장 기간을 0으로 바꿈) 명령
				response.addCookie(cookies[i]);        // 브라우저로 삭제했다고 전송
			}
		}
	}
	response.sendRedirect("list.jsp");
%>