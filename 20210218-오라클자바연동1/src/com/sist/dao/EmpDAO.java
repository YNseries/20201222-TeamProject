package com.sist.dao;
// 기능별로 만든다 => 재사용 목적
/*
 * 	 게시판(VO,DAO)
 *   회원 (VO,DAO)
 *   영화 (VO,DAO)
 *   예매 (VO,DAO)
 *   --
 *   --
 *   --
 *   --
 */
/*
 * 	  1. SELECT
 *    	 1) 형식
 *          SELECT
 *          FROM
 *          WHERE
 *          GROUP BY
 *          HAVING
 *          ORDER BY
 *       2) 연산자
 *          IN, NULL(IS NULL, IS NOT NULL), BETWEEN ~ AND, NOT
 *       3) 내장함수
 *       	문자: SUBSTR(), RPAD(), LENGTH()
 *       	숫자: ROUND(), CEIL()
 *          날짜: SYSDATE
 *          변환: TO_CHAR => 날짜, 시간 ==> YYYY(RRRR), MM, DD, HH24, MI, SS
 *          				숫자 => 99,999
 *          일반: NVL
 *          집합: MAX, COUNT, RANK() => AVG, SUM
 *       4) GROUP BY
 *       5) JOIN
 *       	INNER JOIN: EQUI_JOIN
 *       	OUTER JOIN: LEFT, RIGHT
 *       ===============================
 *       6) SUBQUERY => VIEW
 *          CREATE TABLE table_name
 *          AS
 *            SELECT~~
 *       ===============================
 *    2. INSERT
 *    3. UPDATE
 *    4. DELETE  ==> JDBC
 */
