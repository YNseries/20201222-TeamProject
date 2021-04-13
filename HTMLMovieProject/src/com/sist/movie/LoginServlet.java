package com.sist.movie;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.*;  // 오라클 연결
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 로그인 화면 => JSP(파일 두 개를 만들어서 처리)/ servlet처럼 doGet,doPost로 나눠진게 아닌 service 하나만 있기 때문에
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. HTML을 전송(요청한 클라이언트의 브라우저로)
		// => HTML을 보낸다는 메세지를 브라우저에 알려준다(text/html, text/xml, text/plain(JSON))
		response.setContentType("text/html;charset=EUC-KR");
		// 1조는 UTF-8
		// 클라이언트 브라우저에서 HTML을 읽어갈 수 있는 위치 확인(메모리)
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		// => CSS, JavaScript, Title => AJAX
		// CSS 사용 => 외부 CSS
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<style type=text/css>");
		// container(960px) , container-fluid(Full 화면)
		out.println(".row { width:350px;margin:0px auto;}");//<center>태그는 사용금지
		// <center> => margin:0px auto;
		out.println("h3{text-align:center}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		// => 화면 출력하는 태그를 이용한다
		out.println("<div class=container>");
		out.println("<h3>Login</h3>");
		out.println("<div class=row>");
		
		// 전송 준비
		out.println("<form method=post action=LoginServlet>");
		// LoginServlet 클래스의 doPost()로 입력된 값을 보낸다
		out.println("<table class=\"table table-condensed\">");
		out.println("<tr>");
		out.println("<th width=20% class=\"danger text-right\">ID</th>");
		out.println("<td width=80%>");
		out.println("<input type=text name=id size=20>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<th width=20% class=\"danger text-right\">Password</th>");
		out.println("<td width=80%>");
		out.println("<input type=password name=pwd size=20>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td colspan=2 class=text-center>");
		out.println("<input type=submit value=로그인 class=\"btn btn-sm btn-primary\">");
		// 버튼 크기  btn-lg(large), btn-sm(small), btn-xs(Xsmall)
		out.println("<input type=button value=취소 class=\"btn btn-sm btn-danger\">");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
	// 사용자가 입력한 id, pwd를 받아서 처리 => 로그인시 이동(영화목록으로)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HTML 전송
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out=response.getWriter();
		
		// 1. 사용자가 보내준 id, password를 받는다
		String id=request.getParameter("id");    // <input type=text name=id>
		String pwd=request.getParameter("pwd");  // <input type=password name=pwd>
		
		// 2. DAO 연동 => 결과
		MovieDAO dao=new MovieDAO();
		String result=dao.isLogin(id, pwd);
		
		// 3. 이동 시도
		if(result.equals("NOID"))   // ID가 없는 경우
		{
			out.println("<script>");
			out.println("alert(\"아이디가 존재하지 않습니다\");");
			out.println("history.back();");   // 로그인 화면으로 이동
			out.println("</script>");
		}
		else if(result.equals("NOPWD"))   // ID는 존재 => 비밀번호 틀린 경우
		{
			out.println("<script>");
			out.println("alert(\"비밀번호가 틀립니다\");");
			out.println("history.back();");   // 로그인 화면으로 이동
			out.println("</script>");
		}
		else   // ID, PWD 일치 => 로그인 되는 상태 
		{
			// 1. 서버에 id,name을 저장 => 프로그램 종료시까지 기억: 세션(일부 정보를 기억하는것)
			HttpSession session=request.getSession();
			session.setAttribute("id",id);   // Map방식 => (key,value)
			session.setAttribute("name", result);
			
			// 이동
			response.sendRedirect("MovieListServlet");
		}
	}

}
