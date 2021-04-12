/*
 *    1. 생성자가 한개라도 존재하면 컴파일러가 생성자를 만들어주지 않는다
 *    예)
 *        class A
 *        {
 *           // 컴파일러가 A(){}
 *        }
 *        class A
 *        {
 *           A(){} => 생성자(디폴트 생성자)
 *        }
 *        class A
 *        {
 *           A(int a){}
 *        }
 *        class A
 *        {
 *           A(int a,int b){} => A(){} (x)   A(10,20){} (O)
 *        }
 *        
 *        메소드
 *        void display(int a){}  => display(int)로 저장됨
 *        void display(int b){}  => display(int)로 저장됨. 같은 메소드
 *        int display(int a,int b){} => display(int,int) => 다른 메소드
 *        int display(String a){}    => display(String) => 다른 메소드
 *        
 *        display() => 오류발생
 *        display(10) => 정수값을 넣어줘야 호출됨
 *        
 *        
 *        ==> class A
 *        
 *            => A(){}            => new A()
 *            => A(int a){}       => new A(10)
 *            => A(int a,int b){} => new A(10,20)
 *            => A(String name){} => new A("Hong")
 *            => A(char a){}      => new A('A')
 *            
 *            => A(double d1, double d2, double d3)
 *               new A(10.5, 10.6, 10.7)
 *               new A('A',10,10.5F)
 */
public class 생성자 {
	// 생성자(){}  // 하나라도 존재하면 생성자 추가되지 않음
	// ★오버로딩 : 중복메소드 정의 => 같은 메소드로 여러개 기능을 처리(다형성)
	// 새로운 기능을 추가(new)
	// 생성자는 필요시마다 제작 => 서버연결, 오라클연결, 윈도우제작
	int a=10;
	// a=100;  선언 후 구현은 안됨. 오류나
	{
		a=100;      // 초기화블록. 어디에서든 쓸 수 있음
	}
	생성자(int a){
		System.out.println("a="+a);
	}
	생성자(char a)
	{
		System.out.println("a="+a);
		{
			int b=10;  // 사용범위 지정. 클래스 안에 걸 때는 초기화블록.
		}
	}
	생성자(double d1, double d2, double d3)
	{
		System.out.println("d1="+d1);
		System.out.println("d2="+d2);
		System.out.println("d3="+d3);
	}
	
	public static void main(String[] args) {
		// 생성자 aa1=new 생성자();
		생성자 aa2=new 생성자(10);  // 정수값을 넣어줘야 실행
		// 매개변수에 값을 추가 => 같은 값, 작은 값
		생성자 aa3=new 생성자('A',10,10.5F);
		생성자 aa4=new 생성자('B');
		생성자 aa5=new 생성자(67);
		
		new 생성자('A');  // 생성자 호출할 때 쓰는 방식. 주소를 저장할 필요가 없을 때
		// 초기화블럭 => 자동 호출이 됨
		int a=10;
		System.out.println("a="+a);
	}

}
