package com.sist.io;
// ���� ����
// byte[]
// String
import java.io.*;
public class MainClass7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			// 1. ���� �����
			File file=new File("c:\\download\\sawon.txt");
			// 2. ���� Ȯ��
			if(!file.exists())
			{
				file.createNewFile();
			}
			// 3. ���� ����
			FileWriter fw=new FileWriter(file,true);  // true�� �־�� ����� ����
			fw.write("�ڹ���|�ѹ���|�븮|����\n");
			// 4. �ݱ�
			fw.close();
			
		}catch(Exception ex) {}
	}

}
