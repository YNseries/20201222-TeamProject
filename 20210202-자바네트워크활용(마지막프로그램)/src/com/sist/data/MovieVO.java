package com.sist.data;

import java.io.Serializable;

/*
 * 1|1|�ҿ�(2020)|
 * 8.6|�ִϸ��̼�/��Ÿ��|2021.01.20 |
 * 107��|��ü������|��Ʈ ����|���� �Ŀ���|
 * //img1.daumcdn.net/thumb/C155x225/?fname=https%3A%2F%2Ft1.daumcdn.net%2Fmovie%2F71454256ae63506a7fee5e03cf929b9b65a4f433|1|���� ��� �������� �¾�� �Ǿ�����? ������ ���� �� ��ȥ���� �ӹ��� ���¾�� �� ������ �ִٸ�? ���忡�� ���� ���������� ���ϴ� �������� �޿� �׸��� �ְ��� ���� ���� Ŭ������ �����ϰ� �� �� ��, ����ġ ���� ���� ��ȥ�� �Ǿ� ���¾�� �� ���󡯿� ��������. ź�� �� ��ȥ���� ����� �Բ� �ڽ��� ���ɻ縦 �߰��ϸ� ���� �������� �߱��ϴ� ���¾�� �� ���� �������� �� ������ �����ϰ� ������ ���� �;����� �ʴ� �ô����� ��ȥ ��22���� ���䰡 �ȴ�. ����, ����, �׷��� ���൵ ����Ǳ� ������ ��ȥ ��22�� ���� ���뿡 ������ ��22���� ���� �������� �ʿ��� ������ �״� �ٽ� ������ ���ư� ���� ���뿡 �� �� ������?
 */
public class MovieVO implements Serializable{
	private int mno,cno;
	private String title;
	private String score;
	private String genre;
	private String regdate;
	private String time;
	private String grade;
	private String director;
	private String actor;
	private String poster;
	private String shoUser;
	private String story;
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
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
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getShoUser() {
		return shoUser;
	}
	public void setShoUser(String shoUser) {
		this.shoUser = shoUser;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	
	
}
