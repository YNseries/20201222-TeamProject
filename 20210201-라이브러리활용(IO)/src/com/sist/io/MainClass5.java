package com.sist.io;
// ���� ����(���ε�) => FileInputStream, FileOutputStream
// ���� �б� / ���� ���� => FileReader, FileWriter (2byte => �ѱ�)
/*
 *     1. ����: ������ȭ(������ ����) => ������ȭ ������ �б� => ����ȭ(AI)
 *               ���� : ���� ����
 *             ������ȭ(���и� �ִ�) => XML, JSON
 *     2. ����Ŭ: ����ȭ
 */
import java.io.*;
public class MainClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			// 1. ������ ������ ���� ����
			File dir=new File("c:\\download");
			if(!dir.exists())   // ������ ���� ��쿡�� ������ �����
			{
				dir.mkdir();
			}
			// 2. ���� �б� => ����
			File file=new File("c:\\javaDev\\back.jpg");
			FileInputStream fis=new FileInputStream(file);
			FileOutputStream fos=new FileOutputStream(dir+"\\"+file.getName());
			
			int i=0;
			byte[] buffer=new byte[1024];   // 1024, 512, 2048, 4096...
			// 29,773
			// 850
			while((i=fis.read(buffer, i, 1024))!=-1)  // 1024�� ���� ���� ä���� �ؼ� ���� ��. ������ length
			{
				fos.write(buffer, 0, i);  // send()
			}
			/*
			 *     int read() => ���� ��ȣ(A=>65)
			 *     int read(byte[],int,int) => ���� ����Ʈ ��
			 */
			fis.close();
			fos.close();
			System.out.println("���� �Ϸ�");
			
			//Class clsName=Class.forName("");
        	//Object obj=clsName.newInstance();
        	//clsName.getConstructor().newInstance();
        	
		}catch(Exception ex) {}
	}

}
