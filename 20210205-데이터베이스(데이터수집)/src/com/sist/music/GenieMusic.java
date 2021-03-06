package com.sist.music;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 *    Oracle 연결 프로그램이 중심(오라클: 데이터베이스(데이터를 저장하는 장소 => 데이터 공유))
 *    1. 데이터형
 *       숫자형
 *        NUMBER(10), NUMBER(7,2)
 *        ==========  ===========
 *           int         double
 *       문자형
 *        CHAR, VARCHAR2, CLOB => String
 *       날짜형
 *        DATE => Date
 *    ===> int, double, String, Date
 *    2. 데이터를 모아서 전송
 *       ArrayList => 제네릭스(데이터형 통일)
 *    3. Connection, Statement, ResultSet
 *    4. 예외처리
 *   =====================================
 */
// 웹 크롤링
public class GenieMusic {
	public void getGenieMusic()
	{
		try
		{
			MusicDAO dao=new MusicDAO();  // for문 안에 들어가면 안됨
			int k=201;  // 여긴 고유번호이기 때문에 TOP200 이후에 진행=> 201부터
			for(int i=1;i<=2;i++)  // i<=4(TOP 200일 때), i<=2(장르별 차트일 때)
			{
				// TOP 200
				//Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20210210&hh=14&rtm=Y&pg="+i).get();
				//                                                                          날짜======== =====시간
				// 장르별 차트
				Document doc=Jsoup.connect("https://www.genie.co.kr/chart/genre?ditc=D&ymd=20210209&genrecode=M0100&pg="+i).get();
				// title, singer, album, poster, state, idcrement, rank
				Elements title=doc.select("tr.list a.title");  // <a class="title">
				Elements singer=doc.select("tr.list a.artist");
				Elements album=doc.select("tr.list a.albumtitle");
				Elements poster=doc.select("tr.list a.cover img");
				Elements etc=doc.select("tr.list span.rank");
				for(int j=0;j<title.size();j++)
				{
					System.out.println("순위:"+k);  // 테이블1
					System.out.println("제목:"+title.get(j).text());  // 테이블2
					System.out.println("가수:"+singer.get(j).text());  // 테이블3
					System.out.println("앨범:"+album.get(j).text());  // 테이블4
					System.out.println("포스터:"+poster.get(j).attr("src"));  // 테이블5
					String str=etc.get(j).text();
					// 유지
					// 2하강 => 숫자 제거 필요
					// 1상승 => 숫자 제거 필요
					// new
					String id="";
					String state=str.replaceAll("[^가-힣/^a-z]", "");  // 한글,영문을 제외하고 나머지는 공백
					if(state.equals("유지"))
					{
						id="0";
					}
					else if(str.equals("new"))
					{
						id="0";
					}
					else
					{
						id=str.replaceAll("[^0-9]", "");  // 숫자 제외하고 나머지는 공백
					}
					System.out.println("상태:"+state);  // 테이블6
					System.out.println("등폭:"+id);  // 테이블7
					//System.out.println("상태:"+etc.get(j).text());
					System.out.println("==============================================");
					// 데이터 모아서 => MusicDAO로 전송 => 오라클에 Insert
					GenieMusicVO vo=new GenieMusicVO();
					vo.setNo(k);
					vo.setCno(2);  // 1 TOP 200   2 장르
					vo.setTitle(title.get(j).text());
					vo.setSinger(singer.get(j).text());
					vo.setAlbum(album.get(j).text());
					vo.setPoster(poster.get(j).attr("src"));
					vo.setState(state);
					vo.setIdcrement(Integer.parseInt(id));
					
					dao.genieMusicInsert(vo);
					
					Thread.sleep(100);   // 오라클 열고 닫는 시간이 꽤 걸리니까 속도 맞춰서 올라올 수 있도록 지연되는 시간 걸어줘야 함
					k++;
				}
			}
		}catch(Exception ex) {ex.printStackTrace();}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenieMusic gm=new GenieMusic();
		gm.getGenieMusic();
	}

}
