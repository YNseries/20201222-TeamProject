package com.sist.io;
// BufferedReader: ��Ʈ��ũ => ���� ��Ʈ��
/*
 *    FileInputStream/FileOutputStream
 *    BufferedInputStream / BufferedOutputStream
 *    
 *    FileReader / FileWriter
 *    BufferedReader
 *    
 *    ===========================================
 *    
 */
import java.io.*;
public class MainClass9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2753 => 33
		try
		{
			/*// ���� �б� => daum_movie.txt
			File file=new File("c:\\javaDev\\daum_movie.txt");
			FileReader fr=new FileReader(file);  // �� ���ھ� ����
			int i=0;
			StringBuffer sb=new StringBuffer();  // ���� ������ ���� ����
			long start=System.currentTimeMillis();
			//String data="";
			while((i=fr.read())!=-1)
			{
				//data+=String.valueOf((char)i);
				sb.append(String.valueOf((char)i));  // append ���ڿ� ����  => \n
			}
			System.out.println(sb.toString());
			long end=System.currentTimeMillis();
			System.out.println("�ɸ� �ð�:"+(end-start));*/
			File file=new File("c:\\javaDev\\daum_movie.txt");
			FileInputStream fis=new FileInputStream(file);  // �̰Ÿ� ���� �ѱ� �� ����. Reader �����
			BufferedReader br=new BufferedReader(new InputStreamReader(fis));
			//                    InputStream => Reader(1byte => 2byte)
			long start=System.currentTimeMillis();
			// �����ʹ� ���ڵ����� / ������ ���ڵ�����
			while(true)
			{
				String str=br.readLine();   // �� �پ� �о���� ������ ���� StringBuffer���� �� ����
				if(str==null) break;   // ���� => �����͸� �� ���� ���
				System.out.println(str);
			}
			br.close();
			long end=System.currentTimeMillis();
			System.out.println("�ɸ� �ð�:"+(end-start));
		}catch(Exception ex) {}
	}

}
