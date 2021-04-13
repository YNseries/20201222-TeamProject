<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	 application: ServletContext => 서버 정보
	 서버정보 읽기
	   getServerInfo()
	   getMinorVersion()
	   getMajorVersion()     14.0.2
	                         == ===
	 로그 읽기
	   log() => 로그파일
	 환경 설정 읽기
	   web.xml
	 자원 정보 읽기
	   ***getRealPath() => 경로 읽기 어려울 때 이용하면 불러올 수 있음
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h3>서버명</h3>
   <%= application.getServerInfo() %><br>
   <h3>Major Version</h3>
   <%= application.getMajorVersion() %><br>
   <h3>Minor Version</h3>
   <%= application.getMinorVersion() %>
   <h3>실제 경로</h3><!-- 엄청 중요! 잘 외우고 있어야 함 -->
   <%= application.getRealPath("/jsp/application.jsp") %>
</body>
</html>