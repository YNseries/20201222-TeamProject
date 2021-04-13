package com.sist.dao;
import java.sql.*;
// VO, DAO
/*
 *    SQL
 *     = DML(데이터 조작 언어)
 *         = SELECT: 데이터 검색 ****
 *             = JOIN
 *             = SUBQUERY
 *         = INSERT: 데이터 추가
 *         = UPDATE: 데이터 수정
 *         = DELETE: 데이터 삭제
 *     = DDL(데이터 선언 언어) => 제약조건(PRIMARY KEY: 중복이 안되는 데이터 넣을 때, FOREIGN KEY, CHECK, UNIQUE, DEFAULT)
 *         = CREATE: 생성
 *             TABLE, VIEW, INDEX, SEQUENCE, PROCEDURE, FUNCTION, TRIGGER
 *         = ALTER: 수정
 *         = DROP: 삭제
 *         = TRUNCATE: 잘라내기
 *         = RENAME: 이름 변경
 *     = DCL(데이터 제어 언어)
 *         = GRENT: 권한 부여
 *         = REVOKE: 권한 해제
 *     = TCL(트랜잭션 제어 언어)
 *         = COMMIT: 정상 저장
 *         = ROLLBACK: 저장 취소
 *     
 *     PL/SQL
 *        ===
 *     == 
 *     함수를 만드는 언어 Procedure Language: 재사용, 자동 동작
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			// 1. Driver 등록 => Oracle 제공
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 연결
			String url="jdbc:oracle:thin:@localhost:1521:XE";  // 오라클 주소
			Connection conn=DriverManager.getConnection(url,"hr","happy");  
			// 3. SQL문장 전송 ****
			String sql="SELECT empno,ename,job,hiredate,sal FROM emp WHERE hiredate LIKE '%T'";  // from 다음에 table명
			//          startsWith
			// 오라클 => 대소문자 구분이 없다(약속 => 키워드는 대문자로 한다)
			// class, interface => 대문자 시작 / 변수, 메소드 => 소문자
			/*
			 *    class mainclass
			 *    {
			 *    
			 *    }
			 *    
			 *    mainclass mainclass=new mainclass();   // 이렇게 보면 알아보기 힘드니까. REFACTORING이 필요
			 *    => MainClass mainclass=new MainClass();
			 */
			PreparedStatement ps=conn.prepareStatement(sql);  // 전송
			/*
			 *     empno
			 *     ename
			 *     job
			 *     mgr
			 *     hiredate
			 *     sal
			 *     comm
			 *     deptno
			 */
			// 4. 결과값 받아서 출력
			ResultSet rs=ps.executeQuery();   // rs에 데이터 값 다 들어감
			while(rs.next())  // 한 줄씩 읽어 온다 => 데이터가 없으면 false,  rs.privious()는 거꾸로 읽어 올라가는 것
			{
				System.out.println(
					rs.getInt(1)+" "
					+rs.getString(2)+" "
					+rs.getString(3)+" "
					+rs.getDate(4)+" "
					+rs.getString(5)
				);
			}
		}catch(Exception ex) {ex.printStackTrace();}
	}
	
}
