/*
 *  ���ڸ��� ����(10~99) �Է¹ް�,
 *  10���ڸ��� 1���ڸ��� ������ �Ǻ��Ͽ� ����ϴ� ���α׷� ���
 */

import java.util.Scanner;
public class ����15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int input;  // �� ��ġ���� ����Ǿ�� ��ü������ �� �� ����
		while(true)
		{
			System.out.print("���ڸ� ������ �Է��ϼ���(10~99):");
			input=scan.nextInt();
			if(input<10 || input>99)
			{
				System.out.println("�߸��� �Է��Դϴ�!!");
				continue;  // while�� ù��° ��� �̵� (���ǽ�)
			}
			break; //���������� �Է��� �ƴٸ� while�� ����
		}
		
		//  78/10=7   78%10=8
		int a=input/10;
		int b=input%10;
		
		if(a==b)
		{
			System.out.println("Yes!");
		}
		else
		{
			System.out.println("No!");
		}
		

	}

}
