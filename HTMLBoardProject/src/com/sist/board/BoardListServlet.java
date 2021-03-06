package com.sist.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;
@WebServlet("/BoardListServlet")  // 사이트(url) 주소. 맘대로 바꿔도 됨. 대신 중복되지 않게
// BoardListServlet a=new BoardListServlet();
// 웹 => main(X)  |  서블릿, JSP => 메모리할당(톰캣) 서블릿?변수=값 : ?있어야 값 넘어감
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 서블릿 => 브라우저로 전송(HTML, XML)
		response.setContentType("text/html;charset=EUC-KR");  // text/xml;charset=EUC-KR 한글 쓰겠다!
		// 2. 어느 컴퓨터로 전송할지
		PrintWriter out=response.getWriter();   // 해당 클라이언트에 HTML을 전송
		/*
		 *   데이터 받기
		 *   http://211.238.142.181/HTMLBoardProject/BoardListServlet
		 */
		// 1) 데이터 => 사용자가 요청한 페이지 받기
		String page=request.getParameter("page");
		// 2) 처음에는 페이지 설정(X) => 디폴트
		if(page==null)
			page="1";
		// 현재 페이지 저장
		int curpage=Integer.parseInt(page);
		// 총 페이지 지정?저장
		BoardDAO dao=new BoardDAO();
		int count=dao.boardRowCount();  // 번호 순서로 출력
		int totalpage=(int)(Math.ceil(count/10.0));
		//페이지별 데이터 읽기
		ArrayList<BoardVO> list=dao.boardListData(curpage);
		
		// 3. 어떤 HTML 설정
		out.println("<html>");
		out.println("<head>");
		out.println("<style type=text/css>");
		out.println("td,th{font-family:맑은 고딕;font-size:9pt;height:35px}");
		out.println(".table_main{border-collapse:collapse;");
		out.println("border-top-width: 2px;"
				+ "border-bottom-width: 1px;"
				+ "border-top-style: solid;"
				+ "border-bottom-style: solid;"
				+ "border-top-color: #333;"
				+ "border-bottom-color: #333;}");
		out.println(".table_main th{");
		out.println("background-color: #999;"
				+ "color: #fff;"
				+ "border-bottom-width: 1px;"
				+ "border-bottom-color: #333;}");
		out.println(".table_main td{");
		out.println("border-bottom-width: 1px;"
				+ "border-bottom-color: #666;"
				+ "border-bottom-style: dotted;}");
		out.println("a{color:black;text-decoration:none}");
		out.println("a:hover{color:green;text-decoration:underline}");
		out.println(".dataTr:HOVER {"
				+ "background-color: #FC6;"
				+ "cursor: pointer;"
				+ "cursor: hand;"
				+ "}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		//out.println("IP:"+request.getRemoteAddr());  // 접근하는 사람의 IP를 갖고옴
		
		out.println("<h1>게시판</h1>");
		out.println("<table border=0 width=700>");
		out.println("<tr>");
		out.println("<td><a href=BoardInsertServlet>새글</a></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<div style=\"height:400px\">");
		out.println("<table width=700 class=table_main>");
		out.println("<tr id=head>");
		out.println("<th width=10%>번호</th>");
		out.println("<th width=45%>제목</th>");
		out.println("<th width=15%>이름</th>");
		out.println("<th width=20%>작성일</th>");
		out.println("<th width=10%>조회수</th>");
		out.println("</tr>");
		// 데이터를 출력하는 위치
		for(BoardVO vo:list)
		{
			out.println("<tr class=dataTr>");
			out.println("<td width=10% align=center>"+vo.getNo()+"</td>");
			String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			String dbday=vo.getRegdate().toString();
			// 오라클에선 YY/MM/DD => java에선 yyyy-MM-dd
			out.println("<td width=45%><a href=BoardDetailServlet?no="+vo.getNo()+">"+vo.getSubject()+"</a>");
			if(today.equals(dbday))
			{
				out.println("<sup><font color=red>new</font></sup>");   // 오늘 날짜에 new 달기
			}
			out.println("</td>");
			out.println("<td width=15% align=center>"+vo.getName()+"</td>");
			out.println("<td width=20% align=center>"+vo.getRegdate().toString()+"</td>");
			out.println("<td width=10% align=center>"+vo.getHit()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		// 하단 출력
		out.println("<table width=700>");
		out.println("<tr>");
		// 검색창
		out.println("<td align=left>");
		out.println("Search:");
		out.println("<select name=fs>");
		out.println("<option value=name>이름</option>");
		out.println("<option value=subject>제목</option>");
		out.println("<option value=content>내용</option>");
		out.println("</select>");
		out.println("<input type=text name=ss size=10>");
		out.println("<input type=submit value=검색>");
		out.println("</td>");
		
		out.println("<td align=right>");
		out.println("<a href=BoardListServlet?page="+(curpage>1?curpage-1:curpage)+">이전</a>&nbsp;");
		out.println(curpage+" page / "+totalpage+" pages&nbsp;");
		out.println("<a href=BoardListServlet?page="+(curpage>1?curpage-1:curpage)+">다음</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

}
