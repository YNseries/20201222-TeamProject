package com.sist.server;
/*
 *    서버
 *    class Server
 *    {
 *        접속자를 저장(변수) => Server, Client => 공유
 *        ==> 저장
 *        class Client
 *        {
 *           ==> 퇴장(제거)
 *        }
 *     }
 *     
 *     공유: 내부 클래스, static(저장 공간 1개)
 *     
 *     class Server
 *     {
 *         static Vector waitVC=new Vector();
 *     }
 *     class Client
 *     {
 *     }
 *     
 *     class DAO
 *     {
 *         Connection conn;
 *         Statement stmt;
 *     }
 */
import java.net.*;
import java.io.*;
import java.util.*;

import com.sist.common.Function;
// LOGIN => id,대화명,성별 ==> login버튼 누르면 => 100|id|대화명|성별 묶어서 한번에 => Server로 전송(StringTokenizer)
public class Server11 implements Runnable{
	// 접속을 담당
	private ServerSocket ss;
	private Vector<Client> waitVc=new Vector<Client>();  // 접속자 정보 저장(동기화)
	public Server11()
	{
		try
		{
			ss=new ServerSocket(3355);  // 접속자가 50명, Serversocket(3355,1000) 얘만 있으면 서버가 가동됨
			// ss.bind("localhost",3355) => 개통
			// ip(전화번호), port(연결선)
			// 대기 => listen()
			/*
			 *    class ServerSocket
			 *    {
			 *        public ServerSocket(int port)
			 *        {
			 *            this.bind("localhost",port);
			 *            this.listen();
			 *        }
			 */
			System.out.println("Server Start...");
		}catch(Exception ex) {ex.printStackTrace();}
	}
	// 클라이언트가 접속할 때마다 처리해줌
	/*
	 *    클라이언트가 접속하면 => 클라이언트의 정보(ip+port=socket)를 받아서 쓰레드에 전송해줌
	 *                                                       =====
	 *                                                       전송받은 클라이언트와 통신
	 *                   => 정보를 저장
	 *    while(true)
	 *    {
	 *        ss=getClient();
	 *        System.out.println(ss);
	 *    }
	 */
	// 접속만 처리(접속하면 쓰레드 연결)
	public void run()
	{
		try
		{
			while(true)  // 서버 종료할 때까지 접속을 받는다(무한루프)
			{
				Socket s=ss.accept();  // 멈춤(특수 메소드) => 조건(클라이언트가 접속시에만 호출 가능) => 대기 중
				// 접속(핸드폰 전화걸면 => 발신자 정보(이름, 전화번호) 뜸 => IP, PORT(IP+PORT=Socket)
				// 한 명이 여러개 실행 => IP 동일, PORT 다름 => 다른 사람으로 인식
				// 각자 통신 => 쓰레드를 생성
				// ====== 쓰레드가 IP를 가지고 있어야 함
				Client client=new Client(s);
				// 통신을 시작한다
				client.start();
				// 여기에 저장하면 안됨(로그인 여부를 알려줘야 하기 때문에)
				/*
				 *   통신 기능
				 *    1. 로그인 처리
				 *    2. 채팅 처리
				 *    3. 쪽지 보내기
				 *    4. 나가기
				 */
			}
		}catch(Exception ex) {ex.printStackTrace();}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server11 server=new Server11();
		new Thread(server).start();
	}
	
