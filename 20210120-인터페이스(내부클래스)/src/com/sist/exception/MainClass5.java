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
				}catch(Exception e) {}   // ����ó�� �׻� ������ ���ΰ� ���� �ʿ� x. ��ġ�� �߿�
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		System.out.println("���α׷� ����!!");
	}

}
