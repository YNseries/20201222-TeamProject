/*
 *    for
 *    1. ���ó=> �ݺ� Ƚ���� ������ ��쿡 �ַ� ���
 *    2. while, do~while(1��)�� �޸� for���� 2������ �ؾ���
 *    3. for���� ����
 *       3-1. �Ϲ� for    false => ����
 *                 ��  ��  ��  ��  ��
 *            for(�ʱⰪ;���ǽ�;������)
 *            {          �� true
 *                       ��     ��
 *                    �ݺ����๮��
 *            }
 *            
 *            �������
 *              �ʱⰪ => ���ǽ�(���ǰ˻�)              �� (���ǽ����� �̵�)
 *                       = true  : => �ݺ����๮�� => �ʱⰪ�� ����(����/����)
 *                       = false : for���� ���� 
 *       
 *       3-2. ���� for(JDK1.5�̻�) => web���� �ַ� ���(forEach����)
 *            =========
 *            1. �迭(������), 2. �÷���(2��)�� �־�� ��� ���� 
 *           
 */
public class �ݺ���_for {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Ȧ���� ��, ¦���� ��
		for(int i=1; i<=10; i++) {
			// ���� 10�� ���
			/* if(i%2==1)
				System.out.print("��"); // i�� Ȧ���� ���
			else
				System.out.print("��"); // i�� ¦���� ��� */
		
			if(i%3==0)
				System.out.print("��");
			else
				System.out.print("��");
		}

	}

}
