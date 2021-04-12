/*
 *    산술연산자 = 이항연산자 (연산대상이 2개가 필요)
 *    =======
 *    +(덧셈), -(뺄셈), *(곱셈), /(나눗셈), %(나머지)
 *    1) 우선수위
 *    	*, /, % >= +, -
 *      예) () => 최우선순위 연산자
 *    	    3+5*10 => 53
 *    2) 다른 데이터형이 연산이 된 경우 (가장 큰 데이터형으로 변경 후에 연산)
 *       int + double
 *       ===
 *       double     => double + double (연산은 항상 같은 데이터형만 연산처리가 됨)
 *       예)
 *       	10 + 10.5
 *       	==
 *       	10.0    => 10.0 + 10.5 = 20.5
 *       
 *       char + int
 *       ====
 *        int로 변환  => int + int = int
 *       예)
 *          'A' + 100
 *          ===
 *           65     => 65 + 100 = 165  =====> 다시 문자로 변환? (char)165
 *           
 *       int + long
 *       ===
 *       long
 *       예)
 *       	10 + 100L
 *       	==
 *       	10L		=> 10L + 100L = 110L
 *       ===========================================
 *       char + byte = 결과값 (int)
 *       short + short 
 *       
 *          int 이하 데이터형(char, byte, short)의 연산시 결과값은 int
 *       ===========================================
 */
public class 연산자_산술연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b1=10;
		byte b2=20;
		byte b3=(byte)(b1+b2); // 혹은 int b3=b1+b2
		System.out.println("b3="+b3);
		
		int a=10;
		double d=10.5;
		//a+d 한 결과값을 출력
		// int res=(int)(a+d);
		// double res=a+d;
		int res = a+(int)d;
		// a=10.0 d=10.5  ==> 10.0+10.5 = 20.5
		System.out.println(res);
		
		double d1=10.5;
		double d2=10.5;
		//int res1=(int)(d1+d2);  ==> d1+d2=21.0 ==> (int)21.0 ==> 21
		//           2     1
		int res1=(int)d1+(int)d2;
		//         1   3   2   (순서)
		//        10   +   10 = 20
		System.out.println(res1);
		
		// 뺄셈 ===> (-)
		int i=10;
		int j=6;
		// i, j
		int z=i-j;
		System.out.println("z="+z);
		
		// 곱셈 ===> (*)
		i=10;
		j=6;
		z=i*j;
		System.out.println("z="+z);
		
	}

}
