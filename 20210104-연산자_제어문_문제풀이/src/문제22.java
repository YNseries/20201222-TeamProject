// 임의의 문자열을 저장 후에 A,a가 몇개인지 여부를 확인
public class 문제22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="AbceasdwfrttAAdfsfa";
		int count=0;
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			if(c=='A'||c=='a')
				count++;
		}
		System.out.println("A나 a의 갯수:"+count);

	}

}
