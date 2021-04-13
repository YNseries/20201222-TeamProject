package com.sist.network2;
import java.io.*;  // ��Ʈ��ũ(Ŭ���̾�Ʈ�� ������ �����) ����: OutputStream, ����: BufferedReader
import java.net.*;  // ServerSocket(������ ���� ���), Socket(Ŭ���̾�Ʈ ����) => IP,PORT(�ڵ�����/�ߺ� ����)
import java.util.*;  // Collection(Ŭ���̾�Ʈ�� ������ ���� => ����ȭ �ʿ� => Vector)
/*
 *    �ڹ�
 *    ***����Ŭ
 *    ===== �ڹ�+����Ŭ (JDBC)
 *    HTML
 *    CSS
 *    JavaScript + JQuery, VueJs
 *    ========== (�ڹ�: ����������, XML, ANNOTATION)
 *    JSP
 *    ========== �ڹ�+����Ŭ+HTML
 *    MVC
 *    ***Spring
 *    ==========================================
 *    
 *    Collection: �ڷᱸ��(�޸𸮿� �����ϰ� ���� => CURD) => ǥ��ȭ
 *    ==========
 *       List: ������ ������ �ִ�(index��ȣ) = �����͸� �ߺ��ؼ� ������ ����
 *             **ArrayList: Vector�� ������ Ŭ����(�񵿱�ȭ) => �����ͺ��̽� ���α׷�(��, ERP)
 *             **Vector: ����ȭ => ��Ʈ��ũ(����, �����)
 *             LinkedList: C��� ȣȯ
 *             Stack => coding test
 *       Set : ������ ����, ������ ������ �ߺ��Ǹ� �ȵ�
 *             HashSet
 *       Map : �� �� ����(Ű, ��) => Ű�� ������ ���� ã�´�
 *             Ű�� �ߺ� X, ���� �ߺ� ����
 *             => ��(session, cookie, request, response) => Spring, MyBatis(Map�� ����)
 */
public class Server implements Runnable{
	private Vector<Client> waitVc=new Vector<Client>();  //Ŭ���̾�Ʈ ������ ����
	private ServerSocket ss;
	private final int PORT=3355;
	/*
	 *    ���� �д�
	 *      = ���Ӹ� ���
	 *      = �� Ŭ���̾�Ʈ ���� ��� ���
	 *        ========= ������ => ����Ŭ����
	 */
	// 1. ���� ����
	public Server()
	{
		try
		{
			ss=new ServerSocket(PORT);  // bind(): ����, Listen(): ������
			System.out.println("Server Start...");
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	/*
	 *   ����
	 *    1. ���� ����
	 *    2. ���ӽ� ó��
	 *       => �޸𸮿� ����(Ŭ���̾�Ʈ�� ������ ����)
     *       => Ŭ���̾�Ʈ�� ��� ��� 
	 */
	// 2. ���ӽÿ� ó�� => Ŭ���̾�Ʈ�� Vector�� ����
	public void run()
	{
		try
		{
			while(true)
			{
				Socket s=ss.accept();  // �߽��� ����(IP+PORT=Socket)�� ������ �´�
				// ������� ����� �����ϰ� => ������ ���� => �ش� Ŭ���̾�Ʈ�� Socket�� �Ѱ��ش�
				Client client=new Client(s);  // �����帶�� Ŭ���̾�Ʈ�� ����Ѵ�
				waitVc.add(client);  // Ŭ���̾�Ʈ ������ ����
				client.start();  // Ŭ���̾�Ʈ�� ����� �����Ѵ�
			}
		}catch(Exception ex) {ex.printStackTrace();}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server=new Server();  // ���� ����
		new Thread(server).start();  // ���ӽ� ó��
	}
	// ����� ����ϴ� Ŭ����
	class Client extends Thread
	{
		// �� Ŭ���̾�Ʈ���� ����� ���. �����־�� �� �͵�
		// 1. Ŭ���̾�Ʈ�� ����(ip, port = Socket)
		Socket s;
		// 2. Ŭ���̾�Ʈ�� ����ϱ� ���ؼ� IO(�����)
		BufferedReader in;  // Ŭ���̾�Ʈ�� ��û���� �޴� ���
		OutputStream out;   // ��û ó�� �Ŀ� ������ �� ���
		
		// �����ڸ� �̿��ؼ� => ServerŬ�����κ��� Socket(ip)
		public Client(Socket s)
		{
			try
			{
				this.s=s;  // s=Ŭ���̾�Ʈ
				out=s.getOutputStream();
				in=new BufferedReader(new InputStreamReader(s.getInputStream(),"UTF-8"));
			}catch(Exception ex) {ex.printStackTrace();}
		}
		// ��� ����
		public void run()
		{
			try
			{
				while(true)
				{
					// ������� ��û ������ �޴´�
					String msg=in.readLine();
					messageAll(msg);
				}
			}catch(Exception ex) {ex.printStackTrace();}
		}
		// �޽��� ���� �޼ҵ�
		// 1. ���������� ���� => ����������, �ӼӸ�
		/*
		 *    transient String name; => name�� ����(���ܽ�ų ���� ���� �� ���� �տ� ���� ��)
		 *    synchronized => ����ȭ
		 *    => �������� default(�񵿱�ȭ) �����Ͱ� �浹�� ������ ����
		 *    
		 *       sync function aaa(){}
		 *       async function bbb(){}
		 *       ajax => �ǽð�
		 */
		public synchronized void messageTo(String msg)
		{
			try
			{
				out.write((msg+"\n").getBytes());
			}catch(Exception ex) {ex.printStackTrace();}
		}
		// 2. ��ü������ ���� => ä��
		public synchronized void messageAll(String msg)
		{
			try
			{
				for(Client client:waitVc)
				{
					client.messageTo(msg);
				}
			}catch(Exception ex) {ex.printStackTrace();}
		}
	}

}
