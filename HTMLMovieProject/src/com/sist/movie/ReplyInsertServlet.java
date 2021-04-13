package com.sist.movie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.*;
/*
 * 	 <a href=ReplyInsertServlet?no=1> => doGet()
 *   <form method=post action=ReplyInsertServlet> => doPost()
 *   
 *   => ������ ���� ���(����������) HTML
 *     GET : URL�ڿ� ������ ���� ==> ?����=�� => ?mno=1
 *           ���ȿ� �����
 *           => ��ȭ��ȣ, �ܼ� �˻�, ������ ===================> �������� �ڵ� ȣ�� doGet()
 *     POST: UTL�ڿ� ������ => ���� ��Ʈ��ũ�� �̿��ؼ� ����(����, �����Ͱ� ���� ��� ���)
 *           => �α���, ȸ������, �۾���, ���Ͼ��ε� =============> doPost()
 */

@WebServlet("/ReplyInsertServlet")
public class ReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. ����ڰ� ���� ���� �޴´�
		try
		{
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		String mno=request.getParameter("mno");
		String msg=request.getParameter("msg");
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		String name=(String)session.getAttribute("name");
		// �Ű������� 3�� �̻��̸� => VO �̿�
		ReplyVO vo=new ReplyVO();
		vo.setMno(Integer.parseInt(mno));
		vo.setMsg(msg);
		vo.setId(id);
		vo.setName(name);
		// => DAO�� ���� => �����͸� ����Ŭ�� ����
		MovieDAO dao=new MovieDAO();
		dao.replyInsert(vo);
		// => �̵� => �󼼺���� �̵�
		response.sendRedirect("MovieDetailServlet?mno="+mno);
	}

}
