package com.sist.main;
/*
 *    ����(�� �� ������ �ϸ� ��)
 *    ȸ��(�ý��ۿ� �ñ�� ��) => ������ ���(������ �� ����)  throws
 *    ��ȯ => ���Ƿ� ������ �߻���ų �� �ִ�               throw ����� ������ ������ ã�� �� �ִ�
 *                                               ����ó�� ȣ�� �� throw new ()
 *    
 *    ���α׷� ����
 *    =========
 *       �ڹ�: �̱� => �ѱ�(����) => ����� ����
 */
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			String s=" 100";
			int i=Integer.parseInt(s);   // ���ڿ� -> ���� ��ȯ
		}catch(NumberFormatException ex)
		{
			try
			{
				System.out.println("���� ��ȯ ����");
				throw new Exception(); // ����ó�� ȣ��
				// throw => ����� ���� ����ó���� ȣ���� �� �ַ� ���
				// throw => �׻� {}�� �� ������ �ٿ� �ҽ��ڵ��� �ؾ� ��
			}catch(Exception e) 
			{
				System.out.println("�ٽ� �Է��ϼ���!!");  // ��ȯ
			}

		}catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("�迭 ���� �ʰ�");
		}catch(Exception ex)
		{
			    // ��ȯ. ���Կ��� 5�� => ȸ������
		}
	}

}
