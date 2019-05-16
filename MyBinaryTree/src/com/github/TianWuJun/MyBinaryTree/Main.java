package com.github.TianWuJun.MyBinaryTree;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

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
		int flag=0;
		ArrayList<Long> ls=new ArrayList<>();
		System.out.println("�����������ݣ����������ַ���β��");
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextLong()) {					//��������
			ls.add(sc.nextLong());
		}
		long[] dataList=new long[ls.size()];
		for(int i=0;i<ls.size();i++) {
			dataList[i]=ls.get(i);
		}
				
//		for(int i=0;i<10;i++) {
//			System.out.println();
//		}
		/*��ʾԭʼ����*/
		System.out.println("ԭʼ����Ϊ��");
		sb.append('{');
		for(long temp:dataList) {
			sb.append(temp+",");
		}
		sb.setCharAt(sb.length()-1, '}');
		System.out.println(sb.toString());
	
		System.out.print("--------����������������ʵ��--------\n"
							+ "1.�������\n"
							+"2.ǰ�����\n"
							+"3.�������\n"
							+"4.�������\n"
							+"5.ͳ��Ҷ�ӽ����\n"
							+"6.�����������ͳ��\n"
							+"7.��������\n"
							+"8.���򹹽��������������Ժ�̽�����\n");
		
		/*����������*/
		btn.createTree(dataList);
		System.out.print("������������еĲ�������ţ�");
		Scanner sc2=new Scanner(System.in);
		flag=sc2.nextInt();
		switch(flag) {
		case 1:{
			/*�㼶����*/
			System.out.println("�㼶���������");
			btn.levelOrder(btn.getRoot());
			System.out.println();
			
		}break;
		
		case 2:{
			/*ǰ�����*/
			System.out.println("ǰ����������");
			btn.preOrder(btn.getRoot());
			System.out.println();
		}break;
		
		case 3:{
			/*�������*/
			System.out.println("������������");
			btn.inOrder(btn.getRoot());
			System.out.println();
		}break;
		
		case 4:{
			/*�������*/
			System.out.println("������������");
			btn.afterOrder(btn.getRoot());
			System.out.println();
		}break;
		
		case 5:{
			/*ͳ��Ҷ�ӽ��*/
			System.out.println("ͳ��Ҷ�ӽ������");
			System.out.println(btn.countLeaves(btn.getRoot()));
		}break;
		
		case 6:{
			/*�����������ͳ��*/
			System.out.println("ͳ�ƶ�������Ƚ����");
			System.out.println(btn.countDepth(btn.getRoot()));
		}break;
		
		case 7:{
			/*��������*/
			System.out.println("�������������");
			btn.Exchange(btn.getRoot());
			btn.levelOrder(btn.getRoot());//ͨ������������鿴�Ƿ��������������
			System.out.println();
		}break;
		
		case 8:{
			/*��������������*/
			ThreadBinaryTreeNode tbtn=new ThreadBinaryTreeNode();
			tbtn.createThreadTree(dataList);
			tbtn.inThreadOrder(tbtn.getRoot());
			System.out.println("���򰴺�̽��������������������");
			tbtn.inThreadList(tbtn.getRoot());
		}break;
		}
		sc.close();
		sc2.close();
	}
	
}
