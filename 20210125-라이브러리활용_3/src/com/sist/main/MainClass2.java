package com.sist.main;
import java.util.*;
import java.text.*;
/*class A
{
	private static A a=null;
	public static A getInstance()
	{
		if(a==null)
			a=new A();   // a�� null �̸� ����
		return a;        // �ƴϸ� �׳� ��
	}
}*/
/*
 *    year/day�� ������� �״�� ��������� �ȴ�
 *    month => 1~12�� ���� ��. ������ ������ �� month-1 �ؾ���
 *    week => DAY_OF_WEEK ==> 1~7 -1 �迭(0���� �����ϴϱ�) ���ư� �� ����
 *    
 *    getActualMaximum(): �� ���� ������ ��¥�� �о�´�
 *    set(): ��¥ ����
 *    get(): ������ ��¥ �о�´�
 */
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar cal=Calendar.getInstance();  // �̱���(static)
		/*
		 * A a=A.getInstance(); System.out.println("a="+a); A b=A.getInstance();
		 * System.out.println("b="+b); // �������� �����ص� ���� �ּҰ��� ���� �� = �̱��� 
		 * A c=A.getInstance(); System.out.println("c="+c);
		 */
		/* Scanner scan=new Scanner(System.in);
		System.out.print("�⵵ �Է�:");
		int year=scan.nextInt();
		System.out.print("�� �Է�:");
		int month=scan.nextInt();
		System.out.print("�� �Է�:");
		int day=scan.nextInt();
		
		cal.set(Calendar.YEAR, year);  // ����
		cal.set(Calendar.MONTH, month-1);  // (0~11) 1��-0, 2��-1, 3��-2, ...
		cal.set(Calendar.DATE, day);
		
		int week=cal.get(Calendar.DAY_OF_WEEK)-1;  // 1~7 -1  => 0~6
		int lastday=cal.getActualMaximum(Calendar.DATE);   // ������ ��¥ �����
		System.out.println(lastday);
		String[] strWeek= {"��","��","ȭ","��","��","��","��"};
		//int week=cal.get(Calendar.DAY_OF_WEEK);
		//String[] strWeek= {"","��","��","ȭ","��","��","��","��"}; �̷��� 0�� ���ֱ� ���� ������ �־��൵ ��
		
		String msg=String.format("%d�⵵ %d�� %d�� %s�����Դϴ�", cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH)+1,cal.get(Calendar.DATE),strWeek[week]);  // ������ �� �������
		//              ================= ����� ���� 1�� �پ�� �����̱� ������ +1 ����� ��
		System.out.println(msg); */
		
		Date date=new Date();  // �ý����� ��¥(�ð�) ==> ����Ŭ ����ÿ� ���
		System.out.println(date);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  // ���ϴ� �������� �ٲ�
		System.out.println(sdf.format(date));
	}

}
