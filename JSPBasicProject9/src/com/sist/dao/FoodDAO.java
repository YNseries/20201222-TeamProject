package com.sist.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

// DBCP => 웹에서만 가능
public class FoodDAO {

	private Connection conn;
	private PreparedStatement ps;
	// 미리 만들어진 객체 주소를 얻어온다(Connection)
		public void getConnection()
		{
			try
			{
				Context init=new InitialContext();
				Context c=(Context)init.lookup("java://comp/env");
				DataSource ds=(DataSource)c.lookup("jdbc/oracle");
				conn=ds.getConnection();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		// 반환(POOL로 반환) => 재사용
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
	public List<FoodCategoryVO> foodCategoryData(int index)
	{
		List<FoodCategoryVO> list=new ArrayList<FoodCategoryVO>();
		try
		{
			getConnection();
			int start=0;
			int end=0;
			// 컬럼 나누는 것의 중요성... tno로 나눴으면 이렇게 번거롭게 안가져와도 됨
			if(index==1)
			{
				start=1;
				end=12;
			}
			else if(index==2)
			{
				start=13;
				end=18;
			}
			else
			{
				start=19;
				end=30;
			}
			String sql="SELECT * FROM food_category "
					+ "WHERE no BETWEEN ? AND ?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				FoodCategoryVO vo=new FoodCategoryVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setSubject(rs.getString(3));
				vo.setPoster(rs.getString(4));
				vo.setLink(rs.getString(5));
				
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
	
	// 카테고리 번호(cno)를 맞추기(쓰기) 위해 번호-링크 연결 / 링크만 가지고 오면 카테고리 내 음식점을 찾을 수 없기 때문
	public List<FoodCategoryVO> foodCategoryLinkData()
	{
		List<FoodCategoryVO> list=new ArrayList<FoodCategoryVO>();
		try
		{
			getConnection();
			String sql="SELECT no,link FROM food_category ORDER BY no ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				FoodCategoryVO vo=new FoodCategoryVO();
				vo.setNo(rs.getInt(1));
				vo.setLink(rs.getString(2));
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
	
	public FoodCategoryVO foodInfoData(int cno)
	{
		FoodCategoryVO vo=new FoodCategoryVO();
		try
		{
			getConnection();
			String sql="SELECT title,subject FROM food_category "
					+ "WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, cno);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setTitle(rs.getString(1));
			vo.setSubject(rs.getString(2));
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
	
	public List<FoodVO> foodCategoryFoodData(int cno)
	{
		List<FoodVO> list=new ArrayList<FoodVO>();
		try
		{
			getConnection();
			String sql="SELECT no,title,score,address,poster "
					+ "FROM food_house "
					+ "WHERE cno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, cno);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				FoodVO vo=new FoodVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setScore(rs.getDouble(3));
				vo.setAddress(rs.getString(4));
				vo.setPoster(rs.getString(5));
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
	/*
	 * 	private int no,cno,good,soso,bad;
		private String poster,title,address,tel,type,price,parking,time,menu;
		private double score;
	 */
	public FoodVO foodDetailData(int no)
	{
		FoodVO vo=new FoodVO();
		try
		{
			getConnection();
			String sql="SELECT no,poster,title,address,tel,price,parking,time,NVL(menu,'no'),"
					                                            // menu NULL인 곳이 많아서 테이블(메뉴 라벨)이 안나오게 설정
					+ "score,good,soso,bad,type "
					+ "FROM food_house "
					+ "WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			//결과값 받기
			ResultSet rs=ps.executeQuery();   // row단위
			rs.next();
			// 위에 sql 문장에서 갖고온 순서대로 적어야 함
			vo.setNo(rs.getInt(1));
			vo.setPoster(rs.getString(2));
			vo.setTitle(rs.getString(3));
			vo.setAddress(rs.getString(4));
			vo.setTel(rs.getString(5));
			vo.setPrice(rs.getString(6));
			vo.setParking(rs.getString(7));
			vo.setTime(rs.getString(8));
			vo.setMenu(rs.getString(9));
			vo.setScore(rs.getDouble(10));
			vo.setGood(rs.getInt(11));
			vo.setSoso(rs.getInt(12));
			vo.setBad(rs.getInt(13));
			vo.setType(rs.getString(14));
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			disConnection();
		}
		return vo;
	}
	public List<FoodVO> foodLocation(String gu)  // 근처 맛집
	{
		List<FoodVO> list=new ArrayList<FoodVO>();
		try
		{
			getConnection();
			String sql="SELECT no,title,poster,type,address,price,rownum "
					+ "FROM food_house "
					+ "WHERE address LIKE '%'||?||'%' AND rownum<=5";  // LIKE 문장 쓰는법 다름!
			ps=conn.prepareStatement(sql);
			ps.setString(1, gu);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				FoodVO vo=new FoodVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPoster(rs.getString(3));
				vo.setType(rs.getString(4));
				vo.setAddress(rs.getString(5));
				vo.setPrice(rs.getString(6));
				
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
