<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.model.*"%>
<jsp:useBean id="model" class="com.sist.model.SawonModel"></jsp:useBean>
<%
	// Controller 영역: 클라이언트가 요청 => 요청을 받아서 해당 Model을 찾고
	// 메소드를 호출
	model.sawonInit(request);  // Call By Reference 방식
	model.sawonDetailData(request);  // VO
	model.sawonTwoData(request);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%--
	   Insert ~~ VALUES(#{id},#{name})
	                    getId() getName()
	   <%= %>
	   System.out.println(10+10) 연산자는 있는데, 제어문은 없음
 --%>
</head>
<body>
  이름: ${name }<br>
  사번: ${vo.sabun },${vo.getSabun() }<br>
  이름: ${vo.name },${vo.getName() }<br>
  부서: ${vo.dept },${vo.getDept() }<br>
  <!--  =========    ============= 결과값은 같음. 쓰는 형식만 다를 뿐 -->
  <!--  실무에서 쓰임 -->
  이름: ${first+=last }   <!-- 그냥 +는 연산자에서만 쓰임. 때문에 +만 쓰면 에러500 -->
</body>
</html>