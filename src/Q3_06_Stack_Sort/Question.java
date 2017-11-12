package Q3_06_Stack_Sort;

import java.util.ArrayList;
import java.util.Stack;

/**
 * ���⣺�������ջ��������ջ��Ԫ����󣩣�ֻ����ʹ��һ����ʱջ������ݡ�
 * @author Young
 *
 */
public class Question {
	
	/*
	 * solution 1: ѡ�����򣨲��������⣬��Ҫ3��ջ����ÿ��ѡ��ջ����СԪ
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
	 * solution 2: ��������good����ÿ�ΰ�һ��ջ�е�վ��Ԫ�ز��뵽��һ��ջ�ĺ���λ��
	 */
	public static Stack<Integer> sortStack2(Stack<Integer> stack) {
		Stack<Integer> sorted_stack = new Stack<Integer>();
		// ��stack�и���Ԫ�ز���sorted_stack�к��ʵ�λ��
		while (!stack.isEmpty()) {
			Integer x = stack.pop();
			//��x���ʲ���λ��
			Integer temp;
			while (!sorted_stack.isEmpty() && x < sorted_stack.peek()) {  // ע��߽�����
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
