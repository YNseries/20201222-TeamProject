/*
 *    ��������(sort) : ������ �� ���� ���ؼ� ����
 *    i=0�� �� j=0 ~ 4
 *    i=1�� �� j=0 ~ 3
 *    i=2�� �� j=0 ~ 2
 *    i=3�� �� j=0 ~ 1
 *            ===
 *            
 *            i+j=4  ==> j=4-i
 *    
 *    30  20  50  10  40
 *    ==  ==
 *        ==  ==
 *            ==   ==
 *                 ==  ==
 */
public class �迭Ȱ��_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {30, 20, 50, 10, 40};  // ����
		System.out.println("===== ���� �� =====");
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		System.out.println("\n===== ���� �� =====");
		for(int i=0;i<arr.length-1;i++)    // 4���� ����
		{
			for(int j=0;j<arr.length-1-i;j++)  // ���⼭ 
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
				for(int k:arr)
				{
					System.out.print(k+" ");
				}
				System.out.println();
			}
			System.out.println("=== "+(i+1)+" Round End ===");
		}
		System.out.println("===== ������� =====");
		for(int k:arr)
		{
			System.out.print(k+" ");
		}
	}

}
