// Scanner : Ű���� �Է°��� �޾Ƽ� �޸𸮿� ����
// BufferedReader : �ݵ�� ����ó�� ���� �� ��� ��
// Scanner�� ����ϱ� ���ؼ��� �ݵ�� Ŭ������ �ҷ��;� ��
// �̹� ������� Ŭ������ �о�� �� ��� : import
import java.util.Scanner;

import javax.swing.JOptionPane;
/*
 *    import : Java
 *    include : C
 *    using : C#
 *    Kotlin : import (Java)
 */
public class ����_4 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner�� ����ϴ� ���
		Scanner scan=new Scanner (System.in); // Scanner ������ �ؾ���
		// new => �޸� �Ҵ�, System.in => Ű���� �Է°�
		// System.out.print("���� �Է�:");
		// Ű����� �Է��� ������ �����Ѵ�
		// int input = scan.nextInt();
		// System.out.println("Ű���� �Է°�:"+input);
		int kor,eng,math;
		System.out.print("���� ���� �Է�:");
		kor=scan.nextInt();
		System.out.print("���� ���� �Է�:");
		eng=scan.nextInt();
		System.out.print("���� ���� �Է�:");
		math=scan.nextInt();
		
		// ������� ��� (����) => ������
		System.out.println("����:"+(kor+eng+math));
		System.out.printf("���:%.2f",(kor+eng+math)/3.0);
		// ����ڷκ��� �Է°��� �޾Ƽ� ó��. Scanner
		// �ʱⰪ => ���Ƿ� ���� int kor=80, �Է°��� �޾Ƽ� ��� Scanner, ���� 
		// JOptionPane.showInputDialog("�����Է�");
		
		/*   1. ���
		 * 
		 * 		= System.out.println => \n ���� (�����ٷ� �ѱ�� ��) (�⺻)
		 * 		= System.out.print => \n ������
		 * 		= System.out.printf => ������ �ʿ��� �� (�Ҽ���ó�� ��..)
		 * 
		 * 	 2. �Է�
		 * 
		 * 		Scanner => Ű���� �Է°��� �޴� ��쿡 �ַ� ���
		 * 		// Scanner => Ŭ����
		 *  	= import java.util.Scanner
		 *  	= Scanner�� ����
		 *  	  *** Ŭ������ ������ �ÿ��� �ݵ�� new�� ����ؼ� ����
		 *  	Scanner scan=new Scanner(system.in)
		 *  	= �Է��� �Ǹ�
		 *  	  **scan.nextInt() => ������ �Է����� ��
		 *  	  **scan.next()    => ���ڿ��� �Է����� ��
		 *  	  scan.nextDouble()  => �Ǽ��� �Է����� ��
		 *  	  scan.nextBoolean() => true/false
		 */
		
	}

}
