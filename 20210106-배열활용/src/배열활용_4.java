/*
 *    버블정렬(sort) : 인접한 수 끼리 비교해서 변경
 *    i=0일 떄 j=0 ~ 4
 *    i=1일 때 j=0 ~ 3
 *    i=2일 때 j=0 ~ 2
 *    i=3일 때 j=0 ~ 1
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
public class 배열활용_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {30, 20, 50, 10, 40};  // 정렬
		System.out.println("===== 정렬 전 =====");
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		System.out.println("\n===== 정렬 후 =====");
		for(int i=0;i<arr.length-1;i++)    // 4바퀴 돌려
		{
			for(int j=0;j<arr.length-1-i;j++)  // 여기서 
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
		System.out.println("===== 최종결과 =====");
		for(int k:arr)
		{
			System.out.print(k+" ");
		}
	}

}
