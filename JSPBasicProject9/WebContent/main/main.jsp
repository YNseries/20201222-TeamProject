<%@ page import="com.sist.dao.JSPChange" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
	//                   ====== 변경될 화면(위치) => JSPChange.java에 설정함
	// 화면 변경   main.jsp?mode=1
	//          ======== 기본 화면 유지(include)
	String mode=request.getParameter("mode");
	if(mode==null)
		mode="0";  // mode가 없다? = home으로 들어옴
	int no=Integer.parseInt(mode);
	String main_jsp=JSPChange.change(no);
	// 세션에 저장되어 있는 데이터 읽기
	String id=(String)session.getAttribute("id");  // 없는 경우: null
	String log_jsp="";
	// include가 되면, 아래의 두 페이지는 member가 아니라 main에 있는 것과 같음(화면에 나타나는 형태가 main에 포함되어 나옴)
	if(id==null)
		log_jsp="../member/login.jsp";
	else
		log_jsp="../member/logout.jsp";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=36d0996e6c622e6b843d89c99d03a6d2&libraries=services"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="main.jsp">맛집추천</a>  <%--mode=0&index=1 --%>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="main.jsp">Home</a></li>
      <%
      	 if(id==null){
      		
      %>
      <li><a href="#">회원가입</a></li>
      <%
         }
      	 else {
      		 
      %>
      <li><a href="#">회원수정</a></li>
      <%
         }
      %>
      <li><a href="#">맛집추천</a></li>
      <%
      	 if(id!=null) {
      		 
      %>
      <li><a href="#">마이페이지</a></li>
      <%
      	 }
      %>
    </ul>
  </div>
</nav>
<div style="height:30px"></div>
<div class="container">
  <div class="col-sm-3">
    <jsp:include page="<%=log_jsp %>"></jsp:include>
  </div>
  <div class="col-sm-9">
    <jsp:include page="<%=main_jsp %>"></jsp:include>
  </div>
</div>
</body>
</html>

