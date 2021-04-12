import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


/*
 *    1. 사용자로부터 ID, Password를 받아서 로그인 처리 => 결과값은 true/false
 *       메소드명 => login
 *       리턴형 메소드명(매개변수..)
 *       boolean login(String id,String pwd) => login("","")
 *       boolean bCheck=login("","");
 *       
 *    2. 검색 => 노래제목을 사용자로부터 받아서 가수명(결과값)을 출력
 *       find()
 *       ==> String find(String title)
 *       String singer=find("")
 *    3. 5개의 정수를 사용자로부터 받아서 정렬 후 결과값을 다시 전송
 *       int[] sort(int[] arr)
 *       int[] aaa={3,5,4,7,1};
 *       int[] arr=sort(aaa);
 *       *** 라이브러리에서 제공하는 메소드명은 키워드가 아니다
 *       리턴형 :
 *       매개변수:
 *       ========================= 기본데이터형, 참조데이터형(배열,클래스)
 *    4. 메소드 만드는 이유 : 분리 => 소스를 나눠서 처리 (관련된 내용을 모아서 만든다) : 가독성 상승, 수정 쉬워짐
 *       ==== 유지보수
 *       
 *       사용자가 보내주는 값(매개변수)
 *       결과값이 있는 경우 (리턴형)
 *    5. 메소드가 종료될 때 return을 사용
 *       void => return을 생략할 수 있다 => JVM이 자동으로 첨부
 *       
 *       ==> int[] arr={};
 *           int[] arr=new int[]{}
 *           
 *           https://www.genie.co.kr/chart/top200
 *           
 *            <td class="info">
              <a href="#" class="title
 */
public class 메소드만들기3 {
	static void genie()
    {
    	try
    	{
    		Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
    		Elements title=doc.select("td.info a.title");
    		for(int i=0;i<title.size();i++)
    		{
    			System.out.println(title.get(i).text());
    		}
    	}catch(Exception ex) {}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
