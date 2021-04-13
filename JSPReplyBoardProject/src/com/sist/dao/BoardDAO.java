package com.sist.dao;
/*
 * 				  요청 내용이 request에 묶임
 * 		클라이언트 ============> 톰캣이 받음 ==========> list.jsp(list_jsp.java)
 *           요청(파일)                         컴파일 => 인터프리터 실행(메모리에 HTML만 저장)
 *   http://서버주소/board/list.jsp                                       ↓
 *          ↑                                                           │ 
 *          └───────────────────────────────────────────────────────────┘    
 *                              HTML을 클라이언트에 전송
 *           
 */
import java.sql.*;
import java.util.*;

public class BoardDAO {
	  private Connection conn;
	  private PreparedStatement ps;
	  private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	  public BoardDAO()
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
	  
	  // 게시판 기능
	  // 목록
	  public List<BoardVO> boardListData(int page)
	  {
		  // => ArrayList VS Vector  =>  기술면접 예상문제(ArrayList 써 봤는지 확인하기 위함)
		  //     비동기화        동기화
		  List<BoardVO> list=new ArrayList<BoardVO>();
		  /*
		   * 		List: 데이터의 중복을 허용. 단, 순서가 있음(index:0~)
		   *          |
		   *       =====================
		   *       ArrayList, Vector, LinkedList
		   *       
		   *       글이 생기는 순으로 게시판no 생성됨 때문에 댓글과 글을 묶을 수 있는 group_id 필요
		   *       1. 글 올리기
		   *       3.  -> 댓글 (group_tab은 1, group_step은 1)
		   *       5.  -> 댓글 (group_tab은 1, group_step은 2)
		   *       2. 새 글
		   *       4.  -> 댓글
		   */
		  try
		  {
			  getConnection();
			  String sql="SELECT no,subject,name,regdate,hit,group_tab,num "
					  								// rownum은 중간을 자를 수 없기 때문에 이렇게 코딩한 것
			  		+ "FROM (SELECT no,subject,name,regdate,hit,group_tab,rownum as num " 
			  		+ "FROM (SELECT no, subject,name,regdate,hit,group_tab "
			  		// 답변별로 모아서 답변 순서대로 출력
			  		+ "FROM jspReplyBoard ORDER BY group_id DESC,group_step ASC)) "
			  		+ "WHERE num BETWEEN ? AND ?";
			        // 페이징 기법으로 무엇을 썼는가? => 인라인뷰(위와같이 코딩하는 방법) 이용함
			  ps=conn.prepareStatement(sql);
			  // ?에 값을 채운다
			  int rowSize=10;  // 게시물 한 페이지의 게시글 갯수
			  int start=(rowSize*page)-(rowSize-1);   // 오라클 시작번호(rownum=1) 때문에 1을 빼줌
			  int end=rowSize*page;
			  /*
			   *    1page  1  ~ 10
			   *    2page  11 ~ 20
			   */
			  ps.setInt(1, start);
			  ps.setInt(2, end);
			  
			  // 실행
			  ResultSet rs=ps.executeQuery();
			  while(rs.next())
			  {   // no,subject,name,regdate,hit,group_tab
				  BoardVO vo=new BoardVO();
				  vo.setNo(rs.getInt(1));
				  vo.setSubject(rs.getString(2));
				  vo.setName(rs.getString(3));
				  vo.setRegdate(rs.getDate(4));
				  vo.setHit(rs.getInt(5));
				  vo.setGroup_tab(rs.getInt(6));
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
	  // 게시물 총 갯수
	  public int boardRowCount()
	  {
		  int count=0;
		  try
		  {
			  getConnection();
			  String sql="SELECT COUNT(*) FROM jspReplyBoard";
			  ps=conn.prepareStatement(sql);
			  ResultSet rs=ps.executeQuery();
			  rs.next();   // 커서 위치
			  count=rs.getInt(1);
			  rs.close();
		  }catch(Exception ex) {
			  ex.printStackTrace();
		  }
		  finally
		  {
			  disConnection();
		  }
		  return count;
	  }
	  
	  // 글쓰기
	  public void boardInsert(BoardVO vo)
	  {
		  try
		  {
			  getConnection();
			  String sql="INSERT INTO jspReplyBoard(no,name,subject,content,pwd,group_id) "
					    +"VALUES(jrb_no_seq.nextval,?,?,?,?,"
					    +"(SELECT NVL(MAX(group_id)+1,1) FROM jspReplyBoard))";
			  ps=conn.prepareStatement(sql);
			  ps.setString(1, vo.getName());
			  ps.setString(2, vo.getSubject());
			  ps.setString(3, vo.getContent());
			  ps.setString(4, vo.getPwd());
			  
			  // 실행 요청. 미리 오류 방지하면서 코딩해야 함. 게시글이 아무 것도 없을 때도 생각해야 함
			  ps.executeUpdate();
		  }catch(Exception ex) {
			  ex.printStackTrace();
		  }
		  finally
		  {
			  disConnection();
		  }
	  }
	  // 내용보기 => SQL문장:2개
	  public BoardVO boardOneRowData(int no,int type)
	  {
		  BoardVO vo=new BoardVO();
		  try
		  {
			  getConnection();
			  String sql="";
			  if(type==1)
			  {
				  sql="UPDATE jspReplyBoard SET "
				  		+ "hit=hit+1 "
				  		+ "WHERE no=?";
				  ps=conn.prepareStatement(sql);
				  ps.setInt(1, no);
				  ps.executeUpdate();
			  }
			  // 상세보기, 수정하기 동일하게 적용
			  sql="SELECT no,name,subject,content,regdate,hit "
			  		+ "FROM jspReplyBoard "
			  		+ "WHERE no=?";
			  ps=conn.prepareStatement(sql);
			  ps.setInt(1, no);
			  ResultSet rs=ps.executeQuery();
			  rs.next();
			  vo.setNo(rs.getInt(1));
			  vo.setName(rs.getString(2));
			  vo.setSubject(rs.getString(3));
			  vo.setContent(rs.getString(4));
			  vo.setRegdate(rs.getDate(5));
			  vo.setHit(rs.getInt(6));
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
	  // 답변 => SQL문장:4개
	  /*
	   * 					  group_id  group_step  group_tab  depth
	   * 	AAAAA                 1         0           0
	   *     => DDDD              1         1           1
	   *     => BBBBBBB           1         2           1
	   *        => CCCCCCCC       1         3           2
	   *    새로운 댓글이 달릴 때 이전 댓글의 group_step을 하나씩 증가시키고, 새로운 댓글을 맨 위로 올리는 형식
	   *    (보통 최신 글이 맨 위로 올라오는것 생각하면 됨!)
	   */
	  // 오라클 단점 => ORDER BY시에 같은 값이면 우선으로 INSERT가 된 데이터를 먼저 출력한다 = 같은 번호라면 문제가 될 수 있음
	  public void boardReplyInsert(int root,BoardVO vo)
	  {
		  try {
			  getConnection();  // 연결
			  // commit을 사용하지 않는다
			  conn.setAutoCommit(false);  // 트랜잭션 프로그램(일괄처리)
			  // 1. root가 가지고 있는 그룹 관련 컬럼값을 읽어온다 => SELECT
			  String sql="SELECT group_id,group_step,group_tab "
			  		+ "FROM jspReplyBoard "
			  		+ "WHERE no=?";
			  ps=conn.prepareStatement(sql);
			  ps.setInt(1, root);
			  ResultSet rs=ps.executeQuery();
			  rs.next();
			  int gi=rs.getInt(1);
			  int gs=rs.getInt(2);
			  int gt=rs.getInt(3);
			  rs.close();
			  // 2. 전체 번호(group_step)를 증가한다 => UPDATE *****
			  sql="UPDATE jspReplyBoard SET "
			  		+ "group_step=group_step+1 "
			  		+ "WHERE group_id=? AND group_step>?";
			  ps=conn.prepareStatement(sql);
			  ps.setInt(1, gi);
			  ps.setInt(2, gs);
			  ps.executeUpdate();			  
			  // 3. INSERT 
			  sql="INSERT INTO jspReplyBoard VALUES("
			  		+ "jrb_no_seq.nextval,?,?,?,?,SYSDATE,0,?,?,?,?,0)";
			  ps=conn.prepareStatement(sql);
			  // ?에 값을 채운다
			  ps.setString(1, vo.getName());
			  ps.setString(2, vo.getSubject());
			  ps.setString(3, vo.getContent());
			  ps.setString(4, vo.getPwd());
			  
			  ps.setInt(5, gi);
			  ps.setInt(6, gs+1);
			  ps.setInt(7, gt+1);
			  ps.setInt(8, root);
			  
			  ps.executeUpdate();
			  // 4. root의 depth를 증가 => UPDATE
			  
			  sql="UPDATE jspReplyBoard SET "
			  		+ "depth=depth+1 "
			  		+ "WHERE no=?";
			  ps=conn.prepareStatement(sql);
			  // ?에 값을 채운다
			  ps.setInt(1, root);
			  // 실행
			  ps.executeUpdate();
			  conn.commit();
		  }catch(Exception ex) {
			  try
			  {
				  conn.rollback();
			  }catch(Exception e) {
				  ex.printStackTrace();
			  }
			  ex.printStackTrace();
		  }
		  finally
		  {
			  try {
				  conn.setAutoCommit(true);
			  }catch(Exception ex) {
				  ex.printStackTrace();
			  }
			  disConnection();
		  }
	  }
	  // 수정(비밀번호 확인 필요 = boolean)
	  /*
	   *    라이브러리 메소드: Callback이 있는 경우도 있다
	   *    Callback메소드 => 시스템에 의해서 자동으로 호출되는 메소드
	   *       main(), doGet(), doPost()
	   *    사용자정의 메소드: Callback이 없다 => 반드시 호출 후에 사용
	   */
	  public boolean boardUpdate(BoardVO vo)
	  {
		  boolean bCheck=false;
		  try
		  {
			  // 1. 연결
			  getConnection();
			  // 2. sql 문장
			  // 2-1. 비밀번호 검색
			  String sql="SELECT pwd FROM jspReplyBoard "
			  		+ "WHERE no=?";
			  ps=conn.prepareStatement(sql);
			  //?에 값 채운다
			  ps.setInt(1, vo.getNo());
			  // 결과값을 갖고온다
			  ResultSet rs=ps.executeQuery();
			  rs.next();
			  String db_pwd=rs.getString(1);
			  rs.close();
			  // 본인 여부 확인
			  if(db_pwd.equals(vo.getPwd()))
			  {
				  bCheck=true;
				  // 수정하기
				  sql="UPDATE jspReplyBoard SET "
				  	+ "name=?,subject=?,content=? "
				  	+ "WHERE no=?";
				  ps=conn.prepareStatement(sql);
				  // ?에 값 채운다
				  ps.setString(1, vo.getName());
				  ps.setString(2, vo.getSubject());
				  ps.setString(3, vo.getContent());
				  ps.setInt(4, vo.getNo());
				  // 실행요청
				  ps.executeUpdate();
			  }
			  else
			  {
				  bCheck=false;
			  }
			  // 2-2. 실제 수정
			  
		  }catch(Exception ex) {
			  // 오류 체크
			  ex.printStackTrace();
		  }
		  finally
		  {
			  // 오라클 종료: 오류가 있던, 없던 무조건! 종료해야 함
			  disConnection();
		  }
		  return bCheck;
	  }
	  // 삭제 => SQL문장:4개
	  /*
	   *   1. 비밀번호 체크
	   *   2. 비밀번호가 맞는 경우: true
	   *      = depth: 0 => DELETE
	   *      = depth> 0 => UPDATE
	   *      = depth 1개 감소
	   *      틀린 경우: back
	   */
	  public boolean boardDelete(int no,String pwd)
	  {
		  boolean bCheck=false;
		  try
		  {
			  getConnection();
			  conn.setAutoCommit(false);
			  // 처리
			  // 1. 비밀번호
			  String sql="SELECT pwd FROM jspReplyBoard "
			  		+ "WHERE no=?";
			  ps=conn.prepareStatement(sql);
			  ps.setInt(1, no);
			  ResultSet rs=ps.executeQuery();
			  rs.next();
			  String db_pwd=rs.getString(1);
			  rs.close();
			  
			  if(db_pwd.equals(pwd)) {
				  bCheck=true;
				  sql="SELECT root,depth FROM jspReplyBoard "
				  		+ "WHERE no=?";
				  ps=conn.prepareStatement(sql);
				  ps.setInt(1, no);
				  rs=ps.executeQuery();
				  rs.next();
				  int root=rs.getInt(1);
				  int depth=rs.getInt(2);
				  rs.close();
				  
				  if(depth==0)   // 댓글이 없는 상태
				  {
					  sql="DELETE FROM jspReplyBoard "
					  		+ "WHERE no=?";
					  ps=conn.prepareStatement(sql);
					  ps.setInt(1, no);
					  ps.executeUpdate();
				  }
				  else   // 댓글이 있는 상태
				  {
					  String msg="관리자가 삭제한 게시물입니다";
					  sql="UPDATE jspReplyBoard Set "
					  		+ "subject=?,content=? "
					  		+ "WHERE no=?";
					  ps=conn.prepareStatement(sql);
					  ps.setString(1, msg);
					  ps.setString(2, msg);
					  ps.setInt(3, no);
					  
					  ps.executeUpdate();
				  }
				  sql="UPDATE jspReplyBoard SET "
				  		+ "depth=depth-1 "
				  		+ "WHERE no=?";
				  ps=conn.prepareStatement(sql);
				  ps.setInt(1, root);
				  ps.executeUpdate();
			  }
			  else {
				  bCheck=false;
			  }
			  conn.commit();
		  }catch(Exception ex) {
			  try {
				  conn.rollback();
			  }catch(Exception e) {}
			  ex.printStackTrace();
		  }
		  finally
		  {
			  try
			  {
				  conn.setAutoCommit(true);
			  }catch(Exception ex) {}
			  // 종료
			  disConnection();
		  }
		  return bCheck;
	  }
	  // 찾기
	  
}