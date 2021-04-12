package com.sist.munje;
/*
 *    자바 클래스를 작성하는 연습을 해보자. 다음 main() 메소드를 실행하였을 때 예시와 같이 출력되도록 TV 클래스를 작성하라.
Class TV{
    private String pro;
    private int year;
    private int inch;
    public TV(String pro, int year, int inch)
    {
        this.pro=pro;
        this.year=year;
        this.inch=inch;
    }
    public void show()
    {
        System.out.println(pro+"에서 만든 "+year+"년형"+inch+"인치 TV");
    }
}
	public static void main(String[] args) {
	TV myTV = new TV("LG", 2017, 32); //LG에서 만든 2017년 32인치
	myTV.show();
	}
	
	출력 내용
	LG에서 만든 2017년형 32인치 TV
 */
// 생성자: 여러개(오버로딩이 가능), 생성자에서 사용하는 매개변수는 지역변수
class TV{
    private String pro;
    private int year;
    private int inch;
    // 생성자를 통한 초기화 작업
    public TV(String pro, int year, int inch)  // 생성자를 이용해서 변수 초기화
    {
        this.pro=pro;
        this.year=year;
        this.inch=inch;
    }
    public void show()
    {
        System.out.println(pro+"에서 만든 "+year+"년형 "+inch+"인치 TV");
    }
}

public class 문제3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV myTV = new TV("LG", 2017, 32); //LG에서 만든 2017년 32인치
		myTV.show();

	}

}
