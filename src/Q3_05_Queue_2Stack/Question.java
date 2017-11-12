package Q3_05_Queue_2Stack;

import java.util.Stack;

/**
 * 问题： 用连个栈实现一个队列Queue.
 * @author Young
 *
 */
public class Question {
	
	/*
	 * solution: 两个栈，一个栈执行push，另一个栈执行peek和pop操作
	 *          当后一个栈中元素为空时，一次性导入前一个栈元素
	 *          可达到延迟元素移动作用，实现效率，类似于动态分配数组！
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
				while (!oldStack.isEmpty()) {    // 当新的栈中元素为空时，把旧的栈中元素转移到新的栈中
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
