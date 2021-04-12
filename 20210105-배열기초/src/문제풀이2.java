import java.util.Arrays;

/*
 *    정렬 (ASC/DESC)
 *    ASC : 올림차순
 *    DESC : 내림차순
 *    ==> 정렬 처리 방식
 *        = 선택 정렬
 *          31  55  85  63  96   ==>  96 85 63 55 31
 *          ==  ==
 *          55  31
 *          ==      ==
 *          85      55
 *          ==          ==
 *          85          63
 *          ==              ==
 *          96              85
 *          ============================= for문 (1round)
 *          96  31  55  63  85
 *              ==  ==
 *              55  31
 *              ==      ==
 *              63      55
 *              ==          ==
 *              85          63
 *          ============================== 2round
 *          96  85  31  55  63
 *                  ==  ==
 *                  55  31
 *                  ==      ==
 *                  63      55
 *          ============================== 3round
 *          96  85  63  31  55
 *                      ==  ==
 *                      55  31
 *          ============================== 4round
 *          96  85  63  55  31
 *                          ==      0 arr.length-1
 *                          
 *        = 버블 정렬
 *          31  55  85  63  96   ==>  96 85 63 55 31
 *          ==  ==
 *          55  31
 *              ==  ==
 *              85  31
 *                  ==  ==
 *                  63  31
 *                      ==  ==
 *                      96  31
 *          =============================== 1round
 *          55  85  63  96  31
 *          ==  ==
 *          85  55
 *              ==  ==
 *              63  55
 *                  ==  ==
 *                  96  55
 *          ============================== 2round
 *          85 63 96 55 31
 *          == ==
 *          85 63
 *             == ==
 *             96 63
 *          ============================== 3round
 *          85 96 63 55 31
 *          == ==
 *          96 85
 *          ============================== 4round
 *             
 */
public class 문제풀이2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[5];
		//초기값
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*100)+1;  //1~100
		}
		//출력
		System.out.println("=====정렬전=====");
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		System.out.println("\n=====정렬후=====");
		// Arrays.sort(arr);
		
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]<arr[j])    // 내림차순.   >방향이면 오름차순
				{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		for(int i:arr)
		{
			System.out.print(i+" ");
		}

	}

}
