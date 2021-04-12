/*	 
 *   ����
 *     �⺻�� ������
 *     ==========================================================
 *     	  	  1byte		2byte		4byte		8byte
 *     ==========================================================
 *     ����	   byte		short		int			long
 *     							   default
 *     							   System.out.println(100)
 *     												 ===== ��ǻ�Ϳ����� int�� �ν�
 *     							   => int�� long ���� ==> l(L) ��) long�����͸� ��� 100L
 *     ==========================================================
 *     �Ǽ�	 						float		double
 *     											default
 *     											System.out.println(100.5)
 *     															  ======= ��ǻ�ʹ� double�� �ν�
 *     								=> float�� double ���� ==> f(F)
 *     								��) 10.5F,  10.5
 *     ==========================================================
 *     ����				 char
 *     					���� 1���� ���� ���� ==> ''
 *     ==========================================================
 *     ��	   boolean	�׻� ����ÿ� true/false�� ������ ����
 *     ==========================================================
 */
public class ����_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���� ����
		// ����(4byte)�� 100���� ����
		int x = 100; // �ʱⰪ
		System.out.println("x="+x); // ���ڿ� ���� "Hello" +"Java" => "HelloJava" �ٿ������ ���
		// �������� 5��ŭ �̵�
		x = 95;
		System.out.println("x="+x); // x=95
		x = 90;
		// ������ ���� ���� (����=> ĳ���Ͱ� �̵� => x,y)
		// ����� ���� ���
		System.out.println("x="+x); // x= 90
		
		char c='A';
		// 'A'�� ���� => 'A'�� 'B'�� �ٲ۴�
		c= 'B'; // c��� �޸� �������� ���� ���� ����ȴ�
		System.out.println("c="+c);
		// ������ �ݵ�� �ʱⰪ�� �����ؾ� �Ѵ�.
		// 4byte ������ 3���� ����� 100, 200, 300�� ����
		//int a = 100;
		//int b = 200;
		//int d = 300;
		int a=100, b=200, d=300;
		/*	 
		 * 	 1. ����(��������)
		 * 		= ����� ���ÿ� �ʱⰪ�� ����
		 * 		  int a=100;  // default 
		 * 		= ������ �ϰ� ���߿� �ʱⰪ�� ����
		 * 		  int=a;	//�Է°��� �ްų� �ܺο��� �����͸� ����� ��, �����߻�
		 * 		  a=100;
		 */
		int k;
		k=500;
		// ������ �����͸� ���
		System.out.println("a="+a+",b="+b+",d="+d+",k="+k);
		
		// �Ǽ�
		float f=10.9f; // float f=(float)10.9; => �� ��ȯ
		// UP Casting (�������� Ŀ����), DOWN Casting (�������� �۾�����)
		// ���α׷��� ��������� (���� ��� => �����ڸ��� �ҽ��ڵ��� �ٸ���)
		double q=10.9;
		
		// ���
		double w=100;
		// 100 => �ڵ����� 100.0
		int u = 'A'; // u='A'(X) u=65 // A�� ������ ���� ������ �׿� �´� ���ڷ� �ٲ� ��.
		System.out.println("u="+u);
		System.out.println("w="+w);
		// ���� ����ÿ��� ���ʿ� �ִ� ���������� �����ϴ� ������ �׻� ũ�ų� ���ƾ� �Ѵ�
		/*
		 * 		���������� ũ��
		 * 		===========
		 * 		byte < short, char < int < long < float < boolean
		 * 		�������ٴ� �Ǽ��� ũ��
		 * 		= �޸� ũ��� �����ϴ��� ���� �ƴ϶� ���ڸ� ǥ���� �� �ִ� ����
		 * 		  1
		 * 		  1.00000
		 * 		  1.0000000000000
		 */
		System.out.println("byte�� �ּҰ�:"+Byte.MIN_VALUE);
		System.out.println("byte�� �ִ밪:"+Byte.MAX_VALUE);
		
		System.out.println("int�� �ּҰ�:"+Integer.MIN_VALUE);
		System.out.println("int�� �ִ밪:"+Integer.MAX_VALUE);
		
		System.out.println("long�� �ּҰ�:"+Long.MIN_VALUE);
		System.out.println("long�� �ִ밪:"+Long.MAX_VALUE);
	}

}
