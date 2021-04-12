package com.sist.main;
/*
 *    �߻� Ŭ���� ===> Board
 *      = ������ ������ �޼ҵ�
 *      = ���� �ϴ� �޼ҵ�
 */
abstract class Board{
	protected abstract update() {}
	
	public void delete() {}
	public void find() {}
}
class �Խ��� extends Board
{
	public abstract void write() {}  // �۾���
	public void list() {}   // ���
	public void detail() {}  // �󼼺���
	public void update() {} // ����
	public void delete() {}
	public void find() {}
}
class �ڷ�� extends Board
{
	public void write() {}  // �۾���, ���� �ø���
	public void list() {}   // ���
	public void detail() {}  // �󼼺���, ���� �ٿ�ε�
	public void update() {}  // ����
	public void delete() {}  // ����
	public void find() {}
	public void upload() {}
	public void download() {}
}
class �亯�Խ��� extends Board
{
	public void write() {}  // �۾���
	public void list() {}   // ���, �亯�� ���
	public void detail() {} // ��
	public void update() {} // ����
	public void delete() {} // ����
	public void find() {}
	public void replyWrite() {}
	public void replyDelete() {}
	public void replyUpdate() {}
}
class ��۰Խ���
{
	public void write() {}  // �۾���
	public void list() {}   // ���
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
