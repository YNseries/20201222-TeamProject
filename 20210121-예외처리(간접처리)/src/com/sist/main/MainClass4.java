package com.sist.main;

public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			int a=10;
			if(a%2==0)
			{
				throw new MyException("홀수만 사용이 가능합니다");   // 이렇게 써야 catch를 수행
				// 사용자 정의 예외는 자바 시스템에서 찾지 못하기 때문에 직접 호출
				// System.out.println("홀수만 사용이 가능합니다"); 써도 되지만 
				// throws / try-catch냐 잘 생각해야함
			}
		}catch(NumberFormatException ex)
		{
			
		}catch(MyException m)
		{
			System.out.println(m.getMessage());
		}catch(Exception e)
		{
			
		}
	}

}
