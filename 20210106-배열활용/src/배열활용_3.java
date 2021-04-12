/*
 *   선택정렬
 *   =====
 *     30  20  50  10  40   i=0 (1차 for문) j=1~4
 *     ==  ==============  
 *                     
 *         ==  ==========   i=1일 떄, j=2~4(3바퀴)
 *         
 *             ==  ======   i=2일 떄, j=3~4(2바퀴)
 *             
 *                 ==  ==   i=3일 떄, j=4  (1바퀴)
 *                          ===
 *                          arr.length-1
 *     i    j(s)  j(e)
 *     0     1     4
 *     1     2     4
 *     2     3     4
 *     3     4     4
 *     
 *     i=j-1  => j=i+1  j=4  : i+1 ~ 4까지 간다는 말. (= arr.length)
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
public class 배열활용_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {30, 20, 50, 10, 40};  // 정렬
		System.out.println("===== 정렬 전 =====");
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		System.out.println("\n===== 정렬 후 =====");
		/*
		 *    int a=10;
		 *    int b=20;
		 *    
		 *    a=b;  // a=20
		 *    b=a;  // b=20     => 이렇게 저장하면 안됨. 교체가 아니라 바뀌기 때문
		 *    
		 *    int temp=a;  // temp=10     => 이렇게 임시 변수를 만들어 저장해야 함
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
			System.out.println((i+1)+"Round 종료");
			
		}
		// 최종
		for(int i:arr)
		{
			System.out.print(i+" ");   // 최종으로 정렬된 순간 나옴.
		}

	}

}
