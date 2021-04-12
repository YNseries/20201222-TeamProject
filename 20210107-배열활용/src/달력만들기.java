/*
 *   �ڹ� : �ʹݿ� �˰���(����)�� ��� => ���̺귯�� => ����(�⺻: �޼ҵ�)
 *              ==========
 *               => ���
 *   ==================================================
 *   ������(���� ���鼭 ����, �߰��� �����ؾ� ��), ������ ��ȣ(ĸ��ȭ)
 *   ==================================================
 *   ������ ���Ḧ �����ϴ� ���α׷�(����ó��)
 *   ==================================================
 *   
 *   1. ����ڰ� �⵵/�� �Է�
 *   2. ó�� => �޷� ���
 *      2-1. �ſ� 1������ ����Ȯ��
 *      2-2. �޷� ���
 */
import java.util.Scanner;
public class �޷¸���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. ����� �Է��� �޴´�
		Scanner scan=new Scanner(System.in);  // System.in => Ű���� �Է°��� �о���� ���
		// �⵵ �Է�
		System.out.print("�⵵ �Է�:");
		int year=scan.nextInt();
		System.out.print("�� �Է�:");
		int month=scan.nextInt();
		// ����ڰ� ��û�� ��/���� ���� �޷�
		// ���
		System.out.println(year+"�⵵ "+month+"��");
		System.out.println("\n");    // �� ��
		/*
		 * System.out.print("��\t"); System.out.print("��\t"); System.out.print("ȭ\t");
		 * System.out.print("��\t"); System.out.print("��\t"); System.out.print("��\t");
		 * System.out.print("��\t");
		 */
		String[] strWeek={"��","��","ȭ","��","��","��","��"};
		for(String week:strWeek)
		{
			System.out.print(week+"\t");   // �� ��ġ�� week�� �Ʒ���ġ�� week�� �ٸ�. ��������
		}
		System.out.println();   // �����ٿ� ���
		/*
		 *    2021.1
		 *    
		 *    => 1�� 1�� 1�� ~ 2020.12.31
		 *       ====================== +1 (�� ���� %7)
		 */
		// 1. ���⵵������ ��
		int total=(year-1)*365+(year-1)/4          // ���⵵�����ϱ� ���ظ� �����ϰ� ���� ��� �߰�
				              -(year-1)/100
				              +(year-1)/400;
		// 2. �� �ޱ����� ��
		/*
		 *    case 2:      // 2�����̸�
		 *       total+=31    // 31���� �߰��Ǿ��    
		 *    case 3:
		 *       total+=31+28
		 *     case 4:
		 *       total+=31+28+31      // => ������ �ϴ� �ͺ��� �迭�� �̿��ϴ� ���� ����!
		 */
		int[] lastday= {31,28,31,30,31,30,
				        31,31,30,31,30,31};
		if((year%4==0 && year%100!=0)||(year%400==0))   // ****��������**** 2�� =>29
			lastday[1]=29;
		else
			lastday[1]=28;
		
		for(int i=0;i<month-1;i++)  // �� ��, �������� ����ڰ� �Է��� ���̱� ������ 
		{
			total+=lastday[i];
		}                           // �̰� �� �ޱ����� �� ��
		
		// 3. +1
		total++;    // �� ���� 1���� Ȯ��
		int week=total%7;     // ����
		
		for(int i=1;i<=lastday[month-1];i++)
		{
			if(i==1)
			{
				for(int j=0;j<week;j++)
				{
					System.out.print("\t");     // ����(tab)
				}
			}
			System.out.printf("%2d\t",i);       // %2d: �� ĭ ����?
			week++;                             // ����ϱ��� ���ڰ� �Էµǰ� ������ �������� �ڵ� �ʿ���
			if(week>6)   // ����Ϻ��� Ŀ����
			{
				week=0;  // 0, �Ͽ��Ϸ� ������
				System.out.println();
			}
		}
		
	}

}
