package com.sist.string;
/*
 *    ��Ʈ�� Ŭ����
 *    =========
 *       char[]�� �����ϴ� ���α׷�
 *       String => Ŭ����
 *              => ���ڿ��� ����
 *              => ���ڿ��� ���� ��� �����ϰ� ���� Ŭ����
 *              => ���ڿ��� �����ϴ� �Ϲ� ������������ ����� ����
 *                 ***String name="";
 *                 String name=new String();  // �޸� �Ҵ�
 *       String Ŭ������ Call By Reference�� ����� �� ����(�Ϲ� ��������ó�� ���. String�� ����)
 *       
 *       => �޼ҵ� ȣ���ϴ� ���
 *          1) ���� �����ϴ� ���(Call By Value) => �޸𸮸� ���� ����� ��(= ���纻. ������ ����x). �⺻ ��������(int a, int b)
 *          2) �ּҸ� �����ϴ� ���(Call By Reference) => ������ �ּҸ� �ѱ�(�迭, Ŭ����) A a => String�� ���� ����
 *       => Ŭ������ Ŭ���� ������ �� => �ݵ�� �޼ҵ� ȣ��!
 *       
 *       String���� ���
 *       ============
 *       ���ڿ� ��ȯ                                                   (return��)
 *         = �빮�� ����: toUpperCase() => "aaa".toUpperCase() => "AAA" (String)
 *         = �ҹ��� ����: toLowercase()                        =>       (String) 
 *         = ���鹮�� ����: �¿��� ���鸸 ���� => trim()   " aaa ".trim() => "aaa" (String)
 *         = ���ڿ� ����: concat() => �󵵰� �۴� (+)
 *                    "Hello".concat("Java") ==> "HelloJava" =>       (String)
 *                    ������ "Hello"+"Java" �߾���
 *       ���ڿ� ����
 *         ###### ��� ���ڿ��� ���� ��ȣ�� 0������ �����Ѵ�
 *         "Hello Java"
 *          0123456789   ==> length(): 10 (���� �����ؾ� ��)
 *         = ���ڿ� ����: length()
 *         = ���� �� ���� ������ �´�: charAt()  => charAt(6)
 *         ===============================
 *         = ���� ���ڿ�: startsWith()
 *         = ������ ���ڿ�: endsWith()
 *         =============================== �˻��� ����
 *         = ���Թ���: contains() : ��õ
 *         "hello" "Hello" => ID, Password
 *         = ���ں�: equals(): ��ҹ��� ����(�ٸ��� Ʋ��), equalsIgnoreCase(): ��ҹ��� ���� ���� ��
 *           "Hell.o.java"
 *         = ���� ��ġã��: indexOf() => l.o: ó��(.), lastIndexOf() => o.java: �������� �ִ� ����(.)
 *         = ���ں�ȯ: replace: �� ����, replaceAll: ���Խ�
 *           "abcAbc1234�ѱ�" => replaceAll("[^0-9]","") = ���ڸ� �����ϰ� ������ ���� => "1234"
 *           ����  [0-9]
 *           ���ĺ� [A-Z]�빮�� + [a-z]�ҹ��� = [A-Za-z]���ĺ� ��ü
 *           �ѱ�  [��-�R]
 *           
 *           "red,green,blue,yellow,black"
 *         = ���ں���
 *           = split: �����ں��� �迭�� ����
 *           = substring: ������ ��ġ ����
 *         = ��ü�� ���� ��ȯ: toString()
 *         = ��� ���������� ���ڿ��� ��ȯ => valueOf()
 *         = ���� ũ�� ��(����): "ABC" "ACD" compareTo() int => ����(0), ������ũ��(1), ��������ũ��(-1)
 *           "aaa".compareTo("aaa")
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="hello";
		String s=str.toUpperCase();   // s�� �ٲ����, str�� �״�� ����
		String s1=str.toLowerCase();
		System.out.println(str);
		System.out.println(s);
		String s2=str.concat("Java");  // s2�� �ٲ���� str�� �ٲ�� �ƴ�! ������
		System.out.println(s2);
		System.out.println(str);

	}

}
