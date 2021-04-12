package com.sist.recipe;
import java.io.*;
import java.util.Scanner;  
/*
 *    class에서 선언되는 모든 변수는 private 감춰두는게 좋다
 *    => method를 통해 보여준다
 */
public class RecipeManager {
	private static String[] menu1={"밑반찬","메인반찬","찌개","디저트","면","만두","밥","죽","떡","퓨전","김치","젓갈","장류","양념","소스","잼","양식"
            ,"샐러드","스프","빵","과자","음료","술"};
	private static String[] menu2={"일상","초스피드","손님접대","술안주","다이어트도시락","영양식","간식","야식","푸드스타일링","해장","명절","이유식"};
	private static String[] menu3={"소고기","돼지고기","닭고기","육류","채소류","해물류","달걀","유제품","가공식품류","쌀","밀가루",
             "건어물류","버섯류","과일류","콩","견과류","곡류"};
	private static String[] menu4={"볶음","끓이기","부침","조림","무침","비빔","찜","절임","튀김","삶기","굽기","데치기","회"};
	public int main_menu()
	{
		System.out.println("============== Main Menu =============");
		System.out.println("1. 종류별, 2. 상황별, 3. 재료별, 4. 방법별");
		Scanner scan=new Scanner(System.in);
		System.out.print("메인 메뉴를 선택하시오?");
		int no=scan.nextInt();
		return no;
	}
	public String sub_menu(int no)
	{
		String data="";
		String[] menu=null;
		switch(no)
		{
		case 1:
			menu=menu1;
			break;
		case 2:
			menu=menu2;
			break;
		case 3:
			menu=menu3;
			break;
		case 4:
			menu=menu4;
			break;
		}
		System.out.println("============= Sub Menu ============");
		int i=1;
		for(String s:menu)
		{
			System.out.println(i+". "+s);
			i++;
		}
		
		Scanner scan=new Scanner(System.in);
		System.out.print("레시피를 선택하세요?");
		int r=scan.nextInt();
		data=menu[r-1];  // 배열은 0부터 시작하기 때문에! 하나를 빼 줘야 실제 데이터 값 갖고옴
		return data;
	}
	/* public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecipeManager rm=new RecipeManager();
		int no=rm.main_menu();
		rm.sub_menu(no);
		
	}
	*/

}
