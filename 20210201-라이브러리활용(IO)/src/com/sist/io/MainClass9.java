package com.sist.io;
// BufferedReader: 네트워크 => 보조 스트림
/*
 *    FileInputStream/FileOutputStream
 *    BufferedInputStream / BufferedOutputStream
 *    
 *    FileReader / FileWriter
 *    BufferedReader
 *    
 *    ===========================================
 *    
 */
import java.io.*;
public class MainClass9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2753 => 33
		try
		{
			/*// 파일 읽기 => daum_movie.txt
			File file=new File("c:\\javaDev\\daum_movie.txt");
			FileReader fr=new FileReader(file);  // 한 글자씩 읽음
			int i=0;
			StringBuffer sb=new StringBuffer();  // 읽은 데이터 저장 공간
			long start=System.currentTimeMillis();
			//String data="";
			while((i=fr.read())!=-1)
			{
				//data+=String.valueOf((char)i);
				sb.append(String.valueOf((char)i));  // append 문자열 결합  => \n
			}
			System.out.println(sb.toString());
			long end=System.currentTimeMillis();
			System.out.println("걸린 시간:"+(end-start));*/
			File file=new File("c:\\javaDev\\daum_movie.txt");
			FileInputStream fis=new FileInputStream(file);  // 이거만 쓰면 한글 다 깨짐. Reader 써야함
			BufferedReader br=new BufferedReader(new InputStreamReader(fis));
			//                    InputStream => Reader(1byte => 2byte)
			long start=System.currentTimeMillis();
			// 데이터는 인코딩으로 / 실행은 디코딩으로
			while(true)
			{
				String str=br.readLine();   // 한 줄씩 읽어오기 때문에 위의 StringBuffer보다 더 빨라
				if(str==null) break;   // 종료 => 데이터를 다 읽은 경우
				System.out.println(str);
			}
			br.close();
			long end=System.currentTimeMillis();
			System.out.println("걸린 시간:"+(end-start));
		}catch(Exception ex) {}
	}

}
