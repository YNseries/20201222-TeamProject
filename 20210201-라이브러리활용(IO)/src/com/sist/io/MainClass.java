package com.sist.io;
/*
 *    IO => 입출력(메모리, 파일, 네트워크)
 *    ===
 *      File 관련: 업로드, 다운로드 => 추천 프로그램, AI
 *      1) File
 *      2) byte 단위로 읽기, 쓰기 => ~InputStream, ~OutputStream => 1바이트씩
 *      3) char 단위로 읽기, 쓰기 => ~Reader, ~Writer => 2바이트씩(한글)
 *      4) 객체 단위로 읽기, 쓰기 => ObjectInputStream, ObjectOutputStream
 *    ** 자바에서 입출력은 스트림 => 데이터를 이동하는 통로(단방향) => 양방향(프로그램 두 개를 동시에 처리)
 *                                                     ========================== 쓰레드(메소드 여러개를 동시에 수행)
 *       모든 메소드는 동기화 프로그램을 갖고 있음
 *       class A
 *       {
 *           public void aaa(){}
 *           public void bbb(){}
 *       }
 *       
 *       A a=new A();
 *       a.aaa();   ==> return(끝나야)
 *       a.bbb();   ==> return(다음걸 수행)      aaa() bbb() aaa() bbb() 이렇게 수행할 수도 있음 => 쓰레드(동시다발적 수행 가능)
 *       ============================================================ IO만으로 양방향은 불가
 *          = 바이트 스트림(1byte): 이미지파일, ZIP... (업로드, 다운로드)
 *            InputStrimg       OutputStream  ==> interface
 *                 |                  |
 *               read               write  => 파일을 처리한 후에는 반드시 닫기(close())
 *                                            ================================ finally
 *            ***** IO는 CheckException: 반드시 예외처리한다 => finally
 *            = 구현된 클래스
 *              FileInputStream        FileOutputStream
 *              BufferedInputStream    BufferdOutputStream
 *              ObjectInputStream      ObjectOutputStream
 *            
 *          = 문자 스트림(한글이 있는 경우) => 2byte
 *            Reader       Writer ===> interface
 *            = 구현된 클래스
 *              FileReader        FileWriter
 *              BufferedReader    BufferedWriter
 *            
 *          = File (클래스명)
 *            = file =======> 파일명까지
 *              File file=new File("c:\\javaDev\\daum_movie.txt")
 *            = directory ==> 폴더명까지
 *              File dir=new File("c:\\javaDev")
 *            = 라이브러리
 *              directory 관련
 *                = listFiles(): 폴더 안에 있는 파일과 폴더..
 *                = delete(): 폴더 삭제
 *                = mkdir(): 폴더 생성
 *              file 관련
 *                = 수령일: lastModified(long) => 날짜형으로 변경
 *                                              ====    ===
 *                                              Date    SimpleDateFormat
 *                = 파일명 읽기 => getName(), getPath(), getParent()
 *                         getName(): 파일명만 가지고 온다
 *                         getPath(): 경로명부터 파일명까지 읽기
 *                         getParent(): 경로명만 읽을 정우
 *                = 숨김파일여부: isHidden()
 *                  읽기쓰기여부: canRead(), canWrite()
 *                  
 */
import java.io.*;   // 파일 포함 => 입출력과 관련된 모든 클래스의 집합(메모리입출력, 파일입출력, 네트워크입출력)
// URL => IO를 이용해서 입출력 => 전체 파일의 내용을 모아서 처리(Buffered~~)
// File
/*
 *   1. File 객체 생성
 *      File file=new File("c:\\폴더명\\파일명");(********** 선호)   // length 크기 반드시 확인
 *      
 *      File dir=new File("c:\\폴더명");
 *      File file=new File(dir,"파일명");
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 폴더(directory) 읽기
		// 1. 폴더 만들기
		File dir=new File("c:\\download");
		if(!dir.exists())  // 폴더가 있는지 여부 확인
		{
			// 존재하지 않는 경우, 폴더를 만든다
			dir.mkdir();
		}
		// 폴더 안에 들어가 있는 파일의 종류
		File[] files=dir.listFiles();   // 탐색기를 만드는 경우
		for(File f:files)
		{
			if(f.isFile())        // 파일일 경우
			{
				System.out.println(f.getName());
			}
			if(f.isDirectory())   // 폴더일 경우
			{
				System.out.println(f.getName()+" DIR");
			}
			
			// 폴더 삭제
			dir.delete();   // 폴더 안에 파일이나 폴더가 있는 경우에는 삭제할 수 없다
			for(File f1:files)
			{
				if(f1.isFile())
				{
					f1.delete();   // 파일 삭제
				}
				if(f1.isDirectory()) {
					File dir2=new File("c:\\download\\"+f1.getName());
					File[] files2=dir2.listFiles();
					for(File ff:files2)
					{
						ff.delete();   // 삭제할 폴더 내 폴더 삭제
					}
					dir2.delete();
				}
			}
			dir.delete();   // 폴더 삭제
		}
	}

}
