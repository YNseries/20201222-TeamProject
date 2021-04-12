/*
 *    주사위 2개를 던져서 합이 6일 경우의 수를 출력하고 총 갯수는 몇개인지 출력
 */
public class 문제21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0;
		for(int i=1;i<=6;i++)
		{
			for(int j=1;j<=6;j++)
			{
				if((i+j)>=10)
				{
					count++;
					System.out.println("["+i+","+j+"]");
				}
			}
			System.out.println("총 갯수:"+count);
		}

	}

}
