package com.sist.string;
/*
 *    ½ºÆ®¸µ Å¬·¡½º
 *    =========
 *       char[]À» Á¦¾îÇÏ´Â ÇÁ·Î±×·¥
 *       String => Å¬·¡½º
 *              => ¹®ÀÚ¿­À» ÀúÀå
 *              => ¹®ÀÚ¿­À» ½±°Ô Á¦¾î°¡ °¡´ÉÇÏ°Ô ¸¸µç Å¬·¡½º
 *              => ¹®ÀÚ¿­À» ÀúÀåÇÏ´Â ÀÏ¹İ µ¥ÀÌÅÍÇüÀ¸·Î »ç¿ëÀÌ °¡´É
 *                 ***String name="";
 *                 String name=new String();  // ¸Ş¸ğ¸® ÇÒ´ç
 *       String Å¬·¡½º´Â Call By Reference¸¦ »ç¿ëÇÒ ¼ö ¾ø´Ù(ÀÏ¹İ µ¥ÀÌÅÍÇüÃ³·³ »ç¿ë. StringÀÌ À¯ÀÏ)
 *       
 *       => ¸Ş¼Òµå È£ÃâÇÏ´Â ¹æ½Ä
 *          1) °ª¸¸ Àü¼ÛÇÏ´Â ¹æ½Ä(Call By Value) => ¸Ş¸ğ¸®¸¦ µû·Î »ı±â°Ô ÇÔ(= º¹»çº». ¿øÇü¿£ ¿µÇâx). ±âº» µ¥ÀÌÅÍÇü(int a, int b)
 *          2) ÁÖ¼Ò¸¦ Àü¼ÛÇÏ´Â ¹æ½Ä(Call By Reference) => º»ÀÎÀÇ ÁÖ¼Ò¸¦ ³Ñ±è(¹è¿­, Å¬·¡½º) A a => StringÀº ¿¹¿Ü Á¶°Ç
 *       => Å¬·¡½º¿Í Å¬·¡½º ¿¬°áÇÒ ¶§ => ¹İµå½Ã ¸Ş¼Òµå È£Ãâ!
 *       
 *       String¿¡¼­ ±â´É
 *       ============
 *       ¹®ÀÚ¿­ º¯È¯                                                   (returnÇü)
 *         = ´ë¹®ÀÚ º¯°æ: toUpperCase() => "aaa".toUpperCase() => "AAA" (String)
 *         = ¼Ò¹®ÀÚ º¯°æ: toLowercase()                        =>       (String) 
 *         = °ø¹é¹®ÀÚ Á¦°Å: ÁÂ¿ìÀÇ °ø¹é¸¸ Á¦°Å => trim()   " aaa ".trim() => "aaa" (String)
 *         = ¹®ÀÚ¿­ °áÇÕ: concat() => ºóµµ°¡ ÀÛ´Ù (+)
 *                    "Hello".concat("Java") ==> "HelloJava" =>       (String)
 *                    ¿ø·¡´Â "Hello"+"Java" Çß¾úÁö
 *       ¹®ÀÚ¿­ Á¦¾î
 *         ###### ¸ğµç ¹®ÀÚ¿­Àº ½ÃÀÛ ¹øÈ£°¡ 0¹øºÎÅÍ ½ÃÀÛÇÑ´Ù
 *         "Hello Java"
 *          0123456789   ==> length(): 10 (°ø¹é Æ÷ÇÔÇØ¾ß ÇÔ)
 *         = ¹®ÀÚ¿­ ±æÀÌ: length()
 *         = ¹®ÀÚ ÇÑ °³¸¦ °¡Áö°í ¿Â´Ù: charAt()  => charAt(6)
 *         ===============================
 *         = ½ÃÀÛ ¹®ÀÚ¿­: startsWith()
 *         = ³¡³ª´Â ¹®ÀÚ¿­: endsWith()
 *         =============================== °Ë»ö±â Á¦ÀÛ
 *         = Æ÷ÇÔ¹®ÀÚ: contains() : ÃßÃµ
 *         "hello" "Hello" => ID, Password
 *         = ¹®ÀÚºñ±³: equals(): ´ë¼Ò¹®ÀÚ ±¸ºĞ(´Ù¸£¸é Æ²¸²), equalsIgnoreCase(): ´ë¼Ò¹®ÀÚ ±¸ºĞ ¾øÀÌ ºñ±³
 *           "Hell.o.java"
 *         = ¹®ÀÚ À§Ä¡Ã£±â: indexOf() => l.o: Ã³À½(.), lastIndexOf() => o.java: ¸¶Áö¸·¿¡ ÀÖ´Â ¹®ÀÚ(.)
 *         = ¹®ÀÚº¯È¯: replace: ÇÑ ±ÛÀÚ, replaceAll: Á¤±Ô½Ä
 *           "abcAbc1234ÇÑ±Û" => replaceAll("[^0-9]","") = ¼ıÀÚ¸¦ Á¦¿ÜÇÏ°í ³ª¸ÓÁö Áö¿ö => "1234"
 *           ¼ıÀÚ  [0-9]
 *           ¾ËÆÄºª [A-Z]´ë¹®ÀÚ + [a-z]¼Ò¹®ÀÚ = [A-Za-z]¾ËÆÄºª ÀüÃ¼
 *           ÇÑ±Û  [°¡-ÆR]
 *           
 *           "red,green,blue,yellow,black"
 *         = ¹®ÀÚºĞÇØ
 *           = split: ±¸ºĞÀÚº°·Î ¹è¿­¿¡ ÀúÀå
 *           = substring: ¹®ÀÚÀÇ À§Ä¡ ÁöÁ¤
 *         = °´Ã¼¸¦ ¹®ÀÚ º¯È¯: toString()
 *         = ¸ğµç µ¥ÀÌÅÍÇüÀ» ¹®ÀÚ¿­·Î º¯È¯ => valueOf()
 *         = ¹®ÀÚ Å©±â ºñ±³(Á¤·Ä): "ABC" "ACD" compareTo() int => °°´Ù(0), ¿ŞÂÊÀÌÅ©´Ù(1), ¿À¸¥ÂÊÀÌÅ©´Ù(-1)
 *           "aaa".compareTo("aaa")
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="hello";
		String s=str.toUpperCase();   // s°¡ ¹Ù²ï°ÅÁö, strÀº ±×´ë·Î ÀÖÀ½
		String s1=str.toLowerCase();
		System.out.println(str);
		System.out.println(s);
		String s2=str.concat("Java");  // s2°¡ ¹Ù²ï°ÅÁö strÀÌ ¹Ù²ï°Å ¾Æ´Ô! ÀØÁö¸¶
		System.out.println(s2);
		System.out.println(str);

	}

}
