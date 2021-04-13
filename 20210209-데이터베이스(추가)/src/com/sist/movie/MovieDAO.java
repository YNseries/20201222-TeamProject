package com.sist.movie;
// ����Ŭ ����
import java.sql.*;
public class MovieDAO {
	private Connection conn;  // ����Ŭ ����
	private PreparedStatement ps;  // SQL������ ����
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";  // ����Ŭ �ּ�
	// URL ���� => jdbc:��ü��:IP:PORT:�����ͺ��̽���    // java database connective
	// thin ����̹� => ����(����Ŭ <==> �ڹ��������α׷�) => �ӵ��� �ʴ�, ����
	// ����̹� ��� => �� ���� ����
	public MovieDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");  // ����Ŭ�ϰ� ������ �� �ְ� ����̹��� ��ġ(����Ʈ����)
			// reflection => Ŭ���� ������ �о �޸� �Ҵ� / Properties(.setProperty) �� �̿��ϴ� ���
		}catch(Exception ex) {ex.printStackTrace();}
	}
	// ����Ŭ ����
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");  // ���� => ����Ŭ URL, username, password
			// conn hr/happy=>����Ŭ �Ѿ��    (sqlplus, id, pwd)
			// ��� ������Ʈ���� sqlpluse hr/happy ��� ģ �Ͱ� ������
		}catch(Exception ex) {ex.printStackTrace();}
	}
	// ����Ŭ �ݱ�
	public void disConnection()
	{
		try
		{
			// exit
			if(ps!=null) ps.close();  // OutputStream / BufferedReader => Statement ��û(��)�� �ް�, ���� �־���
			if(conn!=null) conn.close();  // Socket => TCP
		}catch(Exception ex) {ex.printStackTrace();}
	}
	
	// ���(������ �߰�) -> �� �κи� �ٲ�� ������ �Ź� ����
	public void movieInsert(MovieVO vo)
	{
		try
		{
			/*
			 *    SELECT: ������ �˻�
			 *    INSERT: ������ �߰�
			 *    UPDATE: ������ ����
			 *    DELETE: ������ ����
			 *    ==> CURD => ������ ����
			 *    ����Ŭ ���� => �������� ���� ��ġ(����� ������ ��������), ��ο��� ������ �� �ִ� ������
			 */
			getConnection();
			String sql="INSERT INTO movie VALUES(?,?,?,?,?,?,?,?)";   // ���� ������ ����, ����Ŭ�� ������ �߰� ��ɾ�
			ps=conn.prepareStatement(sql);  // sql ���� �غ�
			ps.setInt(1, vo.getMno());  // TO_NUMBER()
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getGenre());
			ps.setString(4, vo.getPoster());
			ps.setString(5, vo.getActor());
			ps.setString(6, vo.getRegdate());
			ps.setString(7, vo.getGrade());
			ps.setString(8, vo.getDirector());
			
			// ����
			ps.executeUpdate();  // �����ϸ� ���� ����
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
}
