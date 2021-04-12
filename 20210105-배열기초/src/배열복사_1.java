/*
 *    �迭�� ����
 *       �Ѱ��� ����
 *       ���̺귯�� �̿�=> arraycopy()
 *    ���� for
 */
public class �迭����_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10,20,30,40,50};   // �迭 => �������
		// ū �迭�� ����
		int[] temp=new int[10];
		// �������� ���
		for(int i=0;i<arr.length;i++)
		{
			temp[i]=arr[i];
		}
		/*
		 *    =====================
		 *      10  20  30  40  50   ==> arr
		 *    =====================
		 *    =====================================
		 *      10  20  30  40  50  0  0  0  0  0     ==> temp
		 *    =====================================
		 */
		// ���
		for(int i:temp)  // for-Each, ���� for��  => ����� �� �ַ� ���
		{
			// i=10, i=20  ==> tmep�� ���޿� ���� �����Ͱ��� �޾ƿ´�(���⼭ i�� �ε��� ��ȣ�� �ƴ�)
			System.out.print(i+" ");
		}
		// �����
		System.out.println("\n======== forEach ==========");  // JDK1.5 �̻�, ���� �������� ����, ��´��
		
		// �ݵ�� �迭, �÷���(�����Ͱ� ����� �־�� ����)
		char[] alpha= {'A','B','C','D','E'};
		System.out.println("����� �������� ����:"+alpha.length);
		System.out.println("ù��° ����� ������:"+alpha[0]);
		System.out.println("������ ����� ������:"+alpha[alpha.length-1]);
		
		// ��ü ������ ���
		/*
		 * for(int i=0;i<alpha.length;i++) 
		 * { alpha[0]='K'; // �ε��� ��ȣ�� ������� ���̱� ������ ���� �ٲ� �� ���� 
		 * System.out.println(alpha[i]); }
		 */
		
		System.out.println("=====���� for(forEach)=====");
		for(char c:alpha)
		{
			c='K';          // �ε��� ��ȣ�� �ƴ϶� ���� ���� �ٲ� �� ����
			System.out.println(c);
		}
		
		System.out.println("=====���� for(forEach)=====");
		for(char c:alpha)
		{
			System.out.println(c);
		}

	}

}
