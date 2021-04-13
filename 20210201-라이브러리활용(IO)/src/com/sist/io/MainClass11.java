package com.sist.io;
import java.io.*;
import java.util.*;
/*
 *    ����, �迭(1����), Ŭ����(VO)
 *    �޼ҵ� => ������, ������ ȣ��(JSP) => Java+HTML
 *    ==== ������, ���
 *    Ŭ���� => 1) ĸ��ȭ 2) ���, ���� 3) �����ε�, �������̵�
 *    �������̽�
 *    ���̺귯��
 *    =======
 *      Object, String, StringBuffer, Math, Wrapper
 *      StringTokenizer, Date, Calendar, Collection(ArrayList, HashMap, Vector)
 *      IO => File, FileInputStrem(Output), FileReader, FileWriter,
 *            BufferedReader, BufferedInputStream(OutputStream)
 *    ========================================================================== ����ó��
 */
/*
 *    A a=new A()
 *    
 *    ======================
 *    A a=new B()
 *    A a=A.getInstance()
 *        A.newInstance() => �����ڰ� �ٸ���, �޼ҵ带 ���ؼ� ���� => �߻�Ŭ����, �������̽�
 *    ======================
 *    Calendar => month=0~11, week=1~7 =========> �޷�(����, ȣ��, ����ǥ)
 *    => Calendar cal=Calendar.getInstance();
 *       cal.set(Calendar.YEAR,year)
 *       cal.set(Calendar.MONTH,month-1)
 *       cal.set(Calendar.DATE,day)
 *       
 *    SimpleDateFormat => ���� : yyyy, MM, dd, hh, mm, ss => ���(�ð�)
 */
public class MainClass11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			FileInputStream fis=
					new FileInputStream("c:\\download\\sawon.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			ArrayList<Sawon> list=(ArrayList<Sawon>)ois.readObject();  // ������ �о��
			//list.remove(0);
			for(Sawon s:list)
			{
				System.out.println("�̸�:"+s.getName());
				System.out.println("����:"+s.getPay());
				System.out.println("=====================");
			}
		}catch(Exception ex) {}
	}

}
