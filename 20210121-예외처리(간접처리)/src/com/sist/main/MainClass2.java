package com.sist.main;
/*
 *    예외 회피: 시스템에서 처리 => throws
 *    형식)
 *         접근지정어 리턴형 메소드명(매개변수..) throws로 예상되는 에러 등록..
 *         
 *         예)
 *             public void display() throws NumberFormatException, NullPoint Exception,
 *                                   ClassCastException,Exception
 *                                   ============================ 순서가 없다
 *             => display() 호출시에
 *                  = 회피
 *                  public void main() throws NumberFormatException, NullPoint Exception,
 *                                     ClassCastException,Exception
 *                  {
 *                      display;
 *                  }
 *                  
 *                  public void main() throws Exception
 *                  {
 *                      display();
 *                  }
 *                  
 *                  public void main() throws Throwable
 *                  {
 *                      display();
 *                  }
 *                  = 복구 => try-catch써서 돌아오게 해야 함. 혹은 위의 예외처리를 사용
 *                  public void main()
 *                  {
 *                     try
 *                     {
 *                        display()
 *                     }catch(Exception ex){}
 *                  }
 */
// 라이브러리 => throws는 try-catch 써줘야함
import java.io.*;
public class MainClass2 {
	public void display() throws Exception,NumberFormatException,ArithmeticException,ArrayIndexOutOfBoundsException
	                          //            ========================================================================
	                          // 여기에 Exception만 쓰면, 다 포함하기 때문에 뒤에껀 안 써줘도 됨.
	{
		
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		MainClass2 m=new MainClass2();
		FileReader fr=new FileReader("c:\\javaDev\\movie.json"); // 컴파일 하자마자 예외처리 들어갔는지 확인
	}

}
