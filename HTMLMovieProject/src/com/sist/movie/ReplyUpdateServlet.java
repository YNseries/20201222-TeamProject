package com.sist.movie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.dao.*;
@WebServlet("/ReplyUpdateServlet")
public class ReplyUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			// http: 네트워크(TCP) => 서버로 전송(1byte씩) 한글(byte로 변환 후 전송)
			// 자바 => %EC%9E%90%EB%B0%94 (인코딩) => web에서는 자동으로 인코딩 
			// %EC%9E%90%EB%B0%94 => 자바 (디코딩)
			request.setCharacterEncoding("UTF-8");  // (한글 인터넷에서 안깨지게 하려고)인코딩 => 디코딩
			// 이거 없으면 다 깨짐
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		// 1. web => 한글(브라우저, 자바...)
		String no=request.getParameter("no");
		String mno=request.getParameter("mno");
		String msg=request.getParameter("msg");
		
		// DAO 연결
		MovieDAO dao=new MovieDAO();
		dao.replyUpdate(Integer.parseInt(no), msg);
		// mno => 화면이동
		response.sendRedirect("MovieDetailServlet?mno="+mno);
	}

}
