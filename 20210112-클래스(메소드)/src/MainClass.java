class Music
{
	String title;
	String singer;
	void print()
	{
		System.out.println("노래명:"+title);
		System.out.println("가수명:"+singer);
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Music m1=new Music();
		/*
		 *    m1 ===> title
		 *            singer
		 *            print()
		 */
		m1.title="aaa";
		m1.singer="bbb";
		m1.print();
		
		Music m2=new Music();
		/*
		 *    m2 ===> title
		 *            singer
		 *            print()
		 */
		m2.print();
		
		Music m3=m1;   // 같은 메모리를 제어
		m3.print();
		System.out.println("m2="+m2);
		System.out.println("m1="+m1);
		System.out.println("m3="+m3);
		
		m3.title="ccc";
		m3.singer="ddd";
		
		m1.print();

	}

}
