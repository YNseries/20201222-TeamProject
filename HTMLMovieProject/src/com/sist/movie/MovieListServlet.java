package com.sist.movie;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.MovieDAO;
import com.sist.dao.MovieVO;

@WebServlet("/MovieListServlet")
public class MovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out=response.getWriter();
		// session�� ������ �´� => �� Ŭ���̾�Ʈ �� �� ���� ���� => request�� �̿��ؼ� ����
		//HttpSession session=request.getSession();  // ������ ������ �´�
		String page=request.getParameter("page");
		// dafault ���� => page=1
		if(page==null)
			page="1";
		int curpage=Integer.parseInt(page);   // ���� ���� �ִ� ������
		// �� ������
		MovieDAO dao=new MovieDAO();
		int totalpage=dao.movieTotalPage();
		// �ش� �������� �ش�Ǵ� ������ �б�
		ArrayList<MovieVO> list=dao.movieListData(curpage);
		
		out.println("<html>");
		out.println("<head>");
		// CSS ��� => �ܺ� CSS
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<style type=text/css>");
		// bootStrap => container(960px), container-fluid(Full ȭ��)
		out.println(".row{width:960px;margin:0px auto;}");  // <center>�±� ��� ����
		// �������: <center> ��� margin:0px auto
		out.println("h3{text-align:center}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
			/*
			    out.println("<center>"); out.println("<h3>��ȭ ���</h3>");
				out.println("<h4>ID:"+session.getAttribute("id")+"</h4>");
				out.println("<h4>�̸�:"+session.getAttribute("name")+"</h4>");
				out.println("</center>");
			 */
		out.println("<div style=\"height:50px\"></div>");
		out.println("<div class=container>");
		out.println("<div class=row>");
		/*
		 *   <div class="col-md-4">
			    <div class="thumbnail">
			      <a href="/w3images/lights.jpg">
			        <img src="/w3images/lights.jpg" alt="Lights" style="width:100%">
			        <div class="caption">
			          <p>Lorem ipsum...</p>
			        </div>
			      </a>
			    </div>
			  </div>
		 */
		for(MovieVO vo:list)
		{
			out.println("<div class=\"col-md-3\">");   // �ڿ� ������ ���ڰ� 12�� �Ǹ�, �ڵ����� ������ ��������
			// col-md-3   4���� ����ϱ� ����(12���� 3�ٷ� ����=���� 4���� ����)
			out.println("<div class=\"thumbnail\">");
			out.println("<a href=MovieDetailServlet?mno="+vo.getMno()+">");   // ?�� request�� ���� �־��ش�
			out.println("<img src=\""+vo.getPoster()+"\" class=img-rounded style=\"width:220;height:300px\">");
			out.println("<div class=\"caption\">");
			out.println("<p style=\"font-size:8pt;font-weight:bold;font-family:���� ���\">"+vo.getTitle()+"</p>");
			out.println("</div>");
			out.println("</a>");
			out.println("</div>");
			out.println("</div>");
		}
		out.println("</div>");   // Ŭ���� row�� ������ �κ�
		
		out.println("<div class=row>");
		out.println("<div style=\"text-align:center\">");
		out.println("<a href=MovieListServlet?page="+(curpage>1?curpage-1:curpage)+" class=\"btn btn-sm btn-success\">����</a>");
		// btn-lg, btn-sm, btn-md, btn-xs
		// btn-success(green), btn-danger(red), btn-info(cyan), btn-primary(blue), btn-warning(orange), btn-active(grey) - Ʈ��Ʈ���� ���������ϴ� css���̺귯��
		out.println(curpage+" page / "+totalpage+" pages");
	    out.println("<a href=MovieListServlet?page="+(curpage<totalpage?curpage+1:curpage)+" class=\"btn btn-sm btn-info\">����</a>");
	    out.println("</div>");   // div
		
		out.println("</div>");   // class row
		out.println("</div>");   // container
		out.println("</body>");
		out.println("</html>");
		
	}

}
