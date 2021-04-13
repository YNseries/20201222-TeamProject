package com.sist.music;
// ���⿣ ���Ϲ���, ��й��� ���� ����
import java.sql.*;
/*
 *	  JDBC => Java DataBase Connective ==> ojdbc(Oracle ~)
 *    ����Ŭ ����
 *    1. ����̹� ��ġ	Class.forName("����̹� Ŭ������");
 *    2. ����Ŭ ����	Connection Ŭ���� => ����Ŭ �ּ�,username, password
 *    3. SQL ���� ���� => ����Ŭ���� SQL�� �޾Ƽ� ����
 *    				   Statement
 *                     = Statement: SQL���� + �����Ͱ�(���ÿ�)
 *                       String name,sex,addr,tel;
 *                       int age;
 *                       String sql="INSERT INTO member VALUES('"+name+"','"+sex+"','"+addr+"','"+tel+"',"+age")";
 *                       // member�� ��(VALUES)�� ä��ڴ�
 *                     = PreparedStatement: default(SQL������ �����, ���߿� ���� ä��)
 *                       String sql="INSERT INTO member VALUES(?,?,?,?,?);  // �����ؼ� ���� ���(Statement�� ������ ����)
 *                     = CallableStatement: �Լ� ȣ���(PS/SQL)
 *    	 executeQuery(SQL����): ����� ����� �޾ƿ� �� => SELECT
 *    	 executeUpdate(SQL����): ����Ŭ ��ü���� ó�� => INSERT, UPDATE, DELETE
 *    4. ����Ŭ �ݱ� => �� ������ ��� ��. ���� �ݰ� �߿� �ȱ׷��� Connection ������. xe�� 50����� ���� ����
 *       = ���� => ���� => �ݱ�
 */
public class MusicDAO {
	private Connection conn;  // ����Ŭ ���� => Socket
	private PreparedStatement ps;  // OutputStream(����Ŭ�� ����), BufferedReader(����Ŭ�κ��� ������ ����)
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	// ���⼭ �������� => DOSâ�� null, NullPointerException ��
	// ����̹� ��ġ: �� ���� ���� => ���� �����ڿ� ��ġ
	public MusicDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {ex.printStackTrace();}
	}
	
	// ����
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");  // ���� XML�� ����
			// ����Ŭ ������ �� ==> conn hr/happy ������ ���۵� ��. ���߿��� �̷��� �����ϸ� �ȵ� => ����Ŭ�� ��� ������ �и�
		}catch(Exception ex) {ex.printStackTrace();}
	}
	// �ݱ�
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
			// ����Ŭ ���� ==> exit ����
		}catch(Exception ex) {ex.printStackTrace();}
	}
	// �� ������� ����Ŭ �����ϸ� �׻� �־���� �ϴ� �κ�. ������ ����
	
	// ���Ϲ����� ������ ���� => ����� ���� �ٲ�� �ȵʡڡ�
	/*
	 * 	NO           NUMBER(3)     
		CNO          NUMBER(1)     
		TITLE        VARCHAR2(300) 
		SINGER       VARCHAR2(200) 
		ALBUM        VARCHAR2(200) 
		POSTER       VARCHAR2(260) 
		STATE        CHAR(4)       
		IDCREMENT    NUMBER(3)
	 */
	public void genieMusicInsert(GenieMusicVO vo)  // �̷��� vo�� ������ ������ �ϳ��� �ؾ��ϴ� ���ŷο��� ����
	{
		try
		{
			// ����
			getConnection();
			// SQL���� ����
			String sql="INSERT INTO genie_music VALUES(?,?,?,?,?,?,?,?)";  // �� �ٿ� 8���� ��. ?���� Ʋ���� �ȵ�
			ps=conn.prepareStatement(sql);
			// ?�� �� ä���
			ps.setInt(1, vo.getNo());  // ����Ŭ�̴ϱ� 1���� ����
			ps.setInt(2, vo.getCno());
			ps.setString(3, vo.getTitle());
			ps.setString(4, vo.getSinger());
			ps.setString(5, vo.getAlbum());
			ps.setString(6, vo.getPoster());
			ps.setString(7, vo.getState());
			ps.setInt(8, vo.getIdcrement());
			/*
			 *    VARCHAR2, CHAR, CLOB => String
			 *    NUMBER => int(���� double => ����)
			 *    DATE => java.util.Date()
			 */
			// SQL���� ����
			ps.executeUpdate();
		}catch(Exception ex) {
			// ����Ȯ��
			System.out.println(ex.getMessage());
		}
		finally
		{
			// ����Ŭ �ݱ�
			disConnection();
		}
	}

}
