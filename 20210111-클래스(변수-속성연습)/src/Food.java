/*
 *    1) ��Ÿ��
 *    2) �ּ�  ����Ư���� ������ �ø��ȷ�60�� 5 �ѽ����� 1F
 *    3) ���� ����� ������ ������ 111-55 �ѽ����� 1F
 *    4) ��ȭ��ȣ	02-474-3520
	  5) ���� ����	�±� ����
	  6) ���ݴ�	����-2����
  	  7) ����	������������
	  8) �����ð�	11:30 - 21:30
	  9) ���½ð�	14:30 - 17:00
 	 10) �޴�	  ��Ÿ��          10,000��
			  ������Ŀ�� (2����) 18,000��
			  �c���          12,000��
			  �ٿ��̶��   	 	9,000��
	 11) ���� 4.3
	 12) description 84751��
	 13) ���ִ� 58
	 14) ������ 10
	 15) ���� 9
	 16) �� 1880	 
 */
/*
 *    Ŭ����
 *      = �������� Ŭ����(��������� ����)
 *      = �׼� Ŭ����(��ɸ� �޼ҵ� => �����ͺ��̽�)
 *      = ȥ��(����+�޼ҵ�)
 */
public class Food {
	String name;
	double score;
	String addr1;
	String addr2;
	String tel;
	String type;
	String price;
	String parking;
	String day1,day2;
	String[] menu;   // ���� null���̱� ������ ũ�⼳�� �ʿ�.
	int good;
	int soso;
	int bad;
	static String title="�����÷���Ʈ";
	// poster
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Food food=new Food();   // static�� ������ ������ ������ food�� �����
		// food ������ �� �ִ� �������� �ʱ�ȭ: ����
		food.name="��Ÿ��";
		food.score=4.3;
		food.addr1="����Ư���� ������ �ø��ȷ�60�� 5 �ѽ����� 1F";
		food.addr2="����� ������ ������ 111-55 �ѽ����� 1F";
		food.tel="02-474-3520";
		food.type="�±� ����";
		food.price="����-2����";
		food.parking="������������";
		food.day1="11:30 - 21:30";
		food.day2="14:30 - 17:00";
		food.menu=new String[4];       // �迭�� �ִ� ��� �ݵ�� ũ�� ������ �����.
		food.menu[0]="��Ÿ�� 10,000��";
		food.menu[1]="������Ŀ��(2����) 18,000��";
		food.menu[2]="�c��� 12,000��";
		food.menu[3]="�ٿ��̶�� 9,000��";
		food.good=58;
		food.soso=10;
		food.bad=9;
		// ������ �����͸� �޸𸮿� ���� => ����� �����͸� �б�/����
		System.out.println("========= �󼼺��� =========");
		System.out.println(food.name+" "+food.score);
		System.out.println("�ּ�:"+food.addr1);
		System.out.println("    ����:"+food.addr2);
		System.out.println("��ȭ��ȣ:"+food.tel);
		System.out.println("��������:"+food.type);
		System.out.println("���ݴ�:"+food.price);
		System.out.println("����:"+food.parking);
		System.out.println("�����ð�:"+food.day1);
		System.out.println("���½ð�:"+food.day2);
		System.out.print("�޴�:");
		for(String s:food.menu)
		{
			System.out.println(s);
		}
		System.out.print("��ü("+(food.good+food.soso+food.bad)+")|");
		System.out.print("���ִ�("+food.good+")|");
		System.out.print("������("+food.soso+")|");
		System.out.print("����("+food.bad+")");
		System.out.println("\n���������� ��ü:"+food.title);
	}

}
