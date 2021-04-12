package com.sist.main;
// page 375
/*
 *    추상 클래스
 *    1. 형식
 *       접근지정어 타입 class className{}
 *       ======  ==(final|abstract)
 *    public|default
 *    
 *       public abstract class className
 *       {
 *          ================
 *            변수
 *             = 멤버변수(instance)
 *             = 공통변수(static)
 *          ================
 *            메소드
 *             ============= 먹는다 (개, 소, 돼지, 사람...)
 *             = 구현된 메소드
 *                컴퓨터 / 노트북 / 핸드폰 ==> 파워기 클릭(필요하면 오버라이딩)
 *                public 리턴형 메소드(매개변수..) => 선언부
 *                {
 *                   구현부
 *                }
 *             = 선언된 메소드 ==> 구현이 안 된 나용
 *               기능은 동일 => 구현이 다르다
 *               public (abstract) 리턴형 메소드(매개변수);   // 선언완료. 갖다쓸 수 없음 = 미완성
 *                                                         => 상속을 받아서 완성
 *          ================
 *          ================
 *       }
 *       특징
 *       ===
 *       1) 자신이 메모리 할당을 할 수 없다(미완성된 클래스) => new를 사용할 수 없다
 *          abstract class A
 *          A a=new A();   // 완성이 안된 작품이기 때문에 사용불가
 *       2) 상속을 받은 클래스에서 미완성된 메소드를 구현해서 사용
 *       3) 추상 클래스는 설계
 *          ======== 문제, 숙제, 아이템
 *       4) 공통적으로 적용이 되는 기능만 설정
 *          게시판(글쓰기, 수정, 삭제, 내용보기, 찾기)
 *            = 일반게시판
 *            = 댓글형 게시판
 *            = 갤러리 게시판
 *            = 묻고 답하기
 *            = 자료실
 *    2. 사용처
 *       = 요구사항 분석(마킹) => 위에서 지시
 *         의뢰 => 요구사항 분석 => 필요한 데이터 수집 => UI => 구현 => 테스팅
 *               ==========    =============   ===   ===    ====
 *                  아키텍쳐           DBA      퍼블리셔 웹프로그래머 테스터
 *       = 기능은 동일 => 구현형태가 여러가지
 *         ======== 프로그램에 맞게 구현해서 사용
 *         ======== 여러개의 관련 클래스를 모아서 처리(클래스를 모아서 한개의 이름으로 제어)
 *         ======== 표준화가 된다(라이브러리)
 */
// 추상클래스의 상속 => 단일 상속만 가능
abstract class Print{
	public abstract void list();
	public abstract void detail();
	// =========================== 위 두개의 public은 무조건 구현해서 사용한다
	public void reserve() {
		System.out.println("예약이 가능합니다");   // 필요한 클래스에서만 변경해서 사용 가능
	}
	public void end()
	{
		System.out.println("사이트 이동");
	}
}
class 영화 extends Print{
	
	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("영화 포스터 출력");
	}
	
	@Override
	public void detail() {
		// TODO Auto-generated method stub
		System.out.println("영화 관련 데이터 출력");
	}
	/* public void reserve() {
		System.out.println("예약이 가능합니다");   // 필요한 클래스에서만 변경해서 사용 가능
	} */
}

class 맛집 extends Print{
	
	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("맛집을 테이블 형태로 출력");
	}
	
	@Override
	public void detail() {
		// TODO Auto-generated method stub
		System.out.println("맛집 지도와 메뉴를 출력");
	}
	/* public void reserve() {
		System.out.println("예약이 가능합니다");   // 필요한 클래스에서만 변경해서 사용 가능
	} */
}
class 항공사 extends Print{
	
	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("포스터 없이 테이블 형태로 출력");
	}
	
	@Override
	public void detail() {
		// TODO Auto-generated method stub
		System.out.println("시간을 출력한다");
		/*
		 *    class final System
		 *    {
		 *        static O
		 *        static 
		 *    }
		 */
	}
	
	public void reserve() {
		// TODO Auto-generated method stub
		System.out.println("항공 시간 예약을 합니다");  // 필요한 클래스에서만 변경해서 사용이 가능
	}
	/*
	 *     메소드는 {} => 구현
	 */
}
public class 추상클래스 {
	/*
	 *    프로그램 => 모아서 한 개로 제어
	 *    데이터가 여러개 => 배열
	 *    클래스가 여러개 => 추상클래스 or 인터페이스
	 *    
	 *    영화 int
	 *    맛집 double
	 *    항공사 String   // 클래스 이름이 다르면 배열도 다름!을 기억
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 서로 다른 클래스를 연결해서 사용이 가능
		Print p=new 영화();
		p.list();
		p.detail();
		p.reserve();
		
		p=new 맛집();
		p.list();
		p.detail();
		p.reserve();
		
		p=new 항공사();
		p.list();
		p.detail();
		p.reserve();
	}

}
