package com.sist.main;
import java.util.*;
class SawonVO
{
	private int sabun;
	private String name;
	private String dept; // 부서
	private String job;  // 직위
	private int pay;
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	// 생성자 생성: Source -> Constructor using field
	public SawonVO(int sabun, String name, String dept, String job, int pay) {
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
		this.job = job;
		this.pay = pay;
	}
	
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList sawonList=new ArrayList();
		sawonList.add(new SawonVO(1,"홍길동","개발부","대리",3600));  // 생성자 만들어두면, 이렇게 한 번에 쓸 수 있음
		sawonList.add(new SawonVO(2,"심청이","총무부","과장",4000));  // 데이터 추가 add()
		sawonList.add(new SawonVO(3,"김두한","영업부","실장",3600));
		sawonList.add(new SawonVO(4,"이순신","기획부","사원",3000));
		sawonList.add(new SawonVO(5,"강감찬","자재부","이사",7000));
		
		System.out.println("총 인원:"+sawonList.size());  // 저장된 갯수 size()
		System.out.println("============ 사원 관리 =============");
		/*
		 *    Object obj=new String()
		 *    ======
		 */
		for(int i=0;i<sawonList.size();i++)  // Object로 하면 get set 사용할 수 없음
		{
			SawonVO vo=(SawonVO)sawonList.get(i);  // 상위가 하위를 받을 수 없기 때문에 SawonVO로 형변환 해야함
			                                       // 저장된 데이터 읽기 get()
			System.out.println("사번:"+vo.getSabun());
			System.out.println("이름:"+vo.getName());
			System.out.println("부서:"+vo.getDept());
			System.out.println("직위:"+vo.getJob());
			System.out.println("연봉:"+vo.getPay());
			System.out.println("=====================================");
		}
		
		System.out.println("================ 수정 ================");
		SawonVO vo1=new SawonVO(6, "강감찬", "개발부", "사원", 3000);
		sawonList.set(3, vo1);  // 저장된 데이터 수정 set()
		
		for(int i=0;i<sawonList.size();i++)
		{
			SawonVO vo=(SawonVO)sawonList.get(i);
			System.out.println("사번:"+vo.getSabun());
			System.out.println("이름:"+vo.getName());
			System.out.println("부서:"+vo.getDept());
			System.out.println("직위:"+vo.getJob());
			System.out.println("연봉:"+vo.getPay());
			System.out.println("=====================================");
		}
		
		System.out.println("================ 삭제 ================");
		sawonList.remove(2);  // 저장된 데이터 삭제 remove()
		
		for(int i=0;i<sawonList.size();i++)
		{
			SawonVO vo=(SawonVO)sawonList.get(i);
			System.out.println("사번:"+vo.getSabun());
			System.out.println("이름:"+vo.getName());
			System.out.println("부서:"+vo.getDept());
			System.out.println("직위:"+vo.getJob());
			System.out.println("연봉:"+vo.getPay());
			System.out.println("=====================================");
		}
		
		System.out.println("============= 전체 삭제 =============");
		sawonList.clear();  // 전체 제거 clear()
		
		System.out.println("인원:"+sawonList.size());
		
		ArrayList a1=new ArrayList();
		//a1.add()
		ArrayList<String> a2=new ArrayList<String>();
		//a2.add()
		ArrayList<Integer> a3=new ArrayList<Integer>();
		//a3.add()
		ArrayList<SawonVO> a4=new ArrayList<SawonVO>();
		//a4.add()
	}

}
