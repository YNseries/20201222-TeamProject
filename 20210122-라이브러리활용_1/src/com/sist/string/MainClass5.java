package com.sist.string;
/*
 *    replace: 한개의 문자변경
 *    replaceAll: 정규식(문자패턴을 주는 것) => 한번에 처리가 가능!
 *    
 *    이메일: ^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w\\.)+\\w+$
 *    IP
 *        211.238.142.181
 *        127.0.0.1
 *                 .은 임의의 글자?숫자? .을 넣고싶으면 앞에 \\넣어야 함
 *        [0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}   => 전세계 IP를 갖고올 수 있음
 */
public class MainClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg="ABCDEFGABCD";
		String replace_msg=msg.replace('A', 'K');   //=> A를 K로 변환
		System.out.println(replace_msg);
		// 네트워크 => 서버가 값을 받는 경우 ==> \n까지가 하나의 문장
		// => replace('\n', '\t') => replace("<title>","");  * 10번보다는 정규식이 편하지
		String msg2="<title>명예훼손 없이 <b>리뷰</b>쓰기</title>\r\n"
				+ "<link>http://openapi.naver.com/l?AAABWLyw6CMBREv+ayNJe2UrrogvJwg8aYKGvACiSUalNR/t6azGLO5Mzrrd0moVSQJZDl/6I4KIxGpx9y9P4JNANShXSzHXZLu2q3660Jw2bt0k1+aF1rgFYXfZ+c7j3QorYDkCT4JxuIEEyRUYGcxpGXMeMs3VPBOUEWGXntynUW03k7ohBYfG+mOdRqbPL6E84/apnqgaEAAAA=</link>\r\n"
				+ "<description>명예훼손 없이 <b>리뷰</b>쓰기 우리 블로그하시는 분들께는 꽤 중요한 내용일 수도 있습니다 그것도 주로 <b>리뷰</b> 위주로 블로그를 진행하신 분이라면 더욱 더 말이죠\r\n"
				+ "오늘 포스팅은, 어떻게 하면 객관적이고 좋은 <b>리뷰</b>를... </description>\r\n"
				+ "<bloggername>건짱의 Best Drawing World2</bloggername>";
		msg2=msg2.replaceAll("[^가-힣 ]","");   // 한글은 제외하고, 한글이 아닌 나머지 부분은 공백  ^ = not
		// [가-힣] => 한글 전체   [^가-힣] => 한글 제외   ^[가-힣] => 한글로 시작   [가-힣]$ => 한글로 끝남
		System.out.println(msg2);
	}

}
