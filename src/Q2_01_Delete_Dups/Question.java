package Q2_01_Delete_Dups;

import java.util.HashMap;

/**
 *  问题：删除未排序链表中重复的节点？如果不得使用其他辅助数据结构，又该怎么解决？
 * @author Young
 *
 */
public class Question {
	
	public static class LinkedNode {
		int value;
		LinkedNode next;
		
		public LinkedNode(int val, LinkedNode next) {
			this.value = val;
			this.next = next;
		}
		
		public void add(int value) {
			LinkedNode node = new LinkedNode(value, null);
			LinkedNode x = this;
			while (x.next != null) {
				x = x.next;
			}
			x.next = node;
		}
		
		public void show() {
			for (LinkedNode node = this; node != null; node = node.next) {
				System.out.print(node.value + ", ");
			}
			System.out.println();
		}
 	}
		
	public static void deleteDups(LinkedNode node) {
		HashMap<Integer, Boolean> nodeMap = new HashMap<Integer, Boolean>();
		LinkedNode previous = null;
		while(node != null) {
			if (nodeMap.containsKey(node.value)) {
				previous.next = node.next;
			} else {
				nodeMap.put(node.value, true);
				previous = node;
			}
			node = node.next;
		}	
	}
	
	public static void main(String args[]) {		
		LinkedNode node = new LinkedNode(0, null);
		node.add(1);
		node.add(2);
		node.add(3);
		node.add(2);
		node.add(4);
		node.add(1);
		node.show();
		
		deleteDups(node);
		node.show();
		
	}
}