	// 통신만 담당하는 클래스 => 접속자마다 따로 생성 => 여러개가 동시에 동작해야 함(쓰레드 사용!)
	class Client extends Thread
	{
		// 클라이언트의 모든 정보를 가지고 있다
		// ip, port
		Socket s;
		// 클라이언트와 입출력(저장 공간 확인)
		OutputStream out;
		BufferedReader in;
		// 일반 변수
		String id,name,sex;
		// 소켓을 받아온다
		// Client client=new Client(s);
		public Client(Socket s)
		{
			try
			{
				this.s=s;  // 나가기 => Socket을 닫는다(s.close())
				// 클라이언트(s)가 데이터를 읽어가는 위치 확인 => out
				out=s.getOutputStream();
				// 클라이언트로부터 데이터를 읽어오는 위치 => in
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				// 서버 => 클라이언트
				// 클라이언트 => 서버
			}catch(Exception ex) {ex.printStackTrace();}
		}
		// 통신 처리
		public void run()
		{
			try
			{
				while(true)
				{
					// 클라이언트로부터 요청값 받기
					String msg=in.readLine();  // 100|id|name|sex
					System.out.println("Client=>"+msg);   // 서버 디버깅 
					StringTokenizer st=new StringTokenizer(msg,"|");
					int protocol=Integer.parseInt(st.nextToken());
					switch(protocol)
					{
						// 로그인 처리   id|name|sex
					    case Function.LOGIN:  // 100
					    {
					    	// 변수값 저장
					    	id=st.nextToken();
					    	name=st.nextToken();
					    	sex=st.nextToken();
					    	
					    	// 현재 접속중인 사람에게 전송
					    	messageAll(Function.LOGIN+"|"+id+"|"+name+"|"+sex);
					    	
					    	// waitVc에 저장
					    	waitVc.add(this);
					    	
					    	// 현재 접속중인 사람들의 정보 읽어오기(접속한 사람에게 보낸다)
					    	messageTo(Function.MYLOG+"|"+name);
					    	for(Client client:waitVc)
					    	{
					    		messageTo(Function.LOGIN+"|"+client.id+"|"+client.name+"|"+client.sex);
					    	}
					    	messageAll(Function.CHAT+"|[알림 ☞] "+name+"님이 입장하셨습니다|red");
					    }
					    break;
						case Function.SENDMESSAGE://200  200|sid|rid|messge
						{
							String strMsg=st.nextToken();
							String youId=st.nextToken();
							   
							for(Client client:waitVc)
							{
								if(youId.equals(client.id))
								{
									client.messageTo(Function.SENDMESSAGE+"|"+id+"|"+strMsg);
									break;
								}
							}
						}
					    break;
						case Function.CHAT://300  300|message
						{
							String strMsg=st.nextToken();
							String color=st.nextToken();
							  
							// 접속한 모든 사람에게 보낸다 
							messageAll(Function.CHAT+"|["+name+"]"+strMsg+"|"+color);
						 }
						 break;
						 case Function.EXIT:
						 {
							 // 1. 접속된 모든 사람에게 나간다는 메세지 전송 
							 for(Client client:waitVc)// 접속한 사람의 정보 : waitVc
							 {
								 // id => 나가는 사람 => this
								 if(!id.equals(client.id))
								 {
									 client.messageTo(Function.CHAT+"|[알림 ☞] "+name+"님이 퇴장하셨습니다|red");
									 client.messageTo(Function.EXIT+"|"+id);//테이블에 출력된 명단에 제거
								 }
							 }
							 // => 남아 있는 사람 , 나가는 사람 처리 
							 for(int i=0;i<waitVc.size();i++)
							 {
								 Client client=waitVc.get(i);
								 if(id.equals(client.id))
								 {
									 // 윈도우 종료해라 
									 messageTo(Function.MYEXIT+"|");
									 // waitVc에서 제거 
									 waitVc.remove(i);
									 // in,out.close()
									 in.close();
									 out.close();
									 break;// 종료 
								 }
							 }
						 }
						 break;
					}
						
				}
			}catch(Exception ex){ex.printStackTrace();}
		}
		// 동일한 기능
		// 한 사람에게 전송
		public void messageTo(String msg)  // synchronized void 라고 써도 됨
		{
			try
			{
				out.write((msg+"\n").getBytes());
			}catch(Exception ex){ex.printStackTrace();}
		}
		// 접속자 모두에게 보내는 기능 
		public void messageAll(String msg)
		{
			try
			{
				for(Client client:waitVc)
				{
					client.messageTo(msg);
				}
			}catch(Exception ex){ex.printStackTrace();}
		}
	}
}
/*
 *     서버 프로그램
 *       = 접속시 처리(하는 클래스): 교환 소켓(매니저) => 클라이언트 정보(ip, port) 저장
 *       = 각 클라이언트마다 통신을 담당(쓰레드) => 저장된 클라이언트 정보를 사용
 *         =========
 *           여러개를 동시에 수행
 *           *** 두 개 이상의 클래스에서 같은 데이터를 공유할 경우: static, 멤버클래스(내부클래스)
 *                                                            ===============
 *                                                            모든 내용(변수, 메소드)을 공유할 수 있음
 *           *** 내부 클래스: 하둡(데이터를 수집, 분석, 공유해 줌)
 *                            ========== === MapReduce(챗봇 등)
 *       = 한 개의 프로그램 안에서 여러 개의 메소드가 동시에 실행하려면 => 쓰레드(실시간 구현): 금융권, 증권, 예매    
 *       = 네트워크: 클라이언트, 서버
 *         서버
 *          1) 요청 받기 => readLine(): 한 줄씩 읽어서 처리(java.io) => Decoding 해야 함 => InputStreamReader() (필터스트림)
 *          2) 요청 처리, 찾기 => get() => Collection(Vector, ArrayList)
 *          3) 삭제(remove()), 추가(add())
 *          4) 전송 write => Encoding 해야 함 => getBytes()
 *         클라이언트
 *          1) 요청 => write()
 *          2) 결과 받기 => readLine()
 *          3) 결과 출력 => 윈도우, 브라우저
 *         *** 웹, 오라클 => TCP를 이용하는 프로그램 / 게임은 UDP
 *             ======= 처리과정, 결과값 추출
 */





