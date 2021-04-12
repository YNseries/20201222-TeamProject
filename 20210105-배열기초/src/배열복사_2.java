// 라이브러리 이용
public class 배열복사_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] names= {"홍길동","이순신","강감찬","을지문덕","박문수"};
		String[] members=new String[10];
		
		int[] arr= {10,20,30,40,50};
		double[] dd=new double[10];
		
		//  ==> dd[0]=arr[0] 가능
		//  ==> double d=10;  => 
		// System.arraycopy(arr, 0, dd, 0, arr.length);  // arraycopy에서는 arr위치와 dd 위치의 데이터형이 같아야 함.
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(i);
		}
		for(double d:dd)
		{
			System.out.println(d);
		}
		// Object src, int srcPos, Object dest, int destPos, int length)
		/*
		 *         0      1      2       3      4
		 *      =====================================
		 *       "홍길동","이순신","강감찬","을지문덕","박문수"  ==> names
		 *      =====================================
		 *         0   1   2   3   4   5   6   7   8   9
		 *      ===================================================
		 *       null null null "홍길동","이순신","강감찬","을지문덕","박문수" null null  ==> members
		 *      ===================================================
		 * 
		 */

		System.arraycopy(names, 4, members, 9, 1);
		          // 어디서, 몇번째부터, 어디(위치)에, 몇번째에, 몇개를 카피할건지
		          // arraycopy는 같은 데이터형에서만 가능!!!
		//     members[9]=names[4];
		
		// 실행
		for(String name:members)
		{
			System.out.println(name);
		}
	}

}
