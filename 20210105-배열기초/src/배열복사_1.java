/*
 *    배열을 복사
 *       한개씩 복사
 *       라이브러리 이용=> arraycopy()
 *    향상된 for
 */
public class 배열복사_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10,20,30,40,50};   // 배열 => 저장공간
		// 큰 배열을 선언
		int[] temp=new int[10];
		// 원시적인 방법
		for(int i=0;i<arr.length;i++)
		{
			temp[i]=arr[i];
		}
		/*
		 *    =====================
		 *      10  20  30  40  50   ==> arr
		 *    =====================
		 *    =====================================
		 *      10  20  30  40  50  0  0  0  0  0     ==> temp
		 *    =====================================
		 */
		// 출력
		for(int i:temp)  // for-Each, 향상된 for문  => 출력할 때 주로 사용
		{
			// i=10, i=20  ==> tmep에 저잗왼 실제 데이터값을 받아온다(여기서 i는 인덱스 번호가 아님)
			System.out.print(i+" ");
		}
		// 웹출력
		System.out.println("\n======== forEach ==========");  // JDK1.5 이상, 값을 변경하지 못함, 출력담당
		
		// 반드시 배열, 컬렉션(데이터가 모아져 있어야 가능)
		char[] alpha= {'A','B','C','D','E'};
		System.out.println("저장된 데이터의 갯수:"+alpha.length);
		System.out.println("첫번째 저장된 데이터:"+alpha[0]);
		System.out.println("마지막 저장된 데이터:"+alpha[alpha.length-1]);
		
		// 전체 데이터 출력
		/*
		 * for(int i=0;i<alpha.length;i++) 
		 * { alpha[0]='K'; // 인덱스 번호를 갖고오는 것이기 때문에 값을 바꿀 수 있음 
		 * System.out.println(alpha[i]); }
		 */
		
		System.out.println("=====향상된 for(forEach)=====");
		for(char c:alpha)
		{
			c='K';          // 인덱스 번호가 아니라서 실제 값을 바꿀 수 없음
			System.out.println(c);
		}
		
		System.out.println("=====향상된 for(forEach)=====");
		for(char c:alpha)
		{
			System.out.println(c);
		}

	}

}
