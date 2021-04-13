<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.text.*,java.util.*"%> <%-- 라이브러리 추가할 때 --%>
<%-- 위에 import 하나에 여러개의 라이브러리를 추가해도 되고, 개별로
     <%@ page import="java.util.*" %>
	 <%@ page import="java.text.*" %>  
	 이렇게 작성해도 됨
 --%>
<%-- 
	JSP: JavaServerPage = 서버에서 실행하는 자바: 보통 View단(화면 출력)에서 작업
	===================== 단점: Java+HTML => 구분 필요, 모든 소스를 오픈(보안에 취약)
	                           메소드 안에 코딩(확장성)
	<% %> 자바는 이 안에서 코딩해야 함
	= JSP 생명주기
	    생성 ==> 브라우저 출력 ==> 소멸(TomCat이 담당)   =   때문에 사용자 요청에 맞춰 화면만 출력해 주면 됨
	            /login.jsp
	    브라우저 =============> 웹서버(Httpd) (httpd: .html, .xml) ==> 톰캣(웹 컨테이너)
	                                                              =============
	                                                              1. 서블릿이 들어올 때(변환 필요 x 확장자가 java니까): 속도는 빠르지만
	                                                              2. JSP가 들어올 때(.java로 변환 필요): 코딩하기에 더 쉬움
	                                                              ===> JSP를 .java로 변환
	                                                              ===> 컴파일
	                                                              ===> 인터프리터(실행)
	                                                              ===> 실행결과(HTML만 남음)를 메모리에 저장┑
	          <====================================================================================┙
	                     저장된 html을 한 줄씩 읽어서 출력
	       (사용자) => 서버로 전송(주소창)
	           ============> 이동, 새로고침 ==> 자동으로 이전에 저장된 HTML은 사라진다(메모리에서 자바가 소멸됨)
	= 지시자
	  = 지시자 사용법
	    <%@ page|include|tablib
	        속성="값" 속성="값 %>   : 반드시 값을 감싸는 "" 적어야 오류 없음
	        
	        1) 속성
	           = 브라우저에 어떤 형식의 파일을 보낼지 설정
	             contentType="text/html"
	             contentType="text/xml" => response.setContentType("")
	           = import: 여러개 사용이 가능
	           = 다른 속성은 한 번만 사용 가능
	           = error 페이지 지정
	  1. page: JSP파일에 대한 정보
	           브라우저에 전송하는 방법
	           한글 코드
	           라이브러리 추가
	           에러시 이동할 파일
	  2. include: JSP특정 영역에 다른 JSP를 추가
	  3. tagLib: MVC(Mode12)
	     // JSP 코딩할 때 아래와 같이 되어있음. 열고 닫는것 확인 필수
	     <%
	     	 for(int i=1;i<=10;i++)
	     	 {
	     	 	if(i%2==0)
	     	 	{
	     %>
	     	 		<font color=red>짝수출력</font>
	     <%
	     	 	}
	     	 	else
	     	 	{
	     %>
	     	 		<font color=blue>홀수출력</font>
	     <%
	     	 	}
	     	 }
	     %>
	     
	     // tagLib
	     <c:forEach var="i" begin="1" end="10">
	        <c:if test="i%2==0">
	        	<font color=red>짝수출력</font>
	        	<font color=blue>홀수출력</font>
	        </c:if>
	        <c:else>
	        </c:else>
	     </c:forEach>
	     
	= JSP에서 자바 사용법
	  선언식   : <%! %> => 메소드를 만들 경우(보통 메소드 안에 메소드 못들어가니까)
	  표현식   : <%= %> => out.println()과 같이 화면 출력 대신 사용. 끝에 ; 출력하면 오류남.
	  스크립트릿: <% %> => 일반 자바(변수 선언, 데이터베이스 연동, 메소드 호출 등의 역할)
	
	= 내장 객체(미리 생성된 객체)
	  ***1. request
	  ***2. response
	  ***3. session
	  4. out
	  ***5. pageContext: include
	  ***6. application
	  7. config
	  8. exception
	  9. page
	  
	= JSP 액션태그
	  <jsp:include> <jsp:forward> <jsp:useBean> <jsp:setProperty> ... 
	  
	= JavaBean: ~VO(setter/getter) 읽기쓰기가 가능한 변수!
	= 표현식: EL
	= JSTL: 태그로 자바 문법을 만들어
	= MVC
	= DataBase연동(DAO)
	 
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <a href="a.jsp">이동</a>
  <%
  	// 자바 영역(주석이나 모든 코딩이 자바 문법을 사용한다)
  	// HTML을 포함한 주석 => <%-- -->
  	Date date=new Date();
  	SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
  	String today=sdf.format(date);
  %>
  <%-- out.println(today);
  				   ===== <%= %>는 이 부분을 출력하는 것임 
  --%>
  <%= today %>
</body>
</html>