package com.sist.controller;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.model.*;

public class Controller2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map clsMap=new HashMap();
	private String[] strClas= {
			"com.sist.model.DeleteModel";
			"com.sist.model.UpdateModel";
			"com.sist.model.DetailModel";
			"com.sist.model.ListModel";
	};
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//clsMap.put("list", new ListModel());
		// Model model=new ListModel(); 과 같음
		//clsMap.put("update", new UpdateModel());
		//clsMap.put("delete", new DeleteModel());
		//clsMap.put("detail", new DetailModel());
		try
		{
			int i=0;
			for(String cls:strCls)
			{
				Class clsName=Class.forName(cls);
				Object obj=clsName.newInstance();
				clsMap.put(strCmd[i], )
			}
		}
	}
	// http://localhost/JSPMVCProject1/list.do
	//                 ======================= uri
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd=request.getRequestURI();
		cmd=cmd.substring(cmd.lastIndexOf("/")+1,cmd.lastIndexOf("."));
		//System.out.println(cmd);
		Model model=(Model)clsMap.get(cmd);
		model.handlerRequest(request);
		RequestDispatcher rd=request.getRequestDispatcher("view/"+cmd+".jsp");
		rd.forward(request, response);
		
	}

}
