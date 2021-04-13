package com.sist.main;
/*
 *    컬렉션 클래스(Collection): 데이터를 저장하는 표준화된 클래스
 *    =====================
 *      = CURD(Create, Update, Read, Delete)
 *      = 데이터 읽기 / 수정 / 추가 / 삭제
 *      = 표준화
 *      = (배열은 고정이지만) 컬렉션 => 가변
 *    1. 종류
 *       List: 순서가 있다(인덱스 번호가 일괄적으로 생성) = 제어하기 쉬움, 데이터를 중복적으로 저장 가능 => DataBase(오라클)에서 가장 많이 사용
 *       Set: 순서가 없다(인덱스 존재 X) = 데이터 찾기 어려움, 때문에 데이터 중복을 허용하지 X => 사용 빈도가 낮음
 *       Map: 순서가 없다, 키, 값 => 키는 중복 허용 X, 데이터는 중복 허용 (O)
 *       ===
 *       웹 프포그램: session, cookie, request, response
 *       
 *       List: 인터페이스(미완성된 클래스) => 구현하고 있는 클래스를 이용한다(표준화, 서로 다른 클래스를 연결해서 사용 가능)
 *         구현한 클래스
 *         =========
 *         배열을 대체해서 사용 => 더이상 배열은 가급적으로 사용하지 않음
 *         ===============================================
 *         1) ArrayList: 비동기화(데이터베이스 연결할 때 많이 씀) ***
 *         2) Vector: 동기화(네트워크 프로그램) => 속도가 느림
 *         3) LinkedList: C언어 호환 => 속도가 빠름
 *         ===============================================
 *           공통적으로 사용(자료구조) ★★★              오라클에서
 *           1. 데이터 저장(추가)할 때: add()       => INSERT
 *           2. 데이터 삭제        : remove()    => DELETE
 *           3. 데이터 수정        : set()       => UPDATE
 *           4. 데이터 읽기(갖고오기) : get()       => SELECT        JOIN, SUBQUERY부터 좀 어려워질거야
 *           5. 저장된 데이터 개수   : size()
 *         ===============================================
 *         4) Stack: LIFO, Queue: FIFO
 *            ===========  ===========
 *            주차장         네트워크, 운영체제
 *       
 *       
 *       ArrayList
 *       =========
 *       1. 생성하는 방법
 *          ArrayList list=new ArrayList();
 *          =========          ===========
 *          Vector             Vector()       => 이렇게 클래스만 바꿔도 밑(메소드)에는 변경사항 없음
 *          LinkedList         LinkedList()      동일하게 작동함. 이래서 인터페이스로 상속받으면 표준화 되어있어 사용하기 좋음 
 *       2. 데이터 저장 방법
 *          = 맨 뒤에 추가 list.add(데이터);
 *                              ====== Object  => (원형) public void add(Object obj)
 *          = 원하는 위치에 추가 list.add(int index,Object obj)
 *                                  ==========
 *                                  1
 *                                  2    <= 1, 3, 2 중간에 끼어들 수도 있음(갯수 증가)
 *       3. 데이터 읽기 
 *          list.get(int index): 0부터 시작       => (원형) public Object get(int index)
 *          예) list.get(1): 2번째로 들어간 값       => int no=(int)list.get(i)  // 초반엔 다 형변환 시켜주는 게 좋음
 *       4. 데이터 갯수 확인
 *          list.size()                        => (원형) public int size()
 *       5. 데이터 수정 
 *          list.set(int index,Object obj)     => (원형) public Object set(int index,Object obj)
 *                        0 1
 *                        1 1
 *                        2 1 => 2 5 : list.set(2,5)
 *                        3 1
 *                        4 1
 *                        5 2
 *       6. 데이터 삭제(한 개, 전체)
 *          list.remove(int index)             => (원형) public boolean remove(int index)
 *          list.removeAll(), list.clear()  // 전체 삭제, 비워버리기
 */
import java.util.*;  // Collection 클래스 모두 들어가 있음
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 이름을 저장(여러개) = 초반에 배울 때: String[] names=new String[10];
		// 저장할 메모리 공간 생성
		ArrayList nameList=new ArrayList();  // 클래스가 메모리 공간 만들어냄  // 노란줄은 경고 ==> 저장(Object)
		//Vector nameList=new Vector();
		//LinkedList nameList=new LinkedList();
		//Stack nameList=new Stack();
		// 저장
		nameList.add("홍길동");  // 0  => Object o= "홍길동"; Object o=new Object() => Object
		nameList.add("심청이");  // 1          Object o=new String(""); => String
		nameList.add("이순신");  // 2
		nameList.add("강감찬");  // 3
		nameList.add("박문수");  // 4
		// ArrayList 장점: 제어문 쓰기 좋음. 다만 Object에 들어가는 데이터형이 다양해지면 일일이 형 변환 시키면서 for문 돌리기 어려움
		// 때문에 들어가는 데이터형 통일한 상태에서 하는게 좋음 => 통일시키는 방법: 제네릭스<>
		
		/*
		 *   public void display(double d)
		 *   {
		 *         65.0
		 *   }
		 *   display('A'); 
		 *           === char
		 *   double d='A';   => 65.0
		 *            === char
		 *   public void add(Object o)
		 *   {
		 *   }
		 *   
		 *   add("aaa")
		 */
		Object o="AAAA";  // "주소" new
		Object o1=new Object();
		System.out.println(o);
		System.out.println(o1);
		
		System.out.println("========= ArrayList에 저장된 데이터 ========");
		// Object nema=new String();
		/*for(Object name:nameList)  // 매개변수에 따라 데이터형이 달라지니까 Object로 받아서 Object 써야함
		{
			System.out.println((String)name);  // 혹은 name.toString | name만 써도 됨
		}
		System.out.println("현재 저장된 이름:"+nameList.size());
		                                   //     ======== 총 저장된 갯수 */
		for(int i=0;i<nameList.size();i++)
		{
			Object obj=nameList.get(i);
			System.out.println(i+":"+obj);
		}
		// 원하는 위치에 데이터를 출력(권장하지 않음)
		System.out.println("============== 추가 =============");
		nameList.add(2, "을지문덕");
		/*
		 *  홍길동  0
			심청이  1
			          <-  2, "을지문덕"
			이순신  2 -> 3
			강감찬  3 -> 4
			박문수  4 -> 5
			=> 이렇게 중간에 추가했을 때 단점: 뒤의 숫자들이 하나씩 추가되면서 속도가 느려짐
			   때문에 될 수 있으면 맨 뒤에 추가하는게 좋아
		 */
		for(int i=0;i<nameList.size();i++)
		{
			Object obj=nameList.get(i);
			System.out.println(i+":"+obj);
		}
		
		System.out.println("============== 수정 =============");
		nameList.set(3,"춘향이");
		for(int i=0;i<nameList.size();i++)
		{
			Object obj=nameList.get(i);
			System.out.println(i+":"+obj);
		}
		
		System.out.println("============== 삭제 =============");
		nameList.remove(2); // (권장하지 않음)
		/*
		 *  홍길동  0
			심청이  1
			을지문덕 2 => 삭제
			춘향이  3 -> 2
			강감찬  4 -> 3
			박문수  5 -> 4
		 */
		for(int i=0;i<nameList.size();i++)
		{
			Object obj=nameList.get(i);
			System.out.println(i+":"+obj);
		}
		
		System.out.println("=========== 전체 삭제 ============");
		nameList.clear();
		System.out.println("저장된 이름:"+nameList.size());
	}

}
