package com.github.TianWuJun.MyBinaryTree;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Project:二叉树基本操作的实现
 * 
 * @author 陈兴利
 * @version 2019/5/11
 */

public class Main {
	public static void main(String[] args) {
		BinaryTreeNode btn =new BinaryTreeNode();
		StringBuilder sb=new StringBuilder();
		int flag=0;
		ArrayList<Long> ls=new ArrayList<>();
		System.out.println("请输入结点数据，并以任意字符结尾：");
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextLong()) {					//输入数据
			ls.add(sc.nextLong());
		}
		long[] dataList=new long[ls.size()];
		for(int i=0;i<ls.size();i++) {
			dataList[i]=ls.get(i);
		}
				
//		for(int i=0;i<10;i++) {
//			System.out.println();
//		}
		/*显示原始数据*/
		System.out.println("原始数据为：");
		sb.append('{');
		for(long temp:dataList) {
			sb.append(temp+",");
		}
		sb.setCharAt(sb.length()-1, '}');
		System.out.println(sb.toString());
	
		System.out.print("--------二叉树基本操作的实现--------\n"
							+ "1.层序遍历\n"
							+"2.前序遍历\n"
							+"3.中序遍历\n"
							+"4.后序遍历\n"
							+"5.统计叶子结点数\n"
							+"6.二叉树的深度统计\n"
							+"7.子树交换\n"
							+"8.中序构建线索二叉树并以后继结点遍历\n");
		
		/*建立二叉树*/
		btn.createTree(dataList);
		System.out.print("请输入您想进行的操作的序号：");
		Scanner sc2=new Scanner(System.in);
		flag=sc2.nextInt();
		switch(flag) {
		case 1:{
			/*层级遍历*/
			System.out.println("层级遍历结果：");
			btn.levelOrder(btn.getRoot());
			System.out.println();
			
		}break;
		
		case 2:{
			/*前序遍历*/
			System.out.println("前序遍历结果：");
			btn.preOrder(btn.getRoot());
			System.out.println();
		}break;
		
		case 3:{
			/*中序遍历*/
			System.out.println("中序遍历结果：");
			btn.inOrder(btn.getRoot());
			System.out.println();
		}break;
		
		case 4:{
			/*后序遍历*/
			System.out.println("后序遍历结果：");
			btn.afterOrder(btn.getRoot());
			System.out.println();
		}break;
		
		case 5:{
			/*统计叶子结点*/
			System.out.println("统计叶子结点结果：");
			System.out.println(btn.countLeaves(btn.getRoot()));
		}break;
		
		case 6:{
			/*二叉树的深度统计*/
			System.out.println("统计二叉树深度结果：");
			System.out.println(btn.countDepth(btn.getRoot()));
		}break;
		
		case 7:{
			/*子树交换*/
			System.out.println("子树交换结果：");
			btn.Exchange(btn.getRoot());
			btn.levelOrder(btn.getRoot());//通过层序遍历，查看是否完成了子树交换
			System.out.println();
		}break;
		
		case 8:{
			/*构造线索二叉树*/
			ThreadBinaryTreeNode tbtn=new ThreadBinaryTreeNode();
			tbtn.createThreadTree(dataList);
			tbtn.inThreadOrder(tbtn.getRoot());
			System.out.println("中序按后继结点遍历线索二叉树结果：");
			tbtn.inThreadList(tbtn.getRoot());
		}break;
		}
		sc.close();
		sc2.close();
	}
	
}
