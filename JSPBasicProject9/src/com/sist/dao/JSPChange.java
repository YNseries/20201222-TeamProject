package com.sist.dao;

public class JSPChange {
	private static String[] jsp={
		// mode에 맞게 화면을 바꾸기 위함
		"../food/home.jsp",      //=> main.jsp?mode=0(main에 설정되어 있음. mode=0은 보통 생략되어 있음)
		// main.jsp?mode=0%index=1 에서 index=1은(
		"../food/category.jsp",  //=> main.jsp?mode=1
		"../food/detail.jsp"     //=> main.jsp?mode=2
		// _ok.jsp는 포함되지 않음(화면에 출력되는게 아니기 때문)
	};
	
	public static String change(int no)
	{
		
		return jsp[no];   // jsp의 no번째를 리턴
	}
}
