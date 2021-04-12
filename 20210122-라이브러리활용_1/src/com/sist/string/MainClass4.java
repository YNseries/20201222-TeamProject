package com.sist.string;
// data-lazy="https://mp-seoul-image-production-s3.mangoplate.com/keyword_search/meta/pictures/afkudopipqgww3lu.jpg?fit=around|600:400&amp;crop=600:400;*,*&amp;output-format=jpg&amp;output-quality=80"/>
// ������ ��ġ�� ã���ش� => indexOf,lastIndexOf(���, Ȯ����)
/*
 *     String s="ABCDEFGABC";
 *               0123456789
 *     s.indexOf('A') => 0      : �տ������� ã��!
 *     s.lastIndexOf('A') => 7  : �ڿ������� ã��!
 *     
 *     indexOf(char) => int indexOf('A') | indexOf("A")
 *     int lastIndexOf('A')
 */
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String image="https://mp-seoul-image-production-s3.mangoplate.com/keyword_search/meta/pictures/afkudopipqgww3lu.jpg?fit=around|600:400&amp;crop=600:400;*,*&amp;output-format=jpg&amp;output-quality=80";
		int index=image.indexOf("?");  // image.indexOf('?') �� �ᵵ �������
		int last=image.lastIndexOf('?');
		System.out.println("index="+index);
		System.out.println("last="+last);
		// substring: ���ڿ��� �ڸ� ��  => �� �̿��ؼ� �̹��� �߶����!
		String real_image=image.substring(0,image.indexOf("?"));
		System.out.println(real_image);
		/*
		 *  String s="ABCDEFGHIJK";
		 *            012345678910 => 11��
		 *  String substring(int s)         => s���� ������
		 *  substring(3) ==> "DEFGHIJK"
		 *  String substring(int s, int e)  => s���� e-1����(s�̻� e�̸�)
		 *  substring(5,9) ==> "FGHI"
		 */
	}

}
