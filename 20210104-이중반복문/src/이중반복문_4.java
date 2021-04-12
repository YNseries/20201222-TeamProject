/*
 *           *
 *          **
 *         ***
 *        ****
 *      =========================
 *         i    j    k      i,j    i,k
 *         줄수  공백  별표
 *         1    3    1      i+j=4  ==>  j=4-i    i=k
 *         2    2    2 
 *         3    1    3
 *         4    0    4
 *      =========================
 *        ****
 *         ***
 *          **
 *           *
 *        i    j    k            i+k=5  ==>  k=5-i
 *        줄수  공백  별표
 *        1    0    4            j+1=i  ==>  j=i-1 (수열): 일정 패턴이 있어야 함 => 방정식
 *        2    1    3
 *        3    2    2
 *        4    3    1
 * 
 */
public class 이중반복문_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=4;i++)
		{
			// 공백출력
			for(int j=1;j<=i-1;j++)
			{
				System.out.print(" ");
			}
			// 별표출력
			for(int k=1;k<=5-i;k++)
			{
				System.out.print("★");
			}
			System.out.println();
		}
		

	}

}
