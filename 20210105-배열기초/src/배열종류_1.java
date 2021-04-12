/*
 *    배열
 *     1. 정수형 배열
 *        int[] arr={1,2,3,4,5}
 *        int[] arr=new int[5];
 *           == ===        == 저장할 갯수
 *        배열설정,배열명
 *        long[] arr=new long[];
 *        long[] arr={1L,2L,3L,4L,5L} => {1,2,3,4,5}  (21억4천을 넘어가지 않는 한 L 안붙여도 됨)
 *        long a=1   ==> a=1L
 *        long[] arr={'A','B','C'...}
 *        
 *        int[] arr=new int[5];  // 0,0,0,0,0
 *        long[] arr=new long[5];  // 0L,0L,0L,0L,0L
 *     2. 실수형 배열
 *        double[] arr={1.0, 2.0, 3.0...};
 *        float[] arr={1.0,2.0,3.0...};      (오류)
 *        float[] arr={1.0F,2.0F,3.0F...};
 *        float f=10.5
 *                ==== double  
 *        double[] arr=new double[5];  // 0.0,0.0,0.0,0.0,0.0
 *        float[] arr=new float[5];  // 0.0f,0.0f,0.0f,0.0f,0.0f
 *     3. 문자형 배열
 *        char[] arr={'A','B','C'...};
 *        char[] arr=new char[5];  // '\0','\0','\0','\0','\0'
 *     4. 논리형 배열
 *        boolean[] arr={true,false,true...};
 *        boolean[] arr=new boolean[5];  // false,false,false,false,false
 *     5. 문자열 배열
 *        String[] arr={"홍길동","심청이","박문수","이순신","강감찬"...};
 *        String[] arr=new String[5];  // null,null,null,null,null
 *           *** null: 실체가 없는 값
 */
import java.util.Scanner;
public class 배열종류_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 3명의 학생 => 국어, 엉어, 수학 점수를 입력받아서 총점, 평균, 학점을 출력
		/*
		 *   배열 => 관련된 데이터를 모아서 관리
		 */
		// 국어 => 3명
		int[] kor=new int[3];
		int[] eng=new int[3];
		int[] math=new int[3];
		int[] total=new int[3];
		double[] avg=new double[3];
		char[] score=new char[3];
		
		// 등수 저장 변수 => 3개 묶어서 처리
		int[] rank=new int[3];
		
		// 입력
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<3;i++)
		{
			System.out.print((i+1)+"번째 국어점수 입력:");
			kor[i]=scan.nextInt();
			
			System.out.print((i+1)+"번째 영어점수 입력:");
			eng[i]=scan.nextInt();
			
			System.out.print((i+1)+"번째 수학점수 입력:");
			math[i]=scan.nextInt();
			
			// 총점
			total[i]=kor[i]+eng[i]+math[i];
			//total[0],total[1],total[2]...
			
			// 평균
			avg[i]=total[i]/3.0;
		}
		
		// 학점 구하기
		for(int i=0;i<3;i++)
		{
			switch((int)(avg[i]/10))   // 정수, 문자, 문자열만 갖고올 수 있음
			{
			case 10:   // 100점 이거나
			case 9:    // 90점의 경우
				score[i]='A';   // 학점 A를 주겠다
				break;
			case 8:
				score[i]='B';
				break;
			case 7:
				score[i]='C';
				break;
			case 6:
				score[i]='D';
				break;
			default:
				score[i]='F';
			}
		}
		// 등수 구하기
		for(int i=0;i<3;i++)
		{
			rank[i]=1;
			for(int j=0;j<3;j++)
			{
				if(total[i]<total[j])
				{
					rank[i]++;
				}
			}
		}
		
		// 출력
		for(int i=0;i<3;i++)
		{
			System.out.printf("%d  %d  %d  %d  %.2f  %c  %d\n",   // 출력 형식
					kor[i],eng[i],math[i],total[i],avg[i],score[i],rank[i]);   // 입력 값
		}

	}

}
