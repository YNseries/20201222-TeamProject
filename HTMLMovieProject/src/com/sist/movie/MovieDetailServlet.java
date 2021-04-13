package com.sist.movie;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.*;
import java.util.*;
@WebServlet("/MovieDetailServlet")
public class MovieDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// doGet => 화면 출력만 함(자동으로 호출되는 프로그램이라 doPost()와 (필요시)같이 웹에서 씀) => request를 통해 넘어옴
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 화면에 출력 => 브라우저에 html을 전송하겠다!
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out=response.getWriter();
		// MovieDetailServlet?mno=5; = URL주소 => Tomcat(웹서버)이 받음 => request.setAttribute("mno",5) => doGet(request) 순으로 진행
		// 사용자로부터 영화 번호를 받는다
		String mno=request.getParameter("mno");   // 자동호출할 수 있는 값을 넣어야 호출할 수 있음
		// 영화 번호를 => DAO로 넘김 => 상세내용 출력(리턴) VO: 데이터베이스 내용 갖고옴
		MovieDAO dao=new MovieDAO();
		MovieVO vo=dao.movieDetailData(Integer.parseInt(mno));   //영화 한 개의 내용
		ArrayList<MovieVO> list=dao.replyTop10();   // 댓글
		// 목록 출력 => DAO로부터 ArrayList 받음
		// 상세보기 => DAO에서 VO(영화 하나에 대한 모든 정보) 갖고옴
		out.println("<html>");
		out.println("<head>");
		// script, css, title, meta 태그 가능 => 설정o, 화면출력x
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<style type=text/css>");
		// container(960px) , container-fluid(Full 화면)
		out.println(".row { width:1200px;margin:0px auto;}");
		// <center> => margin:0px auto;
		//out.println(".col-sm-9{border:1px solid green;height:450px}");
		//out.println(".col-sm-3{border:1px solid blue;height:450px}");
		out.println("h3{text-align:center}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		// 화면 출력 부분 ==> <html><head><body> 생략할 수 있다(틀린게 아님)
		out.println("<div style=\"height:30px\"></div>");   // 밑으로 좀 내림
		out.println("<div class=container>");   // width=960px
		
		out.println("<div class=row>");   // 상세보기, 인기순위
		// 상세보기
		out.println("<div class=col-sm-9>");   // row는 다 더했을 때 12 되어야 한 줄
		out.println("<h3>&lt;"+vo.getTitle()+"&gt; 상세보기</h3>");
		out.println("<table class=\"table table-stripted\">");
		
		out.println("<tr>");
		out.println("<td width=30% class=text-center rowspan=6>");
		out.println("<img src="+vo.getPoster()+" width=100%>");
		out.println("</td>");
		out.println("<td colspan=2 style=\"color:orange;font-size:15pt\">");
		out.println(vo.getTitle()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=10% class=text-right style=\"color:gray\">감독</td>");
		out.println("<td width=60%>"+vo.getDirector()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=10% class=text-right style=\"color:gray\">출연</td>");
		out.println("<td width=60%>"+vo.getActor()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=10% class=text-right style=\"color:gray\">장르</td>");
		out.println("<td width=60%>"+vo.getGenre()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=10% class=text-right style=\"color:gray\">등급</td>");
		out.println("<td width=60%>"+vo.getGrade()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=10% class=text-right style=\"color:gray\">개봉일</td>");
		out.println("<td width=60%>"+vo.getRegdate()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td colspan=3 class=text-right>");
		out.println("<a href=# class=\"btn btn-xs btn-danger\">예매하기</a>");
		out.println("<a href=# class=\"btn btn-xs btn-warning\">찜하기</a>");
		out.println("<a href=MovieListServlet class=\"btn btn-xs btn-info\">목록</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</div>");
		
		// 인기순위
		out.println("<div class=col-sm-3>");
		out.println("<h3>댓글이 많은 영화</h3>");   // 댓글을 올릴 때마다 자동으로 히트를 증가시키는 형식(Trigger)
		out.println("<table class=\"table table-hover\">");
		for(MovieVO tvo:list)
		{
			out.println("<tr>");
			out.println("<td class=text-center>");
			out.println("<img src="+tvo.getPoster()+" width=30 height=30>");
			out.println("</td>");
			out.println("<td class=text-center>");
			out.println(tvo.getTitle());
			out.println("</td>");
			out.println("<td class=text-center>");
			out.println(tvo.getHit());
			out.println("</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</div>");
		out.println("</div>");
		
		out.println("<div class=row>"); // 댓글, 영화뉴스
		// 댓글
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		out.println("<div class=col-sm-9>");
		// 댓글 출력 위치
		// 댓글이 없는 경우 없다고 나오도록 => 댓글 갯수 필요
		if(id!=null) // 로그인이 성공했을때만 댓글 쓸 수 있게
		{
			out.println("<table class=table>");
			out.println("<tr>");
			out.println("<td>");
			out.println("<form method=post action=ReplyInsertServlet>");   // form => doPost
			out.println("<input type=hidden name=mno value="+vo.getMno()+">");
			out.println("<textarea rows=3 cols=90 style=\"float:left\" name=msg></textarea>");
			out.println("<input type=submit value=댓글쓰기 class=\"btn btn-sm btn-primary\" style=\"height:68px;float:left\">");
			out.println("</form>");
			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");
		}
		out.println("</div>");
		// 영화 뉴스
		out.println("<div class=col-sm-3>");
		
		out.println("</div>");
		
		out.println("</div>");
		out.println("</div>");   // container
		out.println("</body>");
		out.println("</html>");
	}

}
