// 정수 1개를 입력받아서 2진법으로 변경해서 출력 => 16bit(0,1 => 16)
// 32767(양수만 처리) => 16bit의 가장 마지막 정수
/*
 *    1. 정렬
 *       = 선택정렬(배열활용_3)
 *       = 버블정렬(배열활용_4)
 *    1-1 빈도수 확인(배열활용_5)
 *        132111222   => 문자열 => 추천
 *    2. 윤년 => 달력
 *    3. 숫자 야구 게임(중복이 없는 난수 발생)
 *                  ===============
 *                     로또 => 6개
 *    4. 문자열 배열(배열활용_6) page206
 */
// 정수 1개를 입력받아서 2진법으로 변경해서 출력 => 16bit (0,1=>16)
/*
 *    1. 변수(저장공간)
 *       = 0,1을 16개 저장할 수 있는 공간 => 배열
 *       = 사용자 입력값 저장
 *       = 배열 => 16 => index번호를 제어할 변수
 */
// 사용자 입력값
import java.util.Scanner;
public class 배열활용_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] binary=new int[16];  // 0,1만 저장
		int input;  // 사용자가 입력한 정수를 저장
		int index=15;  // 맨 뒤에서부터 올라오기 위함
		// 배열에 값을 채울 경우, 뒤에서부터(length-1) 채울건지, 앞에서부터(0) 채울건지 생각을 갖고있어야 함. 
		// 사용자로부터 정수값을 받기
		Scanner scan=new Scanner(System.in);
		System.out.print("0~32767 사이의 정수를 입력(16bit):");
		input=scan.nextInt();  // 사용자 입력을 받았음 ==> 입력된 정수를 2진법으로 출력
		// 입력된 정수에 따라 반복수행이 달라짐 => while
		/*
		 *   1. 정수를 나누고 나머지 저장
		 *   2. 정수를 2로 나눈다
		 */
		System.out.println("======라이브러리======");
		System.out.println(Integer.toBinaryString(input));   // 메소드. 필요할 때마다 가져다 쓸 수 있게 만든것
		
		// 위와 같은 내용의 메소드를 풀어쓰면
		while(true)
		{
			// 나머지 저장
			binary[index]=input%2;  // 0,1
			input= input/2;
			if(input==0)
				break;
			index--;
		}
		
		// 출력 0000 0000 0000 1010
		for(int i=0;i<binary.length;i++)
		{
			if(i%4==0 && i!=0)
				System.out.print(" ");
			System.out.print(binary[i]);
		}

	}

}
