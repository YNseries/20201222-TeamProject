// 1~100������ ��
// 1+2+3+4+...+100 ?
public class �ݺ���_while2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ���� 2�� �ʿ� => 1~100 ����Ǵ� ����(��������)
		int i=1;
		// 1~100���� ���� ���� ������ ����
		int sum=0; // + => ���� (0), * => 1
		while(i<=100) // 100���� �ݺ��Ѵ�
		{
			sum+=i; //sum=sum+i; ������
			/*
			 *    sum = sum +i
			 *    
			 *    i=1
			 *    sum=0+1 ==> sum=1
			 *    i=2
			 *    sum=1+2 ==> sum=3
			 *    i=3
			 *    sum=3+3 ==> sum=6
			 *    --
			 *    --
			 *    --
			 *    sum=()+100 ==> sum=?
			 */
			System.out.println("i="+i+",sum="+sum); //i�� ���� �� sum�� ������ Ȯ�� ����
			i++;
			
		}
		System.out.println("1~100������ ����:"+sum);

	}

}
