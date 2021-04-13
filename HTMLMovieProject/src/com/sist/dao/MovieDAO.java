package com.sist.dao;
import java.util.*;  // (영화)목록 출력 => ArrayList => 브라우저에 전송
import java.sql.*;  // 오라클 연동
public class MovieDAO {
	// 1. 오라클 연결 객체
	private Connection conn;
	// 2. SQL문장 전송 => 결과값 받아오는 객체
	private PreparedStatement ps;
	// 3. 오라클 주소(URL)
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	//                          원격으로 진행 할 땐 =========== IP
	// 1-1. 드라이버 등록 => sqldeveloper 열기 => 생성자는 한 번만 사용이 가능
	/*
	 *    new MovieDAO()
	 *    new MovieDAO()    => 창 두개 열게 되는 것
	 *    ====> 패턴 (싱글턴,팩토리...)
	 */
	public MovieDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	// 1-2. 오라클 연결  conn hr/happy
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	// 1-3. 오라클 닫기  exit
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	// 2-1. 기능 설정
	//   1) 로그인 => 경우의 수(2개: boolean, 2개 이상: String,int)
	//              (ID가 틀린 경우, 비밀번호가 틀린 경우, 로그인)
	public String isLogin(String id,String pwd)
	{
		String result="";
		try
		{
			// 1. 연결 
			getConnection();
			// 2. SQL문장 => ID가 존재하는지 여부 
			String sql="SELECT COUNT(*) FROM webMember "
					+"WHERE id=?";
			ps=conn.prepareStatement(sql);
			// ?에 값을 채운다 
			ps.setString(1, id);
			// 실행후에 결과값을 받는다 
			ResultSet rs=ps.executeQuery();
			rs.next();
			int count=rs.getInt(1);
			rs.close();
			  
			if(count==0) //ID가 존재하지 않는 경우
			{
				result="NOID"; // alert()
			}
			else // ID가 존재하는 경우 
			{
				// 비밀번호 검색 
			    sql="SELECT pwd,name FROM webMember "
			    	+"WHERE id=?";
				ps=conn.prepareStatement(sql);
				// ?에 값을 채운다
				ps.setString(1, id);
				// 실행 결과값가 가지고 온다
				rs=ps.executeQuery();
				rs.next();
				String db_pwd=rs.getString(1);
				String name=rs.getString(2);
				rs.close();
				 
				// 비밀번호가 있냐?
				if(db_pwd.equals(pwd)) // 비밀번호가 맞는 상태 => 로그인 
				{
					// 영화목록으로 이동 
					result=name; // id,name=> session => 댓글사용이 안된다 
				}
				else // 비밀번호가 틀린 상태 
				{
					result="NOPWD";
				}
			}
			   
		}catch(Exception ex)
		{
			// 오류 확인 
			System.out.println(ex.getMessage());
		}
		finally
		{
			// 닫기
			disConnection();
		}
		return result;
	}
	//   2) 영화 목록 출력
	public ArrayList<MovieVO> movieListData(int page)
	{
		ArrayList<MovieVO> list=new ArrayList<MovieVO>();
		try
		{
		    // 1. 연결
			getConnection();
			// 2. SQL문장 
			String sql="SELECT mno,title,poster,num "
				     +"FROM (SELECT mno,title,poster,rownum as num "
				     +"FROM (SELECT mno,title,poster "
				     +"FROM movie ORDER BY 1)) "
				     +"WHERE num BETWEEN ? AND ?";
			int rowSize=20;  // 20개씩 출력
			int start=(rowSize*page)-(rowSize-1);
			int end =rowSize*page;
			   
			ps=conn.prepareStatement(sql);
			   
			// ?에 값을 채운다
			ps.setInt(1, start);
			ps.setInt(2, end);
			   
			// 실행요청 => 결과값을 받는다 
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				MovieVO vo=new MovieVO();
				vo.setMno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setPoster(rs.getString(3));
				list.add(vo);
			}
			rs.close();
			   
		}catch(Exception ex)
		{
		    System.out.println(ex.getMessage());
		}
		finally
		{
			disConnection();
		}
		return list;
	}
	//   2-1) 총 페이지(이건 항상 갖고와야함. 클릭해서 넘어가게)
	public int movieTotalPage()
	{
	    int total=0;
	    try
	    {
		    // 1. 연결
		    getConnection();
		    // 2. SQL문장 
		    String sql="SELECT CEIL(COUNT(*)/20.0) FROM movie";
		    ps=conn.prepareStatement(sql);
		    ResultSet rs=ps.executeQuery();
		    rs.next();
		    total=rs.getInt(1);
		    rs.close();
	    }catch(Exception ex)
	    {
		    System.out.println(ex.getMessage());
	    }
	    finally
	    {
		    disConnection();
	    }
 	    return total;
	}
	//   3) 영화 상세보기(mno => 사용자가 포스터를 클릭할 때 넘겨준 번호) => 해당하는 영화 1개의 정보
	/*
	 *  MNO      NOT NULL NUMBER(4)     
		TITLE             VARCHAR2(100) 
		GENRE             VARCHAR2(100) 
		POSTER            VARCHAR2(200) 
		ACTOR             VARCHAR2(300) 
		REGDATE           VARCHAR2(100) 
		GRADE             VARCHAR2(50)  
		DIRECTOR          VARCHAR2(100)
	 */
	public MovieVO movieDetailData(int mno)
	{
		MovieVO vo=new MovieVO();
		try
		{
			getConnection();
			String sql="SELECT mno,title,poster,actor,genre,actor,"
					+ "regdate,grade,director "
					+ "FROM movie "
					+ "WHERE mno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, mno);
			// 결과값 받기
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setMno(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			vo.setPoster(rs.getString(3));
			vo.setGenre(rs.getString(4));
			vo.setActor(rs.getString(5));
			vo.setRegdate(rs.getString(6));
			vo.setGrade(rs.getString(7));
			vo.setDirector(rs.getString(8));
			rs.close();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally
		{
			disConnection();
		}
		return vo;   // vo에 값을 채워서 넘겨준다
	}
	//   3-1) 댓글이 많은 영화
	public ArrayList<MovieVO> replyTop10()
	{
		ArrayList<MovieVO> list=new ArrayList<MovieVO>();
		try
		{
			getConnection();
			// SQL문장 => 공지사항, 이벤트, 인기순위 ... 몇 개씩 잘라올 때: rownum
			String sql="SELECT title,poster,hit,rownum "
					+ "FROM (SELECT title,poster,hit "
					+ "FROM movie ORDER BY hit DESC) "
					+ "WHERE rownum<=10";
			ps=conn.prepareStatement(sql);
			// ? 없으니까 바로 실행 요청
			ResultSet rs=ps.executeQuery();
			rs.next();
			while(rs.next())
			{
				MovieVO vo=new MovieVO();
				vo.setTitle(rs.getString(1));
				vo.setPoster(rs.getString(2));
				vo.setHit(rs.getInt(3));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		finally
		{
			disConnection();
		}
		return list;
	}
	//   4) 댓글 쓰기
	public void replyInsert(ReplyVO vo)
	{
		try
		{
			// 1. 연결
			getConnection();
			// 2. sql문장(댓글에 따른 조회수 증가)
			String sql="UPDATE movie SET "
					+ "hit=hit+1 "   // 댓글 insert 될 때마다 hit 하나씩 증가
					+ "WHERE mno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, vo.getMno());
			ps.executeUpdate();
			
			sql="INSERT INTO webReply VALUES("
					+ "wr_no_seq.nextval,?,?,?,?,SYSDATE)";
			ps=conn.prepareStatement(sql);
			// 2-1. ?에 값채우기
			ps.setInt(1, vo.getMno());
			ps.setString(2, vo.getId());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getMsg());
			// 3. 실행요청
			ps.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
	//   5) 댓글 삭제
	//   6) 댓글 수정
	//   7) 댓글 읽기
	public ArrayList<ReplyVO> replyListData(int mno)
	{
		ArrayList<ReplyVO> list=new ArrayList<ReplyVO>();
		try
		{
			getConnection();
			String sql="SELECT no,id,name,msg,TO_CHAR(regdate,''YYYY-MM-DD HH24:MI:SS') "
					+ "FROM webReply "
					+ "WHERE mno=? "
					+ "ORDER BY no DESC";   // 최신 댓글 순으로 나오게
			ps=conn.prepareStatement(sql);
			ps.setInt(1, mno);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ReplyVO vo=new ReplyVO();
				vo.setNo(rs.getInt(1));
				vo.setId(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setMsg(rs.getString(4));
				vo.setDbday(rs.getString(5));   // 날짜 값 갖고올 때 오라클에서 갖고와야 함
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
	//   8) 댓글 몇 개인지 확인... 은 안해도 될듯

}
