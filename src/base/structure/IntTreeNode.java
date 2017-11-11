package base.structure;

/**
 * 面向对象编程：继承等概念需要再练习！！
 * @author Young
 *
 */
public class IntTreeNode extends TreeNode {
	
	int value;
	
	public IntTreeNode(TreeNode[] children, int value) {
		super(children);
		// TODO Auto-generated constructor stub
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public static void main(String args[]) {
		IntTreeNode[] children = new IntTreeNode[3];
		for (int i = 0; i < children.length; i++) {
			children[i] = new IntTreeNode(null, i);
		}
		
		IntTreeNode root = new IntTreeNode(children, 10);
        
		for (int i = 0; i < root.children.length; i++) {
			System.out.println(root.getChild(i));
		}

	}
}
