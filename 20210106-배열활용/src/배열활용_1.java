/*
 *    데이터형
 *      = 기본데이터형 : JVM이 이미 알고 있다 (메모리 크기)
 *        int a=10;            => 정적
 *        ===
 *        4byte
 *      = 참조데이터형 : JVM이 메모리 크기를 알 수 없다 (확인 후 메모리 설정)
 *                   배열, 클래스 => new
 *        int[] arr;
 *        arr=new int[5]       => (new로 들어온 데이터를 확인하고 움직이기 때문에) 동적
 *        *** 사용자 정의 데이터형
 *        *** 여러개의 데이터가 설정 ==> 메모리 주소를 참조해서 처리
 *        
 *    배열 선언 : 메모리 크기 결정(데이터 몇 개를 저장할건지?) => 지정하면 고정
 *      = 데이터형[] 배열명;
 *        정수 : int[] 배열명;
 *        문자열 : String[] 배열명;
 *        실수 : double[] 배열명;
 *      = 데이터형 배열명[];
 *      
 *    배열 초기값 : 만들어진 메모리에 값을 첨부
 *      = int[] arr=new int[갯수];  => 0
 *      = int[] arr={10,20,30};    => 3개
 *      = int[] arr=new int[]{10,20,30};
 *                  ========= 생략이 가능
 *    배열 인덱스 : 저장된 데이터를 제어(변경), 읽기
 *      = int[] arr={10,20,30,40,50};
 *                  arr[0]      arr[2]      arr[4]
 *      ===arr===  ==============================
 *      279f2327      10    20    30    40    50
 *      =========  |=============================
 *             279f2327   arr[1]       arr[3]
 *                           ===          ===
 *                           인덱스: 구분자 => 0번부터, arr.length-1
 */
public class 배열활용_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* int[] a=new int[5];
		int[] aa= {10,20,30};  // 앞에 new int[]{10,20,30}
		//                           ========== 가 생략되어있음
		System.out.println(a);  // 위치 알 수 있음
		*/
		int[] arr= {100,200,300,400,500};
		// 배열에 저장된 데이터를 출력
		for(int i:arr)
		{
			System.out.println("i="+i);
		}
		
		double[] arr1={100.0,200.0,300.0,400.0,500.0};
		for(double d:arr1)
		{
			System.out.println("d="+d);
		}
		
		String[] names= {"홍길동","박문수","이순신","강감찬","을지문덕"};
		for(String name:names)
		{
			System.out.println("name="+name);
		}
	}

}
