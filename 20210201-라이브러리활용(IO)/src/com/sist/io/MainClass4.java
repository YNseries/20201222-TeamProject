package com.sist.io;
import java.util.*;
import java.io.*;
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			/*String msg="국내 협상을 완전히 접고 메이저리그 진출에만 집중하기로 한 양현종(33)은 ‘KIA 타이거즈’를 언급했다. “반드시 빅리그에 멋지게 서서 KIA 타이거즈 출신이라는 이름에 누가 되지 않게 하겠다”고 다짐했다. 꿈을 이루기 위해 KIA를 떠나지만 미국에 가서 목표를 이뤄 빅리그에 설 때까지 자신을 에이스로 키워준 타이거즈의 이름을 안고 도전하겠다는 다짐이다.";
			FileOutputStream fos=new FileOutputStream("c:\\javaDev\\student.txt");  // 뒤에 true 안쓰면 덮어씀
			fos.write(msg.getBytes());
			fos.close();
			System.out.println("첫번째 파일 저장 완료!!");*/
			/*fos=new FileOutputStream("c:\\javaDev\\student.txt");
			fos.write("안녕하세요".getBytes());
			fos.close();
			System.out.println("두번째 파일 저장 완료!!");*/
			// 파일 읽기
			FileInputStream fis=new FileInputStream("c:\\javaDev\\student.txt");
			int i=0;
			while((i=fis.read())!=-1)
			{
				System.out.print((char)i);
			}
			fis.close();
		}catch(Exception ex) {}

	}

}
