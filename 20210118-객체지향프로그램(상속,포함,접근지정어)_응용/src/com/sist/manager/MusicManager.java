package com.sist.manager;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/*
 *  { Object   [ array
 *   {"genie":[
 *        {"singer":"iKON",
 *         "movie":"vecSVX1QYbQ",
 *         "rank":"1",
 *         "title":"����� �ߴ� (LOVE SCENARIO)",
 *         "poster":"\/\/image.genie.co.kr\/Y\/IMAGE\/IMG_ALBUM\/081\/019\/709\/81019709_1516862241098_1_140x140.JPG"},
 */
class Human /* extends Object */
{
	public void display()
	{
		System.out.println("Human:display() Call...");
	}
	public void print()
	{
		System.out.println("Human:print() Call...");
	}
}
class Student extends Human
{
	/*
	 * public void display()
	   {
			System.out.println("Human:display() Call...");
	   }
			public void print()
	   {
		 	System.out.println("Human:print() Call...");
	   }
	 */
	// ������� ���� �޼ҵ带 ������(�������̵�)�� �� �ִ� : �ʿ��� �κ�(�޼ҵ�)�� ����
	public void display()
	{
		System.out.println("Student:display() Call...");
	}
	// Ȯ�� => ��� �߰�
	public void studentAllData()
	{
		System.out.println("Student:studentAllData() Call...");
	}
}
/*
 *     Object  = Object(�ֻ�!)
 *       |   Object o=new Object() �� ����
 *     Human   = Human, Object(�� �� ���� ����)
 *       |   Human h=new Human()
 *           Object o=new Object()
 *    Studnet  = Huma, Object, Student (�޸𸮴� Ŀ���µ� ���� �ö� ���� ���������� Ŀ��)
 */
/*
 *     class A
 *     {
 *         void aaa(){} 
 *         void bbb(){}
 *         void ccc(){}
 *         --
 *         --
 *         --
 *         void zzz(){}
 *     }
 *     
 *     class B
 *     {
 *         void aaa(){} 
 *         void bbb(){}
 *         void ccc(){}
 *         --
 *         --
 *         --
 *         void zzz(){}
 *     }
 *     
 *     class C extends A
 *     {
 *         void bbb(){}
 *         void ccc(){}
 *     }
 */
public class MusicManager {
	public MusicVO[] musicAllData()
	{
		MusicVO[] music=new MusicVO[50];  // {null....���� 50��} music[0]=new MusicVO()
		try
		{
			FileReader fr=new FileReader("c:\\javaDev\\genie.json");
			String data="";
			int i=0;
			while((i=fr.read())!=-1)  // -1 ���� ��  read() => �� ���ھ� �о�´�
			{
				data+=String.valueOf((char)i);
			}
			fr.close();
			// System.out.println(data);
			
			// �Ľ�(���Ͽ� ���õ� ������ �б�)
			JSONParser jp=new JSONParser();
			JSONObject root=(JSONObject)jp.parse(data);  // Object�� ���� ũ�� ������ ����ȯ �� ��� ��
			System.out.println(root.toJSONString());  // ���ڿ� ��ȯ
			
			JSONArray arr=(JSONArray)root.get("genie");
			System.out.println(arr.toJSONString());
			
			// System.out.println(arr.size());
			for(i=0;i<50;i++)
			{
				music[i]=new MusicVO();  // ��ü �迭
				System.out.println("music["+i+"]:"+music[i]);
				JSONObject obj=(JSONObject)arr.get(i);
				System.out.println(obj.toJSONString());
				music[i].setRank(Integer.parseInt((String)obj.get("rank")));
				// ingeger.parseInt => String�� int�� ��ȯ
				music[i].setTitle((String)obj.get("title"));
				music[i].setSinger((String)obj.get("singer"));
				music[i].setPoster((String)obj.get("poster"));
				music[i].setMovie((String)obj.get("movie"));
			}
		}catch(Exception ex) {}   // ����ó��
		/*
		 *    try
		 *    {
		 *       ��������� �ϴ� �ҽ��ڵ�
		 *       =
		 *       =
		 *       =
		 *       = �����߻�
		 *    }catch(Exception ex)
		 *    {
		 *       ����ó��
		 *    }  
		 *    ==
		 *    ==
		 *    ==
		 */
		return music;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MusicManager m=new MusicManager();
        MusicVO[] data=m.musicAllData();
        System.out.println("================= ���� ��� =================");
        for(MusicVO vo:data)
        {
        	
        	System.out.println("����:"+vo.getRank());
        	System.out.println("�뷡��:"+vo.getTitle());
        	System.out.println("������:"+vo.getSinger());
        	System.out.println("�̹���:"+vo.getPoster());
        	System.out.println("������:"+vo.getMovie());
        	System.out.println("===========================================");
        }
		/* Human h=new Human();
		h.display();
		h.print();  //
		Student s=new Student();
		s.display();
		s.print();  // h.print()�� ����� ����
		s.studentAllData();
		
		Human h2=new Student();
		h2.display();
		h2.print();
		
		Student s2=(Student)h2;
		s2.studentAllData(); */
		// Ŭ�������� ����ȯ => ���, ����
		
		// instanceof
		/* String str=new String("Hello");
		StringBuffer sb=new StringBuffer();
		Object obj=new Object();
		
		if(str instanceof Object)
		{
			System.out.println("�������");
		}
		if(sb instanceof Object)
		{
			System.out.println("�������");
		}
		if(obj instanceof String)
		{
			System.out.println("�������");
		} */

	}

}
