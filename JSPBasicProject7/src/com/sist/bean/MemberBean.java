package com.sist.bean;
/*
 *   네트워크 통신
 *   브라우저(클라이언트) <==========> 톰캣(서버)   : C/S(client server 과정)
 *      결과값 (서버에서 보내줌) => 데이터가 많은 경우에 클래스로 묶어서 한 번에 전송(회사마다 명칭 다름/데이터를 모을 목적)
 *      JSP: Bean
 *        = 변수(private), 읽기/쓰기 => getter/setter
 *      MyBatis: DTO(Data Transfer Object: 데이터 모아서 전송할 목적)
 *      Spring: VO(Value Object: 값만 가지고 있다)
 *      ============ 캡슐화 코딩(데이터 보호를 위함: [시큐어 코딩] 안하면 사이트 벌금내야 함(3천만원))
 *                   실무 하면 이미 설정이 다 되어있(다는 전제하에)기 때문에, 보안상의 이유로
 *                   Server.xml / web.xml 볼 수 없을 것임(들어가면 해킹인것) => xml 쓰는 이유: 태그 구분이 되어있어서
 */
public class MemberBean {
	private String id;
	private String name;
	private String addr;
	private String tel;
	private String sex;
	private boolean admin;
	
	
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
