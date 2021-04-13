<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	  내장객체(기본객체): 미리 만들어진 객체
	  ***request: 요청 정보 = HttpServletRequest
	  ***response: 응답정보 = HttpServletResponse
	  *out: 출력과 관련 = JspWriter <%= %>
	  ***application: 서버관련, 로그파일, 실제경로 = ServletContext
	  ***session: 서버에 저장공간 = HttpSession
	  config: 환경 설정(web.xml) = ServletConfig
	  ***pageContext: 흐름제어, include, forward = PageContext
	     = <jsp:include>
	     = <jsp:forward>
	  page: 자신의 페이지 => this = Object
	  exception: 예외처리 = Exception => try~catch
	  
	  cookie는 내장객체가 아니다
	  
	  out
	  ==== 관리 영역
	  클라이언트 ========> 웹서버(httped) ==========> WAS(TomCat)
	            요청                                  |
	            							 	jsp ==> .java
	  												 | = javac
	  										    .java ==> .class
	  										         | = java
	  										        실행
	  				   결과값 출력(메모리)
	                   ============= out이 관리 => 출력퍼버(8kb)
	                    <html>
	                    <body>
	                     ==
	                     ==
	                    </body>
	                    </html>
	                   =============
	                     => out.println("<html>")
	                        <%=값%>
	  주요 메소드
	    ***1. println(): 출력 버퍼에 데이터 출력할 때
	          복잡한 코딩
	          <%
	              if() {
	          %>
	                  <span>HTML</span>
	          <%
	                  if() {
	          %>
	          <%
	                  else {
	          %>
	          
	          <%
	                  }
	          %>
	          
	          <%
	               }
	               else {
	          %>
	          <%
	          	   }
	          %>
	          
	          간단한 코딩
	          <%
	               if()
	               {
	                  if()
	                  {
	                     out.println("<span>HTML</span>");
	                  }
	               else
	               {
	               }
	          %>
	    2. getBufferSize(): HTML을 저장할 수 있는 총 크기
	    
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h3>총 버퍼의 크기</h3>
   <%=out.getBufferSize() %><br>
   <% out.println(out.getBufferSize()); %> <%-- 위와 같은 것 --%>
   <h3>사용중인 버퍼 크기</h3>
   <%=out.getBufferSize()-out.getRemaining() %><br>
   <h3>남아있는 버퍼(HTML을 출력해 놓은 메모리 공간) 확인</h3>
   <%=out.getRemaining() %><br>
   <h3>자동 초기화(브라우저가 출력한 HTML을 읽어가면 자동으로 버퍼를 비워준다)</h3>
   <%=out.isAutoFlush() %><br>
</body>
</html>