package com.sist.dao;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;

/*
	 *  NO     NOT NULL NUMBER                
		TITLE   NOT NULL VARCHAR2(300) 
		SUBJECT NOT NULL VARCHAR2(300) 
		POSTER  NOT NULL VARCHAR2(260) 
		LINK    NOT NULL VARCHAR2(260) 
 */
public class FoodManager {
	private FoodDAO dao=new FoodDAO();
	public void foodCategoryData()
	{
		try
		{
			int k=1;  // 카테고리 번호
			// 연결 후 소스 읽기(읽고 가져오는 것: Document)
			Document doc=Jsoup.connect("https://www.mangoplate.com/").get();
			// System.out.println(doc);   // => 정상 출력되는지 확인
			Elements title=doc.select("div.top_list_slide span.title");  // select 내엔 CSS선택자 들어감 / Elements: 같은 태그 여러개를 모을 때
			Elements poster=doc.select("div.top_list_slide img.center-croping");  // 못 읽으면 바로 위 코드까지 한꺼번에 갖고오면 됨
			Elements subject=doc.select("div.top_list_slide p.desc");
			Elements link=doc.select("div.top_list_slide a");
			for(int i=0;i<title.size();i++) {
				System.out.println("번호:"+k);
				System.out.println("제목:"+title.get(i).text());
				System.out.println("부제목:"+subject.get(i).text());
				System.out.println("이미지:"+poster.get(i).attr("data-lazy"));
				System.out.println("링크:https://www.mangoplate.com"+link.get(i).attr("href"));
				FoodCategoryVO vo=new FoodCategoryVO();
				vo.setTitle(title.get(i).text());
				vo.setSubject(subject.get(i).text());
				vo.setPoster(poster.get(i).attr("data-lazy"));
				vo.setLink("https://www.mangoplate.com"+link.get(i).attr("href"));
				dao.foodCategoryInsert(vo);
				k++;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	/*
	 *   <div class="info">
            <div class="wannago_wrap">
               <button class="btn-type-icon favorite wannago_btn "
                                  data-restaurant_uuid="411974"
                                  data-action_id="">
                          </button>
                          <p class="wannago_txt">가고싶다 </p>
                        </div>
                        <span class="title ">
                          <a href="/restaurants/HrBaIZj2EXJH"
                             onclick="trackEvent('CLICK_RESTAURANT', {&quot;position&quot;:0,&quot;restaurant_key&quot;:&quot;HrBaIZj2EXJH&quot;})">
                            1.<h3> 경성초밥</h3>
	 */
	public void foodDetailData()
	{
		List<FoodCategoryVO> list=dao.foodCategoryLinkData();
		try
		{
			for(FoodCategoryVO vo:list)   // 카테고리 30개 => 30바퀴
			{
				Document doc=Jsoup.connect(vo.getLink()).get();
				Elements link=doc.select("div.info span.title a");   // 망고의 레시피에서 이미지링크+제목링크 따로 있음
				for(int i=0;i<link.size();i++) 
				{
				try {
					FoodHouseVO fvo=new FoodHouseVO();
					System.out.println("https://www.mangoplate.com"+link.get(i).attr("href"));
    				Document doc2=Jsoup.connect("https://www.mangoplate.com"+link.get(i).attr("href")).get();
    				fvo.setCno(vo.getNo());
    				System.out.println("Category NO:"+fvo.getCno());
    				Elements poster=doc2.select("figure.restaurant-photos-item img.center-croping");
    				String str="";
    				for(int j=0;j<poster.size();j++)
    				{
    					String s=poster.get(j).attr("src");
    					str+=s+"^";   // ^로 갖고온 내용을 나눠서 저장. 하나로 전체를 처리
    				}
    				// a.jpg^b.jpg^c.jpg^ 이렇게 나올 것임
    				str=str.substring(0,str.lastIndexOf("^"));  // 문자열 결합된 "^" 제거
    				System.out.println(str);
    				// 이미지 출력
    				fvo.setPoster(str);
    				Element title=doc2.selectFirst("span.title h1.restaurant_name"); // 식당 이름은 하나씩이니까 Element에 selectFirst 사용
    				System.out.println("이름:"+title.text());
    				fvo.setTitle(title.text());
    				Element score=doc2.selectFirst("strong.rate-point span");
    				System.out.println("평점:"+score.text());
    				fvo.setScore(Double.parseDouble(score.text()));
    				Element review=doc2.selectFirst("script#reviewCountInfo");
    				//[{"action_value":1,"count":8},{"action_value":2,"count":30},{"action_value":3,"count":99}]
    				//                        bad                          soso                          good
    				//  ========================== JSONObject
    				System.out.println("리뷰:"+review.data());;  // script와 script 사이에 있으니 .data()로 출력해야 함
    				// JSON 파싱(위의 내용물에서 필요한 숫자만 빼오기 위함) => 실무 거의 100%
    				/*
    				 * 	 [] = 배열 형식 JSONArray
    				 * 	 {} = 객체     JSONObject
    				 */
    				JSONParser jp=new JSONParser();
    				// int a=(int)10.5;
    				JSONArray arr=(JSONArray)jp.parse(review.data());   // 리턴형이 object라서 형변환 해 줘야 함
    				long[] re=new long[3];   // review 값 여기에 들어가 있음
    				/*
    				 * 	 A[] arr={new A(),new A()...};
    				 *   for(int i=0;i<arr.length;i++) {
    				 *      A a=arr[i];
    				 *   }
    				 *   ["",""]
    				 *   [1,2,3,]
    				 */
    				for(int j=0;j<arr.size();j++) {
    					JSONObject obj=(JSONObject)arr.get(j);   // get()메소드는 하나 => Object 리턴형 = 형변환 필요
    					System.out.println(obj.get("count"));    // count에 있는 숫자만 잘라옴
    					re[j]=(Long)obj.get("count");   // JSON으로 받은거 언제나 Long으로 받아줘야 함 / good, soso, bad
    				}
    				fvo.setGood((int)re[2]);
    				fvo.setSoso((int)re[1]);
    				fvo.setBad((int)re[0]);
    				
    				Elements info=doc2.select("table.info tr th");  // 그에 대한 정보(종류: 주소, 전화번호 등)는 여러개니까
    				Elements data=doc2.select("table.info tr td");
    				for(int j=0;j<info.size();j++)
    				{
    					//System.out.println(info.get(j).text());
    					String label=info.get(j).text();
    					if(label.equals("주소"))
    					{
    						System.out.println("주소:"+data.get(j).text());
    						fvo.setAddress(data.get(j).text());
    					}
    					else if(label.equals("전화번호"))
    					{
    						System.out.println("전화번호:"+data.get(j).text());
    						fvo.setTitle(data.get(j).text());
    					}
    					else if(label.equals("음식 종류"))
    					{
    						System.out.println("음식 종류:"+data.get(j).text());
    						fvo.setType(data.get(j).text());
    					}
    					else if(label.equals("가격대"))
    					{
    						System.out.println("가격대:"+data.get(j).text());
    						fvo.setPrice(data.get(j).text());
    					}
    					else if(label.equals("주차"))
    					{
    						System.out.println("주차:"+data.get(j).text());
    						fvo.setParking(data.get(j).text());
    					}
    					else if(label.equals("영업시간"))
    					{
    						System.out.println("영업시간:"+data.get(j).text());
    						fvo.setTime(data.get(j).text());
    					}
    					else if(label.equals("메뉴"))
    					{
    						System.out.println("메뉴:"+data.get(j).text());
    						fvo.setMenu(data.get(j).text());
    					}
    				}  // 2차 for문 끝
    				dao.foodInsert(fvo);
    				Thread.sleep(50);
				}catch(Exception ex) {
					ex.printStackTrace();}  // NotNull때문에 하나가 튀어서 예외처리 해 줘야 함
    			}  // 1차 for문 끝
    			System.out.println("================="+vo.getNo()+"번 end=================");
    		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		FoodManager fm=new FoodManager();
		//fm.foodCategoryData(); => foodCatetoryData 30개 뽑기
		fm.foodDetailData();
		/*int[] arr={1,2,3,4,5,0,9,6,7,8};
		for(int a:arr) {  // for문 안에 try~catch를 넣어 문제되는 곳 넘어서 전체를 진행할 수 있게 할 수 있다
			try {
				System.out.println(10/a);
			}catch(Exception ex) {}
		}*/
	}
}
