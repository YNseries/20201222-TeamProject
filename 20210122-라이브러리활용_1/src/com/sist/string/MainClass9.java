package com.sist.string;
/*
 *   equals(): 문자열이 같은지 확인(대소문자 구분)
 *     리턴형: boolean
 *     매개변수: String
 *     원형: public boolean equals(String str)
 *   equalsIgnoreCase(): 문자열이 같은지 확인(대소문자 구분 없이)
 *     리턴형: boolean
 *     매개변수: String
 *     원형: public boolean equalsIgnoreCase(String str)
 *     
 *     ### 자바에서는 문자열("") 자체가 주소
 *     String s="Hello";
 *     s.equals("Hello")
 *     "Hello".equals(s)
 *     
 *     ### 문자열 생성
 *     String s="Hello"; => {'H','e','l','l','o'}
 *     String s=new String("Hello");
 *     
 *     => 찾기, 오버라이딩, 조립
 */
public class MainClass9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 같은 문자열이면 String은 같은 주소를 가지고 있다
		String s1="Java";
		String s2="Java";
		String s3=new String("JAVA");  // 새로운 메모리에 저장되었기 때문에 위(s1,s2)와 다름.

		if(s1==s2)
			System.out.println("같다");
		else
			System.out.println("다르다");
		
		if(s1==s3)
			System.out.println("같다");
		else
			System.out.println("다르다");
		
		// 주소를 비교하는 것이 아니라 실제 값을 비교!
		if(s1.equals(s2))
			System.out.println("문자열이 동일");
		else
			System.out.println("동일하지 않다");
		
		if(s1.equals(s3))
			System.out.println("문자열이 동일");
		else
			System.out.println("동일하지 않다");
		
		// 대소문자 구분 없이 비교
		if(s1.equalsIgnoreCase(s3))
			System.out.println("문자열이 동일");
		else
			System.out.println("동일하지 않다");
		

	}

}
