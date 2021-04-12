package com.sist.string;

import java.io.UnsupportedEncodingException;

/*
 *    Object
 *      = toString()
 *      = clone()
 *      = equals()
 *    String
 *      = length()
 *      = equals(), equalsIgnoreCase()
 *      = startsWith(), endsWith(), contains()
 *      = substring(), indexOf(), lastIndexOf()
 *      = trim(), valueOf()
 *      = split()
 *      ========================================
 *      replace, replaceAll, charAt()
 *      
 *      https://www.google.com/search?q=%EC%9E%90%EB%B0%94&oq=wkqk&aqs=chrome.1.69i57j0j0i433j0i395i433j0i395j0i131i395i433j0i395i433j0i395.2216j1j7&sourceid=chrome&ie=UTF-8
		%EC%9E%90%EB%B0%94 = �ڹ�
 */
public class MainClass10 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//byte[] s="�ȳ��ϼ���".getBytes();
		//String str=new String(s,"UTF-8");
		//System.out.println(str);
		// String.format()
		// StringJoiner
		String color="red,blue,green";
		String[] colors=color.split(",");
		String str=String.join("-", colors);  // ��ȭ��ȣ �Է��� �� 
		System.out.println(str);
		
		//String s=String.format("%d * %d = %d", 10,20,10+20);
		//System.out.println(s);
		int year=2021;
		int month=1;
		int day=22;
		String s=year+"�⵵ "+month+"�� "+day+"��";
		System.out.println(s);
		String s2= String.format("%d�⵵ %d�� %d��", year,month,day);
		System.out.println(s2);
		
		
	}

}
