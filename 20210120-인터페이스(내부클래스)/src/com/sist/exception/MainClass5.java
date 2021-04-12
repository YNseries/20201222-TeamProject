package com.sist.exception;

public class MainClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10,20,30,20,0,10,20,30,40,50};
		int a=100;
		try
		{
			for(int b:arr)
			{
				try
				{
					System.out.println(a/b);
				}catch(Exception e) {}   // 예외처리 항상 모든것을 감싸게 만들 필요 x. 위치가 중요
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		System.out.println("프로그램 종료!!");
	}

}
