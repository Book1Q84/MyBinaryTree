package com.github.TianWuJun.MyBinaryTree;

import java.util.LinkedList;
import java.util.List;


/**
 * 
 * 
 * 线索二叉树的实现
 * 
 */

public class ThreadBinaryTreeNode {
	private long data; // 数据域
	ThreadBinaryTreeNode lChild, rChild, root; // 左右指针域
	boolean isLeftThread = false; // 左指针域类型 false:指向子节点 true:前驱或后继
	boolean isRightThread = false; // 右指针域类型 false:指向子节点 true:前驱或后继
	private ThreadBinaryTreeNode preNode; // 线索化时记录前一个节点
	private List<ThreadBinaryTreeNode> datas;

	/*参数为data的构造函数*/
	public ThreadBinaryTreeNode(long data) {
		super();
		this.data=data;
	}
	/* 无参构造函数 */
	public ThreadBinaryTreeNode() {
		super();
	}


	/* 通过LinkedList构造二叉树 */
	public void createThreadTree(long[] dataList) {
		/* List的实现类LinkedList、ArrayList */
		datas = new LinkedList<ThreadBinaryTreeNode>();

		/* 使用for-each循环把数据转换成叶子节点添加进datas数组中 */
		for (long temp : dataList) {
			datas.add(new ThreadBinaryTreeNode(temp));
		}

		/* 选择第一个数据为根节点 */
		root = datas.get(0);

		/* 构建二叉树 */
		for (int i = 0; i < dataList.length / 2; i++) {
			datas.get(i).lChild = datas.get(i * 2 + 1);
			if (i * 2 + 2 < datas.size()) { // 防止i为偶数时下标越界
				datas.get(i).rChild = datas.get(i * 2 + 2);
			}
		}
	}

	/*中序线索化二叉树*/
	public void inThreadOrder(ThreadBinaryTreeNode root) {
		/*顺序为: 左子树-->根-->右子树*/
		if(root==null) {
			return;
		}
		
		/* 处理左子树 */
		inThreadOrder(root.lChild);
		
		/* 如果左指针为空，将左指针指向前驱结点 */
		if(root.lChild==null) {
			root.lChild=preNode;
			root.isLeftThread=true;
		}
		
		/* 前一个结点的后继结点指向当前结点 */
		if(preNode!=null&&preNode.rChild==null) {
			preNode.rChild=root;
			preNode.isRightThread=true;
		}
		
		preNode=root;
		
		/* 处理右子树 */
		inThreadOrder(root.rChild);
		
	}
	
	/*中序遍历线索二叉树(后继方式遍历)*/
	
	public void inThreadList(ThreadBinaryTreeNode root) {
		while(root!=null&&!root.isLeftThread) {
			root=root.lChild;
		}
		while(root!=null) {
			visit(root.data);
		
		
		/*如果右指针是线索*/
		if(root.isRightThread) {
			root=root.rChild;
		}
		else {	//如果右指针不是线索，找到右子树开始的结点
			root=root.rChild;
			while(root!=null&&!root.isLeftThread) {
				root=root.lChild;
			}
		}
	}
	}
	
	/* 访问链表中的某个对象 */
	private void visit(long obj) {
		System.out.print(obj + " ");
	}

	/* 返回数据 */
	public long getData() {
		return data;
	}

	/* 返回根节点 */
	public ThreadBinaryTreeNode getRoot() {
		return root;
	}
	
	
}
