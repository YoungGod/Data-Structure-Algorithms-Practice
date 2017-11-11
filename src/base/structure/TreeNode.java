package base.structure;

public abstract class TreeNode {
	
	TreeNode[] children;
	
	public TreeNode(TreeNode[] children) {
		this.children = children;
	}
	
	public TreeNode getNumChildren(int index) {
		return children[index];
	}
	
	public TreeNode getChild(int index) {
		return children[index];
	}
}
