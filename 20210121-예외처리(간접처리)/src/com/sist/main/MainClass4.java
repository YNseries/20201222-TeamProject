package com.sist.main;

public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			int a=10;
			if(a%2==0)
			{
				throw new MyException("Ȧ���� ����� �����մϴ�");   // �̷��� ��� catch�� ����
				// ����� ���� ���ܴ� �ڹ� �ý��ۿ��� ã�� ���ϱ� ������ ���� ȣ��
				// System.out.println("Ȧ���� ����� �����մϴ�"); �ᵵ ������ 
				// throws / try-catch�� �� �����ؾ���
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
