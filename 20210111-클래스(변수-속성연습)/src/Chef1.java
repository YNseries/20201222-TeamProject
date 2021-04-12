/*
 * 	 소식받기
 *    순위  쉐프이름  소식받기
 *         레시피수  클립된 수  읽은 수  댓글
 */
public class Chef1 {
	int rank;
	String chef;
	int recipe;
	int scrap;
	int view;
	int comment;
	
	static String title="10000개의 레시피";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chef1 c=new Chef1();
		c.rank=1;
		c.chef="시크제이맘";
		c.recipe=1712;
		c.scrap=1027593;
		c.view=33561876;
		c.comment=21771;
		System.out.println("=========== 소식받기 순위 ===========");
		
		
		System.out.println("\n데이터참조 업체:"+c.title);
		
		

	}

}
