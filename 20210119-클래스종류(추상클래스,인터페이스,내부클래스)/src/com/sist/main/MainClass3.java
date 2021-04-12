package com.sist.main;
/*
 *    추상 클래스 ===> Board
 *      = 구현이 가능한 메소드
 *      = 선언만 하는 메소드
 */
abstract class Board{
	protected abstract update() {}
	
	public void delete() {}
	public void find() {}
}
class 게시판 extends Board
{
	public abstract void write() {}  // 글쓰기
	public void list() {}   // 목록
	public void detail() {}  // 상세보기
	public void update() {} // 수정
	public void delete() {}
	public void find() {}
}
class 자료실 extends Board
{
	public void write() {}  // 글쓰기, 파일 올리기
	public void list() {}   // 목록
	public void detail() {}  // 상세보기, 파일 다운로드
	public void update() {}  // 수정
	public void delete() {}  // 삭제
	public void find() {}
	public void upload() {}
	public void download() {}
}
class 답변게시판 extends Board
{
	public void write() {}  // 글쓰기
	public void list() {}   // 목록, 답변을 출력
	public void detail() {} // 상세
	public void update() {} // 수정
	public void delete() {} // 삭제
	public void find() {}
	public void replyWrite() {}
	public void replyDelete() {}
	public void replyUpdate() {}
}
class 댓글게시판
{
	public void write() {}  // 글쓰기
	public void list() {}   // 목록
	public void detail() {}
	public void update() {}
	public void delete() {}
	public void find() {}
	public void replyWrite() {}
	public void replyDelete() {}
	public void replyUpdate() {}
}
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
