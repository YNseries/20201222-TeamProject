/*
 *      1~100���� ����, 3�� ��� ��, 5�� ��� ��, 7�� ��� ���� ���
 *      1-2+3-4+5-6+7-8+9-10 ��
 */
public class �ݺ���_doWhile3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=1;
		// ���� 4�� �ʿ�
		int sum=0, thi=0, fif=0, sev=0;
		do
		{
			sum+=i;
			if(i%3==0)
				thi+=i;
			if(i%5==0)      // else(�������ǹ�x) ���̸� �ȵ�! -> �ߺ��Ǵ� ��찡 ���� �� ���ܵǱ� ������ 
				fif+=i;
			if(i%7==0)
				sev+=i;
			i++;
		}while(i<=100);
		System.out.println("1~100���� ����:"+sum);
		System.out.println("1~100���� 3�ǹ�� ��:"+thi);
		System.out.println("1~100���� 5�ǹ�� ��:"+fif);
		System.out.println("1~100���� 7�ǹ�� ��:"+sev);
		
		//   ������� else ���� �¾��� ��
		
		// 1-2+3-4+5-6+7-8+9-10 ��  => ����
		i=1;
		sum=0;
		do {
				if(i%2==0)
					sum-=i;
				else
					sum+=i;
				i++;
		}while(i<=10);
		System.out.println("��:"+sum);
		
		// =============================== �Ʒ��� ���� ¥�� ��
		i=1;
		sum=0;
		do
		{
			sum = (sum + i) * -1;
			i++;
		}while(i<=10);
		System.out.println("��:"+sum);
	}

}
