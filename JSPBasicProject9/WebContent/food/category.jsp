<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<jsp:useBean id="dao" class="com.sist.dao.FoodDAO"></jsp:useBean>
<%
	// 카테고리 번호 받아야 함
	String cno=request.getParameter("cno");
	FoodCategoryVO vo=dao.foodInfoData(Integer.parseInt(cno));
	List<FoodVO> list=dao.foodCategoryFoodData(Integer.parseInt(cno));
	for(FoodVO fvo:list)
	{
		String s=fvo.getPoster();
		s=s.substring(0,s.indexOf("^"));
		fvo.setPoster(s);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="jumbotron"> <!-- 회색 바탕에 글 나오게 하는 것(구분을 줌) -->
    <h2 class="text-center"><%=vo.getTitle() %></h2>
    <h4 class="text-center"><%=vo.getSubject() %></h4>
  </div>
  <div class="row">
    <%
    	for(FoodVO fvo:list) {
    %>
    		<table class="table">
    		  <tr>
    		    <td width=30% class="text-center" rowspan="3">
    		      <!-- a href="" : 링크 연결 -->
    		      <!--     ======== 사이트가 main에서 계속 변동되기 때문에 경로를 주지 않아도 상관 없음 -->
    		      <a href="main.jsp?mode=2&no=<%=fvo.getNo()%>&cno=<%=cno%>"><!-- detail.jsp의 mode=2 -->
    		      <!--    =========화면     ================== detail.jsp에서 처리 해서 main 화면에 뿌려라 -->
    		      <!--     =============== detail.jsp -->
    		        <img src="<%=fvo.getPoster() %>" width=200 height=150 class="img-rounded">
    		      </a>
    		    </td>
    		    <td width="70%">
    		      <h3><a href="main.jsp?mode=2&no=<%=fvo.getNo()%>&cno=<%=cno%>"><%=fvo.getTitle() %></a>&nbsp;<span style="color:orange"><%=fvo.getScore() %></span></h3>
    		    </td>
    		  </tr>
    		  <tr>
    		    <td width=70% style="color:gray"><%=fvo.getAddress().substring(0,fvo.getAddress().indexOf("지")) %></td>
    		  </tr>
    		  <tr>
    		    <td width=70% height=40>
    		    
    		    </td>
    		  </tr>
    		</table>
    <%
    	}
    %>
  </div>
</body>
</html>