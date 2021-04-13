<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<jsp:useBean id="dao" class="com.sist.dao.MovieDAO"></jsp:useBean> 
                      <!-- class명 넣고 ctrl+enter하면 자동으로 패키지명 붙음 -->
<%
	// list.jsp(영화번호 전송) => 영화 번호를 받아서 해당 영화의 모든 데이터를 요청
	String mno=request.getParameter("mno");
	// DAO 연결 => 메모리 할당 
	MovieBean bean=dao.movieDetailData(Integer.parseInt(mno));
	// 이후에 자바(모델) 수행 후 => JSP(뷰) 순서로 이동
	//        데이터 갖고온 후 => 화면출력
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row{
	width: 960px;
	margin:0px auto;
}
</style>
</head>
<body>
  <div class="container"> <!-- 브라우저를 만들 때 출력할 위치(간격|사각형)를 잡아주는 것 / wrapper로 쓸 때도 있음 -->
    <%--
         ENTITY: 변수
          <!ENTITY lt "<">  ==> &변수; ==> &lt;
          <!ENTITY gt ">">  ==> &변수; ==> &gt;
          <!ENTITY nbsp " ">  ==> &nbsp;
          <!ENTITY amp """> ==> &amp;
     --%>
    <h3 class="text-center">&lt;<%= bean.getTitle() %>&gt; 상세보기</h3>
    <div class="row"> <!-- 위치 내 한 줄(가로 한 칸)씩 잡아줄 때 -->
      <table class="table">
        <%--
        	 동영상: <embed>: iframe과 같이 많이 쓰임, <object>, <iframe>:보안상 embed보다 나음 
        	       <video>: 이미 내 컴퓨터에 존재하는 파일명만 가능
         --%>
        <tr>
          <td>
            <embed src="http://youtube.com/embed/<%=bean.getKey()%>" width=960 height=350></embed>
          </td>
        </tr>
      </table>
    </div>
    <div class="row"> <!-- 최신 선택 영화 출력할 칸 -->
      <table class="table">
        <tr>
          <td width=30% class="text-center" rowspan="9">
            <img src="<%=bean.getPoster() %>" width=100%>
          </td>
          <td colspan="2"><%=bean.getTitle() %></td>
        </tr>
        
        <tr>
          <th class="text-right" width=15%>개봉</th>
          <td width=55%><%=bean.getRegdate() %></td>
        </tr>
        
        <tr>
          <th class="text-right" width=15%>장르</th>
          <td width=55%><%=bean.getGenre() %></td>
        </tr>
        
        <tr>
          <th class="text-right" width=15%>등급</th>
          <td width=55%><%=bean.getGrade() %></td>
        </tr>
        
        <tr>
          <th class="text-right" width=15%>국가</th>
          <td width=55%><%=bean.getNation() %></td>
        </tr>
        
        <tr>
          <th class="text-right" width=15%>시간</th>
          <td width=55%><%=bean.getTime() %></td>
        </tr>
        
        <tr>
          <th class="text-right" width=15%>박스오피스</th>
          <td width=55%><%=bean.getBoxoffice() %></td>
        </tr>
        
        <tr>
          <th class="text-right" width=15%>누적관객</th>
          <td width=55%><%=bean.getShowUser() %></td>
        </tr>
        
        <tr>
          <th class="text-right" width=15%>평점</th>
          <td width=55%><%=bean.getScore() %></td>
        </tr>
        
        <tr>
          <td colspan="3">
            <%=bean.getStory() %>
          </td>
        </tr>
        
        <tr>
          <td colspan="3" class="text-right">
            <a href="list.jsp" class="btn btn-sm btn-danger">목록</a>
          </td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>