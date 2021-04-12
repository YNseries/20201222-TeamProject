package com.sist.string;
// data-lazy="https://mp-seoul-image-production-s3.mangoplate.com/keyword_search/meta/pictures/afkudopipqgww3lu.jpg?fit=around|600:400&amp;crop=600:400;*,*&amp;output-format=jpg&amp;output-quality=80"/>
// 문자의 위치를 찾아준다 => indexOf,lastIndexOf(경로, 확장자)
/*
 *     String s="ABCDEFGABC";
 *               0123456789
 *     s.indexOf('A') => 0      : 앞에서부터 찾기!
 *     s.lastIndexOf('A') => 7  : 뒤에서부터 찾기!
 *     
 *     indexOf(char) => int indexOf('A') | indexOf("A")
 *     int lastIndexOf('A')
 */
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String image="https://mp-seoul-image-production-s3.mangoplate.com/keyword_search/meta/pictures/afkudopipqgww3lu.jpg?fit=around|600:400&amp;crop=600:400;*,*&amp;output-format=jpg&amp;output-quality=80";
		int index=image.indexOf("?");  // image.indexOf('?') 로 써도 상관없음
		int last=image.lastIndexOf('?');
		System.out.println("index="+index);
		System.out.println("last="+last);
		// substring: 문자열을 자를 때  => 를 이용해서 이미지 잘라오기!
		String real_image=image.substring(0,image.indexOf("?"));
		System.out.println(real_image);
		/*
		 *  String s="ABCDEFGHIJK";
		 *            012345678910 => 11개
		 *  String substring(int s)         => s부터 끝까지
		 *  substring(3) ==> "DEFGHIJK"
		 *  String substring(int s, int e)  => s부터 e-1까지(s이상 e미만)
		 *  substring(5,9) ==> "FGHI"
		 */
	}

}
