
public class 반복문_for3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1~9
		/* for(int i=1;i<=9;i++)
		{
			System.out.print(i);
		}
		System.out.println();
		// 9~1
		for(int i=9;i>=1;i--)
		{
			System.out.print(i);
		}*/
		int i=1;
		for(;;) //while(true) 무한루프 => 종료하는 기능을 설정해야 함
			    // 게임은 => 보통 esc / q
		{
			// System.out.println("i="+i);   // 101까지 출력
			if(i>100)
				break;  //종료
			System.out.println("i="+i);   // 100까지 출력
			i++;
		}

	}

}
