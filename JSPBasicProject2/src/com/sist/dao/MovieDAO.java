package com.sist.dao;
/*
 *   JDBC ====> DBCP ====> ORM(MyBatis: DBCP가 포함되어 있음)
 *   ==== 이 방식은 이제 x
 * 	 DBCP(웹에서만 가능)
 *    1. 보안이 뛰어남
 *    2. 오라클 연결에 소모되는 시간을 줄일 수 있다 => 속도 빨라짐
 *    3. Connection객체 메모리를 낭비하지 않는다
 *    4. 웹애플리케이션(사이트)에서 한 번에 많은 접속자가 들어와도 쉽게 무너지지 않는다
 *    5. 사이트를 만들 때 일반화 되어있다.
 *      자바로 짜는 것보다 아래와 같이 xml로 하는 게 훨씬 좋음
 * 		<Resource
            driverClassName="oracle.jdbc.driver.OracleDriver"
            url="jdbc:oracle:thin:@localhost:1521:XE"
            username="hr"
            password="happy"
            maxActive="10"  ----> 인원(접속자)이 증가되면 최대 10개까지 만들어라
            maxIdle="5"    ----> 톰캣이 만들어줌 Connection객체를 5개 만들어라
            maxWait="-1"  ----> 계속 기다려라(10명이 넘어갔을 때, 기다리는 정도)
            name="jdbc/oracle"   ----> 미리 생성된 Connection을 찾아옴
            type="javax.sql.DataSource"  ----> DataSource를 이용해서 찾은 Connection주소를 저장
            auth="Container": 관리자(톰캣)
         />
 */

import java.sql.*;
import java.util.*;

public class MovieDAO {
	  private Connection conn;
	  private PreparedStatement ps;
	  private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	  public MovieDAO()
	  {
		  try
		  {
			  Class.forName("oracle.jdbc.driver.OracleDriver");
		  }catch(Exception ex) {}
	  }
	  public void getConnection()
	  {
		  try
		  {
			  conn=DriverManager.getConnection(URL,"hr","happy");
		  }catch(Exception ex) {}
	  }
	  public void disConnection()
	  {
		  try
		  {
			  if(ps!=null) ps.close();
			  if(conn!=null) ps.close();
		  }catch(Exception ex) {
			  ex.printStackTrace();
		  }
	  }
	  // 기능
	  public ArrayList<MovieVO> movieListData()
	  {
		  ArrayList<MovieVO> list=new ArrayList<MovieVO>();
		  try
		  {
			  getConnection();
			  // 인기순위, 공지사항 등 몇 개씩 잘라서 갖고올 때 rownum 씀
			  String sql="SELECT mno,poster,title,rownum "
			  		+ "FROM daum_movie "
			  		+ "WHERE rownum<=20";
			  ps=conn.prepareStatement(sql);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next())
			  {
				  MovieVO vo=new MovieVO();
				  vo.setMno(rs.getInt(1));
				  vo.setTitle(rs.getString(3));
				  vo.setPoster(rs.getString(2));
				  
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
	  // 상세보기
	  public MovieVO movieDetailData(int mno)
	  {
		  /*
		   *   private String poster,title,director,actor,regdate,
						genre,nation,grade,time,showUser,
						boxoffice,story,key;
				private double score;
		   */
		  MovieVO vo=new MovieVO();
		  try
		  {
			  getConnection();
			  String sql="SELECT poster,title,regdate,genre,nation,grade,time,"
			  		+ "showUser,boxoffice,story,key,score "
			  		+ "FROM daum_movie "
			  		+ "WHERE mno=?";
			  ps=conn.prepareStatement(sql);
			  // ?에 값 채운다 => 지금 ?값 1개이기 때문에 while 안해도 됨
			  ps.setInt(1, mno);
			  
			  ResultSet rs=ps.executeQuery();
			  rs.next();  // row단위
			  vo.setPoster(rs.getString(1));
			  vo.setTitle(rs.getString(2));
			  vo.setRegdate(rs.getString(3));
			  vo.setGenre(rs.getString(4));
			  vo.setNation(rs.getString(5));
			  vo.setGrade(rs.getString(6));
			  vo.setTime(rs.getString(7));
			  vo.setShowUser(rs.getString(8));
			  vo.setBoxoffice(rs.getString(9));
			  vo.setStory(rs.getString(10));
			  vo.setKey(rs.getString(11));
			  vo.setScore(rs.getDouble(12));
			  rs.close();
		  }catch(Exception ex) {
			  ex.printStackTrace();
		  }
		  finally
		  {
			  disConnection();
		  }
		  return vo;
	  }
}
