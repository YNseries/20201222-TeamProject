package com.sist.movie;

import java.io.FileWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

// daum_movie.txt
// daum.news.txt
/*
 * 	  String sql="SELECT name,sex,addr "
 * 			+"FROM member";
 *    데이터 읽기 => 파일 저장
 *    데이터 읽기 => 데이터 전송 => 파일 저장
 *    
 *    예외처리: 사전에 에러를 대비(사용자의 실수, 프로그래머 실수)
 *                         =========  ========== 컴파일러 에러
 *                          대비 가능(실행에러)
 *      = 예외(에러: 수정이 가능한 에러) 발생 => 복구
 *        실행 => try, 에러발생 => catch 에러복구(처음으로 변경, 점프(건너뜀)): catch절은 여러 개 사용이 가능
 *      = 예외 => 회피: 시스템에서 처리(컴파일러만 통과하게 만든것) 복구 못함: throws
 *      = 예외 => 전환: 다른 에러발생 시선을 변경: throw
 *      
 *      CheckException UnCheckException(RuntimeException)
 *        |
 *      IOException: 입출력
 *                   ====
 *                   1) 메모리(에 저장된 값) 입출력
 *                   2) 파일 입출력
 *                   3) 네트워크 입출력(실제서버, 웹서버)
 *      MalformedURLException: 웹에 연결
 *      InterruptedException: 쓰레드(충돌)/ 중간에 끼어들어서
 *      ClassNotFoundException
 *      SQLException
 *      
 *      
 *      <li>
				<a href="http://v.movie.daum.net/v/20210126082631922" 
				class="thumb_line bg_noimage2" data-tiara-layer="bestpoint" data-tiara-ordnum="1" data-tiara-id="20210126082631922" data-tiara-type="news">
				<span class="thumb_img" style="background-image:url(//img1.daumcdn.net/thumb/S320x200/?fname=https://t1.daumcdn.net/news/202101/26/starnews/20210126082632225lrro.jpg);"></span>
				</a>
				<span class="cont_line">
					<strong class="tit_line">
					<a href="http://v.movie.daum.net/v/20210126082631922" class="link_txt" data-tiara-layer="title" data-tiara-ordnum="1" data-tiara-id="20210126082631922" data-tiara-type="news">'승리호' 송중기X조성희 감독, '늑대소년' 이후 8년만 재회</a></strong>
					<a href="http://v.movie.daum.net/v/20210126082631922" class="desc_line" data-tiara-layer="desc_line" data-tiara-ordnum="1" data-tiara-id="20210126082631922" data-tiara-type="news" style="height: auto;">
						[스타뉴스 김미화 기자] /사진='승리호' 포스터 넷플릭스 영화 '승리호'를 통해 8년 만에 조성희 감독과 재회한 송중기는 물론 배우와 제작진들이 조성희 감독을 향한 무한 신뢰를 보내며 작품에 대한 기대를 높이고 있다. '승리호'는 2092년, 우주쓰레기 청소선 승리호의 선원들이 대량살상무기로 알려진 인간형 로봇 도로시를 발견한 후 위험한 거래에 뛰어드는
					</a>
					<span class="state_line">
						스타뉴스<span class="txt_dot">・</span><span class="screen_out">발행일자</span>21.01.26
					</span>
				</span>
			</li>
 */
public class MovieManager {
	public static void main(String[] args) {
		MovieManager m=new MovieManager();
		m.daumNewsData();
		// static에서 인스턴스 메소드 호출시에는 반드시 객체를 생성한 후에 호출
	}
	public void daumNewsData()
	{
		// 웹서버 연결(네트워크 프로그램) => CheckException 갖고있음 : 컴파일시에 예외처리 여부 확인
		/*
		 *   <li>
		 *     <img/>  => Elements
		 *     <span></span>
		 *     <a></a>
		 *   </li>
		 *   <li>
		 *     <img/>
		 *     <span></span>
		 *     <a></a>
		 *   </li>
		 *   ...
		 *   ...
		 *   ...
		 */
		try
		{
			// 1. 웹서버(다음)에 연결해서 news에 대한 데이터를 읽기 시작
			int k=1;
			for(int i=1;i<=15;i++)
			{
				Document doc=Jsoup.connect("https://movie.daum.net/magazine/new?tab=nws&regdate=20210126&page="+i).get();
				// Document: 문서 저장 공간
				Elements title=doc.select("strong.tit_line a");
				Elements content=doc.select("a.desc_line");		
				Elements author=doc.select("span.state_line");
				Elements poster=doc.select("span.thumb_img");
				Elements link=doc.select("a.link_txt");
				for(int j=0;j<title.size();j++)
				{
					// size() => 저장된 갯수
					/*
					 *    <span>aaa</span>  : 텍스트는 <>와 <> 사이에 있음
					 *    <img src="">      : 이미지는 <> 안에 있음
					 */
					System.out.println("번호:"+k);
					System.out.println("제목:"+title.get(j).text().replace("\"", "").replace("\'","")); // "\"" : "를 공백으로 바꾸기
					System.out.println("내용:"+content.get(j).text().replace("\"", "").replace("\'",""));
					System.out.println("저자:"+author.get(j).text().replace("・"," ")); // replace 여러번 써서 지울 수 있음
					String img=poster.get(j).attr("style");  // attr: 속성값을 달라
					//System.out.println(img.indexOf("(")+1);
					img=img.substring(img.indexOf("(")+1,img.lastIndexOf(")"));
					/*   (괄호를 찾고 그 다음부터==============     ================ 마지막 괄호)까지
					 *    background-image:url(//img1.daumcdn.net/thumb/S320x200/?fname=https://t1.daumcdn.net/news/202101/26/starnews/20210126082632225lrro.jpg);
					 */
					System.out.println("http:"+img);
					System.out.println("링크:"+link.get(j).attr("href"));  // a태크 안 href에서 값을 갖고와
					System.out.println("=================================================");
										
					// 파일에 한 줄씩 저장
					String msg=String.format("%d^%s^%s^%s^%s^%s\r\n", k,
							title.get(j).text().replace("\"", "").replace("\'",""),
							content.get(j).text().replace("\"", "").replace("\'",""),
							author.get(j).text().replace("・"," "),
							"http:"+img,
							link.get(j).attr("href")
							);
					/*
					 *    r: read
					 *    w: write => 새롭게 만든다
					 *    a: write+append ===> true를 넣어줘야 함
					 */
					FileWriter fw=new FileWriter("c:\\javaDev\\daum_news.txt",true);
					fw.write(msg);
					fw.close();
					k++;
				}
			}
		}catch(Exception ex) 
		{
			ex.printStackTrace();
			/*
			 *   오류를 확인하는 방법: 에러 메세지 확인(getMessage())
			 *                   실행하는 과정을 보고 => 에러난 소스 위치 확인(printStackTrace())
			 */
		}
	}
	

}
