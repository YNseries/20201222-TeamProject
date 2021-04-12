package com.sist.manager;
import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/*
 *    1. 클래스: public
 *    2. 생성자: public
 *    3. 메소드: public, protected
 *    4. 변수: private
 *       = 지역변수: final
 *    ==========================
 *    static, abstract, final
 *    
 *    클래스: public, (default), final, abstract
 *          = public class
 *          = class
 *          
 *          예)
 *             public class className{
 *             }
 *             
 *             => 종단 클래스(상속하지 않는다_ => 품절(거의 사용빈도 없음)
 *             public final class className{
 *             }
 *             
 *             => 추상 클래스(자신이 메모리 할당을 할 수 없다) => new를 사용하지 않는다
 *             public abstract classMate{
 *             } 
 *             
 *             => public static class className(사용할 수 없다)
 *                only public, abstract & final
 *     메소드: public, protected, abstract, static, final
 *     변수: private, static, final
 */
public class MovieManager {
	// public MovieManager(){}
	public MovieVO[] movieAllData()
	{
		MovieVO[] movie=new MovieVO[7];  // 데이터를 7개 모아서 main으로 전송
		try
		{
			FileReader fr=new FileReader("c:\\javaDev\\movie.json");
			String data="";
			int i=0;
			while((i=fr.read())!=-1)  // -1 파일 끝  read() => 한 글자씩 읽어온다
			{
				data+=String.valueOf((char)i);
				//                문자 번호를 문자로 변환 => String에 저장하게 함
				// 데이터가 많은 경우에는 String보다는 StringBuffer가 속도가 더 빠름
				/* 
				 *   +  => 산술연산자, 문자열 결합
				 */
			}
			fr.close();  // 파일을 읽고나선 꼭 닫아줘야 함
			System.out.println(data);   // 전체가 파일에 묶였는지 확인
			
			// 파싱(파일에 관련된 데이터 읽기)
			/*
			 * 	 시작할 때
			 *    {} => JSONObject로 받아야 함
			 *    [] => JSONArray로 받아야 함
			 *    
			 *    {"datas":[{"actor":"가엘 가르시아 베르날 , 앤서니 곤잘레스 , 벤자민 브랫",
			 *    "director":"리 언크리치",
			 *    "grade":"전체",
			 *    "title":"코코",
			 *    "poster":"http:\/\/img.cgv.co.kr\/Movie\/Thumbnail\/Poster\/000080\/80397\/80397_185.jpg",
			 *    "mno":1,
			 *    "story":
			 */
			JSONParser jp=new JSONParser();
			JSONObject root=(JSONObject)jp.parse(data);  // Object가 제일 크기 때문에 형변환 해 줘야 함
			System.out.println(root.toJSONString());  // 문자열 변환
			
			JSONArray arr=(JSONArray)root.get("datas");
			System.out.println(arr.toJSONString());
			
			// System.out.println(arr.size());
			for(i=0;i<7;i++)
			{
				movie[i]=new MovieVO();  // 객체 배열
				/*
				 *    ===========  ==> 7개를 만들어서 처리
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
				// JSON => 데이터(int=>long)
				//int mno=(int)obj.get("mno");
				//movie[i].setMno(mno);
				movie[i].setTitle((String)obj.get("title"));  // 데이터를 한개씩 읽어온다
				movie[i].setActor((String)obj.get("actor"));
				movie[i].setPoster((String)obj.get("poster"));
				movie[i].setDirector((String)obj.get("director"));
				movie[i].setGrade((String)obj.get("grade"));
				movie[i].setStory((String)obj.get("story"));
				// 변수의 초기값을 설정=> main class에서 출력
			}
		}catch(Exception ex) {}   
		return movie;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MovieManager m=new MovieManager();
        MovieVO[] data=m.movieAllData();
        System.out.println("================= 영화 목록 =================");
        for(MovieVO vo:data)   // For~Each
        {
        	//System.out.println("순위:"+vo.getMno());
        	System.out.println("영화명:"+vo.getTitle());
        	System.out.println("출연:"+vo.getActor());
        	System.out.println("이미지:"+vo.getPoster());
        	System.out.println("감독명:"+vo.getDirector());
        	System.out.println("등급:"+vo.getGrade());
        	System.out.println("줄거리:"+vo.getStory());
        	System.out.println("===========================================");
        }
		
	}

}
