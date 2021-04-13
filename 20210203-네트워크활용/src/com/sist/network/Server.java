package com.sist.network;
import java.io.*;  // ��Ʈ��ũ �����(C/S => Client: ��û, ������ �޾Ƽ� ���, Server: ��û�� �޾Ƽ� ó�� �Ŀ� ����)
import java.net.*;
/*
 *    ���� => ����
 *           ===
 *           localhost, 127.0.0.1, 211.238.142.181
 *           ====================  ===============
 *           ���������� ����ϴ�         �����Ǵ�
 */
public class Server implements Runnable {
	// ���ӹ޴� Ŭ����
	ServerSocket ss;
	final int PORT=3355;   // 0~65535(0~1023�� ������̴� ����) => ȭ��(30000���� ��õ), ����(20000����)
	// �ʱ�ȭ
	// �Ѱ��� ��ǻ�Ϳ��� ������ �ݵ�� �� ���� ����
	// ������ ���൵ ���� => PORT�� ����
	public Server()
	{
		try
		{
			ss=new ServerSocket(PORT);  // ��ǻ�� IP�� �ڵ� �ν�
			/*
			 *    => ip, port
			 *    => ���� bind(ip,port) => ���� �Ϸ�
			 *    => Ŭ���̾�Ʈ�� ���� ��� => listen()
			 */
			System.out.println("Server Start...");
		}catch(Exception ex) {}
	}
	// Ŭ���̾�Ʈ�� ���ӽ� ó�� => ���� ����
	public void run()
	{
		while(true)
		{
			try
			{
				Socket s=ss.accept();  // ������ �� ���¿����� ȣ�� ==> �߽��� ����(ip, port => Socket)�� �޾Ƴ��� ��
				System.out.println("Client IP:"+s.getInetAddress().getHostAddress());
				System.out.println("Client PORT:"+s.getPort());
				/*
				 *    ���� =======> port(����)
				 *    Ŭ���̾�Ʈ ===> port(����) => �ڵ� ����
				 */
				// Ŭ���̾�Ʈ �޼��� ����
				OutputStream out=s.getOutputStream();
				// s => Ŭ���̾�Ʈ
				out.write("�ȳ��ϼ���!! ������ ����Ǿ����ϴ�\n".getBytes());  // ���ڵ�
			}catch(Exception ex) {ex.printStackTrace();}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server=new Server();
		new Thread(server).start();  // server�� �������ִ� run()�� ȣ��
		
	}

}
