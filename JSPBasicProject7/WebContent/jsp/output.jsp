<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.bean.*"%>
<%--
	 public void jspService(HttpServletRequest request,HttpServletResponse response)
	 {  이 영역에 코딩되는 것! 메소드 안이라는 것 잊으면 안됨
 --%>
<%
	try {
		// 한글 디코딩!
		request.setCharacterEncoding("UTF-8");
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	String name=request.getParameter("name");
	String id=request.getParameter("id");
	String sex=request.getParameter("sex");
	String addr=request.getParameter("addr");
	String tel=request.getParameter("tel");
	
	MemberBean bean=new MemberBean();
	bean.setName(name);
	bean.setSex(sex);
	bean.setId(id);
	bean.setAddr(addr);
	bean.setTel(tel);
%>
<!-- 원래는 이렇게 해서 DB가 오라클로 전송되지만 지금은 bean이 어떻게 생긴건지 확인중 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  아이디:<%=bean.getId() %><br>
  이름:<%=bean.getName() %><br>
  성별:<%=bean.getSex() %><br>
  주소:<%=bean.getAddr() %><br>
  전화:<%=bean.getTel() %>
</body>
</html>