package com.sist.io;
// File 정보
import java.io.*;
import java.text.SimpleDateFormat;
/*
 *     자바파일 구조
 *     =========
 *     
 *     package package명: 반드시 한 번만 사용이 가능
 *     import : 여러개를 사용할 수 있다
 *     public class className{
 *       ====================
 *         [변수(멤버변수, 공유변수)]
 *       ====================
 *         [생성자] => 필요하지 않는 경우(네트워크 연결, 윈도우 배치, 오라클 연결)
 *                   default 생성자를 첨부(컴파일러가 첨부)
 *       ====================
 *         [메소드]
 *       ====================
 *         [main 메소드]
 *       ====================
 *       
 *     }
 */
// 파일에 대한 정보 확인
import java.util.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("c:\\javaDev\\daum_movie.txt");
		System.out.println("===== daum_movie.txt 상세 정보 =====");
		System.out.println("***1. 파일 크기"+file.length()+"Bytes");
		// Byte   =>  KB  =>  MB
		// 총 바이트 수 /1024   /1024
		System.out.println("2. 숨김 파일여부"+file.isHidden());  // true 숨김 / false 안숨김
		// 읽기, 쓰기 가능 여부 => true 가능
		System.out.println("3. 읽기전용:"+file.canRead());
		System.out.println("4. 쓰기전용:"+file.canWrite());
		
		System.out.println("***5. 파일명:"+file.getName());
		System.out.println("6. 경로명:"+file.getParent());
		// 5,6 동시에
		System.out.println("***7. 파일명+경로명:"+file.getPath());
		
		System.out.println("8. 파일여부:"+file.isFile());  // 파일이면 true
		System.out.println("9. 수정일:"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
				.format(new Date(file.lastModified())));   // 출력용
		/* 
		 *    Date date=new Date(file.lastModified(());
		 *    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		 *    String day=sdf.format(date)
		 *    // 위의 세 줄을 아래 한 줄로 바꿀 수 있음
		 *    new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date(file.lastModified(()))
		 */
		File creat_file=new File("c:\\javaDev\\naver_movie.txt");
		try
		{
			System.out.println("***10. 새로운 파일 생성:"+creat_file.createNewFile());
			System.out.println("***11. 파일 삭제:"+creat_file.delete());
		}catch(Exception ex) {}	
	}

}


















