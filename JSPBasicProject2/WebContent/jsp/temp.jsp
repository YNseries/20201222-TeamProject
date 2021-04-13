<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//response.sendRedirect("result.jsp");
	//pageContext.forword("result.jsp");  //MVC
	// forword 기법은 화면만 바꿔(덮어)주는 것
	//RequestDispatcher rd=request.getRequestDispatcher("result.jsp");
	//rd.forward(request,response);
	/*
		한 단계 거쳐서 이동
		request
		  필요: forward, session(실행중일 때까지 저장)
		  불필요: sendRedirect
		  
		  a.jsp 
	      _jspService(req,res)
	      {
	         
	      }
	    
	      b.jsp
	      _jspService(req,res)
	      {
	      	 c.jsp => _jspService(req,res)
	      }
	        
	      c.jsp
	      _jspService(req,res)
	      {
	        	 
	      }
	    */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>