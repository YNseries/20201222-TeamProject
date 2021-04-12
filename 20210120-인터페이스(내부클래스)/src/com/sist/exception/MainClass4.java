package com.sist.exception;
/*
 *    에러 메세지 확인
 *      getMessage(): 에러 정보만 출력
 *      printStack(): 실행하는 과정 => 에러난 위치 지정한다
 */
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			System.out.println("연산처리");
			System.out.println(10/0);
		}catch(Exception ex)
		{
			// System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		System.out.println("프로그램 종료");
	}

}
