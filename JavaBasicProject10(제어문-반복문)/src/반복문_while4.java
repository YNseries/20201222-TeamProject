// while : �ݺ�Ƚ���� ���� ��쿡 �ַ� ���
// Up-Down ����
/*
 *     ���� : ���� (1~100 ������ ���� �߻�)
 *           ======================== ���ߴ� ����
 *           ��Ʈ : up, down
 *           ���� : 70
 *           ����� �Է� : 80 ==> DOWN
 *           ����� �Է� : 65 ==> UP
 *     
 *     ���� ����
 *     =======
 *     1. ���� �߻� => �޸𸮿� ����
 *     2. ����ڰ� �Է�
 *     3. ������ ����� �Է°� ��
 *     4. ��Ʈ
 *     5. ���Ῡ�� Ȯ�� => true ==> ���� ����
 *                      false ==> 2������ �̵�
 */
// ����� �Է°��� �ޱ�
import java.util.Scanner;
public class �ݺ���_while4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 1~100 ������ ���� �� ���� ���� (������ ���� = ����)
		int com=(int)(Math.random()*100)+1;
		/*
		 *    1. (Math.random()*100) ==> 0.0~0.99 ==> 0.0~99.0
		 *    2. (int) 0.0~99.0 ==> int ==> 0~99
		 *    3. +1 ==> 1~100
		 */
		// ����� �Է� => ���� ���⶧����
		Scanner scan=new Scanner(System.in);
		while(true)  // ���ѷ���
		{
			// 1. ����� �Է°��� �޴´�
			System.out.print("1~100 ������ ���� �Է�:");
			//    ����� �Է°� ����
			int user=scan.nextInt();
			// 2. ������ �Է� ��
			
			// 3. ��Ʈ
			// 4. ����
			if(com>user)
			{
				System.out.println("�Է°����� ū ���� �Է��ϼ���");  // UP
			}
			else if(com<user)
			{
				System.out.println("�Է°����� ���� ���� �Է��ϼ���");  // DOWN
			}
			else
			{
				//com==user
				System.out.println("Game Over!!");
				//���α׷� ����
				System.exit(0);  // ���� �����Ѵ�. �̰� �Ժη� ���� �ȵ�. �ؿ��� ���ᰡ �Ұ����� ���°� ������
				// break;  // ���� �Ȱ���. ������ break ��������� �ȹ���� ���� ���� ������
			}
			
		}
		// System.out.println("���α׷� ����");

	}

}
