/*	[오버로딩]
 *    메소드 => 한 개 클래스 안에서 같은 이름의 메소드를 사용할 수 있다
 *    => 중복 메소드 정의 => 여러개의 기능을 만든다(오버로딩)
 *    
 *       조건
 *        매개변수의 데이터형, 갯수가 다르다
 *        리턴형은 관계없다
 *        메소드명이 동일
 */
public class MainClass2 {
	public void plus(int a,int b)
	{
		System.out.println("정수 계산");
		System.out.println(a+b);
	}
	public double plus(double d1, double d2)
	{
		System.out.println("실수 계산");
		return d1+d2;
	}
	public int plus(char c1, char c2)
	{
		System.out.println("문자 계산");
		return c1+c2;
	}
	public String plus(String s1, String s2)
	{
		System.out.println("문자열 계산");
		return s1+s2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainClass2 m=new MainClass2();
		m.plus(10, 20);       // int
		m.plus('A', 66);      // int
		m.plus(10.5F, 'A');   // double  비슷한게 없으면 가장 큰 데이터형을 찾아감
		m.plus("Hello", "10");  // m.plus("Hello", 10); 이런 데이터형은 없어서 오류 나옴

	}

}
