import java.util.Scanner;

public class 메소드활용_숫자야구게임 {
	// 1. 컴퓨터 난수발
	static int[] com={3,6,9};

	// 2. 사용자 정수 3개 저장
	static int[] user()
	{
		int[] user=new int[3];
		Scanner scan = new Scanner(System.in);
		while(true)   // 횟수가 명확하지 않을 때!
		{
			System.out.print("세자리 정수를 입력하세요");
			int input=scan.nextInt();
			//오류처리
			if(input<100 || input>999)
			{
				System.out.println("잘못된 입력입니다!");
				// 처음으로 돌아간다
				continue;   // while문의 조건식으로 이동하는 것
			}
			// 567/100 => 5
			user[0]=input/100;  // 첫번째 자리 수
			// 567%100 => 67/10 => 6
			user[1]=(input%100)/10;  // 두번째 자리 수
			user[2]=input%10;  // 세번째 자리 수
			
			if(user[0]==user[1] || user[1]==user[2] || user[0]==user[2])
			{
				System.out.println("중복된 수는 사용할 수 없습니다");
				// 다시 입력 요청
				continue;
			}
		}
	}
	
	// 3. 비교
	static void sb() 
	{
		Scanner scan = new Scanner(System.in);
		int s=0,b=0;
		int user[]=scan.nextInt();
		for(int i=0;i<3;i++)   // com
		{
			for(int j=0;j<3;j++)   // user
			{
				// 같은 수가 있는지 확인
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
	// 4. 힌트주기
	static void hint()
	{
		System.out.println("======== 결과 =========");
		
		System.out.print("S:");
		for(int i=0;i<s;i++)
		{
			System.out.print("●");
		}
		System.out.println();
		System.out.print("B:");
		for(int i=0;i<b;i++)
		{
			System.out.print("○");
		}
		System.out.println();
	}
	
	// 5. 종료
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
					
			// 비교 시작 -> 거의 이중for문
			
			// 힌트
			// System.out.printf("Input Number:%d,Result:%dS-%dB\n",input,s,b);
			
		
			// 종료 여부
	}
	
}
