/*
 *    1. 같은 타입의 여러 변수를 하나로 묶어서 관리하는 기능
 *       ======   ====== 여러개의 변수를 한개의 이름으로 통일 (구분: 인덱스)
 *       정수, 실수, 문자열   arr[0],arr[1]
 *                          ===
 *                          인덱스 번호(인덱스 번호는 0부터 시작)
 *                          *** 배열의 인덱스 번호(범위)를 초과하면 에러 발생
 *                              ArrayIndexOutOfBoundsException
 *    2. 배열 선언
 *       정수형
 *         int[] arr; (권장사항)  /   int arr[];   (C언어에서 옴)
 *         ===== ===
 *         배열선언 배열명
 *            arr
 *           ======
 *            
 *           ======
 *         
 *         예)
 *               int[][] arr : 자바  => int[] arr[]  가능
 *               int arr[][] : C언어   자바에서 가능
 *               int arr[,] : C#    자바에서 불가능
 *               
 *    3. 배열 초기화 ==> 배열, 클래스 ==> 저장되는 위치가 다름 (heap), 일반 데이터형(stack)-자동으로 메모리가 사라짐
 *       int[] arr=new int[5];  ==> 메소드(많이 사용) => 연산자 변경
 *                 ===
 *                 동적메모리 할당 (실행 할 때마다 메모리 생성)  ==> int ==> malloc(),free()
 *                                                               ======== ======
 *                    arr[0] arr[1] arr[2] arr[3] arr[4]           new    delete ==> GC(Garbage Collection)
 *       ===arr===   ===================================
 *         1000         0      0      0      0      0
 *       =========   |======|======|======|======|======
 *                  1000
 *                  
 *                  arr[0] arr[1] arr[2] arr[3] arr[4] => 일반 변수와 동일하게 사용
 *                  
 *                  ==> 읽기, 쓰기
 *                  쓰기 => arr[0]=100
 *                         arr[4]=500
 *                  읽기 => System.out.println(arr[0])
 *                  
 *                  예)
 *                      int[] arr=new int[5];   저장 갯수를 알고 있는 경우
 *                      int[] arr;
 *                      arr=new int[5];   ===> 메모리에 연속적으로 20byte를 만들어 달라
 *                                 === 저장할 갯수(저장 갯수를 알 수 없는 경우)
 *                      arr[0]
 *                         === 데이터가 저장된 위치 (배열은 0부터 시작)
 *                         
 *            int[] score=new int[5];
 */
public class 배열정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
