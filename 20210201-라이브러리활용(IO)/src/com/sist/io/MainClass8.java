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
			// ���� ��Ʈ�� => �ӽ� �������(�޸�)�� ������ �� ��� / ��Ʈ��� �־��� ���� �ϸ� �ӵ��� ������ ����
			FileOutputStream fos=new FileOutputStream("c:\\download\\eclipse.zip");
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			
			byte[] buffer=new byte[1024];
			int i=0;  // ���� ����Ʈ ����
			
			while((i=bis.read(buffer,0,1024))!=-1)
			{
				bos.write(buffer, 0, i);
			}
			bis.close();
			bos.close();
			// ���� ������ �ٿ�ε��� ��쿡 ó�� ����� ����
			System.out.println("���� �ٿ�ε� �Ϸ�!!");
			
		}catch(Exception ex) {}

	}

}
