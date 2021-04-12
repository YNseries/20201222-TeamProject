class A
{
	int age=10;
	
}
class B
{
	void display(A b)
	{
		b.age=100;
	}
	void display2(int[] arr)
	{
		System.out.println("display2:arr="+arr);
		arr[0]=10;
		arr[1]=20;
		arr[2]=30;
	}
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		/*
		 *   a ==> age(10)
		 */
		System.out.println("a.age="+a.age);
		//변경
		a.age=50;
		System.out.println("a.age="+a.age);
		
		B b=new B();
		b.display(a);
		
		System.out.println("a.age="+a.age);
		// A b=a  => Call By Reference
		
		int[] arr=new int[3];  // 0 0 0
		System.out.println("arr="+arr);
		b.display2(arr);  // 10 20 30
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		/*
		 *    매개변수 전송법
		 *    Call By Value : 매개변수가 기본형일 경우(int, long...) => 복사본을 넘기는 것(원본은 그대로)
		 *    Call By Reference : 매개변수가 배열, 클래스일 때 자체가 변경 => 원본(원본이 바뀜)
		 */
	}

}
