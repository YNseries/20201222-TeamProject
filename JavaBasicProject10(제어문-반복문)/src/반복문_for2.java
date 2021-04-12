/*
 *    page 156 
 *    1. for은 주로 반복횟수를 알고 있는 경우에 적합
 *    2. 형식
 *             1     2    4
 *        for(초기값;조건식;증가식)
 *             실행문장 3
 *             
 *              1->2->3->4
 *                 2->3->4
 *                 2->3->4
 *                 ==
 *                 false면 종료 
 *         ***** {}가 없으면 바로 밑있는 문장만 반복문장 된다 
 *         예)
 *             for(int i=1;i<=5;i++)
 *                System.out.println("i="+i);
 *            ==================================
 *                System.out.println("Hello");
 *                
 *             for(int i=1;i<=5;i++)
 *             {
 *                System.out.println("i="+i);
 *                System.out.println("Hello");
 *             }
 *            
 *            1) 초기화
 *               for(int i=0;
 *                   ========
 *                   => 프로그램에 맞게 초기화를 한다 (기본값, 0,1)
 *                   => 자바는 보통 0
 *            2) 조건식
 *               for(int i=0; i<10;
 *                            =====
 *                    반복을 몇번 할지 설정
 *            3) 증감식
 *               for(int i=0;i<10;i++)
 *                                ===
 *                   i--, i+=2, i+=3, ...
 *            
 */
public class 반복문_for2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// A~Z
		for(char alpha='A';alpha<='Z';alpha++) 
		{
			System.out.print(alpha);
		}
		
		// char c=65;
		// System.out.println(c);
		
		// System.out.println();
		// char c=65;
		// c++;
		// int i='A';
		// 		i++;
		// System.out.println((char)i);
			
		System.out.println(); // 다음줄에 출력
		// Z~A순으로 출력
		for(char alpha='Z';alpha>='A';alpha--)
		{
			System.out.print(alpha);
		}


	}

}
