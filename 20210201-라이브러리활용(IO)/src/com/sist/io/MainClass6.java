package com.sist.io;
// �ѱ۷� �� ���� �б�
import java.io.*;
public class MainClass6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			File file=new File("c:\\javaDev\\daum_news.txt");
			// �б�
			//FileInputStream fis=new FileInputStream(file);
			FileReader fis=new FileReader(file);  // �ѱ� ���� �б�, ����(2byte)
			/*
			 *    ����
			 *      = �Ϲ� ���� ==> FileInputStream: zip, ppt, doc...(1byte)
			 *      = �ѱ��� ���Ե� ���� ==> FileReader(2byte)
			 */
			int i=0; // ASC(A=65 a=97...)
			char[] buffer=new char[1024];   
			// buffer => �޸� �ּ�
			while((i=fis.read(buffer,0,1024))!=-1)  // -1(EOF)
			{
				System.out.print(buffer);
			}
			fis.close();
			//char[] buffer={'A','B','C'};  // new char[1024];
			//System.out.println(buffer);
			/*
			 *    1. �� ���� �б� ==> read()
			 *    2. ���� ���� �д� ��� ==> read(byte[] buffer, int off, int len)
			 */
		}catch(Exception ex) {}
	}

}
