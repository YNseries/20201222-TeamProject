<%@ page info="2021-04-12 홍길동" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	1. 웹프로그램 실행을 위한 구성요소(네가지 다 깔려 있어야 가능)
	   1) 웹브라우저: 클라이언트 영역
	   2) 웹서버: 서버(요청을 받고 결과값에 응답하는 역할)
	            번역이 필요 없는 파일 요청시(브라우저에서 실행이 가능)
	            HTML, XML, CSS, JavaScript
	            => Java, C#, 파이썬
	   3) 웹어플리케이션 서버(WAS): 번역 => HTML, XML로 변환
	            => 톰캣, 레진, IIS
	   4) 데이터베이스: 오라클 => 웹사이트에 필요한 데이터를 저장하는 장소
	                     자바 번역 요청
	   웹브라우저 =====> 웹서버 =====> WAS =====> 오라클 연결
	           <=====     HTML 변환    <=====
	                                  데이터
	   /main.jsp
	   /main.do   둘 중 하나로 넘어가면 데이터가 was로 넘어감(번역됨)
	   /main.html은 웹서버가 직접처리. was로 가지 않아도 됨
	   
	   1. URL => 웹에서는 반드시 마지막에 파일명을 전송
	      /main.do => 서블릿을 찾아라(DispatcherServlet)
	      
	      page 
	      ==> web은 거의 대부분이 Map
	          map("localhost", "211.238.142.181")
	          map("daum.net","203.133.167.16")
	      ============================================================== URL
	      http://localhost(IP,Domain)/JSPTotalLastProject/jsp/total1.jsp
	      ====  ==================== ===================================
	      프로토콜        서버 주소                      URI
	                                 ====================
	                                      ContextPath
	      다른 파일로 데이터 전송할 때
	        main.jsp?no=1
	      > 두 개를 전송
	        main.jsp?no=1&page=1  =>  &로 구분
	      (Spring? jsp는 그대로 감)
	      
	=========================================================================
	page 56
	1. page 지시자
	   contextType=""
	     => JSP를 변환할 때(브라우저에서 실행: XML, HTML만 가능) => 브라우저에서는 XML, HTML외의 모든 것은 txt
	        HTML => text/html;charset=UTF-8
	        XML  => text/xml;charset=UTF-8
	   errorPage="" : 오류가 났을 경우 파일 이동(error파일 출력)
	     => 404: 요청한 파일이 없는 경우
	        500: 자바 번역에 오류가 나는 경우
	        415: 스프링에서 등장 => 데이터명이 틀릴 경우
	             main.do?no=1&page=1
	             public String main_list(int a,BoardVO vo) (x)
	             public String main_list(int no,int page) (o) 위의 변수명과 같아야 결과값 받아옴
	        200: 정상 수행(화면에 출력한 것)
	   import=""
	     => import="패키지.*"
	     => import="패키지.*"
	     => import="패키지.*"
	     => import="패키지.*,패키지.*,패키지.*"
	   buffer="16kb"
	     => JSP번역 => Java => 컴파일 => .class => 실행 => HTML만 출력한다
	        출력하는 위치를 Buffer(메모리 공간) => 저장된 HTML을 브라우저가 읽어서 출력
	        기본 8kb(one page) => 증가가 가능하게 만들었다
	     (framework: spring, structs, jfs, 마이플랫폼(유료)) => jsp, asp, aspx, php
	     ***** 프레임워크(레고) => 라이브러리(완제품)
	           전자정부프레임워크 . 애니프레임워크
	page 65~72
	JSP => 자바 + HTML
	자바영역
	  <% %> : 스크립트릿 => 일반 자바 코딩, 변수 선언, 제어문, 연산자, 기타 로직
	  <%= %>: 표현식 => 브라우저에 출력
	  <%! %>: 선언식 => 메소드롤 만들 경우: 자바를 이용해서 만든다(import => 호출)
	HTML 영역
	
	page 72: 내장객체(기본객체)
	  사용 요청 ==> request
	             요청 => 요청값 : getParameter(), getParameterValues()
	                           &hobby=a&hobby=b..
	                           (String [] hobby) => 415
 	             IP 얻기 => getRemoteAddr()
	             요청주소 확인 => getRequestURL() getRequestURI() => 73page
	             요청값 받기 => 데이터 전송 => setAttribute()
	  요청 처리 ==> JSP전체에서 사용 session 
	             setAttribute, getAttribute, invalidate, removeAttribute
	  결과응답(HTML로 응답) ==> response
	             setHeader(91page), redirect(93page)
	  96page 주석
	  
	  99page JSP 처리 과정
	  브라우저 =============> was(톰캣) =====> JSP =======> 자바 변환 ======> 컴파일
	         ====> 실행 =====> 버퍼(html) ====> 브라우저 전송
	  101pgae TCP
	  (반드시 그림이 머리속에 똭 들어와야 함)
	  115page 기본 객체
	    application(121page) => getInitParameter(), getRealPath()
	                            ================== web.xml
	  132page 영역
	    request: 화면이 변경되면 자동 초기화(요청한 파일에만 사용)
	    session: 기간이 지나면 초기화(프로젝트에 있는 모든 JSP파일에서 사용 가능)
	             로그아웃, 브라우저 종료
	  134page => request,session에 데이터를 추가해서 저장
	             setAttribute(), getAttribute()
	  141page => <%@ page errorPage=""> (우선순위)
	  			 web.xml에 분리
	  <7장>
	  157page => JSP 특정 영역에 다른 JSP를 추가 <jsp:include> => Spring (라이브러리: titles)
	             === 절차적 언어. 한 번 쓰고 버려야 함
	             <jsp:include> : HTML+HTML
	             <%@ include %> : Java+Java
	             ㅡ<!iframe> HTML안에 HTML 첨부
	   191page =>  자바 클래스 연동
	               ===========
	               ~VO, ~DATO, ~Manager
	               ===
	               Bean: 데이터를 모아서 한 번에 전송할 목적으로 만든다(소스를 줄이기 위함)
	               195page: <jsp:useBean> 메모리 할당
	               199page: <jsp:setProperty>
	   206page => 쿠키(클라이언트 브라우저에 저장)
	              ==> 최신 방문
	              ==> JSP는 응답시에 response를 이용한다(한 번만 사용이 가능)
	                   response => HTML, 쿠키
	              ==> 생성, 값 얻기, 기간
	              ==> 저장시에 문자열로만 저장 가능
	              ==> Cookie cookie=new Cookie(key, value)
	                         키: String          키, 값
	                         값: String 
	              ==> 저장 기간
	                  setMaxAge(초단위)
	              ==> Cookie[] cookie=request.getCookie()
	                  => 키 => getName()
	                  => 값 => getValue()
	              ==> 클라이언트로 전송
	                  response.addCookie(cookie명)

 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <% String name="HONG"; %>
</body>
</html>