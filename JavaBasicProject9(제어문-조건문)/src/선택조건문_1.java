/*
 *     ����)
 *         if(���ǹ�) => ���ǹ�(������, ����, ��, ��)
 *         {
 *             ���ǹ��� true�϶� ó���ϴ� ����
 *             (���� ������ ������ �� �ִ�)
 *         }
 *         else
 *         {
 *             ���ǹ��� false�϶� ó���ϴ� ����
 *             (���� ������ ������ �� �ִ�)
 *         }
 *         
 *      ����)
 *          if(���ǹ�)
 *            ���๮��1
 *            ���๮��2    => {}�� ���� ������ �ݵ�� ������ �Ǿ� else�� ������� ����
 *          else      ====> if �ؿ��� ó��(else�� �ܵ����� ���๮���� ���� �� ���� 
 *            ���๮��3
 *         
 */
// 3���� ������ �Է� => ��� ==> 60�̻��� Pass �ƴϸ� Non-Pass
import java.util.Scanner;
public class �������ǹ�_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �Է¹��� �����͸� ������ ������ �ʿ� => ���� 4(����3,���1 => 60���̶�� ������ �������� ���x)
		int kor,eng,math,avg;
		Scanner scan=new Scanner(System.in);
		// ����ڰ� �Է� : ����
		System.out.println("���� ���� ���� ���� �Է�:"); // enter || space
		kor=scan.nextInt();
		eng=scan.nextInt();
		math=scan.nextInt();		
		
		/* System.out.print("���� ���� �Է�:");
		kor=scan.nextInt();
		
		System.out.print("���� ���� �Է�:");
		eng=scan.nextInt();
		
		System.out.print("���� ���� �Է�:");
		math=scan.nextInt();
		*/
		
		// ��� => ����(������
		avg=(kor+eng+math)/3; // ����/����=���� (�Ҽ��� ���ŵ�)
		
		// ������� ���
		if(avg>=60)
			System.out.println("Pass");
		else
			System.out.println("Non-Pass");
		
		
	
}
}
