package Q3_02_Stack_Min;

/**
 *  ���⣺���һ��ջ����pop��push��������֧��min������ʱ�临�Ӷ�O(1).
 * @author Young
 *
 */
public class Question {
	
	/*
	 * my solution: ���һ������ջ��Ϊջ��ÿ��״̬ά��һ��min. ������������Ϣֱ�ӷ�װ��ջ��Ԫ����
	 * 
	 *  (1) ���������0��λ�ò����ջԪ�أ���top=0ʱ��ʾջΪ�գ������top=-1��Ϊ��
	 */
	public static final int STACK_SIZE = 20;

	public static class Stack1 {
		private int[] value;
		private int top;
		private int[] mins;
		
		public Stack1() {
			value = new int[STACK_SIZE];
			mins = new int[STACK_SIZE];
			top = -1;
		}
		
		public int pop() {
			if (top < 0) return -1;
			return value[top--];
		}
		
		public void push(int val) {
			// �����ջ����̬����洢�ռ�
			if (top == STACK_SIZE) {
				int[] arr_val = new int[2*STACK_SIZE];
				int[] arr_min =  new int[2*STACK_SIZE];
				for (int i = 0; i < STACK_SIZE; i++) {
					arr_val[i] = value[i];
					arr_min[i] = mins[i];
				}
				value = arr_val;
				mins = arr_min;
			}
			value[++top] = val;
			if (top == 0) {
				mins[top] = val;
			} else {
				/*
				if (min[top-1] < val) {
					min[top] = min[top-1];
				} else {
					min[top] = val;
				}
				*/
				mins[top] = val < mins[top-1] ? val : mins[top-1];
			}
		}
		
		public int min() {
			if (top < 0) return -9999;
			return mins[top];
		}
		
		public void show() {
			for (int i = 0; i <= top; i++) {
				System.out.print(value[i]+", ");
			}
			System.out.println();
		}
	}
	
	/*
	 * solution 2: ׷��ÿһ��ջ״̬����СԪ��û��Ҫ����һ����ԭstackԪ��ֵ��Сһ����mins
	 *  ֻҪά��mins�Ķ���Ԫ�أ���ջstack�У��ӵ���mins����Ԫ��ֵ��ջ��Ԫ�ص���С���ɣ�
	 *  ��push��popʱҪά��mins�е���ҪԪ��
	 */
	public static class Stack2{
		int[] value;
		int[] mins;
		int val_top;
		int mins_top;
		
		public Stack2() {
			value = new int[STACK_SIZE];
			mins =  new int[STACK_SIZE/2];
			val_top = -1;
			mins_top = -1;
		}
		
		public int pop() {
			if (val_top == -1) return -9999;
			int val = value[val_top--];
			if (val == mins[mins_top]) {
				mins_top--;
			}
			return val;
		}
		
		public void push(int val) {
			value[++val_top] = val;
			/*
			if (val_top == 0) {    // ��һ��Ԫ��
				mins[++mins_top] = val;
			} else {
				if (val < mins[mins_top]) {
					mins[++mins_top] = val;
				}
			}
			*/
			/*
			if (val_top == 0 || val < mins[mins_top]) {    // ��һ��Ԫ�� ��ǰԪ��С��minsջ��Ԫ��
				mins[++mins_top] = val;
			}
			*/
			if (val_top == 0 || val < min()) {    // ��һ��Ԫ�� ��ǰԪ��С��minsջ��Ԫ��
				mins[++mins_top] = val;
			}
		}
		
		public int min() {
			if (mins_top < 0) return -9999;
			return mins[mins_top];
		}
		
		public void show() {
			for (int i = 0; i <= val_top; i++) {
				System.out.print(value[i]+", ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		Stack2 s = new Stack2();
		s.push(7);
		s.push(9);
		s.push(8);
		s.push(4);
		s.push(6);
		s.push(3);
		
		s.show();
		System.out.println("min:"+s.min());
		
		s.pop();
		s.show();
		System.out.println("min:"+s.min());
		
		s.pop();
		s.show();
		System.out.println("min:"+s.min());
		
		s.pop();
		s.show();
		System.out.println("min:"+s.min());
		
		s.pop();
		s.show();
		System.out.println("min:"+s.min());
		
		s.pop();
		s.show();
		System.out.println("min:"+s.min());
	}

}
