package com.sist.dao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

// 다음에서 데이터 읽어오기 => MovieDAO 연결 => 데이터 저장
public class MovieManager_1 {
	public void movieData()
	{
		MovieDAO dao=new MovieDAO();
		try
		{
			//String url="https://movie.daum.net/ranking/reservation";
			String url="https://movie.daum.net/ranking/boxoffice/weekly";
			//int cno=1;
			int cno=2;
			Document doc=Jsoup.connect(url).get();
			/*
			 *   <div class="thumb_cont">
                                <strong class="tit_item">
                                    <a href="/moviedb/main?movieId=137317" 
                                    class="link_txt" data-tiara-layer="moviename">미나리</a>
			 */
			Elements link=doc.select("div.thumb_cont strong.tit_item a.link_txt");
			/*
			 *   <span class="txt_info">
							        개봉<span class="txt_num">21.03.03</span>
			 */
			Elements regdate=doc.select("span.txt_info span.txt_num");
			/*
			 *    <span class="txt_tag">
                                            <span class="ico_movie ico_see see12">12세이상관람가</span>
                                        </span>
			 */
			Elements grade=doc.select("span.txt_tag span.ico_movie");
			/*
			 *   <span class="txt_append">
                                    <span class="info_txt">평점<span class="txt_grade">7.2</span></span>
                                    <span class="info_txt">예매율<span class="txt_num">22.1%</span></span>
                                </span>
			 */
			Elements score=doc.select("span.txt_append span.txt_grade");
			/*
			 *   <div class="poster_movie">
                                        <img src="https://img1.daumcdn.net/thumb/C408x596/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fmovie%2F335359e6a5a36f0d334bc20ff2f2c0488b30c67d" class="img_thumb" alt="미나리">
			 */
			Elements poster=doc.select("div.poster_movie img.img_thumb");
			/*
			 *    <div class="poster_info">
                                    <a href="/moviedb/main?movieId=137317" class="link_story" data-tiara-layer="poster">
                                        2021년 전 세계가 기다린어느 한국 가족의 원더풀한 이야기"미나리는 어디서든 잘 자라"낯선 미국, 아칸소로 떠나온 한국 가족.가족들에게 뭔가 해내는 걸 보여주고 싶은 아빠 '제이콥'(스티븐 연)은자신만의 농장을 가꾸기 시작하고 엄마 '모니카'(한예리)도 다시 일자리를 찾는다.아직 어린 아이들을 위해‘모니카’의 엄마 ‘순자’(윤여정)가 함께 살기로 하고가방 가득 고춧가루, 멸치, 한약 그리고 미나리씨를 담은 할머니가 도착한다.의젓한 큰딸 '앤'(노엘 케이트 조)과 장난꾸러기 막내아들 '데이빗'(앨런 김)은여느 그랜마같지 않은 할머니가 영- 못마땅한데…함께 있다면, 새로 시작할 수 있다는 희망으로하루하루 뿌리 내리며 살아가는어느 가족의 아주 특별한 여정이 시작된다!
                                    </a>
			 */
			Elements story=doc.select("div.poster_info a.link_story");
			for(int i=0;i<link.size();i++)
			{
				try
				{
					// html은 값이 두군데 있음.
					// 1. 태그와 태그 사이에 <a>(여기에 값 있음)</a>
					// 2. <a 속성="값"> => attr(속성)
					MovieVO vo=new MovieVO();
					
					if(link.get(i).text().equals("타락천사"))  // 오류나서 빼버림
						continue;
					System.out.println("제목:"+link.get(i).text());
					System.out.println("링크:"+link.get(i).attr("href"));
					System.out.println("개봉일:"+regdate.get(i).text());
					System.out.println("등급:"+grade.get(i).text());
					System.out.println("평점:"+score.get(i).text());
					System.out.println("포스터:"+poster.get(i).attr("src"));
					System.out.println("줄거리:"+story.get(i).text());
					vo.setCno(cno);
					vo.setTitle(link.get(i).text());
					vo.setRegdate(regdate.get(i).text());
					vo.setGrade(grade.get(i).text());
					vo.setScore(Double.parseDouble(score.get(i).text()));
					vo.setPoster(poster.get(i).attr("src"));
					vo.setStory(story.get(i).text());
					// https://movie.daum.net/~
					Document doc2=Jsoup.connect("https://movie.daum.net"
							+link.get(i).attr("href")).get();
					Elements info1=doc2.select("div.inner_cont dl.list_cont dt");
					Elements info2=doc2.select("div.inner_cont dl.list_cont dd");
					for(int j=0;j<info1.size();j++)
					{
						try
						{
							String str=info1.get(j).text();
							if(str.equals("장르"))
							{
								System.out.println("장르:"+info2.get(j).text());
								vo.setGenre(info2.get(j).text());
							}
							else if(str.equals("국가"))
							{
								System.out.println("국가:"+info2.get(j).text());
								vo.setNation(info2.get(j).text());
							}
							else if(str.equals("러닝타임"))
							{
								System.out.println("러닝타임:"+info2.get(j).text());
								vo.setTime(info2.get(j).text());
							}
							else if(str.equals("누적관객"))
							{
								System.out.println("누적관객:"+info2.get(j).text());
								vo.setShowUser(info2.get(j).text());
							}
							else if(str.equals("박스오피스"))
							{
								System.out.println("박스오피스:"+info2.get(j).text());
								vo.setBoxoffice(info2.get(j).text());
							}
						}catch(Exception ex) {
							ex.printStackTrace();
						}
					}
					//System.out.println("동영상:"+youtubeGetKey(vo.getTitle()));
					vo.setKey(youtubeGetKey(vo.getTitle()));
					dao.movieInsert(vo);
					
					Thread.sleep(100);  // 읽는 속도와 오라클에 저장하는 속도(열고 닫느라 느림) 차이를 맞추려고
					// Pro / Standard(연습용. 느림)
					System.out.println("===========================================================");
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	// https://www.youtube.com/results?search_query=영화제목
	public String youtubeGetKey(String title)
	{
		String key="";
		try
		{
			String url="https://www.youtube.com/results?search_query="+title;
			Document doc=Jsoup.connect(url).get();
			// /watch?v=bdcIC8d4nW0
			Pattern p=Pattern.compile("/watch\\?v=[^가-힣]+");  // 한글을 제외한 모든 문자 갖고오기. ?는 앞에 \\ 붙여줘야 문자로 인식
			Matcher m=p.matcher(doc.toString());
			while(m.find())
			{
				String str=m.group();   // 찾은 문자열 읽어오기
				str=str.substring(str.indexOf("=")+1,str.indexOf("\""));
				key=str;
				break;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return key;
	}
	public static void main(String[] args) {
		MovieManager_1 m=new MovieManager_1();
		m.movieData();
	}
}
