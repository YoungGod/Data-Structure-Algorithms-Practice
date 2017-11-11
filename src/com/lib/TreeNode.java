package com.lib;

public class TreeNode {
	
	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	private int size = 0;
	
	public TreeNode(int d) {
		data = d;
		setSize(1);
	}
	
	private void setLeftChild(TreeNode left) {
		this.left = left;
		if (left != null) {
			left.parent = this;
		}
	}
	
	private void setRightChild(TreeNode right) {
		this.right = right;
		if (right != null) {
			right.parent = this;
		}
	}
	
	/* 中序构建二叉树*/
	public void insertInOrder(int d) {
		if (d <= data) {
			if (left == null) {
				setLeftChild(new TreeNode(d));
			} else {
				left.insertInOrder(d);
			}
		} else {
			if (right == null) {
				setRightChild(new TreeNode(d));
			} else {
				right.insertInOrder(d);
			}
		}
		size++;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	/**
	 * 功能：判断二叉树是否为二叉查找树
	 * @return true or false
	 */
	public boolean isBST() {
		if (left != null) {
			// 如果根节点数值小于其左孩子数值，或其左子树不是二叉查找树
			if (data < left.data || !left.isBST()) {
				return false;
			}
		}
		if (right != null) {
			if (data > right.data || !right.isBST()) {
				return false;
			}
		}
		// 左右各子树（包括子树的子树）都是二叉查找树时，true
		return true;
	}
	
	public int height() {
		/*
		int leftHeight;
		if (left != null) {
			leftHeight = left.height();
		} else {
			leftHeight = 0;
		}
		*/
		int leftHeight = left != null ? left.height() : 0;
		int rightHeight = right != null ? right.height() : 0;
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
	public TreeNode find(int d) {
		if (d == data) {
			return this;
		} else if (d < data) {
			return left != null ? left.find(d) : null;
		} else if (d > data) {
			return right != null ? right.find(d) : null;
		}
		return null;
	}
	
	private static TreeNode createMinimalBST(int arr[], int start, int end) {
		if (end < start) return null;
		
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.setLeftChild(createMinimalBST(arr, start, mid - 1));
		n.setRightChild(createMinimalBST(arr, mid + 1, end));
		return n;
	}
	
	public static TreeNode createMinimalBST(int[] array) {
		return createMinimalBST(array, 0, array.length - 1);
	}
	
	public void print() {
		BTreePrinter.printNode(this);
	}
}
