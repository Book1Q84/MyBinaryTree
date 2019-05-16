package com.github.TianWuJun.MyBinaryTree;

import java.util.LinkedList;
import java.util.List;


/**
 * 
 * 
 * ������������ʵ��
 * 
 */

public class ThreadBinaryTreeNode {
	private long data; // ������
	ThreadBinaryTreeNode lChild, rChild, root; // ����ָ����
	boolean isLeftThread = false; // ��ָ�������� false:ָ���ӽڵ� true:ǰ������
	boolean isRightThread = false; // ��ָ�������� false:ָ���ӽڵ� true:ǰ������
	private ThreadBinaryTreeNode preNode; // ������ʱ��¼ǰһ���ڵ�
	private List<ThreadBinaryTreeNode> datas;

	/*����Ϊdata�Ĺ��캯��*/
	public ThreadBinaryTreeNode(long data) {
		super();
		this.data=data;
	}
	/* �޲ι��캯�� */
	public ThreadBinaryTreeNode() {
		super();
	}


	/* ͨ��LinkedList��������� */
	public void createThreadTree(long[] dataList) {
		/* List��ʵ����LinkedList��ArrayList */
		datas = new LinkedList<ThreadBinaryTreeNode>();

		/* ʹ��for-eachѭ��������ת����Ҷ�ӽڵ���ӽ�datas������ */
		for (long temp : dataList) {
			datas.add(new ThreadBinaryTreeNode(temp));
		}

		/* ѡ���һ������Ϊ���ڵ� */
		root = datas.get(0);

		/* ���������� */
		for (int i = 0; i < dataList.length / 2; i++) {
			datas.get(i).lChild = datas.get(i * 2 + 1);
			if (i * 2 + 2 < datas.size()) { // ��ֹiΪż��ʱ�±�Խ��
				datas.get(i).rChild = datas.get(i * 2 + 2);
			}
		}
	}

	/*����������������*/
	public void inThreadOrder(ThreadBinaryTreeNode root) {
		/*˳��Ϊ: ������-->��-->������*/
		if(root==null) {
			return;
		}
		
		/* ���������� */
		inThreadOrder(root.lChild);
		
		/* �����ָ��Ϊ�գ�����ָ��ָ��ǰ����� */
		if(root.lChild==null) {
			root.lChild=preNode;
			root.isLeftThread=true;
		}
		
		/* ǰһ�����ĺ�̽��ָ��ǰ��� */
		if(preNode!=null&&preNode.rChild==null) {
			preNode.rChild=root;
			preNode.isRightThread=true;
		}
		
		preNode=root;
		
		/* ���������� */
		inThreadOrder(root.rChild);
		
	}
	
	/*�����������������(��̷�ʽ����)*/
	
	public void inThreadList(ThreadBinaryTreeNode root) {
		while(root!=null&&!root.isLeftThread) {
			root=root.lChild;
		}
		while(root!=null) {
			visit(root.data);
		
		
		/*�����ָ��������*/
		if(root.isRightThread) {
			root=root.rChild;
		}
		else {	//�����ָ�벻���������ҵ���������ʼ�Ľ��
			root=root.rChild;
			while(root!=null&&!root.isLeftThread) {
				root=root.lChild;
			}
		}
	}
	}
	
	/* ���������е�ĳ������ */
	private void visit(long obj) {
		System.out.print(obj + " ");
	}

	/* �������� */
	public long getData() {
		return data;
	}

	/* ���ظ��ڵ� */
	public ThreadBinaryTreeNode getRoot() {
		return root;
	}
	
	
}
