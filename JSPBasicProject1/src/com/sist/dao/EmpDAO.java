package com.sist.dao;
import java.util.*;
import java.sql.*;
public class EmpDAO {
	// 오라클 연결
	private Connection conn;
	// SQL전송 객체
	private PreparedStatement ps;
	// server.xml에 등록 후 읽기(될 수 있으면 final로 설정하는게 좋아)
	// 오라클 주소 설정
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	// 드라이버 등록
	private final String DRIVER="oracle.jdbc.driver.OracleDriver";
	// user-name
	private final String USERNAME="hr";
	// password
	private final String PASSWORD="happy";
	
	// 드라이버 등록
	public EmpDAO()
	{
		try
		{
			Class.forName(DRIVER);
			// reflection 클래스의 정보를 읽어와서 제어(= 생성, 메소드호출, 소멸) => Spring 잘 하려면 알아야 함
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	// 오라클 연결
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	// 오라클 해제
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	// 기능 수행 => 사원 목록 전체 출력
	public ArrayList<EmpVO> empListData()
	{
		ArrayList<EmpVO> list=new ArrayList<EmpVO>();
		try
		{
			// 1. 연결
			getConnection();
			// 2. sql 문장 전송
			String sql="SELECT * FROM emp ORDER BY dname ASC";
			ps=conn.prepareStatement(sql);
			// 3. 실행후 결과 읽기
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				EmpVO vo=new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setMgr(rs.getInt(4));
				vo.setHiredate(rs.getDate(5));
				vo.setSal(rs.getInt(6));
				vo.setComm(rs.getInt(7));
				vo.setDeptno(rs.getInt(8));
				
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
}
