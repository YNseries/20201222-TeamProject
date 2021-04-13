package com.sist.lib;
// StringBuffer: 읽은 데이터를 임시 메모리 저장하는 클래스
import java.io.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 영화 정보 저장 공간을 만든다
		//StringBuffer sb=new StringBuffer();  // StringBuilder 쓰는 용도 외에(기능은 같으니까)
		StringBuilder sb=new StringBuilder();  // 네트워크, 쓰레드 이용해서 갖고올 때
		// 파일 읽기
		FileReader fr=null;
		// 모든 클래스는 default(초기값)를 사용 => null(주소를 갖고있지 않을 때)
		/*
		 *    멤버변수, 정적변수(static): 클래스 영역에 선언 => 자동 초기값을 가지고 있다
		 *    지역변수는 초기값을 가지고 있지 않다(반드시 초기화를 한다)
		 */
		try
		{
			fr=new FileReader("c:\\javaDev\\movie.txt");
			int i=0;
			while((i=fr.read())!=-1)
			{
				sb.append(String.valueOf((char)i));  // 문자열 결합
			}
			
		}catch(Exception ex) {}
		finally
		{
			try
			{
				fr.close();  // finally에서 코딩
			}catch(Exception ex) {}
		}
		
		// 출력
		System.out.println("=============== 영화 데이터 출력 ===============");
		String data=sb.toString(); // 대입할 땐 .toString 써 줘야 함
		// 출력시에만 toString 자동 호출
		System.out.println(data);  // sb.toString() => toString은 자동으로 호출
	}

}
