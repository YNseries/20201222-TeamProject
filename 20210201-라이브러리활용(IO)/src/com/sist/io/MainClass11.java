package com.sist.io;
import java.io.*;
import java.util.*;
/*
 *    변수, 배열(1차원), 클래스(VO)
 *    메소드 => 윈도우, 웹에서 호출(JSP) => Java+HTML
 *    ==== 연산자, 제어문
 *    클래스 => 1) 캡슐화 2) 상속, 포함 3) 오버로딩, 오버라이딩
 *    인터페이스
 *    라이브러리
 *    =======
 *      Object, String, StringBuffer, Math, Wrapper
 *      StringTokenizer, Date, Calendar, Collection(ArrayList, HashMap, Vector)
 *      IO => File, FileInputStrem(Output), FileReader, FileWriter,
 *            BufferedReader, BufferedInputStream(OutputStream)
 *    ========================================================================== 예외처리
 */
/*
 *    A a=new A()
 *    
 *    ======================
 *    A a=new B()
 *    A a=A.getInstance()
 *        A.newInstance() => 생서자가 다르다, 메소드를 통해서 생성 => 추상클래스, 인터페이스
 *    ======================
 *    Calendar => month=0~11, week=1~7 =========> 달력(예매, 호텔, 일정표)
 *    => Calendar cal=Calendar.getInstance();
 *       cal.set(Calendar.YEAR,year)
 *       cal.set(Calendar.MONTH,month-1)
 *       cal.set(Calendar.DATE,day)
 *       
 *    SimpleDateFormat => 패턴 : yyyy, MM, dd, hh, mm, ss => 댓글(시간)
 */
public class MainClass11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			FileInputStream fis=
					new FileInputStream("c:\\download\\sawon.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			ArrayList<Sawon> list=(ArrayList<Sawon>)ois.readObject();  // 데이터 읽어옴
			//list.remove(0);
			for(Sawon s:list)
			{
				System.out.println("이름:"+s.getName());
				System.out.println("연봉:"+s.getPay());
				System.out.println("=====================");
			}
		}catch(Exception ex) {}
	}

}
