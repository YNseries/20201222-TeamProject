package com.sist.anno;

import java.lang.reflect.Method;

public class MovieSystem {
	public static void main(String[] args) {
		MovieSystem ms=new MovieSystem();
		ms.movie("Ȩ");
	}
	public void movie(String menu)
	{
		try
		{
			Class clsName=Class.forName("com.sist.anno.MovieManager");   // Ŭ������ ������ ������ �´�
			// �޸� �Ҵ�
			Object obj=clsName.getConstructor().newInstance();
			// MovieManager m=new MovieManager()
			// clsName�� ������ �ִ� ��� �޼ҵ带 ������ �´�
			Method[] methods=clsName.getDeclaredMethods();
			for(Method m:methods)
			{
				//System.out.println(m.getName());
				RequestMapping rm=m.getAnnotation(RequestMapping.class);
				if(rm.value().equals(menu))
				{
					m.invoke(obj, null);
					break;
				}
			}
		}catch(Exception ex) {}
	}
}
