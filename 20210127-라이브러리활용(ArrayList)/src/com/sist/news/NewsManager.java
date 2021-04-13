package com.sist.news;
import java.util.*;
import java.io.*;
public class NewsManager {   // NewsVO와 NewsManager는 어디에서 출력하던지 바뀌지 않음.
	private static ArrayList newsList=new ArrayList();
	// 데이터를 공유(static) 
	static
	{
		try
		{
			// 파일 읽기
			FileReader fr=new FileReader("c:\\javaDev\\daum_news.txt");
			int i=0;
			StringBuffer sb=new StringBuffer();
			while((i=fr.read())!=-1)
			{
				sb.append(String.valueOf((char)i));
			}
			fr.close();
			// System.out.println(sb);  // sb | sb.toString() => 둘 다 똑같음. 하나는 toString()이 생략된 것(출력할 때만)
			// 분리 => 데이터 추출을 위함
			String data=sb.toString();  // 그냥 sb쓰면 오류 남
			String[] news_data=data.split("\n");
			//NewsVO vo=new NewsVO();  // 여기에 들어가면 메모리 주소 한개여서 마지막 것만 나옴. 안에 들어가야 주소가 따로 생긴다
			// aaa||bbb|ccc 오류    aaa| |bbb|ccc 정상처리
			for(String news:news_data)
			{
				StringTokenizer st=new StringTokenizer(news,"|");
				NewsVO vo=new NewsVO();  // 각각의 메모리 주소 만들기 위해서 같이 for문 돌려줘야 함
				vo.setNo(Integer.parseInt(st.nextToken()));
				vo.setTitle(st.nextToken());
				vo.setContent(st.nextToken());
				vo.setAuthor(st.nextToken());
				vo.setPoster(st.nextToken());
				vo.setLink(st.nextToken());
				newsList.add(vo);
			}  // vo(stack에 저장되어 있음)는 이 블럭을 나가면 사라지지만 
			   // 이를 저장한 주소_데이터(heap)는 남아있음 => 이걸 종료하기 전 해소하는게 GC
		}catch(Exception ex) {}  
		                  // {}안에 에러를 잡기 위해서 ex.printStackTrace(); 꼭 넣어줘야 함		
	}
	
	// 목록 출력
	public ArrayList newsListData(int page)   // ★★★ 가변형 ★★★
	{
		ArrayList list=new ArrayList();
		int j=0;  // 10개씩 나눠주는 변수 => j<10
		int pagecnt=(page*5)-5;  // 시작 위치를 잡아주는 변수(인덱스 시작점 이용)
		/*                == 나눠주고 싶은 갯수
		 *    1page: 1~5
		 *    2page: 6~10
		 *    3page: 11~15
		 */
		for(int i=0;i<newsList.size();i++)  // 이렇게 나누면 예)300개일 때 매번 300개씩 돌아가기 때문에 느림.
		{    // i=인덱스번호                      그래서 오라클에서 나눠주는게 좋아
			if(j>4) break;
			if(j<5 && i>=pagecnt)   // i(인덱스)는 시작 위치 지정
			{
				NewsVO vo=(NewsVO)newsList.get(i);
				list.add(vo);
				j++;  // j=5가 되면 종료
			}
		}
		return list;
	}
	
	// 총 페이지
	public int newsTotalPage()
	{             // ========= 기억해둬    random은 게임 제작할 때
		return (int)(Math.ceil(newsList.size()/5.0));
		// 203/20.0 ==> 10.15 ==> ceil(10.15) ==> 11     ceil: 올림함수
	}
	
	public static void main(String[] args) {
		NewsManager m= new NewsManager();
		/*String msg="aaa||bbb|ccc|||ddd";
		StringTokenizer st=new StringTokenizer(msg,'|');
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());*/
		/*
		 * for(int i=0;i<newsList.size();i++) { NewsVO vo=(NewsVO)newsList.get(i);
		 * System.out.println(vo.getTitle()); }
		 */
		ArrayList list=m.newsListData(30);
		for(int i=0;i<list.size();i++)
		{
			NewsVO vo=(NewsVO)list.get(i);   // Object 받게되면 getter/setter 이용 불가
			// Object obj=list.get(i)
			System.out.println(vo.getNo()+"."+vo.getTitle());
		}
		System.out.println("총 페이지:"+m.newsTotalPage());  
		/*
		 *    class A
		 *    {
		 *        public String toString(){}
		 *        public void display(){}
		 *    }
		 *    
		 *    Object obj=new A();  ==> Object가 가지고 있는 메소드 중에 A클래스가 오버라이딩 된 것만 호출
		 *    
		 *    obj.toString();
		 *    obj.display()  (X)
		 *    
		 *    A a=(A)obj;   // 형 변환 시키면서 가져와야 함
		 *    a.toString();
		 *    a.display();
		 */
		// String s="Hello";  // "" 자체가 주소
		// char[] s=new char[]{'H'	...} 이렇게 변환되기 때문
		// int[] arr={10, 20, 30, ... }
		
	}
}
