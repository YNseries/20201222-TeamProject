package com.sist.string;
/*
 *    스트링 클래스
 *    =========
 *       char[]을 제어하는 프로그램
 *       String => 클래스
 *              => 문자열을 저장
 *              => 문자열을 쉽게 제어가 가능하게 만든 클래스
 *              => 문자열을 저장하는 일반 데이터형으로 사용이 가능
 *                 ***String name="";
 *                 String name=new String();  // 메모리 할당
 *       String 클래스는 Call By Reference를 사용할 수 없다(일반 데이터형처럼 사용. String이 유일)
 *       
 *       => 메소드 호출하는 방식
 *          1) 값만 전송하는 방식(Call By Value) => 메모리를 따로 생기게 함(= 복사본. 원형엔 영향x). 기본 데이터형(int a, int b)
 *          2) 주소를 전송하는 방식(Call By Reference) => 본인의 주소를 넘김(배열, 클래스) A a => String은 예외 조건
 *       => 클래스와 클래스 연결할 때 => 반드시 메소드 호출!
 *       
 *       String에서 기능
 *       ============
 *       문자열 변환                                                   (return형)
 *         = 대문자 변경: toUpperCase() => "aaa".toUpperCase() => "AAA" (String)
 *         = 소문자 변경: toLowercase()                        =>       (String) 
 *         = 공백문자 제거: 좌우의 공백만 제거 => trim()   " aaa ".trim() => "aaa" (String)
 *         = 문자열 결합: concat() => 빈도가 작다 (+)
 *                    "Hello".concat("Java") ==> "HelloJava" =>       (String)
 *                    원래는 "Hello"+"Java" 했었지
 *       문자열 제어
 *         ###### 모든 문자열은 시작 번호가 0번부터 시작한다
 *         "Hello Java"
 *          0123456789   ==> length(): 10 (공백 포함해야 함)
 *         = 문자열 길이: length()
 *         = 문자 한 개를 가지고 온다: charAt()  => charAt(6)
 *         ===============================
 *         = 시작 문자열: startsWith()
 *         = 끝나는 문자열: endsWith()
 *         =============================== 검색기 제작
 *         = 포함문자: contains() : 추천
 *         "hello" "Hello" => ID, Password
 *         = 문자비교: equals(): 대소문자 구분(다르면 틀림), equalsIgnoreCase(): 대소문자 구분 없이 비교
 *           "Hell.o.java"
 *         = 문자 위치찾기: indexOf() => l.o: 처음(.), lastIndexOf() => o.java: 마지막에 있는 문자(.)
 *         = 문자변환: replace: 한 글자, replaceAll: 정규식
 *           "abcAbc1234한글" => replaceAll("[^0-9]","") = 숫자를 제외하고 나머지 지워 => "1234"
 *           숫자  [0-9]
 *           알파벳 [A-Z]대문자 + [a-z]소문자 = [A-Za-z]알파벳 전체
 *           한글  [가-힣]
 *           
 *           "red,green,blue,yellow,black"
 *         = 문자분해
 *           = split: 구분자별로 배열에 저장
 *           = substring: 문자의 위치 지정
 *         = 객체를 문자 변환: toString()
 *         = 모든 데이터형을 문자열로 변환 => valueOf()
 *         = 문자 크기 비교(정렬): "ABC" "ACD" compareTo() int => 같다(0), 왼쪽이크다(1), 오른쪽이크다(-1)
 *           "aaa".compareTo("aaa")
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="hello";
		String s=str.toUpperCase();   // s가 바뀐거지, str은 그대로 있음
		String s1=str.toLowerCase();
		System.out.println(str);
		System.out.println(s);
		String s2=str.concat("Java");  // s2가 바뀐거지 str이 바뀐거 아님! 잊지마
		System.out.println(s2);
		System.out.println(str);

	}

}
