package Q3_06_Stack_Sort;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 问题：按升序对栈进行排序（栈顶元素最大），只可以使用一个临时栈存放数据。
 * @author Young
 *
 */
public class Question {
	
	/*
	 * solution 1: 选择排序（不符合题意，需要3个栈），每次选择栈中最小元
	 */
	public static ArrayList<Integer> stackSort(Stack<Integer> stack) {
		if (stack.isEmpty())
			return null;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		Stack<Integer> assit_stack = new Stack<Integer>();
		int curr, min;
		/*
		int n = stack.size();
		int m;
		while(n > 0) {
			m = n - 1;
			if (assit_stack.isEmpty()) {
				min = stack.pop();
				while(!stack.isEmpty()) {
					curr = stack.pop();
					if (curr < min) {
						assit_stack.push(min);
						min = curr;
					} else {
						assit_stack.push(curr);
					}
				}
				arr.add(min);
			} else {
				min = assit_stack.pop();
				while (m > 0) {
					curr = assit_stack.pop();
					if (curr < min) {
						stack.push(min);
						min = curr;
					} else {
						stack.push(curr);
					}
					m--;
				}
				arr.add(min);
			}
			n--;
		} */
		while (!assit_stack.isEmpty() || !stack.isEmpty()) {
			if (assit_stack.isEmpty()) {
				min = stack.pop();
				while(!stack.isEmpty()) {
					curr = stack.pop();
					if (curr < min) {
						assit_stack.push(min);
						min = curr;
					} else {
						assit_stack.push(curr);
					}
				}
				arr.add(min);
			} else {
				min = assit_stack.pop();
				while(!assit_stack.isEmpty()) {
					curr = assit_stack.pop();
					if (curr < min) {
						stack.push(min);
						min = curr;
					} else {
						stack.push(curr);
					}
				}
				arr.add(min);
			}
		}
		return arr;
	}
	
	/*
	 * solution 2: 插入排序（good），每次把一个栈中的站顶元素插入到另一个栈的合适位置
	 */
	public static Stack<Integer> sortStack2(Stack<Integer> stack) {
		Stack<Integer> sorted_stack = new Stack<Integer>();
		// 把stack中各个元素插入sorted_stack中合适的位置
		while (!stack.isEmpty()) {
			Integer x = stack.pop();
			//找x合适插入位置
			Integer temp;
			while (!sorted_stack.isEmpty() && x < sorted_stack.peek()) {  // 注意边界条件
				temp = sorted_stack.pop();
				stack.push(temp);
			} 
			sorted_stack.push(x);
		}
		return sorted_stack;
	}
	
	public static void main(String args[]) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(8);
		s.push(4);
		s.push(3);
		s.push(6);
		s.push(5);
		s.push(1);
		s.push(9);
		
		System.out.println(sortStack2(s).toString());
	}
}
