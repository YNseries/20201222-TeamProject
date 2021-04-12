/*     j=1234
 *  i=1  1###
 *  i=2  #2##
 *  i=3  ##3#
 *  i=4  ###4
 *    ======
 *    세로 : 4줄 => for(int i=1;i<=4;i++)  => 1차 for문
 *    가로 : 4줄 => for(int j=1;j<=4;j++)  => 2차 for문
 */
public class 이중반복문_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=1;i<=4;i++)
		{
			for(int j=1;j<=4;j++)
			{
				if(i==j)
				{
					System.out.print(i);
				}
				else
				{
					System.out.print("#");
				}
			}
			// 다음줄에 출력
			System.out.println();
		}

	}

}
