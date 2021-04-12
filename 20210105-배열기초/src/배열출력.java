// for-each
public class 배열출력 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[10];
		// 초기화
		for(int i=0;i<arr.length;i++)  // index번호 이용
		{
			arr[i]=(int)(Math.random()*100)+1;  // 1~100사이의 난수를 생성
		}
		// 출력 => forEach구문
		for(int i:arr)
		{
			System.out.print(i+" ");
		}

	}

}
