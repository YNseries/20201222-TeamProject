package com.sist.movie;
// 오라클 연결
import java.sql.*;
public class MovieDAO {
	private Connection conn;  // 오라클 연결
	private PreparedStatement ps;  // SQL문장을 전송
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";  // 오라클 주소
	// URL 형식 => jdbc:업체명:IP:PORT:데이터베이스명    // java database connective
	// thin 드라이버 => 연결(오라클 <==> 자바응용프로그램) => 속도가 늦다, 무료
	// 드라이버 등록 => 한 번만 설정
	public MovieDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");  // 오라클하고 연결할 수 있게 드라이버를 설치(소프트웨어)
			// reflection => 클래스 정보를 읽어서 메모리 할당 / Properties(.setProperty) 를 이용하는 방법
		}catch(Exception ex) {ex.printStackTrace();}
	}
	// 오라클 연결
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");  // 연결 => 오라클 URL, username, password
			// conn hr/happy=>오라클 넘어간다    (sqlplus, id, pwd)
			// 명령 프롬포트에서 sqlpluse hr/happy 라고 친 것과 같은것
		}catch(Exception ex) {ex.printStackTrace();}
	}
	// 오라클 닫기
	public void disConnection()
	{
		try
		{
			// exit
			if(ps!=null) ps.close();  // OutputStream / BufferedReader => Statement 요청(값)을 받고, 값을 넣어줌
			if(conn!=null) conn.close();  // Socket => TCP
		}catch(Exception ex) {ex.printStackTrace();}
	}
	
	// 기능(데이터 추가) -> 이 부분만 바뀌고 위에는 매번 같음
	public void movieInsert(MovieVO vo)
	{
		try
		{
			/*
			 *    SELECT: 데이터 검색
			 *    INSERT: 데이터 추가
			 *    UPDATE: 데이터 수정
			 *    DELETE: 데이터 삭제
			 *    ==> CURD => 데이터 조작
			 *    오라클 장점 => 영구적인 저장 장치(지우기 전까지 안지워짐), 모두에게 공유할 수 있는 데이터
			 */
			getConnection();
			String sql="INSERT INTO movie VALUES(?,?,?,?,?,?,?,?)";   // 먼저 문장을 만듦, 오라클에 데이터 추가 명령어
			ps=conn.prepareStatement(sql);  // sql 보낼 준비
			ps.setInt(1, vo.getMno());  // TO_NUMBER()
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getGenre());
			ps.setString(4, vo.getPoster());
			ps.setString(5, vo.getActor());
			ps.setString(6, vo.getRegdate());
			ps.setString(7, vo.getGrade());
			ps.setString(8, vo.getDirector());
			
			// 실행
			ps.executeUpdate();  // 실행하면 값이 들어간다
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
}
