package com.sist.anno;

public class MovieManager {
	@RequestMapping("Ȩ")
	public void movieHome() // Ȩ
	{
		System.out.println("��ȭ Ȩ�Դϴ�");
	}
	@RequestMapping("���")
	public void movieList() // ���
	{
		System.out.println("��ȭ ����Դϴ�");
	}
	@RequestMapping("��")
	public void movieDetail() // ��
	{
		System.out.println("��ȭ �󼼺����Դϴ�");
	}
	@RequestMapping("����")
	public void movieReserve() // ����
	{
		System.out.println("��ȭ �����������Դϴ�");
	}
	@RequestMapping("ã��")
	public void movieFind() // ã��
	{
		System.out.println("��ȭ�� ã�� �� �ֽ��ϴ�");
	}
	@RequestMapping("����")
	public void movieEnd()
	{
		System.out.println("��ȭ ����Ʈ ����");
	}

}
