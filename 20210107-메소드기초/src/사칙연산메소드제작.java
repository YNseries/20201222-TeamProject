import java.util.Scanner;
/*
 *    ����ó���ϴ� �޼ҵ带 �����
 *    +
 *    -
 *    *
 *    /
 *    ===> �� �� ������ �޼ҵ�� ����ȭ �ϴ°� ����
 *    
 */
public class ��Ģ����޼ҵ����� {

	// +
	static int plus(int a,int b)
	{
		return a+b;
	}
	// -
	static int minus(int a,int b)
	{
		return a-b;
	}
	// *
	static int multi(int a, int b)
	{
		return a*b;
	}
	// /
	static double div(int a,int b)     // 0�� ������ �� ������ ������ ������ string�� �ִ°� �����ž�
	{
		return a/(double)b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �޼ҵ� ȣ��
		Scanner scan=new Scanner(System.in);
		System.out.print("ù��° ���� �Է�:");
		int a=scan.nextInt();   // nextInt�� ���콺 �ø��� int����.
		System.out.print("�ι�° ���� �Է�:");
		int b=scan.nextInt();
		System.out.print("������ �Է�(+,-,*,/):");
		String op=scan.next();   // next�� ���콺 �÷����� string���� ���� �� �� ����. ������ string���� �޴� ��.
		
		int c=0;
		switch(op)
		{
			case "+":
				c=plus(a,b);    //�Լ����� �ְ� a,b�� �Է¹����� c�� ������� ������
				System.out.printf("%d+%d=%d\n",a,b,c);
				break;
			case "-":
				c=minus(a,b);
				System.out.printf("%d-%d=%d\n",a,b,c);
				break;
			case "*":
				c=multi(a,b);
				System.out.printf("%d*%d=%d\n",a,b,c);
				break;
			case "/":
				if(b==0)
					System.out.println("0���� ���� �� �����ϴ�");
				else   // �� ������ �����ϱ� ������ {} ��� ��
				{
					double d=div(a,b);
					System.out.printf("%d/%d=%.2f\n",a,b,d);
				}
				break;
			default:
				System.out.println("�߸��� �������Դϴ�");
		}
	}

}
