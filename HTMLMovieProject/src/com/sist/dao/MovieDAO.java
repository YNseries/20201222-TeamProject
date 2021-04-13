package com.sist.dao;
import java.util.*;  // (��ȭ)��� ��� => ArrayList => �������� ����
import java.sql.*;  // ����Ŭ ����
public class MovieDAO {
	// 1. ����Ŭ ���� ��ü
	private Connection conn;
	// 2. SQL���� ���� => ����� �޾ƿ��� ��ü
	private PreparedStatement ps;
	// 3. ����Ŭ �ּ�(URL)
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	//                          �������� ���� �� �� =========== IP
	// 1-1. ����̹� ��� => sqldeveloper ���� => �����ڴ� �� ���� ����� ����
	/*
	 *    new MovieDAO()
	 *    new MovieDAO()    => â �ΰ� ���� �Ǵ� ��
	 *    ====> ���� (�̱���,���丮...)
	 */
	public MovieDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	// 1-2. ����Ŭ ����  conn hr/happy
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	// 1-3. ����Ŭ �ݱ�  exit
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	// 2-1. ��� ����
	//   1) �α��� => ����� ��(2��: boolean, 2�� �̻�: String,int)
	//              (ID�� Ʋ�� ���, ��й�ȣ�� Ʋ�� ���, �α���)
	public String isLogin(String id,String pwd)
	{
		String result="";
		try
		{
			// 1. ���� 
			getConnection();
			// 2. SQL���� => ID�� �����ϴ��� ���� 
			String sql="SELECT COUNT(*) FROM webMember "
					+"WHERE id=?";
			ps=conn.prepareStatement(sql);
			// ?�� ���� ä��� 
			ps.setString(1, id);
			// �����Ŀ� ������� �޴´� 
			ResultSet rs=ps.executeQuery();
			rs.next();
			int count=rs.getInt(1);
			rs.close();
			  
			if(count==0) //ID�� �������� �ʴ� ���
			{
				result="NOID"; // alert()
			}
			else // ID�� �����ϴ� ��� 
			{
				// ��й�ȣ �˻� 
			    sql="SELECT pwd,name FROM webMember "
			    	+"WHERE id=?";
				ps=conn.prepareStatement(sql);
				// ?�� ���� ä���
				ps.setString(1, id);
				// ���� ������� ������ �´�
				rs=ps.executeQuery();
				rs.next();
				String db_pwd=rs.getString(1);
				String name=rs.getString(2);
				rs.close();
				 
				// ��й�ȣ�� �ֳ�?
				if(db_pwd.equals(pwd)) // ��й�ȣ�� �´� ���� => �α��� 
				{
					// ��ȭ������� �̵� 
					result=name; // id,name=> session => ��ۻ���� �ȵȴ� 
				}
				else // ��й�ȣ�� Ʋ�� ���� 
				{
					result="NOPWD";
				}
			}
			   
		}catch(Exception ex)
		{
			// ���� Ȯ�� 
			System.out.println(ex.getMessage());
		}
		finally
		{
			// �ݱ�
			disConnection();
		}
		return result;
	}
	//   2) ��ȭ ��� ���
	public ArrayList<MovieVO> movieListData(int page)
	{
		ArrayList<MovieVO> list=new ArrayList<MovieVO>();
		try
		{
		    // 1. ����
			getConnection();
			// 2. SQL���� 
			String sql="SELECT mno,title,poster,num "
				     +"FROM (SELECT mno,title,poster,rownum as num "
				     +"FROM (SELECT mno,title,poster "
				     +"FROM movie ORDER BY 1)) "
				     +"WHERE num BETWEEN ? AND ?";
			int rowSize=20;  // 20���� ���
			int start=(rowSize*page)-(rowSize-1);
			int end =rowSize*page;
			   
			ps=conn.prepareStatement(sql);
			   
			// ?�� ���� ä���
			ps.setInt(1, start);
			ps.setInt(2, end);
			   
			// �����û => ������� �޴´� 
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				MovieVO vo=new MovieVO();
				vo.setMno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPoster(rs.getString(3));
				list.add(vo);
			}
			rs.close();
			   
		}catch(Exception ex)
		{
		    System.out.println(ex.getMessage());
		}
		finally
		{
			disConnection();
		}
		return list;
	}
	//   2-1) �� ������(�̰� �׻� ����;���. Ŭ���ؼ� �Ѿ��)
	public int movieTotalPage()
	{
	    int total=0;
	    try
	    {
		    // 1. ����
		    getConnection();
		    // 2. SQL���� 
		    String sql="SELECT CEIL(COUNT(*)/20.0) FROM movie";
		    ps=conn.prepareStatement(sql);
		    ResultSet rs=ps.executeQuery();
		    rs.next();
		    total=rs.getInt(1);
		    rs.close();
	    }catch(Exception ex)
	    {
		    System.out.println(ex.getMessage());
	    }
	    finally
	    {
		    disConnection();
	    }
 	    return total;
	}
	//   3) ��ȭ �󼼺���(mno => ����ڰ� �����͸� Ŭ���� �� �Ѱ��� ��ȣ) => �ش��ϴ� ��ȭ 1���� ����
	/*
	 *  MNO      NOT NULL NUMBER(4)     
		TITLE             VARCHAR2(100) 
		GENRE             VARCHAR2(100) 
		POSTER            VARCHAR2(200) 
		ACTOR             VARCHAR2(300) 
		REGDATE           VARCHAR2(100) 
		GRADE             VARCHAR2(50)  
		DIRECTOR          VARCHAR2(100)
	 */
	public MovieVO movieDetailData(int mno)
	{
		MovieVO vo=new MovieVO();
		try
		{
			getConnection();
			String sql="SELECT mno,title,poster,actor,genre,actor,"
					+ "regdate,grade,director "
					+ "FROM movie "
					+ "WHERE mno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, mno);
			// ����� �ޱ�
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setMno(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setPoster(rs.getString(3));
			vo.setGenre(rs.getString(4));
			vo.setActor(rs.getString(5));
			vo.setRegdate(rs.getString(6));
			vo.setGrade(rs.getString(7));
			vo.setDirector(rs.getString(8));
			rs.close();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally
		{
			disConnection();
		}
		return vo;   // vo�� ���� ä���� �Ѱ��ش�
	}
	//   3-1) ����� ���� ��ȭ
	public ArrayList<MovieVO> replyTop10()
	{
		ArrayList<MovieVO> list=new ArrayList<MovieVO>();
		try
		{
			getConnection();
			// SQL���� => ��������, �̺�Ʈ, �α���� ... �� ���� �߶�� ��: rownum
			String sql="SELECT title,poster,hit,rownum "
					+ "FROM (SELECT title,poster,hit "
					+ "FROM movie ORDER BY hit DESC) "
					+ "WHERE rownum<=10";
			ps=conn.prepareStatement(sql);
			// ? �����ϱ� �ٷ� ���� ��û
			ResultSet rs=ps.executeQuery();
			rs.next();
			while(rs.next())
			{
				MovieVO vo=new MovieVO();
				vo.setTitle(rs.getString(1));
				vo.setPoster(rs.getString(2));
				vo.setHit(rs.getInt(3));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally
		{
			disConnection();
		}
		return list;
	}
	//   4) ��� ����
	public void replyInsert(ReplyVO vo)
	{
		try
		{
			// 1. ����
			getConnection();
			// 2. sql����(��ۿ� ���� ��ȸ�� ����)
			String sql="UPDATE movie SET "
					+ "hit=hit+1 "   // ��� insert �� ������ hit �ϳ��� ����
					+ "WHERE mno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, vo.getMno());
			ps.executeUpdate();
			
			sql="INSERT INTO webReply VALUES("
					+ "wr_no_seq.nextval,?,?,?,?,SYSDATE)";
			ps=conn.prepareStatement(sql);
			// 2-1. ?�� ��ä���
			ps.setInt(1, vo.getMno());
			ps.setString(2, vo.getId());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getMsg());
			// 3. �����û
			ps.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
	//   5) ��� ����
	//   6) ��� ����
	//   7) ��� �б�
	public ArrayList<ReplyVO> replyListData(int mno)
	{
		ArrayList<ReplyVO> list=new ArrayList<ReplyVO>();
		try
		{
			getConnection();
			String sql="SELECT no,id,name,msg,TO_CHAR(regdate,''YYYY-MM-DD HH24:MI:SS') "
					+ "FROM webReply "
					+ "WHERE mno=? "
					+ "ORDER BY no DESC";   // �ֽ� ��� ������ ������
			ps=conn.prepareStatement(sql);
			ps.setInt(1, mno);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ReplyVO vo=new ReplyVO();
				vo.setNo(rs.getInt(1));
				vo.setId(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setMsg(rs.getString(4));
				vo.setDbday(rs.getString(5));   // ��¥ �� ����� �� ����Ŭ���� ����;� ��
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return list;
	}
	//   8) ��� �� ������ Ȯ��... �� ���ص� �ɵ�

}
