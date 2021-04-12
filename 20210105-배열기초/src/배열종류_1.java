/*
 *    �迭
 *     1. ������ �迭
 *        int[] arr={1,2,3,4,5}
 *        int[] arr=new int[5];
 *           == ===        == ������ ����
 *        �迭����,�迭��
 *        long[] arr=new long[];
 *        long[] arr={1L,2L,3L,4L,5L} => {1,2,3,4,5}  (21��4õ�� �Ѿ�� �ʴ� �� L �Ⱥٿ��� ��)
 *        long a=1   ==> a=1L
 *        long[] arr={'A','B','C'...}
 *        
 *        int[] arr=new int[5];  // 0,0,0,0,0
 *        long[] arr=new long[5];  // 0L,0L,0L,0L,0L
 *     2. �Ǽ��� �迭
 *        double[] arr={1.0, 2.0, 3.0...};
 *        float[] arr={1.0,2.0,3.0...};      (����)
 *        float[] arr={1.0F,2.0F,3.0F...};
 *        float f=10.5
 *                ==== double  
 *        double[] arr=new double[5];  // 0.0,0.0,0.0,0.0,0.0
 *        float[] arr=new float[5];  // 0.0f,0.0f,0.0f,0.0f,0.0f
 *     3. ������ �迭
 *        char[] arr={'A','B','C'...};
 *        char[] arr=new char[5];  // '\0','\0','\0','\0','\0'
 *     4. ���� �迭
 *        boolean[] arr={true,false,true...};
 *        boolean[] arr=new boolean[5];  // false,false,false,false,false
 *     5. ���ڿ� �迭
 *        String[] arr={"ȫ�浿","��û��","�ڹ���","�̼���","������"...};
 *        String[] arr=new String[5];  // null,null,null,null,null
 *           *** null: ��ü�� ���� ��
 */
import java.util.Scanner;
public class �迭����_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 3���� �л� => ����, ����, ���� ������ �Է¹޾Ƽ� ����, ���, ������ ���
		/*
		 *   �迭 => ���õ� �����͸� ��Ƽ� ����
		 */
		// ���� => 3��
		int[] kor=new int[3];
		int[] eng=new int[3];
		int[] math=new int[3];
		int[] total=new int[3];
		double[] avg=new double[3];
		char[] score=new char[3];
		
		// ��� ���� ���� => 3�� ��� ó��
		int[] rank=new int[3];
		
		// �Է�
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<3;i++)
		{
			System.out.print((i+1)+"��° �������� �Է�:");
			kor[i]=scan.nextInt();
			
			System.out.print((i+1)+"��° �������� �Է�:");
			eng[i]=scan.nextInt();
			
			System.out.print((i+1)+"��° �������� �Է�:");
			math[i]=scan.nextInt();
			
			// ����
			total[i]=kor[i]+eng[i]+math[i];
			//total[0],total[1],total[2]...
			
			// ���
			avg[i]=total[i]/3.0;
		}
		
		// ���� ���ϱ�
		for(int i=0;i<3;i++)
		{
			switch((int)(avg[i]/10))   // ����, ����, ���ڿ��� ����� �� ����
			{
			case 10:   // 100�� �̰ų�
			case 9:    // 90���� ���
				score[i]='A';   // ���� A�� �ְڴ�
				break;
			case 8:
				score[i]='B';
				break;
			case 7:
				score[i]='C';
				break;
			case 6:
				score[i]='D';
				break;
			default:
				score[i]='F';
			}
		}
		// ��� ���ϱ�
		for(int i=0;i<3;i++)
		{
			rank[i]=1;
			for(int j=0;j<3;j++)
			{
				if(total[i]<total[j])
				{
					rank[i]++;
				}
			}
		}
		
		// ���
		for(int i=0;i<3;i++)
		{
			System.out.printf("%d  %d  %d  %d  %.2f  %c  %d\n",   // ��� ����
					kor[i],eng[i],math[i],total[i],avg[i],score[i],rank[i]);   // �Է� ��
		}

	}

}
