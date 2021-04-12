package com.sist.main;
/*
 *    복구(할 수 있으면 하면 됨)
 *    회피(시스템에 맡기면 됨) => 에러는 통과(복구할 수 없다)  throws
 *    전환 => 임의로 에러를 발생시킬 수 있다               throw 사용자 정의의 오류를 찾을 수 있다
 *                                               예외처리 호출 시 throw new ()
 *    
 *    프로그램 제작
 *    =========
 *       자바: 미국 => 한국(변경) => 사용자 정의
 */
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			String s=" 100";
			int i=Integer.parseInt(s);   // 문자열 -> 정수 변환
		}catch(NumberFormatException ex)
		{
			try
			{
				System.out.println("정수 변환 오류");
				throw new Exception(); // 예외처리 호출
				// throw => 사용자 정의 예외처리를 호출할 때 주로 사용
				// throw => 항상 {}내 맨 마지막 줄에 소스코딩을 해야 함
			}catch(Exception e) 
			{
				System.out.println("다시 입력하세요!!");  // 전환
			}

		}catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("배열 범위 초과");
		}catch(Exception ex)
		{
			    // 전환. 가입오류 5번 => 회원가입
		}
	}

}
