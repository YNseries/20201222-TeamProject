<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.bean.*"%>
<%--
	  public void display(MemberBean bean)
	  throws Exception  => 예외처리
	  {
	     dao.insert(bean)
	  }
	  [8장] jsp=>화면 출력하는 용도
	  jsp에서 지원하는 액션태그   <jsp:
	  1. 클래스 메모리 할당 => 싱글턴 <jsp:useBean id="객체명" class="패키지명.클래스명">
	     Class.forName("패키지명.클래스명") => 클래스를 등록하고 메모리 할당 요청할 때 => (반드시) 패키지명.클래스명 / 폴더명을 지정해 줘야 나옴!
	  2. 클라이언트가 전송한 데이터를 받아서 setXxx()에 저장하는 태그
	     <jsp:setProperty name="객체명" property="변수명"/> 전체는 *
	  3. Bean에 저장된 데이터를 읽어서 출력: <jsp:getProperty name="객체명" property="변수명">
	  4. request를 공유하면서 JSP여러개를 조립: <jsp:include page="파일명">
	  5. request를 공유하면서 화면을 이동: <jsp:forward page=""> => MVC(재사용↑, 확장성↑)에서 사용
	  
	  Bean을 만들 때: 데이터를 모아서 한 번에 전송할 목적
	  ============
	    변수: private 속성 => 메모리에서 읽어서 갖고오기|저장하기(읽기(Getter)|쓰기(Setter))
	    메소드: public
	      boolean => isXxx()
	    
 --%>
<% 
	request.setCharacterEncoding("UTF-8");
%>
<%--
	 태그형으로 바꾸면서 간소화된 부분
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
	 이게 생략된 것
 --%>
<%--
	MemberBean bean=new MemberBean(); 를 태그형으로 바꾼게 ↓
	   id="객체명"
	<jsp:setProperty name="bean" property="*"/> 
	bean.setXxx()
	
	<c:forEach items="list"> => for문 돌아감
 --%>
<jsp:useBean id="bean" class="com.sist.bean.MemberBean">
	<jsp:setProperty name="bean" property="*"/> 
	<!-- request 받아서 빈 객체에 값을 다 채워주는 태그 -->
</jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%-- 아이디:<%=bean.getId() %><br> --%>
  아이디:<jsp:getProperty name="bean" property="id"/><br>
  <%-- 이름:<%=bean.getName() %><br>--%>
  이름:<jsp:getProperty name="bean" property="name"/><br>
  <%-- 성별:<%=bean.getSex() %><br>--%>
  성별:<jsp:getProperty name="bean" property="sex"/><br>
  <%-- 주소:<%=bean.getAddr() %><br>--%>
  주소:<jsp:getProperty name="bean" property="addr"/><br>
  <%-- 전화:<%=bean.getTel() %>--%>
  전화:<jsp:getProperty name="bean" property="tel"/><br>
  <%--
  	  try {
  		  Class clsName=Class.forName("com.sist.bean.MemberBean");
  		  MemberBean obj=(MemberBeanclsName.newInstance());
  		  
  	  }catch(Exception ex){
  		  ex.printStackTrace();
  	  }
  	  //Thread.sleep(1000);   // 자바에서 그냥쓰면 에러나는 코드 => 예외처리 해 줘야 하는 코드
  			  // => 이 페이지에선 이미 예외처리 되어있어서 오류 안남
  --%>
</body>
</html>