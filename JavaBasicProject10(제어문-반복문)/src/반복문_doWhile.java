/*
 *     do~while : 조건검색을 나중에 하기 때문에 반드시 한 번 이상을 수행
 *     형식)
 *          초기값 int i=1;    ===>1
 *          do
 *          {
 *              반복문장       ====>2
 *              증가식        ====>3
 *          }while(조건식);   ====>4  ====>2  ====>3  ====>4
 *                                     ==================== 4 (false일 경우에 종료)
 *                                     
 *          int i=1;
 *          do{
 *                System.out.println("i="+i);  // i=1 => i=2 => i=3 => i=4 => i=5
 *                i++;  => i=2 => i=3 => i=4 => i=5 => i=6
 *          }while(i<=5); 2<=5 true => 3<=5 true => 4<=5 true => 5>=5 true => 6>=5 false => 종료
 */
// 1~10까지 출력
// while(i<=10)';'
// while(조건식) => 생략할 수 없기 때문에 조건식을 주거나 true를 줘야함
public class 반복문_doWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 초기값
		int i=10; // 최소 한 번은 수행함
		do
		{
			// 2. 반복으로 수행되는 문장
			System.out.println("i="+i);
			// i값을 증가 i=1~i=10
			i++;
		}while(i<=5);
		
		int j=10;  // do-while문과 다르게 한 번도 수행을 못할 수도 있다
		while(j<=5)
		{
			System.out.println("Hello");
			i++;
		}
		

	}

}
