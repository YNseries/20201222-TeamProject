package com.sist.board;

import java.io.*;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;    // ArrayList
import com.sist.dao.*; // BoardVO, BoardDAO

@WebServlet("/BoardListServlet")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. HTML 문서 전송 = 브라우저(web: XML(사용자정의), HTML(고정))
		response.setContentType("text/html;charset=UTF-8");
		/*
		 *    1. 한글을 받는 경우
		 *       EUC-KR => EUC-KR (O)
		 *       UTF-8  => UTF-8  (O)
		 *       EUC-KR => UTF-8  (O)
		 *       UTF-8  => EUC-KR (X) 깨짐
		 */
		// 어디를 출력할 것인지
		PrintWriter out=response.getWriter();   // 사용자의 브라우저에 읽어갈 위치 지정
		/*
		 *    = 서블릿에만 존재하는게 아니다
		 *      JSP, Spring, 장고 NodeJS
		 *    request : 사용자가 보내준 데이터를 저장(브라우저 정보:서버 정보, URI 정보/사용자 정보(IP,PORT,데이터) 포함)
		 *         http://localhost/ProcedureBoardProject/BoardListServlet
		 *         ======================================================= URL
		 *                          ====================================== URI
		 *                ========= localhost:80(우리가 설정했던 것)이 생략되어있음
		 *                          ========= ==
		 *                          서버 주소    서버 포트 => 서버정보 갖고올 수 있지!
		 *    response: 응답(결과값을 브라우저에 전송), 화면 이동 정보(redirect())
		 *    session : 클라이언트의 일부 정보를 서버에 저장(필요할 때마다 끌어다 쓸 수 있음. 서버에 저장되어 있기 때문)
		 *    ============== 내장객체
		 *    cookie  : 클라이언트의 일부 정보를 클라이언트에 저장(최근 본 내용) => 단점: 본인 컴퓨터에서만 적용(저장)됨
		 *    
		 *    서블릿 단점: 수정할 때마다 컴파일 해야 함, HTML 코딩이 어려움
		 *         장점: 보안이 좋음(servlet 파일만 보내기 때문에 소스 노출x)
		 *    JSP의 단점: 보안에 허점이 있음(소스가 노출됨), 자바와 HTML을 구분해서 사용(섞여들어가기 때문), 확장/재사용 어려움
		 *         장점: 컴파일 없이 실행 가능 => 수정하기 좋음, HTMl 코딩이 편함(상대적으로)
		 *    
		 *    서블릿+JSP 장점만 => MVC 구조(작업하기 훨씬 편함)
		 *       Model: 자바 코딩(VO, DAO)
		 *       View : JSP 화면출력
		 *       Controller: Servlet => Spring(자바와 HTML을 연결)에서 제공
		 *    
		 *    *** request, response => TomCat이 생성해서 매개변수를 채운다(TomCat에 의해 호출됨)
		 *    
		 *    생명 주기
		 *      1. 생성자 호출: 메모리 할당(servlet 관련? 자동호출)
		 *    => 2. init(): 멤버변수의 초기화   ====> _jspInit()
		 *    => 3. doGet() | doPost(): 사용자가 브라우저에 요청시마다 호출되는 함수   ====> _jspService()
		 *         => 화면 이동, 새로 고침
		 *      4. destory(): 메모리 해제(특별한 경우는 호출하지 않음. 자동으로 됨)   ====> _jspDestory()
		 *      ***** JSP를 실행하면 자동으로 서블릿 파일로 변경됨(TomCat이 바꿈)
		 *      a.jsp ==> class a_jsp
		 */
		// 2. 사용자가 보내준 데이터를 받는다
		String page=request.getParameter("page");
		if(page==null)
			page="1";   // default 잡아줌
		
		int curpage=Integer.parseInt(page);    // 페이지 해야할 때 기본적으로 해야하는
		
		// 3. 오라클에서 데이터 읽기
		BoardDAO dao=new BoardDAO();
		// 3-1. 목록
		ArrayList<BoardVO> list=dao.board_list(curpage);
		// 3-2. 총 페이지
		int totalpage=dao.board_totalpage();
		// 4. 화면에 데이터 출력(HTML)
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=stylesheet href=\"css/table.css\">");
		out.println("<style>");
		out.println("th,td{font-size:9pt;font-family:맑은 고딕}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h3>게시판</h3>");
		out.println("<table width=700>");
		out.println("<tr>");
		out.println("<td>");
		out.println("<a href=BoardInsertServlet>새글</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<div style=\"height:400px;\">");   // 게시판 박스 사이즈 설정
		out.println("<table class=table-content width=700>");
		out.println("<tr height=35>");  // 게시글 목록 칸 높이
		out.println("<th width=10%>번호</th>");
		out.println("<th width=45%>제목</th>");
		out.println("<th width=15%>이름</th>");
		out.println("<th width=20%>작성일</th>");
		out.println("<th width=10%>조회수</th>");
		out.println("</tr>");
		// 4-1. 오늘 날짜에 올라온 글? new! 
		String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		for(BoardVO vo:list)
		{
			String dbday=vo.getRegdate().toString();
			out.println("<tr class=dataTr height=35>");
			out.println("<td width=10% align=center>"+vo.getNo()+"</td>");
			out.println("<td width=45%><a href=BoardDetailServlet?no="+vo.getNo()+">"+vo.getSubject()+"</a>&nbsp;");
			if(today.equals(dbday))
			{
				out.println("<sup style=\"color:red\">new</sup>");
				// <!ENTITY nbsp " "> XML에서 특수문자 정의
				// => 호출 &nbsp;
				// <!ENTITY lt "<">
				// <!ENTITY gt ">">
				// &lt;Hello&gt;   <Hello>
			}
			out.println("</td>");
			out.println("<td width=15% align=center>"+vo.getName()+"</td>");
			out.println("<td width=20% align=center>"+vo.getRegdate().toString()+"</td>");
			out.println("<td width=10% align=center>"+vo.getHit()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("<table width=700>");
		out.println("<tr>");
		// 4-2. 검색기
		out.println("<td>");
		out.println("Search:");
		out.println("<select name=fd>");
		out.println("<option value=name>이름</option>");
		out.println("<option value=subject>제목</option>");
		out.println("<option value=content>내용</option>");
		out.println("</select>");
		out.println("<input type=text name=ss size=10>");
		out.println("<input type=submit value=검색>");
		out.println("</td>");
		// 4-3. 페이지 이동
		out.println("<td align=right>");
		out.println("<a href=BoardListServlet?page="+(curpage>1?curpage-1:curpage)+">이전</a>&nbsp;");
		out.println(curpage+" page / "+totalpage+" pages");
		out.println("<a href=BoardListServlet?page="+(curpage<totalpage?curpage+1:curpage)+">다음</a>");
		out.println("</td>");
		
		out.println("</tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
