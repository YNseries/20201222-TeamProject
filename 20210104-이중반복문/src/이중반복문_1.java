/*
 *    ★
 *    ★★
 *    ★★★
 *    ★★★★
 *    =================================
 *       i  j
 *      줄수 별표
 *      1    1    i=j   ==>   j=i
 *      2    2
 *      3    3
 *      4    4
 *      
 *    ★★★★
 *    ★★★
 *    ★★
 *    ★
 *    ===============================
 *       i  j
 *      줄수 별표
 *      1  +  4  = 5
 *      2  +  3  = 5
 *      3  +  2  = 5
 *      4  +  1  = 5  ==> 역순 +
 *      i+j=5  ==> j=5-i
 *      
 *      ★★★★★★★★★★
 *      ★★★★★★★★★★
 *      ★★★★★★★★★★
 *      ★★★★★★★★★★
 *      ★★★★★★★★★★
 *      
 *      abcd
 *      efgh
 *      ihkl
 *      mnop
 *      
 *      abcd
 *      abcd
 *      abcd
 *      abcd
 */
public class 이중반복문_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* for(int i=1;i<=4;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print("★");
			}
			// 다음줄로 이동
			System.out.println();
		}*/
		
		
		/* for(int i=1;i<=4;i++)
		{
			for(int j=1;j<=5-i;j++)
			{
				System.out.print("★");
			}
			System.out.println();
		}*/
		
		
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=10;j++)
			{
				System.out.print("★");
			}
			System.out.println();
		}
		
		
		/* char c='A';   // 여기에 뒀을 땐, ABCD   EFGH ~ 이렇게 됨
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=4;j++) {
				System.out.print(c++);
			}
			System.out.println();
		}*/

 
		/* for(int i=1;i<=4;i++)
		{ 
			char c='A';   // 변수를 어디에 두느냐에 따라 달라짐! 
			for(int j=1;j<=4;j++)
			{
				System.out.print(c++);
			}
			System.out.println();
		}*/

	}

}
