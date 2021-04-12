/*
 * String course[]={"Java", "C++", "HTML5", "컴퓨터구조", "안드로이드"};
   int course[]={95, 88, 76, 62, 55};
	과목 이름 >> Jaba
	없는 과목입니다.
	과목 이름 >> Java
	Java의 점수는 95
	과목 이름 >> C++
	C++의 점수는 88
	과목 이름 >> 그만
 */
import java.util.Scanner;
public class 배열문제_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String course[]={"Java", "C++", "HTML5", "컴퓨터구조", "안드로이드"};
		int jumsu[]={95, 88, 76, 62, 55};
		// 입력값
		Scanner scan=new Scanner(System.in);
		
		while(true)
		{
			boolean bCheck=false;   // 있는 과목인지 없는건지 여기서 체크
			System.out.print("과목 이름 >>");
			String subject=scan.next();
			// 빠져나가는 조건
			if(subject.equals("그만")) {
				break;
			}
			
			for(int i=0;i<course.length;i++)   // 루프 안에서 if/else if 하면 안됨
			{
				if(subject.equals(course[i]))
				{
					bCheck=true;
					System.out.println(subject+"의 점수는 "+jumsu[i]);
					break;
				}
			}
			
			if(bCheck==false)
			{
				System.out.println("없는 과목입니다");
			}
		}

	}

}
