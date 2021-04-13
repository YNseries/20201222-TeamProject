package com.sist.movie;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.*;  // ����Ŭ ����
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// �α��� ȭ�� => JSP(���� �� ���� ���� ó��)/ servletó�� doGet,doPost�� �������� �ƴ� service �ϳ��� �ֱ� ������
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. HTML�� ����(��û�� Ŭ���̾�Ʈ�� ��������)
		// => HTML�� �����ٴ� �޼����� �������� �˷��ش�(text/html, text/xml, text/plain(JSON))
		response.setContentType("text/html;charset=EUC-KR");
		// 1���� UTF-8
		// Ŭ���̾�Ʈ ���������� HTML�� �о �� �ִ� ��ġ Ȯ��(�޸�)
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		// => CSS, JavaScript, Title => AJAX
		// CSS ��� => �ܺ� CSS
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">");
		out.println("<style type=text/css>");
		// container(960px) , container-fluid(Full ȭ��)
		out.println(".row { width:350px;margin:0px auto;}");//<center>�±״� ������
		// <center> => margin:0px auto;
		out.println("h3{text-align:center}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		// => ȭ�� ����ϴ� �±׸� �̿��Ѵ�
		out.println("<div class=container>");
		out.println("<h3>Login</h3>");
		out.println("<div class=row>");
		
		// ���� �غ�
		out.println("<form method=post action=LoginServlet>");
		// LoginServlet Ŭ������ doPost()�� �Էµ� ���� ������
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
		out.println("<input type=submit value=�α��� class=\"btn btn-sm btn-primary\">");
		// ��ư ũ��  btn-lg(large), btn-sm(small), btn-xs(Xsmall)
		out.println("<input type=button value=��� class=\"btn btn-sm btn-danger\">");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
	// ����ڰ� �Է��� id, pwd�� �޾Ƽ� ó�� => �α��ν� �̵�(��ȭ�������)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HTML ����
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out=response.getWriter();
		
		// 1. ����ڰ� ������ id, password�� �޴´�
		String id=request.getParameter("id");    // <input type=text name=id>
		String pwd=request.getParameter("pwd");  // <input type=password name=pwd>
		
		// 2. DAO ���� => ���
		MovieDAO dao=new MovieDAO();
		String result=dao.isLogin(id, pwd);
		
		// 3. �̵� �õ�
		if(result.equals("NOID"))   // ID�� ���� ���
		{
			out.println("<script>");
			out.println("alert(\"���̵� �������� �ʽ��ϴ�\");");
			out.println("history.back();");   // �α��� ȭ������ �̵�
			out.println("</script>");
		}
		else if(result.equals("NOPWD"))   // ID�� ���� => ��й�ȣ Ʋ�� ���
		{
			out.println("<script>");
			out.println("alert(\"��й�ȣ�� Ʋ���ϴ�\");");
			out.println("history.back();");   // �α��� ȭ������ �̵�
			out.println("</script>");
		}
		else   // ID, PWD ��ġ => �α��� �Ǵ� ���� 
		{
			// 1. ������ id,name�� ���� => ���α׷� ����ñ��� ���: ����(�Ϻ� ������ ����ϴ°�)
			HttpSession session=request.getSession();
			session.setAttribute("id",id);   // Map��� => (key,value)
			session.setAttribute("name", result);
			
			// �̵�
			response.sendRedirect("MovieListServlet");
		}
	}

}
