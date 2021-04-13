package com.sist.main;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.dao.*;  // ����Ŭ ���� => �����͸� ������ �´�
@WebServlet("/MovieListServlet")
public class MovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request: ����ڰ� ������ �����͸� �޴� ��� => BufferedReader
		// response: ó�� ����� �������� ���� => OutputStream
		// ���� => ����(���������� ���� => HTML, XML)
		response.setContentType("text/html;charset=EUC-KR");   // �ѱ��� ���ԵǾ����� 2byte�� �о��
		// �������� �����ϴµ� html�� ������(��, �ѱ��� �ִ�) => euc-kr (��ҹ��� ����x)
		// xml�� ������ �� => text/xml, json => text/plain => AJAX(Asynchronous JavaScript and XML)�ǽð� => ȭ�� ������ ����
		// 2. �������� �������� ����
		PrintWriter out=response.getWriter();
		// ������ ��û�� ������ �޸� ��ġ out
		// http://localhost/HTMLProject3/MovieListServlet
		// http://211.238.142.181/HTMLProject3/MovieListServlet (�п�ip)
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		
		// 1. ���� ������
		int curpage=Integer.parseInt(page);
		MovieDAO dao=new MovieDAO();
		// 2. �� ������
		int totalpage=dao.movieTotalPage();
		// 3. ��ȭ���� 20�� => ArrayList
		ArrayList<MovieVO> list= dao.movieListData(curpage);
		// JSP => out.write ���� ������ ���α׷�. �����ϸ� �ڵ����� Servelet���� �ٲ�(tomcat��)
		out.write("<html>");
		out.write("<head>");
		out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.write("<body>");
		out.write("<div class=container>");  // container ������ ũ��
		out.write("<div class=row style=\"margin:0px auto;width=800px\">");
		out.write("<center>");
		out.write("<h1>��ȭ ���</h1>");
		out.write("<table class=\"table table-hover\">");   // css => class(�ߺ� ����=������ �ٲ� ��), id(�ߺ� �Ұ�)
		out.write("<tr class=danger>");
		out.write("<th>����</th>");
		out.write("<th></th>");
		out.write("<th>��ȭ��</th>");
		out.write("<th>������</th>");
		out.write("</tr>");
		for(MovieVO vo:list)   // ���� ������ ���
		{
			out.write("<tr>");
			out.write("<td>"+vo.getMno()+"</td>");
			out.write("<td align=center><img src="+vo.getPoster()+" width=30 height=30></td>");
			out.write("<td><a href=MovieDetailServlet?mno="+vo.getMno()+">"+vo.getTitle()+"</a></td>");
			// �������� �ٸ� Ŭ������ ���� ������ �� �׻� ?�ڿ� ��(������)�� �����ؼ� ������ ��(���� ������ �ȵ�). ��� �ִ� �Ͱ� ����
			// ȭ���� �ٲ�� = ���ο� ���� �ʿ�
			out.write("<td>"+vo.getDirector()+"</td>");
			out.write("</tr>");
		}
		out.write("<tr>");
		out.write("<td colspan=4 align=center>");
		out.write("<a href=MovieListServlet?page="+(curpage>1?curpage-1:curpage)+" class=\"btn btn-sm btn-primary\">����</a>&nbsp;");   // a href=# ���⼭ #�� ���� ��ũ�� ���� �ʰڴٴ� ��
		out.write(curpage+" page / "+totalpage+" pages&nbsp;");                         // sm = button  primary = ��ư ��
		out.write("<a href=MovieListServlet?page="+(curpage<totalpage?curpage+1:curpage)+" class=\"btn btn-sm btn-primary\">����</a>");   // ���׿�����
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
