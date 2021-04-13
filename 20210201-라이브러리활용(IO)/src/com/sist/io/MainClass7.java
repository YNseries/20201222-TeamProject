package com.sist.io;
// 파일 쓰기
// byte[]
// String
import java.io.*;
public class MainClass7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			// 1. 파일 만들기
			File file=new File("c:\\download\\sawon.txt");
			// 2. 파일 확인
			if(!file.exists())
			{
				file.createNewFile();
			}
			// 3. 파일 쓰기
			FileWriter fw=new FileWriter(file,true);  // true가 있어야 덮어쓰지 않음
			fw.write("박문수|총무부|대리|서울\n");
			// 4. 닫기
			fw.close();
			
		}catch(Exception ex) {}
	}

}
