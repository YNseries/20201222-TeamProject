
public class �迭Ȱ��_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* String data="Hello Java!!";
		char[] cdata=data.toCharArray();   // {'H','e','l'~~}
		for(char c:cdata)
		{
			System.out.println(c);
		} */
		/* char[] cdata= {'A','B','C','D','E'};
		String data=String.valueOf(cdata);    // ���ڹ迭 => ��Ʈ�� (�� ���� ����� �� �ְ� ������ ��)
		System.out.println(data); */
		
		// substring()
		/*
		 *    substring(int start)  // ���°���� �����ϴ� ��
		 *    substring(int start, int end)  // ���°���� ������ �����ϴ� ��
		 *                         ======= ������ ���� ����  6,10-1
		 *                         mainClass.java   => indexOf(".") : .��ġ�� ã�ƶ�
		 *                         A.java
		 *    
		 *    String data="Hello Java!!";
		 *                 01234567891011
		 */
		String data="0123456789";
		System.out.println(data.substring(3));  // (3)���� ����ʹ޶�
		/*
		 *    "unhappy".substring(2) returns "happy"
		 *     0123456
         *    "Harbison".substring(3) returns "bison"
         *     01234567
		 */
		System.out.println(data.substring(3,5));  // 3,4 (5��������. 5�� �����ϰ� �������)
		                                          // index endIndex - 1
		/*
		 *    "hamburger".substring(4, 8) returns "urge"
		 *     012345678       // ���� ������� �� => 4~7��°
         *    "smiles".substring(1, 5) returns "mile"
         *     012345         // 1~4��°
		 */

	}

}
