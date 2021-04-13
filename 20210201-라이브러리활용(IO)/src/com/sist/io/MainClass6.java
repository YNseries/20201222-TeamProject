package com.sist.io;
// 한글로 된 파일 읽기
import java.io.*;
public class MainClass6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			File file=new File("c:\\javaDev\\daum_news.txt");
			// 읽기
			//FileInputStream fis=new FileInputStream(file);
			FileReader fis=new FileReader(file);  // 한글 파일 읽기, 쓰기(2byte)
			/*
			 *    파일
			 *      = 일반 파일 ==> FileInputStream: zip, ppt, doc...(1byte)
			 *      = 한글이 포함된 파일 ==> FileReader(2byte)
			 */
			int i=0; // ASC(A=65 a=97...)
			char[] buffer=new char[1024];   
			// buffer => 메모리 주소
			while((i=fis.read(buffer,0,1024))!=-1)  // -1(EOF)
			{
				System.out.print(buffer);
			}
			fis.close();
			//char[] buffer={'A','B','C'};  // new char[1024];
			//System.out.println(buffer);
			/*
			 *    1. 한 글자 읽기 ==> read()
			 *    2. 여러 글자 읽는 경우 ==> read(byte[] buffer, int off, int len)
			 */
		}catch(Exception ex) {}
	}

}
