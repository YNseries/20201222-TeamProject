package com.sist.string;
/*
 *    replace: ÇÑ°³ÀÇ ¹®ÀÚº¯°æ
 *    replaceAll: Á¤±Ô½Ä(¹®ÀÚÆÐÅÏÀ» ÁÖ´Â °Í) => ÇÑ¹ø¿¡ Ã³¸®°¡ °¡´É!
 *    
 *    ÀÌ¸ÞÀÏ: ^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w\\.)+\\w+$
 *    IP
 *        211.238.142.181
 *        127.0.0.1
 *                 .Àº ÀÓÀÇÀÇ ±ÛÀÚ?¼ýÀÚ? .À» ³Ö°í½ÍÀ¸¸é ¾Õ¿¡ \\³Ö¾î¾ß ÇÔ
 *        [0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}   => Àü¼¼°è IP¸¦ °®°í¿Ã ¼ö ÀÖÀ½
 */
public class MainClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg="ABCDEFGABCD";
		String replace_msg=msg.replace('A', 'K');   //=> A¸¦ K·Î º¯È¯
		System.out.println(replace_msg);
		// ³×Æ®¿öÅ© => ¼­¹ö°¡ °ªÀ» ¹Þ´Â °æ¿ì ==> \n±îÁö°¡ ÇÏ³ªÀÇ ¹®Àå
		// => replace('\n', '\t') => replace("<title>","");  * 10¹øº¸´Ù´Â Á¤±Ô½ÄÀÌ ÆíÇÏÁö
		String msg2="<title>¸í¿¹ÈÑ¼Õ ¾øÀÌ <b>¸®ºä</b>¾²±â</title>\r\n"
				+ "<link>http://openapi.naver.com/l?AAABWLyw6CMBREv+ayNJe2UrrogvJwg8aYKGvACiSUalNR/t6azGLO5Mzrrd0moVSQJZDl/6I4KIxGpx9y9P4JNANShXSzHXZLu2q3660Jw2bt0k1+aF1rgFYXfZ+c7j3QorYDkCT4JxuIEEyRUYGcxpGXMeMs3VPBOUEWGXntynUW03k7ohBYfG+mOdRqbPL6E84/apnqgaEAAAA=</link>\r\n"
				+ "<description>¸í¿¹ÈÑ¼Õ ¾øÀÌ <b>¸®ºä</b>¾²±â ¿ì¸® ºí·Î±×ÇÏ½Ã´Â ºÐµé²²´Â ²Ï Áß¿äÇÑ ³»¿ëÀÏ ¼öµµ ÀÖ½À´Ï´Ù ±×°Íµµ ÁÖ·Î <b>¸®ºä</b> À§ÁÖ·Î ºí·Î±×¸¦ ÁøÇàÇÏ½Å ºÐÀÌ¶ó¸é ´õ¿í ´õ ¸»ÀÌÁÒ\r\n"
				+ "¿À´Ã Æ÷½ºÆÃÀº, ¾î¶»°Ô ÇÏ¸é °´°üÀûÀÌ°í ÁÁÀº <b>¸®ºä</b>¸¦... </description>\r\n"
				+ "<bloggername>°ÇÂ¯ÀÇ Best Drawing World2</bloggername>";
		msg2=msg2.replaceAll("[^°¡-ÆR ]","");   // ÇÑ±ÛÀº Á¦¿ÜÇÏ°í, ÇÑ±ÛÀÌ ¾Æ´Ñ ³ª¸ÓÁö ºÎºÐÀº °ø¹é  ^ = not
		// [°¡-ÆR] => ÇÑ±Û ÀüÃ¼   [^°¡-ÆR] => ÇÑ±Û Á¦¿Ü   ^[°¡-ÆR] => ÇÑ±Û·Î ½ÃÀÛ   [°¡-ÆR]$ => ÇÑ±Û·Î ³¡³²
		System.out.println(msg2);
	}

}