import java.util.*;
import java.sql.*;
public class EmpDAO {
	// 연결 객체, 전송 객체 생성
	// 1) 연결 객체
	private Connection conn;   // Socket => TCP
	// 2) SQL문장 전송 => 결과값을 읽어오는 객체
	private PreparedStatement ps;
	// 3) 오라클 연결 주소
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	// 프로그램 시작 => 반드시 드라이버(클래스로 되어있음) 설치해야 함 => 클래스를 등록하면 드라이버 설치를 인식함
	public EmpDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {ex.printStackTrace();}
	}
	// 1. 연결
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
			// => 오라클로 전송 conn hr/happy
		}catch(Exception ex) {ex.printStackTrace();}
	}
	// 2. 접속 해제
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();  // 오라클에 연결된 상태라면, 
			if(conn!=null) conn.close();
		// exit. 종료
		}catch(Exception ex) {ex.printStackTrace();}
	}
	
	// 기능 설정(SQL 문장 전송)
	// 1. EMP의 모든 데이터를 출력
	// SQL: SELECT * FROM emp
	public void empAllData()
	{
		try
		{
			// 연결
			getConnection();
			// SQL 문장을 만들고
			String sql="SELECT * FROM emp";
			// SQL 문장 전송
			ps=conn.prepareStatement(sql);
			// 결과값을 받는다
			ResultSet rs=ps.executeQuery();
			// 화면에 출력 => 브라우저, 명령 프롬프트
			/*
			 *    문자형: CHAR, VARCHAR2, CLOB => getString()
			 *    날짜형: DATE, TIMESTAMP => getDate()
			 *    숫자형: NUMBER => 소수점이 없는 경우 => getInt()
			 *     			 	  소수점이 있는 경우 => getDouble()
			 */
			while(rs.next())
			{
				System.out.println("사번:"+rs.getInt(1));
				System.out.println("이름:"+rs.getString(2));
				System.out.println("직위:"+rs.getString(3));
				System.out.println("사수:"+rs.getString(4));
				System.out.println("입사일:"+rs.getDate(5));
				System.out.println("급여:"+rs.getInt(6));
				System.out.println("성과급:"+rs.getInt(7));
				System.out.println("부서번호:"+rs.getInt(8));
				System.out.println("=========================");
			}
			// 끝나고 메모리 지움
			rs.close();
		}catch(Exception ex) {ex.printStackTrace();}
		finally
		{
			// 해체
			disConnection();
		}
	}
	// 2. 원하는 컬럼명 출력 => ename,job,hiredate,sal => 메소드명: empListData()
	public void empListData()
	{
		try
		{
			getConnection();
			String sql="SELECT ename,job,hiredate,sal FROM emp";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("이름:"+rs.getString(1));
				System.out.println("직위:"+rs.getString(2));
				System.out.println("입사일:"+rs.getDate(3));
				System.out.println("급여:"+rs.getInt(4));
				System.out.println("=========================");
			}
			rs.close();
		}catch(Exception ex) {ex.printStackTrace();}
		finally
		{
			disConnection();
		}
	}
	// 3. 사원이름 ename, 급여 sal, 성과급 comm, 총급여 출력(산술연산) sal+comm
	public void empOprationData()
	{
		try
		{
			getConnection();
			String sql="SELECT ename,sal,comm,sal+NVL(comm,0) FROM emp";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("이름:"+rs.getString(1));
				System.out.println("급여:"+rs.getInt(2));
				System.out.println("성과급:"+rs.getInt(3));
				System.out.println("급여+성과급:"+rs.getInt(4));
				System.out.println("=========================");
			}
			rs.close();
		}catch(Exception ex) {ex.printStackTrace();}
		finally
		{
			disConnection();
		}
	}
	// 4. SUBSTR을 이용해서 81년에 입사한 사원의 이름, 입사일, 급여
	//                            getString getDate getInt
	// 5. emp에서 A로 시작하는 사원의 이름만 출력
	public void empSubstrData()
	{
		try
		{
			getConnection();
			String sql="SELECT ename,hiredate,sal FROM emp "
					//+"WHERE SUBSTR(hiredate,1,2)=81";
					+"WHERE ename LIKE '%A%'";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("이름:"+rs.getString(1));
				//System.out.println("입사일:"+rs.getDate(2));
				//System.out.println("급여:"+rs.getInt(3));
				//System.out.println("=========================");
			}
			rs.close();
		}catch(Exception ex) {ex.printStackTrace();}
		finally
		{
			disConnection();
		}
	}
	// 6. emp에서 급여가 1500이상 3000이사인 사원의 이름과 급여, 직위를 출력
	// 7. emp에서 10,20번 부서의 사원이름, 급여, 직위
	public void empBetweenData()
	{
		try
		{
			getConnection();
			//String sql="SELECT ename,sal,job FROM emp "
					//+"WHERE sal BETWEEN 1500 AND 3000";
			String sql="SELECT ename,sal,job FROM emp "
					+"WHERE deptno IN(10,20)";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("이름:"+rs.getString(1));
				System.out.println("급여:"+rs.getInt(2));
				System.out.println("직위:"+rs.getString(3));
				System.out.println("=========================");
			}
			rs.close();
		}catch(Exception ex) {ex.printStackTrace();}
		finally
		{
			disConnection();
		}
	}
	// 8. emp에서 성과급을 받는 사원의 이름, 급여, 성과급,직위
	public void empNotnullData()
	{
		try
		{
			// 연결
			getConnection();
			// SQL 문장을 만들고
			String sql="SELECT ename,sal,comm,job FROM emp "
					+"WHERE comm IS NOT NULL AND comm<>0";
			// SQL 문장 전송
			ps=conn.prepareStatement(sql);
			// 결과값을 받는다
			ResultSet rs=ps.executeQuery();
			// 화면에 출력 => 브라우저, 명령 프롬프트
			while(rs.next())
			{
				System.out.println("이름:"+rs.getString(1));
				System.out.println("급여:"+rs.getInt(2));
				System.out.println("성과급:"+rs.getInt(3));
				System.out.println("직위:"+rs.getString(4));
				System.out.println("=========================");
			}
			rs.close();
		}catch(Exception ex) {ex.printStackTrace();}
		finally
		{
			// 해체
			disConnection();
		}
	}
	// 9. 각 부서별 인원수, 최대급여, 최소급여, 급여 합, 급여평균
	//      입사년도별
	//      직위별
	public void empGroupData(int n)
	{
		try
		{
			getConnection();
			String sql="";
			if(n==1)
			{
				sql="SELECT deptno,COUNT(*),MAX(sal),MIN(sal),SUM(sal),AVG(sal) "
					+"FROM emp "
					+"GROUP BY deptno";
			}
			else if(n==2)
			{
				sql="SELECT TO_CHAR(hiredate,'YYYY'),COUNT(*),MAX(sal),MIN(sal),SUM(sal),AVG(sal) "
					+"FROM emp "
					+"GROUP BY TO_CHAR(hiredate,'YYYY')";
			}
			else if(n==3)
			{
				sql="SELECT job,COUNT(*),MAX(sal),MIN(sal),SUM(sal),AVG(sal) "
					+"FROM emp "
					+"GROUP BY job";
			}
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			// 모든 데이터는 getString()으로 읽어올 수 있다
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "
								+rs.getInt(2)+" "
								+rs.getInt(3)+" "
								+rs.getInt(4)+" "
								+rs.getInt(5)+" "
								+rs.getInt(6)
				);
				System.out.println("=============================");
			}
			rs.close();
		}catch(Exception ex) {ex.printStackTrace();}
		finally
		{
			disConnection();
		}
	}
	// 10. 직위의 종류만 출력 DISTINCT => SELECT DISTINCT job FROM emp;
	public void empDistinctData()
	{
		try
		{
			getConnection();
			String sql="SELECT DISTINCT job "
					+"FROM emp";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(
						rs.getString(1)
				);
			}
			rs.close();
		}catch(Exception ex) {ex.printStackTrace();}
		finally
		{
			disConnection();
		}
	}
	// 11. emp에서 이름, 직위, 입사일, 급여, 부서명, 근무지, 급여등급 출력 ==> empJoinData()
	public void empJoinData()
	{
		try
		{
			getConnection();
			String sql="SELECT ename,job,hiredate,sal,dname,loc,grade "
					+"FROM emp,dept,salgrade "
					+"WHERE emp.dentno=dept.deptno "
					+"AND sal BETWEEN losal AND hisal";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(
						rs.getString(1)+" "
					   +rs.getString(2)+" "
					   +rs.getDate(3)+" "
					   +rs.getInt(4)+" "
					   +rs.getString(5)+" "
					   +rs.getString(6)+" "
					   +rs.getInt(7)
				);
			}
			rs.close();
		}catch(Exception ex) {ex.printStackTrace();}
		finally
		{
			disConnection();
		}
	}
	public static void main(String[] args) {
		EmpDAO dao=new EmpDAO();
		// 1. 데이터 전체 출력 SELECT * FROM table_name
		//dao.empAllData();
		// 2. 필요한 컬럼만 출력
		//dao.empListData();
		// 3. 연산자
		//dao.empOprationData();
		// 4. SUBSTR, 5. A 들어간 사원 이름
		//dao.empSubstrData();		
		// 6. BETWEEN ~ AND, 7. 성과급
		//dao.empBetweenData();
		// 8. 성과급 받는 사원 NOT NULL
		//dao.empNotnullData();
		// 9. 부서별, 입사년도별, 직위별
		/*
		 * dao.empGroupData(1); dao.empGroupData(2); dao.empGroupData(3);
		 */
		// 10.
		//dao.empDistinctData();
		// 11. empJoinData()
		dao.empJoinData();
	}
}
