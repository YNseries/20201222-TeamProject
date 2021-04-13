package com.sist.dao;
// 오라클 연결하는 프로그램
import java.util.*;  // ArrayList
import java.sql.*;  // 
public class MusicDAO {
	// 연결하는 클래스
	private Connection conn;  // 오라클 연결
	// SQL문장을 전송하는 클래스
	private PreparedStatement ps;   // 값을 받아옴
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";   // 오라클 접근 주소
	// 1. 연결 드라이버 설치 => 한 번만 사용(주로 생성자에서 사용)
	public MusicDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {ex.printStackTrace();}
	}
	//2. 연결
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
			// 오라클 => conn hr/happy
		}catch(Exception ex) {ex.printStackTrace();}
	}
	// 3. 해체
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();   // 통신(송신:OutputStream, 수신:BufferedReader) 담당
			if(conn!=null) conn.close();   // 연결기기:Socket
		}catch(Exception ex) {ex.printStackTrace();}
	}
	// 4. 기능 => 뮤직 데이터 50개를 받아서 저장 ==> 저장된 데이터를 브라우저에서 읽어서 출력
	public ArrayList<MusicVO> musicListData()
	{
		// return selectList("sql"); ==> myBatis
		ArrayList<MusicVO> list=new ArrayList<MusicVO>();
		try
		{
			// 4-1. 연결
			getConnection();
			// 4-2. SQL문장을 만든다
			String sql="SELECT no,title,poster,singer,album,state,idcrement "  // 뒤에 공백 안주면 오류남
					+"FROM genie_music "  // 뒤에 공백 잊으면 안됨
					+"ORDER BY no ASC";   // 순서맞추기(no ASC 대신 1 써도 됨)
			ps=conn.prepareStatement(sql);  // 전송 준비
			// 4-3. SQL문장 전송
			ResultSet rs=ps.executeQuery();  // rs=메모리공간
			// 4-4. 결과값을 가지고 온다
			// 4-5. ArrayList에 담는다
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
			while(rs.next())   // .next() 있어야 커서가 맨 앞으로 간 다음, 다음으로 이동 가능(커서위치 변경) => 다음에 값 없으면 false 나오면서 멈춤
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
			// 4-6. 대기상태(브라우저에서 부르기 전까지)
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally
		{
			disConnection();  // 닫기 (오류/정상 상관없이 무조건 오라클을 닫는다)
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
			ps=conn.prepareStatement(sql);  //오라클로 전송
			// ?에 값을 채운다
			ps.setString(1, ename);
			// 실행한 결과를 가지고 온다
			ResultSet rs=ps.executeQuery();
			// 데이터 출력
			while(rs.next())   // rs.previous()
			{
				System.out.println("이름:"+rs.getString(1));
				System.out.println("직위:"+rs.getString(2));
				System.out.println("입사일:"+rs.getDate(3));
				System.out.println("급여:"+rs.getInt(4));
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
		System.out.print("이름 입력:");
		String ename=scan.next();
		// 출력
		MusicDAO dao=new MusicDAO();
		dao.empFindData(ename);
	}
	
}
