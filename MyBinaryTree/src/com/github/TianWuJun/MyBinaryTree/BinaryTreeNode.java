package com.github.TianWuJun.MyBinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*基本二叉树的实现*/

public class BinaryTreeNode {
	/* 定义数据类型，左右孩子，根节点，和以队列形式存储所有节点 */
	private long data;
	private BinaryTreeNode lChild, rChild, root;
	private List<BinaryTreeNode> datas;

	/* 构造函数 */
	public BinaryTreeNode(long data, BinaryTreeNode lChild, BinaryTreeNode rChild) {
		super();
		this.data = data;
		this.lChild = lChild;
		this.rChild = rChild;
	}

	/* 供根节点使用的构造函数 */
	public BinaryTreeNode(long data) {
		this(data, null, null);
	}

	/* 空参的构造函数 */
	public BinaryTreeNode() {
		super(); // 此处super无意义？
	}

	/* 创造二叉树 */
	public void createTree(long[] dataList) {
		/* List的实现类LinkedList、ArrayList */
		datas = new LinkedList<BinaryTreeNode>();

		/* 使用for-each循环把数据转换成叶子节点添加进datas数组中 */
		for (long temp : dataList) {
			datas.add(new BinaryTreeNode(temp));
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
	
	/* 层序遍历 */
	public void levelOrder(BinaryTreeNode root) {
		Queue<BinaryTreeNode> queue=new LinkedList<>();
		BinaryTreeNode currentNode=null;
		queue.offer(root);			//根节点入队
		while(!queue.isEmpty()) {
			currentNode=queue.poll();		//出队队头元素并访问
			visit(currentNode.data);
			if(currentNode.lChild!=null) {	//如果当前节点的左节点不为空，把左节点入队
				queue.offer(currentNode.lChild);
			}
			if(currentNode.rChild!=null) {//如果当前节点的有节点不为空，把右节点入队
				queue.offer(currentNode.rChild);
			}
		}
		
	}
	/* 先序遍历 */
	public void preOrder(BinaryTreeNode root) {
		if (root != null) {
			visit(root.getData());
			preOrder(root.lChild);
			preOrder(root.rChild);
		}

	}

	/* 中序遍历 */
	public void inOrder(BinaryTreeNode root) {
		if (root != null) {
			inOrder(root.lChild);
			visit(root.getData());
			inOrder(root.rChild);
		}

	}

	/* 后序遍历 */
	public void afterOrder(BinaryTreeNode root) {
		if (root != null) {
			afterOrder(root.lChild);
			afterOrder(root.rChild);
			visit(root.getData());
		}
	}

	/* 叶子结点统计 */
	public int countLeaves(BinaryTreeNode root) {
		int counter = 0;
		if (root == null) {						//如果树为空，则返回0
			counter = 0;
		} else if (root.lChild == null && root.rChild == null) {//如果树仅有根节点，则返回1
			counter = 1;
		} else {									//使用递归统计叶子结点数
			counter = countLeaves(root.lChild) + countLeaves(root.rChild);
		}
		return counter;
	}
	
	/*二叉树的深度统计*/
	public int countDepth(BinaryTreeNode root) {
		int lDepth,rDepth;		
		if(root==null) {		//如果根节点为null，则二叉树深度为0
			return 0;
		}
		else {
			lDepth=countDepth(root.lChild);
			rDepth=countDepth(root.rChild);
			return lDepth>rDepth?lDepth+1:rDepth+1;	//如果左子树深度大于右子树则该二叉树深度为左子树深度+1，反之亦然
		}
	}
	
	/*子树交换*/
	public void Exchange(BinaryTreeNode root) {
		BinaryTreeNode temp;
		if(root!=null) {
			/*交换左右子树*/
			temp=root.lChild;
			root.lChild=root.rChild;
			root.rChild=temp;
			/*递归调用函数，直至新二叉树与原来二叉树成堆成形状*/
			Exchange(root.lChild);
			Exchange(root.rChild);
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
	public BinaryTreeNode getRoot() {
		return root;
	}

}
