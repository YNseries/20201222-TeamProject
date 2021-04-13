package com.sist.io;
// 파일 입출력
import java.io.*;
// FileInputStream, FileOutputStream

public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			// 1. 파일 만들기
			File file=new File("c:\\javaDev\\student.txt");
			if(!file.exists())
			{
				file.createNewFile();
			}
			FileOutputStream fos=new FileOutputStream(file);
			// 파일에 쓰기
			// new File("c:\\javaDev\\student.txt",true);
			// new File("c:\\javaDev\\student.txt"); => w
			// new File("c:\\javaDev\\student.txt",true); => w,a(추가)
			/*
			 *     홍길동 | 90|80|70
			 *     심청이 | 90|80|70
			 */
			//fos.write("홍길동".getBytes());  // write(byte[] buffer) => 문자열을 바이트 배열로 변경 => getBytes()
			//fos.write("심청이".getBytes());
			fos.write('A');
			fos.write('B');
			fos.write('C');  // 덮어씌워졌기 때문에 결과적으로 한 글자만 나옴. 한글을 입력하면, 1byte라 깨진 상태로 저장되어있음
			fos.close();
			// https://www.google.com/search?q=%EC%9E%90%EB%B0%94&rlz=1C1CHBD_koKR933KR933&oq=%EC%9E%90%EB%B0%94&aqs=chrome..69i57j35i39l2j0i395i433j0i131i395i433j0i395l2j0i395i433.3267j1j15&sourceid=chrome&ie=UTF-8
		}catch(Exception ex) {}
		
	}

}
