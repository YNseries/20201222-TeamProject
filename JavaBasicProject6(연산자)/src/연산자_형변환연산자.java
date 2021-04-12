/*
 *    형식
 *    ===
 *    (데이터형)값 => 데이터형을 변경할 때 사용
 *    예) => boolean은 제외
 *        정수를 문자로 변경
 *        (char)68 => 'D'
 *        실수를 정수로 변경
 *        (int)10.8 => 10
 */
public class 연산자_형변환연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double d=100.99;
		//       ====== double
		float f=100.99F;
		//      ====== double
		System.out.println("d="+d);
		System.out.println("f="+f);
		// 명령어 => double => 정수(int)
		int a=(int)d; //100
		System.out.println("a="+a);
		// 명령어 float => 문자로 변경
		char c=(char)f;
		// A=65, a=97, b=98, c=99, ...
		System.out.println("c="+c);
		

	}

}
