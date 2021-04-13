package com.sist.network;
import java.io.*;  // 네트워크 입출력(C/S => Client: 요청, 응답을 받아서 출력, Server: 요청을 받아서 처리 후에 응답)
import java.net.*;
/*
 *    본인 => 서버
 *           ===
 *           localhost, 127.0.0.1, 211.238.142.181
 *           ====================  ===============
 *           개인적으로 사용하는         공유되는
 */
public class Server implements Runnable {
	// 접속받는 클래스
	ServerSocket ss;
	final int PORT=3355;   // 0~65535(0~1023은 사용중이니 제외) => 화상(30000번대 추천), 음성(20000번대)
	// 초기화
	// 한개의 컴퓨터에서 서버는 반드시 한 번만 수행
	// 여러번 수행도 가능 => PORT를 변경
	public Server()
	{
		try
		{
			ss=new ServerSocket(PORT);  // 컴퓨터 IP는 자동 인식
			/*
			 *    => ip, port
			 *    => 개통 bind(ip,port) => 셋팅 완료
			 *    => 클라이언트가 접근 대기 => listen()
			 */
			System.out.println("Server Start...");
		}catch(Exception ex) {}
	}
	// 클라이언트가 접속시 처리 => 정보 저장
	public void run()
	{
		while(true)
		{
			try
			{
				Socket s=ss.accept();  // 접속이 된 상태에서만 호출 ==> 발신자 정보(ip, port => Socket)를 받아놔야 함
				System.out.println("Client IP:"+s.getInetAddress().getHostAddress());
				System.out.println("Client PORT:"+s.getPort());
				/*
				 *    서버 =======> port(고정)
				 *    클라이언트 ===> port(가변) => 자동 생성
				 */
				// 클라이언트 메세지 전송
				OutputStream out=s.getOutputStream();
				// s => 클라이언트
				out.write("안녕하세요!! 서버에 연결되었습니다\n".getBytes());  // 인코딩
			}catch(Exception ex) {ex.printStackTrace();}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server=new Server();
		new Thread(server).start();  // server가 가지고있는 run()을 호출
		
	}

}
