// 변수값 설정
public class 변수_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 두개의 변수 x=10, y=20
		int x=10, y=20;
		x=y; // y가 가지고 있는 정수값을 x에 대입 ==> x=20
		y=x; // x가 가지고 있는 정수값을 y에 대입 ==> y=20
		
		// 3+7+"5" => "105"
		// ===  =
		//  10  5  => "105"

		// 국어점수, 수학점수, 영어점수 => 점수를 저장한 후에 국어,영어,수학,총점,평균을 출력
		int kor=80;
		int eng=87;
		int math=85;
		int total = kor+eng+math;
		double avg = total/3.0;
		
		System.out.println("국어점수:"+kor); //국어점수:80
		System.out.println("영어점수:"+eng); //영어점수:87
		System.out.println("수학점수:"+math); //수학점수:85
		System.out.println("총점:"+total); // 총점:252
		System.out.println("평균:"+avg); // 평균:84
		
		// 3+5*2 => 13
		// 정수/정수 = 정수  => 5/2 => 2.5(이렇게 안나옴)   5/2=2, 5/2.0=2.5
		
		// int, double, boolean, String 가장 많이 쓰이는 순서
		
		char c='A'; //65
		char d='B'; //66
		System.out.println(c+d);
		String s ="A";
		String s1="B";
		System.out.println(s+s1); //"AB"
		
		/* 
		 * any타입+문자열 = 문자열   =>   10+"a" ==> "10a"
		 * 							 "a" + 10.0 ===> "a10.0
		 * === 어떤 데이터형에든 상관없이
		 * char+문자열=문자열
		 * 정수+문자열=문자열
		 * 실수+문자열=문자열
		 * 논리+문자열=문자열
		 * 문자열+ any타입 = 문자열
		 */
		
		System.out.println(10/3.0);
		System.out.printf("%.2f",10/3.0); //JDK 1.5 이상에서 새로 등장한 기능 (C언어에서 갖고옴)
		//  				 = 소수점 몇 번째 자리까지 나올 지 결정하는 것. 여기선 2자리
		/*   서식이 있는 출력
		 * 	 사용기호
		 *    %d ==> 정수
		 *    %c ==> 문자
		 *    %s ==> 문자열
		 *    %f ==> 실수
		 */
		System.out.printf("%d", 100); // 뒤에 맞지 않는 서식이 들어오지 않으면 오류가 뜸
		
		/*   특수기호
		 *   \n => new Line : 다음줄에 출력		html에서는 <br>
		 *   \t => tab : 일정 간격 					 &nbsp;
		 */
		System.out.printf("%d\t",100);
		System.out.printf("%s","Hello");
		System.out.printf("%c",'A');
		
		System.out.println("100  80  70");
		System.out.printf("%5d%5d%5d",100,80,70);
		/* 
		 *     000000000000000
		 *       100   80   70
		 *       
		 *       %5d => 5자리씩 오른쪽부터 정렬. 나머진 빈 공백
		 *       %-5d => 5자리씩 왼쪽부터 정렬
		 *       
		 *       출력에서 가장 많이 사용하는 것은? System.out.println()
		 */
		
	}

}
