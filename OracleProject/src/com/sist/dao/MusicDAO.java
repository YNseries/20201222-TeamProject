package com.sist.dao;
// ����Ŭ �����ϴ� ���α׷�
import java.util.*;  // ArrayList
import java.sql.*;  // 
public class MusicDAO {
	// �����ϴ� Ŭ����
	private Connection conn;  // ����Ŭ ����
	// SQL������ �����ϴ� Ŭ����
	private PreparedStatement ps;   // ���� �޾ƿ�
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";   // ����Ŭ ���� �ּ�
	// 1. ���� ����̹� ��ġ => �� ���� ���(�ַ� �����ڿ��� ���)
	public MusicDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {ex.printStackTrace();}
	}
	//2. ����
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
			// ����Ŭ => conn hr/happy
		}catch(Exception ex) {ex.printStackTrace();}
	}
	// 3. ��ü
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();   // ���(�۽�:OutputStream, ����:BufferedReader) ���
			if(conn!=null) conn.close();   // ������:Socket
		}catch(Exception ex) {ex.printStackTrace();}
	}
	// 4. ��� => ���� ������ 50���� �޾Ƽ� ���� ==> ����� �����͸� ���������� �о ���
	public ArrayList<MusicVO> musicListData()
	{
		// return selectList("sql"); ==> myBatis
		ArrayList<MusicVO> list=new ArrayList<MusicVO>();
		try
		{
			// 4-1. ����
			getConnection();
			// 4-2. SQL������ �����
			String sql="SELECT no,title,poster,singer,album,state,idcrement "  // �ڿ� ���� ���ָ� ������
					+"FROM genie_music "  // �ڿ� ���� ������ �ȵ�
					+"ORDER BY no ASC";   // �������߱�(no ASC ��� 1 �ᵵ ��)
			ps=conn.prepareStatement(sql);  // ���� �غ�
			// 4-3. SQL���� ����
			ResultSet rs=ps.executeQuery();  // rs=�޸𸮰���
			// 4-4. ������� ������ �´�
			// 4-5. ArrayList�� ��´�
			/*
			 *      ================
			 *      no title...
			 *      ================
			 *      1    ==         | next()
			 *      ================
			 *      2    ==         | next()
			 *      ================
			 *      3    ==         | next()
			 *      ================
			 *      4    ==         | next()
			 *      ================
			 *      				| next() => false
			 *      
			 */
			while(rs.next())   // .next() �־�� Ŀ���� �� ������ �� ����, �������� �̵� ����(Ŀ����ġ ����) => ������ �� ������ false �����鼭 ����
			{
				MusicVO vo=new MusicVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPoster(rs.getString(3));
				vo.setSinger(rs.getString(4));
				vo.setAlbum(rs.getString(5));
				vo.setState(rs.getString(6));
				vo.setIdcrement(rs.getInt(7));
				list.add(vo);
			}
			rs.close();
			// 4-6. ������(���������� �θ��� ������)
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally
		{
			disConnection();  // �ݱ� (����/���� ������� ������ ����Ŭ�� �ݴ´�)
		}
		return list;
	}
	
	public void empFindData(String ename)
	{
		try
		{
			getConnection();
			String sql="SELECT ename,job,hiredate,sal "
					+"FROM emp "
					+"WHERE ename LIKE '%||?||%'";
			ps=conn.prepareStatement(sql);  //����Ŭ�� ����
			// ?�� ���� ä���
			ps.setString(1, ename);
			// ������ ����� ������ �´�
			ResultSet rs=ps.executeQuery();
			// ������ ���
			while(rs.next())   // rs.previous()
			{
				System.out.println("�̸�:"+rs.getString(1));
				System.out.println("����:"+rs.getString(2));
				System.out.println("�Ի���:"+rs.getDate(3));
				System.out.println("�޿�:"+rs.getInt(4));
				System.out.println("=======================");
			}
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("�̸� �Է�:");
		String ename=scan.next();
		// ���
		MusicDAO dao=new MusicDAO();
		dao.empFindData(ename);
	}
	
}
