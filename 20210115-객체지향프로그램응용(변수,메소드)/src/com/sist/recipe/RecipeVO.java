package com.sist.recipe;
// 사용자정의 데이터형 => ~VO, ~DTO
// 기능 수행 => ~DAO(오라클 연결/데이터베이스 연결), 
// 			 ~Manager(외부에서 긁어오거나, 파일입출력), ~Service
/*
 *    댓글형 게시판
 *    =========
 *    게시판 / 댓글
 *    게시판DAO + 댓글DAO => 게시판Service
 */
public class RecipeVO {
	private int no;
	private String title;
	private String chef;
	private String hit;
	private String link;  // 변수 => 읽기 / 쓰기
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getChef() {
		return chef;
	}
	public void setChef(String chef) {
		this.chef = chef;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	

}
