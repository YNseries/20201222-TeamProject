package com.sist.model;

import javax.servlet.http.HttpServletRequest;
/*
 *             요청           해당 Model로 request 전송
 *    클라이언트 ====== Controller ====== Model
 *            <=====            <=====
 *              JSP           결과값을 request에 담는다
 *              request에 설정한 결과값을 받아서 JSTL,EL을 이용해서 출력
 */
public class DetailModel {
	public void handlerRequest(HttpServletRequest request)
	{
		String msg="홍길동,"","",""";
		request.setAttribute("msg", msg);
	}

}
