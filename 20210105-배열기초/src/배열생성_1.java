/*
 *    page 182
 *    배열
 *     = 같은 데이터형 여러개를 한개로 묶어서 관리
 *       =========
 *       double d='A'   ==> d=65.0
 *       int i=10.5(x)
 *     = 연속적인 메모리 구조
 *     = 한개의 이름으로 모든 데이터를 관리
 *     = 단점: 메모리가 고정(=> 프로그램상에서 변경할 수는 있다)
 *            =================================== 가변(컬렉션 클래스)
 *                                                ==============
 *     = 배열은 같은 데이터형이 3개 이상일 때 잘 씀
 *     1. 배열 선언 => 배열 []
 *        데이터형[] 배열명;  //자바에서 권장하는 형태
 *        데이터형 배열명[];  //C언어에서 파생된 형태
 *     2. 배열 초기화
 *        2-1. 생성과 동시에 초기화
 *             int[] arr={10,20,30,40,50};
 *        2-2. 생성하고 나중에 값을 채우는 방법
 *             int[] arr=new int[5];     //new를 사용하면 자동으로 0으로 초기화 됨
 *                       ===
 *                       int => 0
 *                       double => 0.0
 *                       boolean => false
 *                       String => null
 *             ===> 배열의 값을 변수처럼 수정이 가능하다, 읽기도 가능
 *        2-3. 생성하되, 자동 초기화시키는 방법
 *     3. 배열에 있는 데이터 읽기(출력)
 *             예)
 *                int[] arr={10,20,30,40,50};
 *                
 *                   arr
 *                 =======         ===========================================
 *                   100                10       20     30      40      50     
 *                 =======         |==========================================
 *                                100  arr[0]  arr[1]  arr[2]  arr[3]  arr[4]
 *                                
 *                 ==> 변수와 동일하게 사용이 가능
 *                     arr[0]=100;
 *                   arr
 *                 =======         ===========================================
 *                   100                100      20     30      40      50     
 *                 =======         |==========================================
 *                                100  arr[0]  arr[1]  arr[2]  arr[3]  arr[4]   ==> 변수 대신 사용
 *                        System.out.println(arr[1])   ==> 20
 *                        
 *                 *** 배열은 0번부터 시작한다
 *                 *** 배열의 갯수 => 배열명.length
 *                 
 *                 *** 변수가 여러개 있다 => 1차원 배열을 선택
 *                     1차원 배열이 여러개 => 2차원 배열
 *                     =========================
 *                     2차원 배열이 여러개 => 3차원 배열
 */
public class 배열생성_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* try
		{
			Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe http://www.daum.net");
		}catch(Exception ex) {} */
		
		// 5개의 값을 설정하고 최대값을 출력하는 프로그램
		/* int a=80;
		int b=85;
		int c=75;
		int d=88;
		int e=90;
		
		// 최대값을 저장하는 변수
		int max=0;
		
		// 비교해서 최대값을 찾는다
		if(max<a)
			max=a; //max=80
		if(max<b)
			max=b; //max=85
		if(max<c)
			max=c; //점프 => max=85
		if(max<d)
			max=d; //max=88
		if(max<e)
			max=e; //max=90
		
		System.out.println("최대값은:"+max); */
		
		
		//데이터를 모아서 저장
		int[] arr={80,85,75,88,90};
		/*
		 *    arr         arr[0] arr[1] arr[2] arr[3] arr[4]
		 *                   ===
		 *                   인덱스번호(첨자) ==> 배열의 갯수-1
		 *                  a      b      c      d      e
		 *   =====       ====================================
		 *    100           80     85     75     88     90
		 *   =====       |===================================
		 *             100번지
		 */
		// 유사한 데이터를 모아서 관리 => 한 개 이름으로 처리(배열)
		// arr.length => 배열에 저장된 총 갯수
		int max=arr[0];  //배열의 첫번째 값을 대입
		int min=arr[0];
		for(int i=0;i<arr.length;i++)  // 배열의 갯수 입력보다 길이를 알아서 측정하도록 하는게 좋음
		{
			if(max<arr[i])      // max의 값보다 array[i]이 크면 max = array[i]
				max=arr[i]; 
			if(min>arr[i])      // min의 값보다 array[i]이 작으면 min = array[i]
				min=arr[i];
			System.out.println("max="+max+",min="+min);
		}
		System.out.println("최대값:"+max);
		System.out.println("최소값:"+min);
	}

}
