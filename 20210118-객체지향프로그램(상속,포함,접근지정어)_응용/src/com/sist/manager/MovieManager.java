package com.sist.manager;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/*
 *    1. Ŭ����: public
 *    2. ������: public
 *    3. �޼ҵ�: public, protected
 *    4. ����: private
 *       = ��������: final
 *    ==========================
 *    static, abstract, final
 *    
 *    Ŭ����: public, (default), final, abstract
 *          = public class
 *          = class
 *          
 *          ��)
 *             public class className{
 *             }
 *             
 *             => ���� Ŭ����(������� �ʴ´�_ => ǰ��(���� ���� ����)
 *             public final class className{
 *             }
 *             
 *             => �߻� Ŭ����(�ڽ��� �޸� �Ҵ��� �� �� ����) => new�� ������� �ʴ´�
 *             public abstract classMate{
 *             } 
 *             
 *             => public static class className(����� �� ����)
 *                only public, abstract & final
 *     �޼ҵ�: public, protected, abstract, static, final
 *     ����: private, static, final
 */
public class MovieManager {
	// public MovieManager(){}
	public MovieVO[] movieAllData()
	{
		MovieVO[] movie=new MovieVO[7];  // �����͸� 7�� ��Ƽ� main���� ����
		try
		{
			FileReader fr=new FileReader("c:\\javaDev\\movie.json");
			String data="";
			int i=0;
			while((i=fr.read())!=-1)  // -1 ���� ��  read() => �� ���ھ� �о�´�
			{
				data+=String.valueOf((char)i);
				//                ���� ��ȣ�� ���ڷ� ��ȯ => String�� �����ϰ� ��
				// �����Ͱ� ���� ��쿡�� String���ٴ� StringBuffer�� �ӵ��� �� ����
				/* 
				 *   +  => ���������, ���ڿ� ����
				 */
			}
			fr.close();  // ������ �а��� �� �ݾ���� ��
			System.out.println(data);   // ��ü�� ���Ͽ� �������� Ȯ��
			
			// �Ľ�(���Ͽ� ���õ� ������ �б�)
			/*
			 * 	 ������ ��
			 *    {} => JSONObject�� �޾ƾ� ��
			 *    [] => JSONArray�� �޾ƾ� ��
			 *    
			 *    {"datas":[{"actor":"���� �����þ� ������ , �ؼ��� ���߷��� , ���ڹ� �귧",
			 *    "director":"�� ��ũ��ġ",
			 *    "grade":"��ü",
			 *    "title":"����",
			 *    "poster":"http:\/\/img.cgv.co.kr\/Movie\/Thumbnail\/Poster\/000080\/80397\/80397_185.jpg",
			 *    "mno":1,
			 *    "story":
			 */
			JSONParser jp=new JSONParser();
			JSONObject root=(JSONObject)jp.parse(data);  // Object�� ���� ũ�� ������ ����ȯ �� ��� ��
			System.out.println(root.toJSONString());  // ���ڿ� ��ȯ
			
			JSONArray arr=(JSONArray)root.get("datas");
			System.out.println(arr.toJSONString());
			
			// System.out.println(arr.size());
			for(i=0;i<7;i++)
			{
				movie[i]=new MovieVO();  // ��ü �迭
				/*
				 *    ===========  ==> 7���� ���� ó��
				 *        mno
				 *    =========== 
				 *       title
				 *    =========== 
				 *     director
				 *    =========== 
				 *       actor
				 *    =========== 
				 *      poster
				 *    =========== 
				 *       grade
				 *    =========== 
				 *       story
				 *    =========== 
				 */
				System.out.println("movie["+i+"]:"+movie[i]);
				JSONObject obj=(JSONObject)arr.get(i);
				System.out.println(obj.toJSONString());
				// JSON => ������(int=>long)
				//int mno=(int)obj.get("mno");
				//movie[i].setMno(mno);
				movie[i].setTitle((String)obj.get("title"));  // �����͸� �Ѱ��� �о�´�
				movie[i].setActor((String)obj.get("actor"));
				movie[i].setPoster((String)obj.get("poster"));
				movie[i].setDirector((String)obj.get("director"));
				movie[i].setGrade((String)obj.get("grade"));
				movie[i].setStory((String)obj.get("story"));
				// ������ �ʱⰪ�� ����=> main class���� ���
			}
		}catch(Exception ex) {}   
		return movie;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MovieManager m=new MovieManager();
        MovieVO[] data=m.movieAllData();
        System.out.println("================= ��ȭ ��� =================");
        for(MovieVO vo:data)   // For~Each
        {
        	//System.out.println("����:"+vo.getMno());
        	System.out.println("��ȭ��:"+vo.getTitle());
        	System.out.println("�⿬:"+vo.getActor());
        	System.out.println("�̹���:"+vo.getPoster());
        	System.out.println("������:"+vo.getDirector());
        	System.out.println("���:"+vo.getGrade());
        	System.out.println("�ٰŸ�:"+vo.getStory());
        	System.out.println("===========================================");
        }
		
	}

}
