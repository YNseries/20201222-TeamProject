/*
 *   ��������
 *   =====
 *     30  20  50  10  40   i=0 (1�� for��) j=1~4
 *     ==  ==============  
 *                     
 *         ==  ==========   i=1�� ��, j=2~4(3����)
 *         
 *             ==  ======   i=2�� ��, j=3~4(2����)
 *             
 *                 ==  ==   i=3�� ��, j=4  (1����)
 *                          ===
 *                          arr.length-1
 *     i    j(s)  j(e)
 *     0     1     4
 *     1     2     4
 *     2     3     4
 *     3     4     4
 *     
 *     i=j-1  => j=i+1  j=4  : i+1 ~ 4���� ���ٴ� ��. (= arr.length)
 *     for(int i=0;i<arr.length-1;i++)
 *     {          // ============= 3
 *         for(int j=i+1;j<arr.length;j++)
 *         {         //    ========== 4
 *         
 *         }
 *     }
 *     
 *     
 */ 
public class �迭Ȱ��_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {30, 20, 50, 10, 40};  // ����
		System.out.println("===== ���� �� =====");
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		System.out.println("\n===== ���� �� =====");
		/*
		 *    int a=10;
		 *    int b=20;
		 *    
		 *    a=b;  // a=20
		 *    b=a;  // b=20     => �̷��� �����ϸ� �ȵ�. ��ü�� �ƴ϶� �ٲ�� ����
		 *    
		 *    int temp=a;  // temp=10     => �̷��� �ӽ� ������ ����� �����ؾ� ��
		 *    a=b;         // a=20
		 *    b=temp;      // b=10
		 */
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
				for(int k:arr)
				{
					System.out.print(k+" ");
				}
				System.out.println();
			}
			System.out.println((i+1)+"Round ����");
			
		}
		// ����
		for(int i:arr)
		{
			System.out.print(i+" ");   // �������� ���ĵ� ���� ����.
		}

	}

}
