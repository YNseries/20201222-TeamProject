
public class 배열활용_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* String data="Hello Java!!";
		char[] cdata=data.toCharArray();   // {'H','e','l'~~}
		for(char c:cdata)
		{
			System.out.println(c);
		} */
		/* char[] cdata= {'A','B','C','D','E'};
		String data=String.valueOf(cdata);    // 문자배열 => 스트링 (한 번에 갖고올 수 있게 모으는 것)
		System.out.println(data); */
		
		// substring()
		/*
		 *    substring(int start)  // 몇번째부터 설정하는 것
		 *    substring(int start, int end)  // 몇번째부터 어디까지 설정하는 것
		 *                         ======= 마지막 글자 제외  6,10-1
		 *                         mainClass.java   => indexOf(".") : .위치를 찾아라
		 *                         A.java
		 *    
		 *    String data="Hello Java!!";
		 *                 01234567891011
		 */
		String data="0123456789";
		System.out.println(data.substring(3));  // (3)부터 갖고와달라
		/*
		 *    "unhappy".substring(2) returns "happy"
		 *     0123456
         *    "Harbison".substring(3) returns "bison"
         *     01234567
		 */
		System.out.println(data.substring(3,5));  // 3,4 (5직전까지. 5를 제외하고 갖고오기)
		                                          // index endIndex - 1
		/*
		 *    "hamburger".substring(4, 8) returns "urge"
		 *     012345678       // 실제 갖고오는 값 => 4~7번째
         *    "smiles".substring(1, 5) returns "mile"
         *     012345         // 1~4번째
		 */

	}

}
