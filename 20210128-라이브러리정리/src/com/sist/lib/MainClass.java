package com.sist.lib;
/*
 *     java.lang
 *       Object
 *        = clone(): 복제
 *        = toString(): 문자열 변환
 *       String
 *        = length(): 문자 갯수
 *        = equals(): 문자열 비교(대소문자 구분)
 *        = substring(): 문자를 자를 때 사용
 *        = indexOf(), lastIndexOf(): 문자 찾기
 *        = trim(): 좌우의 공백 제거
 *        = replace(): 문자를 변경(특히 외부에서 갖고올 때 필요없는 글자 변경)
 *        = valueOf(): 모든 데이터형을 문자열로 변환
 *        = split(): 문자열 구분해서 분리
 *       StringBuffer
 *        = append(): 문자열 결합(최적화)
 *       Integer
 *        = parseInt(): 문자열을 정수로 변환
 *       Double
 *        = parseDouble()
 *       Boolean
 *        = parseBoolean()
 *       Math
 *        = random(): 난수 발생
 *        = ceil(): 올림
 *     java.util
 *       StringTokenizer
 *        = hasMoreTokens() => while()
 *        = nextToken(): 자른 문자열을 한 개씩 가지고 올 때
 *       =========================
 *       ArrayList
 *        = add()
 *        = size()
 *        = get()
 *       Vector
 *        = addElement() => add()
 *        = elementAt() => get()
 *        = size()
 *       HashMap
 *        = put(): 저장
 *        = get(): 데이터 읽기
 *       ========================= 컬렉션: 데이터형 처리 => 데이터령 통일(제네릭스) <Type>
 *         어노테이션: 인덱스(찾기위한 구분자)
 *         클래스의 구성 요소 => 찾기 위한 구분을 시켜준다 => 제어역전(IoC) => 마틴 파울러
 *         1. 클래스
 *         2. 메소드 ==> 매개변수
 *         3. 멤버변수
 *         4. 생성자
 *       =================================
 *       Properties
 *        = load() => 파일 읽기(.properties)
 *        = getProperty()
 *       ================================= 파일 (key=값)
 *       Date : 시스템의 날짜를 읽어옴 => 생성할 줄만 알면 됨 (Date date=new Date())
 *          오라클
 *          데이터형
 *          CHAR, VARCHAR2, CLOB ==> String
 *          NUMBER               ==> int, double
 *          DATE, TIMESTAMP      ==> Date
 *          BLOB, BFILE          ==> InputStream
 *       Calendar: 달력
 *          = month: 0~11
 *          = week: 1~7
 *     java.text
 *       SimpleDateFormat
 *          = format()
 *          = yyyy, MM, dd, hh, mm, ss ==> 오라클 TO_CHAR 사용하면 됨
 *     기타 라이브러리
 *     ==========
 *       jsoup, simple-json, jaxb
 *     ==========
 *       java.sql: 오라클
 *     ==========
 */
// Sawon 데이터형(사용자 정의 클래스(데이터형))
/*
 *     기본 데이터형: 메모리에 값 자체를 저장
 *     참조 데이터형: 여러개의 데이터가 저장되기 때문에 저장된 위치(주소, 번지)를 확인
 *     =========
 *       프로그래머가 직접 제작(같은 데이터형을 저장(배열)/다른 데이터형을 저장(클래스))
 *       
 *       영화: 제목, 출연, 감독
 *       
 *       Object obj=new A();
 *       double       int
 *       A a=new Object()
 *       int       double
 */
import java.util.*;
class Sawon
{
	private int sabun;
	private String name;
	private String dept;
	private String job;
	private int pay;                // 데이터형
	
	// 초기값(생성자 만들기) => 변경할 수 없다,  변경도 하고 생성자도 호출하기 위해선 getter/setter 해야 함
	public Sawon(int sabun, String name, String dept, String job, int pay) {
		super();
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
		this.job = job;
		this.pay = pay;
	}
	
	public void print()
	{
		System.out.println("사번:"+sabun);
		System.out.println("이름:"+name);
		System.out.println("부서:"+dept);
		System.out.println("직위:"+job);
		System.out.println("연봉:"+pay);
	}
	
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 사원 저장
		//Sawon sa1=new Sawon(1,"홍길동","개발부","대리",4000);
		//sa1.print();
		// 미리 Collection에 이런 데이터를 저장한다고 알려주면 => 데이터형이 Object인 것을 알려준 데이터형으로 변경
		ArrayList<Sawon> list=new ArrayList<Sawon>();  // Sawon[] 
		// => 데이터는 제어를 쉽게 하기 위해서 같은 종류만 모아야 함
		list.add(new Sawon(1, "홍길동1", "개발부", "대리", 4000));  //0
		list.add(new Sawon(2, "홍길동2", "영업부", "부장", 6000));  //1
		list.add(new Sawon(5, "홍길동5", "개발부", "사원", 3000));  //2
		list.add(new Sawon(6, "홍길동6", "총무부", "사원", 3000));  //3
		list.add(new Sawon(3, "홍길동3", "기획부", "사원", 3000));  //4
		list.add(new Sawon(4, "홍길동4", "자재부", "과장", 5000));  //5
		
		// 순서가 있다(인덱스 번호) => 저장된 순서, 중복된 데이터 첨부 가능
		// 출력
		for(Sawon s:list)
		{
			s.print();
			System.out.println("==============");
		}
		
		// 제네릭스 없을 때
		ArrayList list1=new ArrayList();
		list1.add(new Sawon(1, "홍길동1", "개발부", "대리", 4000));  //0
		list1.add(new Sawon(2, "홍길동2", "영업부", "부장", 6000));  //1
		
		for(Object o:list1)
		{
			Sawon s=(Sawon)o;
			s.print();
		}
		
		// 제네릭스 설정할 때 잘 해야 오류 안남
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("id", "admin");
		String id=map.get("id");
		System.out.println(id);
		
		HashMap map1=new HashMap();
		map1.put("id", "hong");
		id=(String)map1.get("id");
		System.out.println(id);
		id=map1.get("id").toString();
		System.out.println(id);
	}

}
