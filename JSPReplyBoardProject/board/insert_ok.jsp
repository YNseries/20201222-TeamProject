<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%-- 데이터를 받아서 오라클에 전송하는 페이지. HTML출력 안함 --%>
<%
	// 입력창이 나오면 언제나 한글인지 아닌지 확인해야 함
	try{
		request.setCharacterEncoding("UTF-8");  //POST방식: 디코딩 해 줘야 함/Get방식은 세팅해뒀음)
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	String name=request.getParameter("name");
	String subject=request.getParameter("subject");
	String content=request.getParameter("content");
	String pwd=request.getParameter("pwd");
	
	BoardVO vo=new BoardVO();
	vo.setName(name);
	vo.setSubject(subject);
	vo.setContent(content);
	vo.setPwd(pwd);
	
	// DAO를 통해서 => 오라클로 전송
	BoardDAO dao=new BoardDAO();
	dao.boardInsert(vo);
	
	// 이동 => list.jsp로
	response.sendRedirect("list.jsp");
	
%>
