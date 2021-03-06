package com.sist.server;
// 임시 파일(데이터를 가져오기 위함)
import java.util.*;  // 데이터 수집 => ArrayList 저장

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;  // 파일에 저장 =>
/*
 *    자바에서 제공하는 IO(Input, Output)
 *    Input : 파일, 메모리, 네트워크에서 데이터 읽기
 *    Output: 파일, 메모리, 네트워크 데이터 전송
 *                 ====
 *                 System.out
 *                 System.in
 *    ====================================
 *    InputStream, OutputStream => 바이트 스트림(1byte씩 읽어온다) => Upload, Download에서 필요
 *    Reader, Writer => 문자 스트림(2byte씩 읽어온다)
 *      *** 한글(한 글자당 => 2byte)
 */
public class MovieHtmlParser {
	// 상영 => 개봉예정 => 주간 => 월간 => 연간 ==> 따로 긁어올 거지만, 저장은 한 개의 파일에 저장
	public void movieAllData()
	{
		/*
		 *    <div class="wrap_desc">
									<a href="/moviedb/main?movieId=135111"
			  
			  String s="Hello Java";
			  String ss=s.substring(0,5); => Hello
			  
			  s="Hello Java";
			  
			  int a=10;
			  int b=0;
			  if(b==0)
			  {
			      System.out.prinln("0으로 나눌 수 없다")
			  }
			  int c=a/b;  => 종료
			  
			  오류 발생 => if 예상 => try
		 */
		StringBuffer sb=new StringBuffer();  // 메소드 전체에서 사용할 수 있게 try 밖에 있어야 함
		// for문 안에 try에서 오류가 발생하면 => 제외하고 다시 for문을 수행
		// web사이트 => 모든 정보를 출력하지 않는다
		try
		{
			int mno=168;   // 영화 고유 번호
			int cno=5;   // 카테고리 번호
			//for(int i=1;i<=7;i++)
			{
				Document doc=Jsoup.connect("https://movie.daum.net/boxoffice/yearly").get();
			//  ======= 문서 저장             맨 뒤에 .get() 잊으면 안됨
				// doc 목록
				Elements link=doc.select("div.wrap_desc a.desc_movie");  
				for(int j=0;j<link.size();j++)
				{
					try
					{
					System.out.println(link.get(j).attr("href"));
					// doc2 상세보기
					Document doc2=Jsoup.connect("https://movie.daum.net"+link.get(j).attr("href")).get();
					// <span class="txt_name">소울(2020)</span>
					Element title=doc2.selectFirst("span.txt_name");  // 하나만 갖고올 때 selectFirst
					System.out.println(title.text());
					Element score=doc2.selectFirst("div.info_origin a");
					String s=score.text();
					// s.indexOf("점") => 1+2
					s=s.substring(s.indexOf("점")+3);  // 평점 07 . 8에서 앞에 3 글자 제외
					System.out.println(s.replace(" ",""));  // replace로 공백문자를 없앰
					String ss=s.replace(" ","");
					// trim()은 좌우 공백만 지울 수 있음 => 중간에 있는 공백은 replace 사용해야 제거 가능
					Element genre=doc2.selectFirst("dd.txt_main");
					System.out.println(genre.text());
					
					Element etc=doc2.select("dl.list_movie").get(1);
					s=etc.text();
					s=s.substring(s.indexOf("라")+2);  // 개봉 | 영화시간/타입/나라 제거
					String regdate=s.substring(0,s.indexOf(",")-5);  // , 앞에서 5개까지 제거
					System.out.println(regdate.replaceAll("[가-힣]", ""). /*한글 전체 제거*/
							replace("(","").replace(")", ""));  /*()괄호 제거*/    // 설정한 내용을 출력만 한 것
					regdate=regdate.replaceAll("[가-힣]", "").
							replace("(","").replace(")", "");   // regdate를 설정해서 데이터에 저장
					String time=s.substring(0,s.indexOf(","));  // ,까지 자름
					time=time.substring(time.lastIndexOf(" ")+1);  // 상영시간 앞 공백부터 자르고 공백 다음부터 출력
					// substring(int begin) => 해당 위치
					// substring(int begin, int end) => end-1
					System.out.println(time);
					String grade=s.substring(s.lastIndexOf(",")+2);  // ,부터 2개 제거
					System.out.println(grade);
					// 개봉 | 영화시간/타입/나라 1999.11.20 개봉 2020.12.23 (재개봉) 116분, 전체관람가
					// 개봉 | 영화시간/타입/나라 2021.01.07 개봉 105분, 15세이상관람가
					Element director=doc2.select("a.link_person").get(0);
					System.out.println(director.text());
					Element actor=doc2.select("a.link_person").get(1);
					System.out.println(actor.text());
					
					Element story=doc2.selectFirst("div.desc_movie p");
					System.out.println(story.text());
					
					Element poster=doc2.selectFirst("span.thumb_img img");
					System.out.println(poster.attr("src"));
					
					Element showUser=doc2.selectFirst("em.emph_g");
					System.out.println(showUser.text());
					
					String msg=mno+"|"+cno+"|"
							+title.text()+"|"
							+ss+"|"
							+genre.text()+"|"
							+regdate+"|"
							+time+"|"
							+grade+"|"
							+director.text()+"|"
							+actor.text()+"|"
							+poster.attr("src")+"|"
							+showUser.text()+"|"
							+story.text()+"\r\n";   // 영화 하나에 대한 정보
					sb.append(msg); // 영화 하나의 정보를 저장
					mno++;
					}catch(Exception ex) {}  // for문 안에서 try-catch하면 제외하고 진행됨
					
					/*
					 *    <div class="aaa">
					 *       <a href="http://~">link</a>
					 *    </div>
					 *    
					 *    상황에 따라 필요한 부분이 달라
					 *    HTML은 데이터 저장하는 공간이 1. 태그, 2. 속성(attribute)
					 *    <span>aaa</span> ==> select("span") = aaa ==> 갖고오려면 text()써야 함
					 *    <a href="http://~">link</a> ==> ("a") ==> text() 쓰면: link
					 *                                              attr("href") 쓰면: http:/~
					 *    <div class="aaa">   ==> select("div.bbb span")
					 *       <span>aaa</span>
					 *    </div>
					 *    <div class="bbb">
					 *       <span>bbb</span>
					 *    </div>
					 *    <div class="ccc">
					 *       <span>ccc</span>
					 *    </div>
					 *    
					 *    <a> => link 주소
					 *    <img src="">
					 *    class => 화면 디자인용. CSS할 때
					 */
					
				}
			}
			FileWriter fw=new FileWriter("c:\\javaDev\\daum_movie.txt",true); 
			                            // true를 넣어 이후에 생길 목록을 이전 목록 이후에 붙여넣을 수 있게 한다.
			fw.write(sb.toString());
			fw.close();
		}catch(Exception ex) {
			// 에러 메세지 출력 해 주는게 좋음
			ex.printStackTrace();  // 여기에서 복구해서 다시 처리함
		}
		/*
		 *   예외처리
		 *     CheckException: IO(경로), 네트워크(서버IP), Thread(비동기화 => 충돌), Web(URL => site)
		 *                     SQL(sql문장)
		 *                     => 사전에 오류를 방지하는 프로그램
		 */
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovieHtmlParser m=new MovieHtmlParser();
		m.movieAllData();
	}

}
