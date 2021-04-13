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
	// doGet => ȭ�� ��¸� ��(�ڵ����� ȣ��Ǵ� ���α׷��̶� doPost()�� (�ʿ��)���� ������ ��) => request�� ���� �Ѿ��
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ȭ�鿡 ��� => �������� html�� �����ϰڴ�!
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out=response.getWriter();
		// MovieDetailServlet?mno=5; = URL�ּ� => Tomcat(������)�� ���� => request.setAttribute("mno",5) => doGet(request) ������ ����
		// ����ڷκ��� ��ȭ ��ȣ�� �޴´�
		String mno=request.getParameter("mno");   // �ڵ�ȣ���� �� �ִ� ���� �־�� ȣ���� �� ����
		// ��ȭ ��ȣ�� => DAO�� �ѱ� => �󼼳��� ���(����) VO: �����ͺ��̽� ���� �����
		MovieDAO dao=new MovieDAO();
		MovieVO vo=dao.movieDetailData(Integer.parseInt(mno));   //��ȭ �� ���� ����
		ArrayList<MovieVO> list=dao.replyTop10();   // ���
		// ��� ��� => DAO�κ��� ArrayList ����
		// �󼼺��� => DAO���� VO(��ȭ �ϳ��� ���� ��� ����) �����
		out.println("<html>");
		out.println("<head>");
		// script, css, title, meta �±� ���� => ����o, ȭ�����x
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<style type=text/css>");
		// container(960px) , container-fluid(Full ȭ��)
		out.println(".row { width:1200px;margin:0px auto;}");
		// <center> => margin:0px auto;
		//out.println(".col-sm-9{border:1px solid green;height:450px}");
		//out.println(".col-sm-3{border:1px solid blue;height:450px}");
		out.println("h3{text-align:center}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		// ȭ�� ��� �κ� ==> <html><head><body> ������ �� �ִ�(Ʋ���� �ƴ�)
		out.println("<div style=\"height:30px\"></div>");   // ������ �� ����
		out.println("<div class=container>");   // width=960px
		
		out.println("<div class=row>");   // �󼼺���, �α����
		// �󼼺���
		out.println("<div class=col-sm-9>");   // row�� �� ������ �� 12 �Ǿ�� �� ��
		out.println("<h3>&lt;"+vo.getTitle()+"&gt; �󼼺���</h3>");
		out.println("<table class=\"table table-stripted\">");
		
		out.println("<tr>");
		out.println("<td width=30% class=text-center rowspan=6>");
		out.println("<img src="+vo.getPoster()+" width=100%>");
		out.println("</td>");
		out.println("<td colspan=2 style=\"color:orange;font-size:15pt\">");
		out.println(vo.getTitle()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=10% class=text-right style=\"color:gray\">����</td>");
		out.println("<td width=60%>"+vo.getDirector()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=10% class=text-right style=\"color:gray\">�⿬</td>");
		out.println("<td width=60%>"+vo.getActor()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=10% class=text-right style=\"color:gray\">�帣</td>");
		out.println("<td width=60%>"+vo.getGenre()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=10% class=text-right style=\"color:gray\">���</td>");
		out.println("<td width=60%>"+vo.getGrade()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td width=10% class=text-right style=\"color:gray\">������</td>");
		out.println("<td width=60%>"+vo.getRegdate()+"</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td colspan=3 class=text-right>");
		out.println("<a href=# class=\"btn btn-xs btn-danger\">�����ϱ�</a>");
		out.println("<a href=# class=\"btn btn-xs btn-warning\">���ϱ�</a>");
		out.println("<a href=MovieListServlet class=\"btn btn-xs btn-info\">���</a>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</div>");
		
		// �α����
		out.println("<div class=col-sm-3>");
		out.println("<h3>����� ���� ��ȭ</h3>");   // ����� �ø� ������ �ڵ����� ��Ʈ�� ������Ű�� ����(Trigger)
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
		
		out.println("<div class=row>"); // ���, ��ȭ����
		// ���
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		out.println("<div class=col-sm-9>");
		// ��� ��� ��ġ
		// ����� ���� ��� ���ٰ� �������� => ��� ���� �ʿ�
		if(id!=null) // �α����� ������������ ��� �� �� �ְ�
		{
			out.println("<table class=table>");
			out.println("<tr>");
			out.println("<td>");
			out.println("<form method=post action=ReplyInsertServlet>");   // form => doPost
			out.println("<input type=hidden name=mno value="+vo.getMno()+">");
			out.println("<textarea rows=3 cols=90 style=\"float:left\" name=msg></textarea>");
			out.println("<input type=submit value=��۾��� class=\"btn btn-sm btn-primary\" style=\"height:68px;float:left\">");
			out.println("</form>");
			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");
		}
		out.println("</div>");
		// ��ȭ ����
		out.println("<div class=col-sm-3>");
		
		out.println("</div>");
		
		out.println("</div>");
		out.println("</div>");   // container
		out.println("</body>");
		out.println("</html>");
	}

}
