package com.sist.main;
/*
 *    java.lang
 *    =========
 *      Object => 모든 클래스를 모아서 관리(모든 데이터형을 받을 수 있다)
 *                형변환
 *                Object obj=new String();
 *                String str=(String)obj;
 *                => 자바에서 제공하는 메소드 중에 클래스를 리턴형으로 가지고 있는 경우
 *                   모든 메소드가 Object로 넘어옴
 *                ArrayList에서 넘어올 때 저장된 값을 읽어 온다(get으로)
 *                         => public Object get(int index) => (String)list.get(0)
 *                                                            ======== 
 *                                    이렇게 데이터형을 붙이거나 클래스 자체의 데이터형을 변경하거나
 *      String => 웹, 모바일, 윈도우 => 문자열로 저리
 *      Wrapper => Integer, Double, Boolean => 문자열을 변환
 *                 parseInt() parseDouble() parseBoolean
 *      StringBuffer => 파일에 저장된 문자열이 길 경우 => append
 *    java.util
 *    =========
 *      StringTokenizer: 구분문자로 문자열을 자른다
 *                       ================== 영화, 맛집, 여행, 쇼핑 => 이미지가 여러개일 때: 이미지명, 이미지명, ...
 *      Date: 시스템의 날짜 = 오라클
 *      Calendar: 달력(날짜 조작)
 *      SimpleDateFormat, MessageFormat(웹에서 layout 잡을 때 등장), ChoiceFormat(많이는 안써)
 *      ===============   =============                         ============ 대신 (switch, if로 처리가능)
 *         날짜 변경          글자? 요일? 변경
 *      자료구조
 *       List: ArrayList, Vector(네트워크), LinkedList, Stack
 *             ========= 데이터베이스
 *       Set: HashSet, TreeSet
 *            ======= 중복없는 데이터를 저장
 *       Map: HashMap, HashTable => session(웹 서버/접속한 사람의 정보)에서 많이 사용, cookie, request, response
 *                                    id, "admin"                                   ?movieid=111111
 *                                    setAttribute("key","value")  // 실제 사용하는 형식
 *                                    Map map=new HashMap()        // 형식의 내용
 *            =======                 map.put(key,value);          
 *              Spring, MyBatis 라이브러리에 많아
 *              ======  ======= <select id="movie">SQL문장</select>
 *              <bean id="board" class="Board">: 스프링은 클래스 관리자(생성~소멸까지 담당)
 *      ==> 형변환이 없이 Collection => 데이터형을 통일화: 제네릭스 <TYPE>
 *      ==> 메소드 구분, 클래스 찾기(인덱스) => if 대신: 어노테이션
 */
// Vector: 네트워크(ip, port) => Socket => 동기화
/*
 *    java.util => import를 반드시 사용 => import java.util.Vector, import java.util.*
 *                                     ====================== ↖ 이거보단 ↑ 이렇게 쓰는게 나음
 *    Vector: 동기화 프로그램 => 데이터 수집(10000개의 레시피 => 1500000) => Thread
 *    ======
 *     List => 순서가 있다, 중복 데이터 저장이 가능
 *             ======== 인덱스 번호
 *             자료구조: CURD(저장, 수정, 읽기, 삭제)   List 내 메소드,   Vector가 가지고 있는 형식 (둘 다 같음)
 *              = 읽기(데이터를 가지고 온다)         => get(인덱스 번호), elementAt(인덱스)
 *              = 저장                         => add(),         addElement()
 *              = 삭제                         => remove(),      removeElementAt()
 *              = 갯수                         => size()
 *              
 *              public interface List
 *              {
 *                  add(){}
 *                  set(){}
 *                  remove(){}
 *                  size(){}
 *                  get(){}
 *              }
 *              
 *              public class ArrayList implements List
 *              {
 *                  add(){}
 *                  set(){}
 *                  remove(){}
 *                  size(){}
 *                  get(){}
 *              }
 *              
 *              public class Vector implements List
 *              {
 *                  add(){}
 *                  set(){}
 *                  remove(){}
 *                  size(){}
 *                  get(){}
 *              }
 *              
 *              public class LinkedList implements List
 *              {
 *                  add(){}
 *                  set(){}
 *                  remove(){}
 *                  size(){}
 *                  get(){}
 *              }
 *              
 *              List list=new ArrayList();    // 비동기적
 *              List list=new Vector();       // 동기적
 *              List list=new LinkedList();   // 속도빠르게
 *              모두 같은 메소드를 사용하기 때문에 선호도에 따라 선택 가능
 */
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector vec=new Vector();  // Vector(=일반 클래스) 선언
		// add() 한 개씩 첨부, addAll() 지정한 데이터 전부를 한 번에 첨부
		Collections.addAll(vec, "홍길동","심청이","김두한","이순신","강감찬"); // Collections는 최상위클래스
		Collections.sort(vec);
		//                      ================================== 이 내용을 모두 vec에 넣어라. addAll()
		//vec.add("");   이걸 5번 쓰는 것 = Collections.addAll();
		//System.out.println(vec.size());
		for(int i=0;i<vec.size();i++)
		{
			String name=(String)vec.get(i);  // Object로 받으니까 형변환 해야 함
			System.out.println(name);
		}
		
		//Vector vec2=new Vector();
		ArrayList vec2=new ArrayList();
		vec2.addAll(vec);  // 여기서 addAll은 이미 만들어 둔 것 복사/가져다 씀   set은 계열이 다르기 때문에 안됨
		for(int i=0;i<vec2.size();i++)
		{
			String name=(String)vec2.get(i);
			System.out.println(name);
		}
	}

}
