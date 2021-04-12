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
 *         "title":"사랑을 했다 (LOVE SCENARIO)",
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
	// 상속으로 받은 메소드를 재정의(오버라이딩)할 수 있다 : 필요한 부분(메소드)만 변경
	public void display()
	{
		System.out.println("Student:display() Call...");
	}
	// 확장 => 기능 추가
	public void studentAllData()
	{
		System.out.println("Student:studentAllData() Call...");
	}
}
/*
 *     Object  = Object(최상!)
 *       |   Object o=new Object() 만 가능
 *     Human   = Human, Object(둘 다 생성 가능)
 *       |   Human h=new Human()
 *           Object o=new Object()
 *    Studnet  = Huma, Object, Student (메모리는 커지는데 위로 올라갈 수로 데이터형이 커짐)
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
		MusicVO[] music=new MusicVO[50];  // {null....값이 50개} music[0]=new MusicVO()
		try
		{
			FileReader fr=new FileReader("c:\\javaDev\\genie.json");
			String data="";
			int i=0;
			while((i=fr.read())!=-1)  // -1 파일 끝  read() => 한 글자씩 읽어온다
			{
				data+=String.valueOf((char)i);
			}
			fr.close();
			// System.out.println(data);
			
			// 파싱(파일에 관련된 데이터 읽기)
			JSONParser jp=new JSONParser();
			JSONObject root=(JSONObject)jp.parse(data);  // Object가 제일 크기 때문에 형변환 해 줘야 함
			System.out.println(root.toJSONString());  // 문자열 변환
			
			JSONArray arr=(JSONArray)root.get("genie");
			System.out.println(arr.toJSONString());
			
			// System.out.println(arr.size());
			for(i=0;i<50;i++)
			{
				music[i]=new MusicVO();  // 객체 배열
				System.out.println("music["+i+"]:"+music[i]);
				JSONObject obj=(JSONObject)arr.get(i);
				System.out.println(obj.toJSONString());
				music[i].setRank(Integer.parseInt((String)obj.get("rank")));
				// ingeger.parseInt => String을 int로 변환
				music[i].setTitle((String)obj.get("title"));
				music[i].setSinger((String)obj.get("singer"));
				music[i].setPoster((String)obj.get("poster"));
				music[i].setMovie((String)obj.get("movie"));
			}
		}catch(Exception ex) {}   // 예외처리
		/*
		 *    try
		 *    {
		 *       정상수행을 하는 소스코딩
		 *       =
		 *       =
		 *       =
		 *       = 에러발생
		 *    }catch(Exception ex)
		 *    {
		 *       에러처리
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
        System.out.println("================= 뮤직 목록 =================");
        for(MusicVO vo:data)
        {
        	
        	System.out.println("순위:"+vo.getRank());
        	System.out.println("노래명:"+vo.getTitle());
        	System.out.println("가수명:"+vo.getSinger());
        	System.out.println("이미지:"+vo.getPoster());
        	System.out.println("동영상:"+vo.getMovie());
        	System.out.println("===========================================");
        }
		/* Human h=new Human();
		h.display();
		h.print();  //
		Student s=new Student();
		s.display();
		s.print();  // h.print()와 기능이 같음
		s.studentAllData();
		
		Human h2=new Student();
		h2.display();
		h2.print();
		
		Student s2=(Student)h2;
		s2.studentAllData(); */
		// 클래스에서 형변환 => 상속, 포함
		
		// instanceof
		/* String str=new String("Hello");
		StringBuffer sb=new StringBuffer();
		Object obj=new Object();
		
		if(str instanceof Object)
		{
			System.out.println("정상수행");
		}
		if(sb instanceof Object)
		{
			System.out.println("정상수행");
		}
		if(obj instanceof String)
		{
			System.out.println("정상수행");
		} */

	}

}
