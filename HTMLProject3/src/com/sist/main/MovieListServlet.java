package com.sist.main;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;  // 오라클 연결 => 데이터를 가지고 온다
@WebServlet("/MovieListServlet")
public class MovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request: 사용자가 보내준 데이터를 받는 경우 => BufferedReader
		// response: 처리 결과를 브라우저로 전송 => OutputStream
		// 전송 => 형식(브라우저에서 실행 => HTML, XML)
		response.setContentType("text/html;charset=EUC-KR");   // 한글이 포함되었으니 2byte씩 읽어라
		// 브라우저로 전송하는데 html을 보낸다(단, 한글이 있다) => euc-kr (대소문자 구분x)
		// xml로 전송할 때 => text/xml, json => text/plain => AJAX(Asynchronous JavaScript and XML)실시간 => 화면 변경이 없음
		// 2. 누구에게 보내는지 설정
		PrintWriter out=response.getWriter();
		// 서버에 요청한 유저의 메모리 위치 out
		// http://localhost/HTMLProject3/MovieListServlet
		// http://211.238.142.181/HTMLProject3/MovieListServlet (학원ip)
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		
		// 1. 현재 페이지
		int curpage=Integer.parseInt(page);
		MovieDAO dao=new MovieDAO();
		// 2. 총 페이지
		int totalpage=dao.movieTotalPage();
		// 3. 영화정보 20개 => ArrayList
		ArrayList<MovieVO> list= dao.movieListData(curpage);
		// JSP => out.write 생략 가능한 프로그램. 실행하면 자동으로 Servelet으로 바뀜(tomcat이)
		out.write("<html>");
		out.write("<head>");
		out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.write("<body>");
		out.write("<div class=container>");  // container 디자인 크기
		out.write("<div class=row style=\"margin:0px auto;width=800px\">");
		out.write("<center>");
		out.write("<h1>영화 목록</h1>");
		out.write("<table class=\"table table-hover\">");   // css => class(중복 가능=여러개 바꿀 때), id(중복 불가)
		out.write("<tr class=danger>");
		out.write("<th>순위</th>");
		out.write("<th></th>");
		out.write("<th>영화명</th>");
		out.write("<th>감독명</th>");
		out.write("</tr>");
		for(MovieVO vo:list)   // 실제 데이터 출력
		{
			out.write("<tr>");
			out.write("<td>"+vo.getMno()+"</td>");
			out.write("<td align=center><img src="+vo.getPoster()+" width=30 height=30></td>");
			out.write("<td><a href=MovieDetailServlet?mno="+vo.getMno()+">"+vo.getTitle()+"</a></td>");
			// 웹에서는 다른 클래스에 값을 전송할 때 항상 ?뒤에 값(데이터)을 설정해서 보내야 함(공백 넣으면 안됨). 경로 주는 것과 같음
			// 화면이 바뀐다 = 새로운 파일 필요
			out.write("<td>"+vo.getDirector()+"</td>");
			out.write("</tr>");
		}
		out.write("<tr>");
		out.write("<td colspan=4 align=center>");
		out.write("<a href=MovieListServlet?page="+(curpage>1?curpage-1:curpage)+" class=\"btn btn-sm btn-primary\">이전</a>&nbsp;");   // a href=# 여기서 #은 아직 링크를 걸지 않겠다는 말
		out.write(curpage+" page / "+totalpage+" pages&nbsp;");                         // sm = button  primary = 버튼 색
		out.write("<a href=MovieListServlet?page="+(curpage<totalpage?curpage+1:curpage)+" class=\"btn btn-sm btn-primary\">다음</a>");   // 삼항연산자
		out.write("</td>");
		out.write("</tr>");
		out.write("</table>");
		out.write("</div>");
		out.write("</div>");
		out.write("</center>");
		out.write("</body>");
		out.write("</html>");
	}

}
