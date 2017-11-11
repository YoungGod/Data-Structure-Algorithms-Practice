package base.structure;

public class BiNode {

	private BiNode left;
	private BiNode right;
	private int value;
	
	public BiNode(BiNode left, BiNode right, int value) {
		this.setLeft(left);
		this.setRight(right);
		this.setValue(value);
	}

	public BiNode getLeft() {
		return left;
	}

	public void setLeft(BiNode left) {
		this.left = left;
	}

	public BiNode getRight() {
		return right;
	}

	public void setRight(BiNode right) {
		this.right = right;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
