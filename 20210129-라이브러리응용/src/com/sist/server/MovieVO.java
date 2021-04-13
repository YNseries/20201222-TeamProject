package com.sist.server;
/*
 *  �ҿ�(2020)
	08 . 6
	�ִϸ��̼�/��Ÿ��
	2021.01.20 ����
	107��, ��ü������
	���� ��Ʈ ����, ���� �Ŀ��� �ֿ� ���̹� ����, Ƽ�� ����
	598,051
	���� ��� �������� �¾�� �Ǿ�����? 
	������ ���� �� ��ȥ���� �ӹ��� ���¾�� �� ������ �ִٸ�?  
	
	Ŭ����
	 = �����͸� ��Ƽ� ������ ���� => ~VO(Value Object), ~DTO(Data Transfor Object)
	   => �������� Ŭ����
	 = ������ Ȱ�� => �޼ҵ�  ==> ~Manager(���� File, �޸� ����/����), ~DAO(�����ͺ��̽� ����)
	                         ~Service ... 
	   => �׼� Ŭ����(��ûó���� �� ��)
	 ��������
	   �⺻��(�ڹٿ��� ����): �޸𸮿� ���� ���� ����(�޸� ������ 1���� ����ϱ� ����)
	   ������(���α׷��Ӱ� �������� ����): �޸𸮿� �ּҸ� ���� => ���� �����ʹ� �ٸ� �޸𸮿� ���� => �ּҸ� ���� ������ �б�
	   ======================== �迭, Ŭ����, �������̽� => .
	   
	 ��ü���� ���α׷�
	 1. ��� => Actor
	    ����Ʈ
	    = �����(user): ȭ�� UI *****
	    = ������(admin): ���
	 2. ������� �κ�
	 3. ����
 */
public class MovieVO {
	// ã�� => (�ߺ��� �ȵǴ�)��ȣ �ο�
	private int no;   // ��ȭ�� ���� ��ȣ
	private int cno;  // ��ȭ ī�װ�(��, ��������, �ְ�, ����, ����)
	private String title;
	private String score;   // ������ �ʿ��ϸ� ����ȯ �ϸ� �� => Double.parseDouble(score)
	private String genre;
	private String regdate;
	private String time;
	private String grade;
	private String director;
	private String actor;
	private String showUser;  // Integer.parseInt(showUser) => replace(",",")
	private String story;
	private String poster;  // ��ȭ ������
	private String key;  // ������
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getShowUser() {
		return showUser;
	}
	public void setShowUser(String showUser) {
		this.showUser = showUser;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
}
