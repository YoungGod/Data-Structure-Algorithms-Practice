package base.structure;


public class LinkedListWithHead<T> {
	Node head;
	
	private class Node {
		T data;
		Node next;
		
		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	public LinkedListWithHead(T data) {
		// TODO Auto-generated constructor stub
		head = new Node(data, null);
	}
	
	public void addToHead(T data) {
		head.next = new Node(data, head.next);
	}
	
	public void addToTail(T data) {
		Node node = head;
		while (node.next != null) {
			node = node.next;
		}
		node.next = new Node(data, null);
	}
	
	public void traverseList() {
		for (Node node = head.next; node !=null; node = node.next) {
			System.out.print(node.data + ", ");
		}
		System.out.println();
	}
	
	public Node deleteNode(T data) {
		Node node = null;
		for (node = head; node.next != null; node = node.next) {
			if (node.next.data == data) {
				Node temp = node.next;
				node.next = node.next.next;
				return temp;
			}
		}
		return null;
	}
	
	public static void main(String args[]) {
		LinkedListWithHead<String> List = new LinkedListWithHead<String>("HEAD");
		List.addToTail("China");
		List.addToHead("YangJie");
		List.addToHead("Hunan");
		List.traverseList();
		List.addToHead("XiangTan");
		List.addToTail("LongKou");
		List.traverseList();
		
		List.deleteNode("LongKou");
		List.traverseList();
		List.deleteNode("XiangTan");
		List.traverseList();
	}

}
