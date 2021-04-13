package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class EmpDeptJoinDAO {
	   // 1. 오라클  연결 객체 
	   private Connection conn;
	   // 2. SQL문장 전송 => 결과값을 받아오는 객체
	   private PreparedStatement ps;
	   // 3. 오라클 주소 (URL)
	   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	   // 원격                                      ========== IP
	   // 1-1. 드라이버 등록 => sqldeveloper 열기 => 생성자는 한번만 사용이 가능 
	   /*
	    *    new MovieDAO()
	    *    new MovieDAO()
	    *    ====> 패턴 (싱글턴,팩토리...)
	    */
	   public EmpDeptJoinDAO()
	   {
		   try
		   {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
		   }catch(Exception ex){}
	   }
	   // 1-2. 오라클 연결  conn hr/happy
	   public void getConnection()
	   {
		   try
		   {
			   conn=DriverManager.getConnection(URL,"hr","happy");
		   }catch(Exception ex) {}
	   }
	   // 1-3. 오라클 닫기  exit
	   public void disConnection()
	   {
		   try
		   {
			   if(ps!=null) ps.close();
			   if(conn!=null) conn.close();
		   }catch(Exception ex) {}
	   }
	   
	   // 2.
	   public ArrayList<EmpVO> empAllData()
	   {
		   ArrayList<EmpVO> list=
				   new ArrayList<EmpVO>();
		   try
		   {
			   // 1. 연결
			   getConnection();
			   // 2. sql
			   String sql="SELECT empno,ename,job,hiredate,sal,emp.deptno,dname,loc "
			   		+ "FROM emp,dept "
			   		+ "WHERE emp.deptno=dept.deptno";
			   ps=conn.prepareStatement(sql);
			   // 3. 실행요청
			   ResultSet rs=ps.executeQuery();
			   // 4. 결과가ㅓㅄ => list 저장
			   while(rs.next())
			   {
				   EmpVO vo=new EmpVO();
				   vo.setEmpno(rs.getInt(1));
				   vo.setEname(rs.getString(2));
				   vo.setJob(rs.getString(3));
				   vo.setHiredate(rs.getDate(4));
				   vo.setSal(rs.getInt(5));
				   vo.setDeptno(rs.getInt(6));
				   vo.getDvo().setDname(rs.getString(7));
				   vo.getDvo().setLoc(rs.getString(8));
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
	   
	   public static void main(String[] args) {
		   EmpDeptJoinDAO dao=new EmpDeptJoinDAO();
		   ArrayList<EmpVO> list=dao.empAllData();
		   for(EmpVO vo:list)
		   {
			   System.out.println(vo.getEmpno()+" "
					   +vo.getEname()+" "
					   +vo.getJob()+" "
					   +vo.getHiredate()+" "
					   +vo.getSal()+" "
					   +vo.getDeptno()+" "
					   +vo.getDvo().getDname()+" "
					   +vo.getDvo().getLoc());
		   }
	}
}
