package com.github.TianWuJun.MyBinaryTree;

/**
 * Project:����������������ʵ��
 * 
 * @author ������
 * @version 2019/5/11
 */

public class Main {
	public static void main(String[] args) {
		BinaryTreeNode btn =new BinaryTreeNode();
		StringBuilder sb=new StringBuilder();
		long[] dataList= {0,1,2,3,4,5,6,7};
		
		/*��ʾԭʼ����*/
		System.out.println("ԭʼ����Ϊ��");
		sb.append('{');
		for(long temp:dataList) {
			sb.append(temp+",");
		}
		sb.setCharAt(sb.length()-1, '}');
		System.out.println(sb.toString());
		
		/*����������*/
		btn.createTree(dataList);
		
		/*�㼶����*/
		System.out.println("�㼶���������");
		btn.levelOrder(btn.getRoot());
		System.out.println();
		
		/*ǰ�����*/
		System.out.println("ǰ����������");
		btn.preOrder(btn.getRoot());
		System.out.println();
		
		/*�������*/
		System.out.println("������������");
		btn.inOrder(btn.getRoot());
		System.out.println();
		
		/*�������*/
		System.out.println("������������");
		btn.afterOrder(btn.getRoot());
		System.out.println();
		
		/*ͳ��Ҷ�ӽ��*/
		System.out.println("ͳ��Ҷ�ӽ������");
		System.out.println(btn.countLeaves(btn.getRoot()));
		
		/*�����������ͳ��*/
		System.out.println("ͳ�ƶ�������Ƚ����");
		System.out.println(btn.countDepth(btn.getRoot()));

		/*��������*/
		System.out.println("�������������");
		btn.Exchange(btn.getRoot());
		btn.levelOrder(btn.getRoot());//ͨ������������鿴�Ƿ��������������
		System.out.println();
		
		/*��������������*/
		ThreadBinaryTreeNode tbtn=new ThreadBinaryTreeNode();
		tbtn.createThreadTree(dataList);
		tbtn.inThreadOrder(tbtn.getRoot());
		System.out.println("���򰴺�̽��������������������");
		tbtn.inThreadList(tbtn.getRoot());
		
		
	}
}
