/*
 *    로또 => 1~45까지 6개  ==> 배열
 */
public class 배열활용_9 {
	
	public static void main(String[] args) {
		// 6개의 번호를 저장하는 메모리 공간 : 배열
		int[] lotto=new int[6];
		// 초기화
		for(int i=0;i<lotto.length;i++)
		{
			// 0.0 and less than 1.0(0.99)
			lotto[i]=(int)(Math.random()*45)+1;  // 1~45
		}
		// 출력
		for(int i:lotto)
		{
			System.out.print(i+" ");
			/*
			 * try { Thread.sleep(1000); }catch(Exception ex) {}
			 * 나오는 속도를 늦추는 것
			 */
			
		}
	}

}
