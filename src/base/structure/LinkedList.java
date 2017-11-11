package base.structure;

public class LinkedList<T> {
	Node first;
	
	private class Node {
		T data;
		Node next;
		
		public Node(T data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	/**
	 * 表头插入结点
	 * @param data
	 */
	public void addToHead(T data) {
		first = new Node(data, first);
	}
	
	/**
	 * 在链表尾部插入结点
	 * @param data
	 */
	public void addToTail(T data) {
		Node tail = new Node(data, null);
		Node node = first;
		while (node.next != null) node = node.next;
		node.next = tail;
	}
	
	/**
	 * 删除指定结点
	 * @param data
	 * @return
	 */
	public Node deleteNode(T data) {
		Node node = first;
		if (first.data == data) {
			first = first.next;
			return node;
		}
		while (node.next != null) {
			if (node.next.data == data) {
				Node temp = node.next;
				node.next = node.next.next;
				return temp;
			}
			node = node.next;
		}
		return null;
	}
	
	/**
	 * 在指定位置1，2，..，插入结点
	 * @param data
	 * @param pos
	 */
	public void insertNode(T data, int pos) {
		Node node = first;
		if (pos == 1) {
			first = new Node(data, first);
			return;
		}
		
		for (int i = 2; i < pos; i++) {
			node = node.next;
			if (node == null) {
				System.out.println("waring: out of boundary, add to tail instead");
				addToTail(data);
				return;
			}
		}

		Node newNode = new Node(data, node.next);
		node.next = newNode;
	}
	
	public void traverseList() {
		for (Node node = first; node != null; node = node.next) {
			System.out.print(node.data+", ");
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		LinkedList<String> List = new LinkedList<String>();
		List.addToHead("yangjie");
		List.addToHead("China");
		List.addToTail("song");
		List.addToTail("happy");
		List.traverseList();
		
		System.out.println(List.deleteNode("China").data);
		System.out.println(List.deleteNode("song").data);
		List.traverseList();
		
		List.insertNode("China", 1);
		List.traverseList();
		
		List.insertNode("China", 4);
		List.traverseList();
		
		List.insertNode("Come ON", 1);
		List.traverseList();
		
		List.insertNode("Come ON", 10);
		List.traverseList();
	}
}
