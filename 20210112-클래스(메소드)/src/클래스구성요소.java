/*
 *    클래스
 *      1) 구성요소
 *         = 변수
 *           멤버변수: 클래스가 가지고 있는 변수, new를 사용하면 따라 생성되는 메모리 공간
 *           class A
 *           {
 *             ==============   => 자동 초기화(default값으로)
 *              String name;    name=null
 *              int age;        age=0
 *             ==============
 *              int=0
 *              double=0.0
 *              float=0.0F
 *              boolean=false
 *              String=null
 *              
 *           }
 *           공유변수: 클래스에서 공통으로 사용되는 변수, 1개만 생성
 *           class A
 *           {
 *             =====================
 *              static String dept;
 *             =====================
 *           }
 *           지역변수: 메소드 안에서 선언
 *           class A
 *           {
 *               void display()
 *               {
 *                  =========
 *                  int a=10;    => 지역변수는 반드시 초기화를 한다
 *                  =========    display()가 종료되면 사라지는 변수
 *               }
 *           }
 *           
 *           코드 영역
 *           ======
 *            class
 *            {
 *                선언만 가능 = 변수 선언, 메소드 선언 => 구현은 할 수 없다(메소드 호출,연산처리,제어문 (x))
 *            }
 *            method()
 *            {
 *                선언(변수 선언), 메소드 호출, 연산처리, 제어문처리 가능
 *            }
			 *      예)    ==> login => 자동 로그인
			 *            class A
			 *            {
			 *                String id;
			 *                {
			 *                   id=파일을 읽어서 id를 가지고 온다
			 *                }
			 *            }
 *            ==> 사용자 요청 => 처리(구현)
 *            프로그램: 선언(필요한 데이터 선언) + 데이터 처리(읽기, 쓰기, 연산처리, 제어문)
 *            
 *         = 메소드: 기능 처리
 *                 예) 자판기
 *                    =====
 *                    동전, 지폐 ==> 변수
 *                    음료수
 *                    =====
 *                    기능 => 동전을 첨부
 *                  (메소드)   버튼을 클릭
 *                           잔돈을 계산
 *                    클래스 => 명사형 + 동사형
 *                            ====   ====
 *                             변수    메소드
 *           형식)
 *               = 메소드는 항상 클래스 {} 안에 존재
 *                 ==== 클래스 종속적
 *               class A
 *               {
 *                  메소드1(){}
 *                  메소드2(){}
 *                  메소드3(){}
 *                  메소드4(){}
 *                  메소드5(){}
 *                  // 너무 많아지면 어디서 시작하는지 모를 수 있으니까 시작 메소드를 지정해뒀음.
 *                     ==> main: 프로그램 안에서는 반드시 main이 1개 이상 존재
 *               }
 *               
 *               메소드의 구성 요소
 *               =============
 *               1. 리턴형(반환값)
 *               2. 메소드명
 *               3. 매개변수
 *               
 *               => 1) 사용자가 입력한 데이터를 받아서 => id,pwd
 *                  2) 요청 처리 => login 처리
 *                  3) 결과값을 전송 => true/false
 *                  
 *               형식)
 *                   리턴형(데이터형)                       메소드명(매개변수...)
 *                   ===========                       =======
 *                   기본 데이터형                         메소드 => 다른 클래스와 연결할 때 주로 사용  
 *                     = 정수(int,long,byte.short)              (의미를 부여하는게 좋아) => 재사용 가능 
 *                     = 실수(float,double)
 *                     = 논리(boolean)
 *                     = 문자(char)
 *                   참조형 데이터(데이터가 여러개인 경우)
 *                     = 배열: 목록 출력
 *                     = 클래스: 상세보기
 *                     
 *                = 리턴형 (O),  매개변수(O) => 상세보기
 *                = 리턴형 (O),  매개변수(X) => 목록을 출력할 때
 *                =======================================
 *                = 리턴형 (X),  매개변수(O)
 *                = 리턴형 (X),  매개변수(X) => 자주 사용하지 않는다
 *                =======================================
 *                반드시 void라고 사용한다 ==> 데이터베이스(수정, 삭제, 추가)
 *                
 *                = 멤버메소드 => 리턴형 메소드명(매개변수..) => new를 이용해서 저장
 *                = 공유메소드 => static 리턴형 메소드명(매개변수...) : 자동으로 저장
 *                               데이터형 변환
 *                               String.valueOf()
 *                               String s="Hello";
 *                               s.substring()
 *                               String s1="Java";
 *                               
 *                               // 앞에서 두 글자를 자르려고 하면, static에서는 하나만 가능하기 때문에 둘 중 무엇이 될지 모름
 *                               String s="Hello Java!!";
 *                               s.substring(0,2)                     // 때문에 이거 넣어줘야 함
 *                               String s1="Oracle Hello!!";     // 대상이 생기면 따로 존재해야함 s, s1
 *                               
 *                               String.valueOf(10)      => "10"    // 얘는 상관x 대상이 따로 있는게 아님 = static
 *                               String.valueOf(true)    => "true"
 *                               
 *                               Math.random()
 *                               
 *         = 생성자 
 *         
 *         동작: 일치  ==> static
 *         동작: 불일치 ==> 인스턴스 메소드
 */
/*
 *    학생 성적 계산
 *       저장되는 데이터
 *         학점
 *         총점
 *         평균
 *         점수 입력
 *    
 *    static은 멤버 메소드가 아니라 독립적인 메소드
 */
import java.util.Scanner;
public class 클래스구성요소 {
	String name;
	int kor,eng,math;
	// 멤버 메소드는 멤버에서 사용이 가능
	
	// 점수 입력 방법1
	int input(String subject)
	{
		Scanner scan=new Scanner(System.in);
		System.out.print(subject+"점수 입력:");
		return scan.nextInt();
	}   // 아직 저장 안됨
	
	// 점수 입력 방법2
	void input2()
	{
		Scanner scan=new Scanner(System.in);
		System.out.print("국어점수 입력:");
		kor=scan.nextInt();
		System.out.print("영어점수 입력:");
		eng=scan.nextInt();
		System.out.print("수학점수 입력:");
		math=scan.nextInt();
	}
	
	// 총점 (리턴 필요. 위에 선언하지 않았기 때문)
	int jumsuTotal()
	{
		return kor+eng+math;
	}
	// 평균
	double jumsuAvg()
	{
		return (kor+eng+math)/3.0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 클래스 저장
		클래스구성요소 hong=new 클래스구성요소();
		클래스구성요소 shim=new 클래스구성요소();
		클래스구성요소 kim=new 클래스구성요소();
		// hong.kor=hong.input("국어");
		// hong.eng=hong.input("영어");
		// hong.math=hong.input("수학");
		hong.input2();
		int total=hong.jumsuTotal();
		double avg=hong.jumsuAvg();
		
		shim.input2();
		kim.input2();
		
		// 출력
		System.out.println("국어점수:"+hong.kor);
		System.out.println("영어점수:"+hong.eng);
		System.out.println("수학점수:"+hong.math);
		System.out.println("총점:"+total);
		System.out.printf("평균:%.2f",avg);

	}

}
