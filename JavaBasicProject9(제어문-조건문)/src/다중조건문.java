/*
 *    다중조건문
 *       => 여러가지 조건중에 한 개의 조건을 수행할 수 있게 만드는 기능
 *       형식)
 *          if(조건문)
 *          {
 *              조건문 true면 실행하는 문장 => 문장을 수행하면 종료 ===>
 *          }
 *          else if(조건문)
 *          {
 *              조건문 true면 실행하는 문장 => 문장을 수행하면 종료 ===>
 *          }
 *          else if(조건문)
 *          {
 *              조건문 true면 실행하는 문장 => 문장을 수행하면 종료 ===>
 *          }
 *          --
 *          --
 *          --
 *          else
 *          {
 *              조건에 해당되는 조건문이 없는 경우에 수행되는 문장 (default) => 생략이 가능
 *          }
 *          
 *          학점계산
 *            90이상 => A
 *            80이상 => B
 *            70이상 => C
 *            60이상 => D
 *            ============ 해당 조건이 없으면 => F
 */
// 3개의 점수를 받아서 평균, 총점, 학점
import java.util.Scanner; //자바에서 지원하는 클래스를 가지고 올 경우에 사용 (import)
public class 다중조건문 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 저장하는 메모리 공간을 설정
		int kor, eng, math, total;
		double avg;
		char score;
		
		// 3개의 점수는 받아서 저장 => 변수의 초기화
		Scanner scan=new Scanner(System.in); //키보드로 입력된 데이터를 읽어오는 역할
		System.out.println("국어점수 영어점수 수학점수 입력(90 80 70):");
		kor=scan.nextInt(); // nextInt(한개의 데이터만 읽어온다)
		eng=scan.nextInt();
		math=scan.nextInt();
		
		// 가공 (연산자 이용)
		total=kor+eng+math;
		avg=total/3.0;
		
		// 학점
		score='A';
		if(avg>=90 && avg<=100)
			score='A';
        //////////////////////////
		if(avg>=80 && avg<90)
			score='B';
        //////////////////////////
		if(avg>=70 && avg<80)
			score='C';
		///////////////////////////
		if(avg>=60)
			score='D';
		///////////////////////////
		if(avg<60)
			score='F';
		//////////////////////////

		
		// 출력
		System.out.println("국어 점수:"+kor);
		System.out.println("영어 점수:"+eng);
		System.out.println("수학 점수:"+math);
		System.out.println("총점:"+total);
		System.out.printf("평균:%.2f\n",avg);
		System.out.println("학점:"+score);

	}

}
