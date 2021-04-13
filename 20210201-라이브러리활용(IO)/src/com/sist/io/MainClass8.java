package com.sist.io;
/*
 *   BufferedInputStream, BufferedOutputStream
 *   ObjectInputStream, ObjectOutputStream
 *   ==========================================
 *   BufferedReader, BufferedWriter
 */
import java.io.*;
public class MainClass8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			File file=new File("c:\\javaDev\\eclipse.zip");
			
			FileInputStream fis=new FileInputStream(file);
			BufferedInputStream bis=new BufferedInputStream(fis);
			// 보조 스트림 => 임시 저장공간(메모리)에 저장한 후 사용 / 하트웨어에 넣었다 뺐다 하면 속도가 느리기 때문
			FileOutputStream fos=new FileOutputStream("c:\\download\\eclipse.zip");
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			
			byte[] buffer=new byte[1024];
			int i=0;  // 읽은 바이트 갯수
			
			while((i=bis.read(buffer,0,1024))!=-1)
			{
				bos.write(buffer, 0, i);
			}
			bis.close();
			bos.close();
			// 실제 웹에서 다운로드할 경우에 처리 내용과 동일
			System.out.println("파일 다운로드 완료!!");
			
		}catch(Exception ex) {}

	}

}
