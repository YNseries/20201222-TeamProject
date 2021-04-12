/*
 *   이중 반복문(중첩 for)
 *   형식)
 *        가로 : 이차 for
 *        세로 : 일차 for
 *        
 *                 false: 종료
 *                  ↗ 
 *             1 →  2  ← 4
 *        for(초기값;조건식;증가식) ==> 줄 수
 *        {             ↗ 
 *                  ↓ true
 *                  3
 *          =========================================
 *                1 →  2  ← 4 
 *           for(초기값;조건식;증가식)  ==> 실제 반복 내용 수행
 *           {             ↗ 
 *                     ↓ true
 *                     3
 *                반복 수행문장
 *            }
 *          =========================================
 *           다음 줄에 출력
 *        }
 *        
 */
public class 이중반복문_for {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=5;j++)
			{
				System.out.println("i="+i+",j="+j);
				// i=1  => j=1,2,3,4,5
				// i=2  => j=1,2,3,4,5
				// ---
				// i=5  => j=1,2,3,4,5
			}
		}

	}

}
