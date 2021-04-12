// ÇĞÁ¡À» °è»êÇÏ´Â ¸Ş¼Òµå ¸¸µé±â
// replaceAll("[^°¡-ÆR]","")  // ÇÑ±Û¸¸ Ãâ·Â
// [^0-9] // ¼ıÀÚ¸¸     [^A-Za-z]????????? // ¿µ¾î¸¸
import java.util.Scanner;
public class ¸Ş¼ÒµåÈ°¿ë_2 {
	// ¹İº¹ÀÌ µÇ±â ¶§¹®¿¡ (¹İº¹À» ¾ø¾Ö±â À§ÇØ ¸¸µç ¸Ş¼Òµå)
	static int input(String subject)
	{
		Scanner scan=new Scanner(System.in);
		System.out.print(subject+" Á¡¼ö ÀÔ·Â:");
		return scan.nextInt();
	}
	// ÇĞÁ¡À» ±¸ÇÏ´Â ¸Ş¼Òµå (´ÙÀ½¿¡ ´Ù½Ã »ç¿ëÇÏ±â À§ÇØ¼­ ¸¸µå´Â°Å!) : Àç»ç¿ë ¸ñÀû / ¼Ò½º°¡ º¯ÇÏÁö´Â ¾ÊÀ½. ¸Ş¸ğÀå¿¡ µÎ°í °®°í¿Â´Ù°í »ı°¢ÇÏ¸é µÊ
	static char hakjum(int avg)
	{
		char score='A';
		switch(avg)
		{
		case 10:
		case 9:
			score='A';
			break;
		case 8:
			score='B';
			break;
		case 7:
			score='C';
			break;
		case 6:
			score='D';
		default:
			score='F';
		}
		return score;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int kor,eng,math;
		char score='A';
		// »ç¿ëÀÚ°¡ ÀÔ·Â
		/* Scanner scan=new Scanner(System.in);
		System.out.print("±¹¾îÁ¡¼ö ÀÔ·Â:");
		kor=scan.nextInt();
		System.out.print("¿µ¾îÁ¡¼ö ÀÔ·Â:");
		eng=scan.nextInt();
		System.out.print("¼öÇĞÁ¡¼ö ÀÔ·Â:");
		math=scan.nextInt(); */
		kor=input("±¹¾î");
		eng=input("¿µ¾î");
		math=input("¼öÇĞ");
		
		// ÇĞÁ¡
		int avg=(kor+eng+math)/30;   // ¾Õ¿¡ ´ÜÀ§¸¦ ´Ù ¶¼¾î³»´Â°Í! ÀÌ·¯¸é switch ¾²±â ½¬¿öÁü
		/* switch(avg)
		{
		case 10:
		case 9:
			score='A';
			break;
		case 8:
			score='B';
			break;
		case 7:
			score='C';
			break;
		case 6:
			score='D';
		default:
			score='F';
		} */  // ÀÌ¿ëÇÒ source´Â ¶È°°Áö¸¸ method·Î ¸¸µé±â À§ÇØ¼­ À§·Î »¬°Å¾ß! ÇĞÁ¡ È®ÀÎÇÒ ¶§¸¶´Ù ¾µ ¼ö ÀÖÀ¸´Ï±î
		score=hakjum(avg);   // ¸Ş¼Òµå È£Ãâ => ¸Ş¼Òµå Ã³À½ºÎÅÍ ½ÇÇà => °á°ú°ªÀ» ³Ñ°ÜÁÖ°í ´ÙÀ½¹®ÀåÀ¸·Î ÀÌµ¿
		
		System.out.println("±¹¾î:"+kor);
		System.out.println("¿µ¾î:"+eng);
		System.out.println("¼öÇĞ:"+math);
		System.out.println("ÃÑÁ¡:"+(kor+eng+math));
		System.out.printf("Æò±Õ:%.2f\n",(kor+eng+math)/3.0);
		System.out.println("ÇĞÁ¡:"+score);

	}

}
