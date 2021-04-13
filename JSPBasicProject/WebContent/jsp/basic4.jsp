<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 
	클래스가 만들어지면,
	public class basic4_jsp extends HttpServlet
	{
		<%! %>
		public void _jspInit(){}     => web.xml
		public void _jspDestory(){}  => 메모리 해제
		public void _jspService(){   => doGet() / doPost()
			<%  %>
			<%= %>
		
		} => (브라우저에) 화면 출력(jsp가 들어가는 메소드)
	}
 --%>
<%!
	public int add(int a, int b)
	{
		return a+b;
	}

	public int minus(int a, int b)
	{
		return a-b;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%
  	  int a=10;
	  int b=20;
	  int c=add(a,b);
	  int d=minus(a,b);
  %>
  <%= c %><br>
  <%= d %>
</body>
</html>