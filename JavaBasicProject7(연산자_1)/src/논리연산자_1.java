/*
 *    논리연산자 : 효율적인 계산처리할 때
 *    && : 왼쪽편의 조건이 false => false
 *    || : 왼쪽편의 조건이 true => true
 */
public class 논리연산자_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start=System.currentTimeMillis();
		int a=10;       //================== 실행한 시간
		int b=9;
		boolean bCheck=(a>b && ++b==a);
		/*
		 *    a>b ==> 10>9 ==> true
		 *    ++b==a  10==10 ==> true
		 *    true && true = ture
		 */
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("결과:"+bCheck);
		long end=System.currentTimeMillis();
		//   =============================== 처리 끝난 시간
		System.out.println("수행시간:"+(end-start));
		
		// 효율적인 계산
		start=System.currentTimeMillis();
		a=10;
		b=9;
		bCheck=(a<b && ++b==a);
		/*
		 *    a<b ==> 10<9 ==> false
		 *    => false
		 */
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("결과:"+bCheck);
		end=System.currentTimeMillis();
		System.out.println("수행시간:"+(end-start));
		
		

	}

}
