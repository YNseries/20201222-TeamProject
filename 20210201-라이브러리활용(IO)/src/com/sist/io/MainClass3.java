package com.sist.io;
// ���� �����
import java.io.*;
// FileInputStream, FileOutputStream

public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			// 1. ���� �����
			File file=new File("c:\\javaDev\\student.txt");
			if(!file.exists())
			{
				file.createNewFile();
			}
			FileOutputStream fos=new FileOutputStream(file);
			// ���Ͽ� ����
			// new File("c:\\javaDev\\student.txt",true);
			// new File("c:\\javaDev\\student.txt"); => w
			// new File("c:\\javaDev\\student.txt",true); => w,a(�߰�)
			/*
			 *     ȫ�浿 | 90|80|70
			 *     ��û�� | 90|80|70
			 */
			//fos.write("ȫ�浿".getBytes());  // write(byte[] buffer) => ���ڿ��� ����Ʈ �迭�� ���� => getBytes()
			//fos.write("��û��".getBytes());
			fos.write('A');
			fos.write('B');
			fos.write('C');  // ��������� ������ ��������� �� ���ڸ� ����. �ѱ��� �Է��ϸ�, 1byte�� ���� ���·� ����Ǿ�����
			fos.close();
			// https://www.google.com/search?q=%EC%9E%90%EB%B0%94&rlz=1C1CHBD_koKR933KR933&oq=%EC%9E%90%EB%B0%94&aqs=chrome..69i57j35i39l2j0i395i433j0i131i395i433j0i395l2j0i395i433.3267j1j15&sourceid=chrome&ie=UTF-8
		}catch(Exception ex) {}
		
	}

}
