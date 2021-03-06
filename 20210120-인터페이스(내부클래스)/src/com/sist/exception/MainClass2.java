package com.sist.exception;

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1번 문장");
		System.out.println("2번 문장");   // 정상수행
		try
		{
			System.out.println("3번 문장");
			System.out.println(10/0);  // 에러 발생 ==> catch로 이동
			System.out.println("5번 문장");  // 문제가 없다면 catch를 건너뛴다
			
			// 정상으로 수행할 수 있는 문장 => 만약 에러가 발생하면 => 처리하는 영역 => catch
		}catch(Exception ex) 
		{
			System.out.println("6번 문장");  // 에러 복구위치 => catch는 여러번 사용이 가능
			// 에러를 예측한 만큼 사용이 가능
		}
		System.out.println("7번 문장");
		// 1 2 3 4 5 => 7 정상수행
		// 1 2 3 6   => 6 에러 건너뜀
	}

}
