package com.sist.music;
// 여기엔 지니뮤직, 멜론뮤직 전부 저장
import java.sql.*;
/*
 *	  JDBC => Java DataBase Connective ==> ojdbc(Oracle ~)
 *    오라클 연결
 *    1. 드라이버 설치	Class.forName("드라이버 클래스명");
 *    2. 오라클 연결	Connection 클래스 => 오라클 주소,username, password
 *    3. SQL 문장 전송 => 오라클에서 SQL을 받아서 실행
 *    				   Statement
 *                     = Statement: SQL문장 + 데이터값(동시에)
 *                       String name,sex,addr,tel;
 *                       int age;
 *                       String sql="INSERT INTO member VALUES('"+name+"','"+sex+"','"+addr+"','"+tel+"',"+age")";
 *                       // member에 값(VALUES)을 채우겠다
 *                     = PreparedStatement: default(SQL문장을 만들고, 나중에 값을 채움)
 *                       String sql="INSERT INTO member VALUES(?,?,?,?,?);  // 간단해서 자주 사용(Statement가 발전된 버전)
 *                     = CallableStatement: 함수 호출시(PS/SQL)
 *    	 executeQuery(SQL문장): 실행된 결과를 받아올 때 => SELECT
 *    	 executeUpdate(SQL문장): 오라클 자체에서 처리 => INSERT, UPDATE, DELETE
 *    4. 오라클 닫기 => 꼭 종료해 줘야 함. 열고 닫고가 중요 안그러면 Connection 끊어짐. xe는 50명까지 접속 가능
 *       = 연결 => 전송 => 닫기
 */
public class MusicDAO {
	private Connection conn;  // 오라클 연결 => Socket
	private PreparedStatement ps;  // OutputStream(오라클에 전송), BufferedReader(오라클로부터 데이터 받음)
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	// 여기서 오류나면 => DOS창에 null, NullPointerException 뜸
	// 드라이버 설치: 한 번만 수행 => 보통 생성자에 설치
	public MusicDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {ex.printStackTrace();}
	}
	
	// 연결
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");  // 보통 XML에 숨김
			// 오라클 전송할 때 ==> conn hr/happy 문장이 전송된 것. 나중에는 이렇게 설정하면 안됨 => 오라클의 모든 데이터 털림
		}catch(Exception ex) {ex.printStackTrace();}
	}
	// 닫기
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
			// 오라클 전송 ==> exit 종료
		}catch(Exception ex) {ex.printStackTrace();}
	}
	// ↑ 여기까지 오라클 연결하면 항상 넣어줘야 하는 부분. 패턴이 동일
	
	// 지니뮤직의 데이터 저장 => 저장시 순서 바뀌면 안됨★★
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
	public void genieMusicInsert(GenieMusicVO vo)  // 이렇게 vo로 모으지 않으면 하나씩 해야하는 번거로움이 있음
	{
		try
		{
			// 연결
			getConnection();
			// SQL문장 제작
			String sql="INSERT INTO genie_music VALUES(?,?,?,?,?,?,?,?)";  // 한 줄에 8개씩 들어감. ?갯수 틀리면 안됨
			ps=conn.prepareStatement(sql);
			// ?의 값 채우기
			ps.setInt(1, vo.getNo());  // 오라클이니까 1부터 시작
			ps.setInt(2, vo.getCno());
			ps.setString(3, vo.getTitle());
			ps.setString(4, vo.getSinger());
			ps.setString(5, vo.getAlbum());
			ps.setString(6, vo.getPoster());
			ps.setString(7, vo.getState());
			ps.setInt(8, vo.getIdcrement());
			/*
			 *    VARCHAR2, CHAR, CLOB => String
			 *    NUMBER => int(가끔 double => 평점)
			 *    DATE => java.util.Date()
			 */
			// SQL문장 실행
			ps.executeUpdate();
		}catch(Exception ex) {
			// 에러확인
			System.out.println(ex.getMessage());
		}
		finally
		{
			// 오라클 닫기
			disConnection();
		}
	}

}
