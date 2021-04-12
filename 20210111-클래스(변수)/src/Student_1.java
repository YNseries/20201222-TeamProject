// 3명의 학생 => 이름, 국어, 영어, 수학 => 평균, 총점, 학원명(같은 학원)
public class Student_1 {
	/*
	 *    자바 / C
	 *    ==   == 다른 명령을 사용하기 전에 변수를 미리 선언 후에 사용
	 *    변수를 선언할 때 위치에 상관이 없다
	 *    
	 *    ====================
	 *    할 때마다 변수 설정
	 *    한 개 => 재사용
	 *    
	 *    예)
	 *        int a=10;
	 *        System.out.println("a="+a);
	 *        int b=20;
	 *        System.out.println("b="+b);
	 *        ===========================
	 *        int a=10;
	 *        System.out.println("a="+a);
	 *        a=20;
	 *        System.out.println("a="+a);
	 *        
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 배열 => 인덱스 / 같은 번호 : 한 명에 대한 정보
		String[] name= {"홍길동","심청이","박문수"};
		int[] kor= {89,67,90};
		int[] eng= {80,90,70};
		int[] math= {78,79,90};
		String[] school= {"SIST","SIST","SIST"};
		int[] total=new int[3];
		// 초기화
		total[0]=kor[0]+eng[0]+math[0];
		total[1]=kor[1]+eng[1]+math[1];
		total[2]=kor[2]+eng[2]+math[2];
		double[] avg=new double[3];
		avg[0]=total[0]/3.0;
		avg[1]=total[1]/3.0;
		avg[2]=total[2]/3.0;
		// 클래스
		// 출력
		school[0]="SIST2";
		school[1]="SIST2";
		school[2]="SIST2";
		for(int i=0;i<name.length;i++)
		{
			System.out.println("이름:"+name[i]);
			System.out.println("국어:"+kor[i]);
			System.out.println("영어:"+eng[i]);
			System.out.println("수학:"+math[i]);
			System.out.println("총점"+total[i]);
			System.out.println("평균:"+avg[i]);
			System.out.println("학원명:"+school[i]);
			System.out.println("=============================");
		}		

	}

}
