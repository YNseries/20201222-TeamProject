package com.sist.lib;
// StringBuffer: ���� �����͸� �ӽ� �޸� �����ϴ� Ŭ����
import java.io.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ��ȭ ���� ���� ������ �����
		//StringBuffer sb=new StringBuffer();  // StringBuilder ���� �뵵 �ܿ�(����� �����ϱ�)
		StringBuilder sb=new StringBuilder();  // ��Ʈ��ũ, ������ �̿��ؼ� ����� ��
		// ���� �б�
		FileReader fr=null;
		// ��� Ŭ������ default(�ʱⰪ)�� ��� => null(�ּҸ� �������� ���� ��)
		/*
		 *    �������, ��������(static): Ŭ���� ������ ���� => �ڵ� �ʱⰪ�� ������ �ִ�
		 *    ���������� �ʱⰪ�� ������ ���� �ʴ�(�ݵ�� �ʱ�ȭ�� �Ѵ�)
		 */
		try
		{
			fr=new FileReader("c:\\javaDev\\movie.txt");
			int i=0;
			while((i=fr.read())!=-1)
			{
				sb.append(String.valueOf((char)i));  // ���ڿ� ����
			}
			
		}catch(Exception ex) {}
		finally
		{
			try
			{
				fr.close();  // finally���� �ڵ�
			}catch(Exception ex) {}
		}
		
		// ���
		System.out.println("=============== ��ȭ ������ ��� ===============");
		String data=sb.toString(); // ������ �� .toString �� ��� ��
		// ��½ÿ��� toString �ڵ� ȣ��
		System.out.println(data);  // sb.toString() => toString�� �ڵ����� ȣ��
	}

}
