import java.util.Scanner;

public class �޼ҵ�Ȱ��_���ھ߱����� {
	// 1. ��ǻ�� ������
	static int[] com={3,6,9};

	// 2. ����� ���� 3�� ����
	static int[] user()
	{
		int[] user=new int[3];
		Scanner scan = new Scanner(System.in);
		while(true)   // Ƚ���� ��Ȯ���� ���� ��!
		{
			System.out.print("���ڸ� ������ �Է��ϼ���");
			int input=scan.nextInt();
			//����ó��
			if(input<100 || input>999)
			{
				System.out.println("�߸��� �Է��Դϴ�!");
				// ó������ ���ư���
				continue;   // while���� ���ǽ����� �̵��ϴ� ��
			}
			// 567/100 => 5
			user[0]=input/100;  // ù��° �ڸ� ��
			// 567%100 => 67/10 => 6
			user[1]=(input%100)/10;  // �ι�° �ڸ� ��
			user[2]=input%10;  // ����° �ڸ� ��
			
			if(user[0]==user[1] || user[1]==user[2] || user[0]==user[2])
			{
				System.out.println("�ߺ��� ���� ����� �� �����ϴ�");
				// �ٽ� �Է� ��û
				continue;
			}
		}
	}
	
	// 3. ��
	static void sb() 
	{
		Scanner scan = new Scanner(System.in);
		int s=0,b=0;
		int user[]=scan.nextInt();
		for(int i=0;i<3;i++)   // com
		{
			for(int j=0;j<3;j++)   // user
			{
				// ���� ���� �ִ��� Ȯ��
				if(com[i]==user[j])
				{
					if(i==j)
						s++;
					else
						b++;
				}
			}
		}
		return sb;
	}
	// 4. ��Ʈ�ֱ�
	static void hint()
	{
		System.out.println("======== ��� =========");
		
		System.out.print("S:");
		for(int i=0;i<s;i++)
		{
			System.out.print("��");
		}
		System.out.println();
		System.out.print("B:");
		for(int i=0;i<b;i++)
		{
			System.out.print("��");
		}
		System.out.println();
	}
	
	// 5. ����
	static void exit()
	{
		if(s==3)
		{
			System.out.println("Game Over!!");
			break;
		}
	}
	// 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
					
			// �� ���� -> ���� ����for��
			
			// ��Ʈ
			// System.out.printf("Input Number:%d,Result:%dS-%dB\n",input,s,b);
			
		
			// ���� ����
	}
	
}
