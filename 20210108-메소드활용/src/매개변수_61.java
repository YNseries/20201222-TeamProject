
public class 매개변수_61 {
	static void increment()
	{
		int a=10;    // 지역변수
		System.out.println("a="+a);
		a++;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		increment();
		increment();   // 지역변수에 a를 넣어놨기 때문에 
		// a는 증가하고 사라짐 => 똑같이 a=10 a=10 나옴
		// 호출하고, 사라지고, 호출하고 사라짐

	}

}
