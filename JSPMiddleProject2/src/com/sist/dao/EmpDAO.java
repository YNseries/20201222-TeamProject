package com.sist.dao;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.*;
public class EmpDAO {
	   private Connection conn;
	   private PreparedStatement ps;
	   // 미리 생성된 Connection주소 얻기
	   public void getConnection()
	   {
		   try
		   {
			   Context init=new InitialContext();
			   Context c=(Context)init.lookup("java://comp/env");
			   DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			   conn=ds.getConnection();
		   }catch(Exception ex) {}
	   }
	   // 반환 
	   public void disConnection()
	   {
		   try
		   {
			   if(ps!=null) ps.close();
			   if(conn!=null) conn.close();
		   }catch(Exception ex) {}
	   }
	   // 목록
	   public List<EmpVO> empListData()
	   {
		   List<EmpVO> list=new ArrayList<EmpVO>();
		   try
		   {
			   // 주소를 얻기
			   getConnection();
			   String sql="SELECT empno,ename,job,hiredate,sal,dname,loc "
					     +"FROM emp,dept "
					     +"WHERE emp.deptno=dept.deptno";
			   ps=conn.prepareStatement(sql);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   EmpVO vo=new EmpVO();
				   vo.setEmpno(rs.getInt(1));
				   vo.setEname(rs.getString(2));
				   vo.setJob(rs.getString(3));
				   vo.setHiredate(rs.getDate(4));
				   vo.setSal(rs.getInt(5));
				   vo.getDvo().setDname(rs.getString(6));
				   vo.getDvo().setLoc(rs.getString(7));
				   list.add(vo);
			   }
			   rs.close();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();// 반환  => 재사용
		   }
		   return list;
	   }
 }