package com.sist.thread;
/*
 *    쓰레드: 한 개의 프로그램 안에서 여러개의 기능을 동시에 수행
 *          =========== 프로세스
 *          쓰레드는 메소드 호출: 게임, 채팅(카카오 등), 웹(서버 => 통신 기능)
 *    1. 쓰레드 구현과 실행
 *       1) Thread를 상속(Thread는 클래스) => 멀티쓰레드
 *          public class MyThread extends Thread {
 *          }
 *       2) Runnable 구현(Runnable은 인터페이스) => 싱글쓰레드(윈도우)
 *          ============ 이미 상속이 있는 경우에 주로 사용
 *          public class MyThread implements Runnable
 *          {
 *              public void run()
 *              {
 *                  쓰레드 동작을 코딩
 *              }
 *          }

 *    2. 쓰레드 생명주기                      ====>  Blocked(일시정지)
 *       new  ====>  Runnable  ====>  Running
 *                                       ====>  Dead(메모리 해제)
 *       1) new
 *          Thread t=new Thread();
 *          => JVM(가상머신) 구현
 *             = 이름이 부여됨(Thread-0부터..)
 *               이름 가지고 오기: getName()
 *               이름 변경: setName() 
 *             = 우선순위 부여
 *               1 : MIN_PRIORITY
 *               10: MAX_PRIORITY
 *               5 : NORM_PRIORITY(사용자 정의_중간순위)
 *               == 기준: 작업 종료 속도
 *               = 쓰레드는 한 가지 일만 수행함
 *                 예) 서버 / 클라이언트(서버로부터 응답값을 받아서 출력)
 *                    클라이언트
 *                      1) 서버에 요청: 채팅 문자열을 접속자 전체에 전송
 *                                   응답메세지 출력(싱글 쓰레드)
 *                      2) 게임: 비행기      
 *                              비행기 총알
 *                              아바타 총알
 *                              아바타
 *                 ==================================================
 *                 메인프레임 => C/S => 데이터 공유 => 감성 컴퓨터 => Empty(AS)
 *                                     GRID
 *                                   ========   ========
 *                                    클라우드        AI
 *                 ===================================================
 *       2) Runnable(대기상태) => 자원(CPU=>메모리공간) 공유
 *          start()
 *       3) Running(쓰레드 실행) => 쓰레드가 어떻게 동작을 할지 코딩
 *          run(): 작업하는 메소드만 잘 적으면 됨
 *       4) 실행하는 과정: 일시정지
 *          sleep()
 *       5) 종료: 쓰레드 해제
 *          interrupt()
 *    3. 쓰레드는 데이터가 없다 => 프로세스의 데이터를 공유해서 사용(내부클래스)
 *       class Game
 *       {
 *           Game과 관련된 데이터
 *           
 *           class ThreadEx extends Tread
 *           {
 *               
 *           }
 *       }
 */
class MyThread extends Thread
{
	// 동작 
	public void run()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println(Thread.currentThread()+":"+i);   // Thread[홍길동,10,main]:10 현재 Thread 정보를 갖고 있음
			try
			{
				Thread.sleep(1000);   // = 1/1000초씩 일시정지
			}catch(Exception ex) {}
		}
	}
}
/*
 *    모든 프로세스는 main()부터 시작한다
 *               ======
 *               Thread ==> 모든 프로세스(실행중인)는 한 개 이상의 쓰레드를 갖고 있다 
 */
public class MainClass1 {

	public static void main(String[] args) {  // 여기서 main메소드가 Thread임
		// TODO Auto-generated method stub
		// Thread 생성
		System.out.println(Thread.currentThread());
		MyThread t1=new MyThread();
		MyThread t2=new MyThread();
		MyThread t3=new MyThread();
		MyThread t4=new MyThread();
		MyThread t5=new MyThread();
		
		t1.setName("홍길동");
		t2.setName("심청이");
		t3.setName("이순신");
		t4.setName("강감찬");
		t5.setName("을지문덕");
		
		// 우선순위 1(MIN) ~ 5(NORM):default ~ 10(MAX)
		//       ======                     =======
		//         GC                        main() => 쓰레드
		t1.setPriority(10);  // 갯수가 적기 때문에 Priority를 넣어도 큰 차이 없음
		t2.setPriority(1);
		t3.setPriority(1);
		t4.setPriority(1);
		t5.setPriority(1);
		
		// 대기 상태: start()
		t1.start();t2.start();t3.start();t4.start();t5.start();  // 사분할(한번식 수행)
            // ; 단위로 끝나면 실행하는 거지만, 그 순서가 우선순위에 따른것이 아닌 무작위로 한번씩 진행됨

		// 실행 상태: run() => start()를 걸면 자동 호출됨
		
	}

}
