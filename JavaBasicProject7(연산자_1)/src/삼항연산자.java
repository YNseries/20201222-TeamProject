/*
 *    삼항연산자
 *    형식)
 *          조건 ? 값1 : 값2
 *          ===
 *          true ==> 값1
 *          false => 값2
 *          
 *          결과값은 알 수 없다
 *          
 *          boolean bCheck=(조건)?true:false
 *          char c=(조건)?'A':'B'
 *          int i=(조건)?0:1
 *          String s=(조건)?"남자":"여자"
 *          double d=(조건)?0.0;10.0
 *          
 *          /// 결과값이 고정 => 부정연산자, 비교연산자, 논리연산자 ==> boolean
 *          산술 => int+int, int+double
 */
public class 삼항연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c='K';
		boolean bCheck=c>'A'?true:false;
		System.out.println(bCheck);
		
		int a=33;
		String s=a%2==0?"짝수":"홀수";
		System.out.println("a="+s);
		
		int num=1;
		char sex=num==1 || num==3?'남':'여';
		// char, int, long, float, double 가능하지만, 결과로 받을 '남','여'와 같은 char로 받는게 제일 좋음
		System.out.println("성별:"+sex);
		
		sex='남';
		int no=sex=='남'?1:2;
		// int, long. float, double
		System.out.println("주민번호 뒷자리 첫번째 수:"+no);

	}

}
