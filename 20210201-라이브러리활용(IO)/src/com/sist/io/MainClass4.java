package com.sist.io;
import java.util.*;
import java.io.*;
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			/*String msg="���� ������ ������ ���� ���������� ���⿡�� �����ϱ�� �� ������(33)�� ��KIA Ÿ�̰���� ����ߴ�. ���ݵ�� �򸮱׿� ������ ���� KIA Ÿ�̰��� ����̶�� �̸��� ���� ���� �ʰ� �ϰڴ١��� �����ߴ�. ���� �̷�� ���� KIA�� �������� �̱��� ���� ��ǥ�� �̷� �򸮱׿� �� ������ �ڽ��� ���̽��� Ű���� Ÿ�̰����� �̸��� �Ȱ� �����ϰڴٴ� �����̴�.";
			FileOutputStream fos=new FileOutputStream("c:\\javaDev\\student.txt");  // �ڿ� true �Ⱦ��� ���
			fos.write(msg.getBytes());
			fos.close();
			System.out.println("ù��° ���� ���� �Ϸ�!!");*/
			/*fos=new FileOutputStream("c:\\javaDev\\student.txt");
			fos.write("�ȳ��ϼ���".getBytes());
			fos.close();
			System.out.println("�ι�° ���� ���� �Ϸ�!!");*/
			// ���� �б�
			FileInputStream fis=new FileInputStream("c:\\javaDev\\student.txt");
			int i=0;
			while((i=fis.read())!=-1)
			{
				System.out.print((char)i);
			}
			fis.close();
		}catch(Exception ex) {}

	}

}
