<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
    //1.사용자가 보낸 데이터 받기 
    String no=request.getParameter("no");
    //2.오라클 연결 => 데이터 읽기
    MusicDAO dao=new MusicDAO();
    MusicVO vo=dao.musicDetailData(Integer.parseInt(no));    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
</head>
<body>
  <table class="table">
    <tr>
      <td width=30% class="text-center" rowspan="5">
       <img src="<%=vo.getPoster() %>" width=300 height=300>
      </td>
    </tr>
    </table>
    <table class="table">
    <tr>
      <td width=30% class="text-right">
        <span style="color:green;font-weight:bold">제목</span></td>
      <td width=70%><%=vo.getTitle() %></td>
    </tr>
    <tr>
      <td width=30% class="text-right">
        <span style="color:green;font-weight:bold">가수</span></td>
      <td width=70%><%=vo.getSinger() %></td>
    </tr>
    <tr>
      <td width=30% class="text-right">
        <span style="color:green;font-weight:bold">앨범</span></td>
      <td width=70%><%=vo.getAlbum() %></td>
    </tr>
    <tr>
      <td width=30% class="text-right">
        <span style="color:green;font-weight:bold">등락</span></td>
      <td width=70%>
      	<% String state=vo.getState();
           String str="";
           if(state.equals("상승")) {
              str="▲ "+vo.getIdcrement();
           }
           else if(state.equals("하강")) {
           	  str="▼ "+vo.getIdcrement();
           }
           /*else if(state.equals("new")) {
              str="new";
           }*/
           else {
              str="-";
           } %>
        <%=str %> 
      
      </td>
    </tr>    
  </table>
</body>
</html>