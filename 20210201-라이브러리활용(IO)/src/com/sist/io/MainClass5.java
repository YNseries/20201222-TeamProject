package com.sist.io;
// 파일 복사(업로드) => FileInputStream, FileOutputStream
// 파일 읽기 / 파일 쓰기 => FileReader, FileWriter (2byte => 한글)
/*
 *     1. 파일: 비정형화(구분이 없다) => 비정형화 데이터 읽기 => 정형화(AI)
 *               질문 : ㅋㅋ ㅇㅇ
 *             반정형화(구분만 있다) => XML, JSON
 *     2. 오라클: 정형화
 */
import java.io.*;
public class MainClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			// 1. 파일을 복사할 폴더 생성
			File dir=new File("c:\\download");
			if(!dir.exists())   // 폴더가 없는 경우에만 폴더를 만든다
			{
				dir.mkdir();
			}
			// 2. 파일 읽기 => 복사
			File file=new File("c:\\javaDev\\back.jpg");
			FileInputStream fis=new FileInputStream(file);
			FileOutputStream fos=new FileOutputStream(dir+"\\"+file.getName());
			
			int i=0;
			byte[] buffer=new byte[1024];   // 1024, 512, 2048, 4096...
			// 29,773
			// 850
			while((i=fis.read(buffer, i, 1024))!=-1)  // 1024는 위에 값을 채워야 해서 넣은 것. 원래는 length
			{
				fos.write(buffer, 0, i);  // send()
			}
			/*
			 *     int read() => 글자 번호(A=>65)
			 *     int read(byte[],int,int) => 읽은 바이트 수
			 */
			fis.close();
			fos.close();
			System.out.println("복사 완료");
			
			//Class clsName=Class.forName("");
        	//Object obj=clsName.newInstance();
        	//clsName.getConstructor().newInstance();
        	
		}catch(Exception ex) {}
	}

}
