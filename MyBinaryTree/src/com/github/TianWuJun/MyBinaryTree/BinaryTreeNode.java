package com.github.TianWuJun.MyBinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*������������ʵ��*/

public class BinaryTreeNode {
	/* �����������ͣ����Һ��ӣ����ڵ㣬���Զ�����ʽ�洢���нڵ� */
	private long data;
	private BinaryTreeNode lChild, rChild, root;
	private List<BinaryTreeNode> datas;

	/* ���캯�� */
	public BinaryTreeNode(long data, BinaryTreeNode lChild, BinaryTreeNode rChild) {
		super();
		this.data = data;
		this.lChild = lChild;
		this.rChild = rChild;
	}

	/* �����ڵ�ʹ�õĹ��캯�� */
	public BinaryTreeNode(long data) {
		this(data, null, null);
	}

	/* �ղεĹ��캯�� */
	public BinaryTreeNode() {
		super(); // �˴�super�����壿
	}

	/* ��������� */
	public void createTree(long[] dataList) {
		/* List��ʵ����LinkedList��ArrayList */
		datas = new LinkedList<BinaryTreeNode>();

		/* ʹ��for-eachѭ��������ת����Ҷ�ӽڵ���ӽ�datas������ */
		for (long temp : dataList) {
			datas.add(new BinaryTreeNode(temp));
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
	
	/* ������� */
	public void levelOrder(BinaryTreeNode root) {
		Queue<BinaryTreeNode> queue=new LinkedList<>();
		BinaryTreeNode currentNode=null;
		queue.offer(root);			//���ڵ����
		while(!queue.isEmpty()) {
			currentNode=queue.poll();		//���Ӷ�ͷԪ�ز�����
			visit(currentNode.data);
			if(currentNode.lChild!=null) {	//�����ǰ�ڵ����ڵ㲻Ϊ�գ�����ڵ����
				queue.offer(currentNode.lChild);
			}
			if(currentNode.rChild!=null) {//�����ǰ�ڵ���нڵ㲻Ϊ�գ����ҽڵ����
				queue.offer(currentNode.rChild);
			}
		}
		
	}
	/* ������� */
	public void preOrder(BinaryTreeNode root) {
		if (root != null) {
			visit(root.getData());
			preOrder(root.lChild);
			preOrder(root.rChild);
		}

	}

	/* ������� */
	public void inOrder(BinaryTreeNode root) {
		if (root != null) {
			inOrder(root.lChild);
			visit(root.getData());
			inOrder(root.rChild);
		}

	}

	/* ������� */
	public void afterOrder(BinaryTreeNode root) {
		if (root != null) {
			afterOrder(root.lChild);
			afterOrder(root.rChild);
			visit(root.getData());
		}
	}

	/* Ҷ�ӽ��ͳ�� */
	public int countLeaves(BinaryTreeNode root) {
		int counter = 0;
		if (root == null) {						//�����Ϊ�գ��򷵻�0
			counter = 0;
		} else if (root.lChild == null && root.rChild == null) {//��������и��ڵ㣬�򷵻�1
			counter = 1;
		} else {									//ʹ�õݹ�ͳ��Ҷ�ӽ����
			counter = countLeaves(root.lChild) + countLeaves(root.rChild);
		}
		return counter;
	}
	
	/*�����������ͳ��*/
	public int countDepth(BinaryTreeNode root) {
		int lDepth,rDepth;		
		if(root==null) {		//������ڵ�Ϊnull������������Ϊ0
			return 0;
		}
		else {
			lDepth=countDepth(root.lChild);
			rDepth=countDepth(root.rChild);
			return lDepth>rDepth?lDepth+1:rDepth+1;	//�����������ȴ�����������ö��������Ϊ���������+1����֮��Ȼ
		}
	}
	
	/*��������*/
	public void Exchange(BinaryTreeNode root) {
		BinaryTreeNode temp;
		if(root!=null) {
			/*������������*/
			temp=root.lChild;
			root.lChild=root.rChild;
			root.rChild=temp;
			/*�ݹ���ú�����ֱ���¶�������ԭ���������ɶѳ���״*/
			Exchange(root.lChild);
			Exchange(root.rChild);
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
	public BinaryTreeNode getRoot() {
		return root;
	}

}
