<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%--404를 뺀 나머지에선 isErrorPage 출력해줘야 함 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <center>
      <img src="../error/error_500.png" width=500 height=450>
      <p>
      <%=exception.getMessage() %>
      <%-- 500파일은 ↑ 써 줘야 함 --%>
      </p>
   </center>
</body>
</html>