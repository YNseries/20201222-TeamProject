/*
 *    break : 반복문(while,do~while,for), switch : 반복문을 종료
 *            break => 무한루프에 걸렸을 때(while문에 잘 등장)
 */
public class 반복제어문_break {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// i 값을 출력(1~100)
		for(int i=1;i<=100;i++)  // 반복횟수가 100
		{
			if(i==10)
				break;  // 반복을 중단  ==> for문 중단
			System.out.println("i="+i);
		}

	}

}
