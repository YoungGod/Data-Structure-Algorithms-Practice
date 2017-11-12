package Q3_05_Queue_2Stack;

import java.util.Stack;

/**
 * ���⣺ ������ջʵ��һ������Queue.
 * @author Young
 *
 */
public class Question {
	
	/*
	 * solution: ����ջ��һ��ջִ��push����һ��ջִ��peek��pop����
	 *          ����һ��ջ��Ԫ��Ϊ��ʱ��һ���Ե���ǰһ��ջԪ��
	 *          �ɴﵽ�ӳ�Ԫ���ƶ����ã�ʵ��Ч�ʣ������ڶ�̬�������飡
	 */
	public static class Queue<T> {
		Stack<T> oldStack;
		Stack<T> newStack;
		
		public Queue() {
			oldStack = new Stack<T>();
			newStack = new Stack<T>();
		}
		
		public void push(T item) {
			oldStack.push(item);
		}
		
		public T peek() {
			if (newStack.empty()) {
				while (!oldStack.isEmpty()) {    // ���µ�ջ��Ԫ��Ϊ��ʱ���Ѿɵ�ջ��Ԫ��ת�Ƶ��µ�ջ��
					newStack.push(oldStack.pop());
				}
			}
			return newStack.peek();
		}
		
		public T pop() {
			if (newStack.empty()) {
				while (!oldStack.empty()) {
					newStack.push(oldStack.pop());
				}
			}
			return newStack.pop();
		}
	}
	
	public static void main(String args[]) {
		Queue<Integer> queue = new Queue<Integer>();
		queue.push(1);
		queue.push(2);
		queue.push(3);
		System.out.println(queue.pop());
		
		queue.push(4);
		System.out.println(queue.pop());
		
		queue.push(5);
		System.out.println(queue.pop());
		
		queue.push(6);
		System.out.println(queue.pop());
		
		queue.push(7);
		System.out.println(queue.pop());
	}

}
