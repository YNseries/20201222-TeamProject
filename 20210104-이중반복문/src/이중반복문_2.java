/*     j=1234
 *  i=1  1###
 *  i=2  #2##
 *  i=3  ##3#
 *  i=4  ###4
 *    ======
 *    ���� : 4�� => for(int i=1;i<=4;i++)  => 1�� for��
 *    ���� : 4�� => for(int j=1;j<=4;j++)  => 2�� for��
 */
public class ���߹ݺ���_2 {

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
			// �����ٿ� ���
			System.out.println();
		}

	}

}
