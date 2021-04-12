/*
 * 	  쉐프: 요리조이
 *    팽이버섯 계란말이 # 치즈
 *    view 77
	  야채를 품은 계란말이~! 보기도 이쁘고 맛도 좋아요 ~!
	  인분:2인분 
	  조리시간: 5분 이내 
	  난이도: 초급
  	  주재료  달걀 4개, 팽이버섯 1 덩어리, 풋고추 1개, 모짜렐라 치즈 적당량
	  양념 및 소스재료: 소금 네꼬집
	  조리순서Steps
	  1. 팽이버섯 밑둥을 자르고 (1덩어리 사용했어요)
	  2. 잘게 썰고 풋고추도 잘게 썰어서 (2/3개 넣었어요) 계란물에 넣어 주세요
	  3. 계란은 4개를 준비합니다 먼저 2개를 곱게 푼 다음 소금 두꼬집 뿌려주세요
	  4. 웍에 식용유를 두르고 예열한 후 뒤집개로 기름 코팅을 한 다음 달걀물을 모두 넣어 주었어요
	  불은 중불로 조절한 다음 가장자리가 익기 시작하면 바로 접어 주세요
	  5. 나머지 달걀 2개를 소금 두꼬집 넣고 바로 풀어서 접어준 달걀에 붙도록 부어줍니다
	  6. 연결해서 한번 접으면서 웍을 기울여서 달걀물을 바깥쪽으로 넓게 펴줍니다
	  7. 바로 접어서 마무리 해주셔도 되고 저는 모짜렐라 치즈를 적당량 뿌려서 접어주었어요 납작 치즈를 넣으셔도 좋구요
	  8. 웍의 코팅이 안좋아서 식용유를 넉넉히 두르고 코팅시켰는데 깔끔하게 만들어 졌네요
	  9. 겉이 달걀로 싸여서 야채에 대한 거부감 없이 먹게 된답니다 도톰하게 썰어서 포만감도 있고 느끼하지 않아요 풋고추가 맵지 않아서 아이들도 잘먹을수 있어요
	  등록일 : 2021-01-11
 */

public class Egg {
	String chef;
	String name;
	int view;
	String content;
	int servings;
	int time;
	String grade;
	String main;
	String sub;
	String[] step;   // 현재 null값이기 때문에 크기설정 필요.
	String date;

	static String title="10000개의 레시피";
	// poster
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Egg r=new Egg();   // static을 제외한 나머지 변수가 food에 저장됨
		// food 공간에 들어가 있는 변수들의 초기화: 쓰기
		r.chef="요리조이";
		r.name="팽이버섯 계란말이 # 치즈";
		r.view=77;
		r.content="야채를 품은 계란말이~! 보기도 이쁘고 맛도 좋아요 ~!";
		r.servings=2;
		r.time=5;
		r.grade="초급";
		r.main="달걀 4개, 팽이버섯 1 덩어리, 풋고추 1개, 모짜렐라 치즈 적당량";
		r.sub="소금 네꼬집";
		r.step=new String[9];       // 배열이 있는 경우 반드시 크기 설정해 줘야함.
		r.step[0]="1. 팽이버섯 밑둥을 자르고 (1덩어리 사용했어요)";
		r.step[1]="2. 잘게 썰고 풋고추도 잘게 썰어서 (2/3개 넣었어요) 계란물에 넣어 주세요";
		r.step[2]="3. 계란은 4개를 준비합니다 먼저 2개를 곱게 푼 다음 소금 두꼬집 뿌려주세요";
		r.step[3]="4. 웍에 식용유를 두르고 예열한 후 뒤집개로 기름 코팅을 한 다음 달걀물을 모두 넣어 주었어요. 불은 중불로 조절한 다음 가장자리가 익기 시작하면 바로 접어 주세요";
		r.step[4]="5. 나머지 달걀 2개를 소금 두꼬집 넣고 바로 풀어서 접어준 달걀에 붙도록 부어줍니다";
		r.step[5]="6. 연결해서 한번 접으면서 웍을 기울여서 달걀물을 바깥쪽으로 넓게 펴줍니다";
		r.step[6]="7. 바로 접어서 마무리 해주셔도 되고 저는 모짜렐라 치즈를 적당량 뿌려서 접어주었어요 납작 치즈를 넣으셔도 좋구요";
		r.step[7]="8. 웍의 코팅이 안좋아서 식용유를 넉넉히 두르고 코팅시켰는데 깔끔하게 만들어 졌네요";
		r.step[8]="9. 겉이 달걀로 싸여서 야채에 대한 거부감 없이 먹게 된답니다 도톰하게 썰어서 포만감도 있고 느끼하지 않아요 풋고추가 맵지 않아서 아이들도 잘먹을수 있어요";
		r.date="2021-01-11";
		// 변수는 데이터를 메모리에 저장 => 저장된 데이터를 읽기/변경
		System.out.println("================= 상세보기 =================");
		System.out.print(r.chef+"  ");
		System.out.print(r.view);
		System.out.println("\n"+r.name);
		System.out.println(r.content);
		System.out.print(r.servings+"인분|");
		System.out.print(r.time+"분 이내|");
		System.out.print(r.grade);
		System.out.println("\n[주재료]"+r.main);
		System.out.println("[양념 및 소스재료]:"+r.sub);
		System.out.println("조리순서");
		for(String re:r.step)
		{
			System.out.println(re);
		}
		System.out.println("등록일:"+r.date);
		System.out.println("\n데이터참조 업체:"+r.title);
	}

}
