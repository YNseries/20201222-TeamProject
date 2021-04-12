


// 1~10까지 랜덤 수 중복되지 않게
public class 배열활용_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[10];
		// 난수를 저장하는 변수
		int su=0;
		// 중복여부를 확인하는 변수
		boolean bCheck=false;
		
		for(int i=0;i<arr.length;i++)
		{
			bCheck=true;
			while(bCheck)
			{
				// 난수 발생 후 비교 => 중복여부 확인 / 중복이 없으면 저장
				su=(int)(Math.random()*10)+1;
				bCheck=false;   // 빠져나가는 조건 밖에 해야 함. for문에 else if 못넣으니까
				for(int j=0;j<i;j++)
				{
					if(arr[j]==su)
					{
						bCheck=true;
						break;  // continue ==> 자신의 반복문만 제어
					}
				}
			}
			arr[i]=su;   // 중복되지 않은 데이터만 저장된
		}
		// 출력
		for(int i:arr)
		{
			System.out.print(i+" ");
		}

	}

}
