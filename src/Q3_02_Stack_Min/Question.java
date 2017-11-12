package Q3_02_Stack_Min;

/**
 *  问题：设计一个栈，除pop与push方法，还支持min方法，时间复杂度O(1).
 * @author Young
 *
 */
public class Question {
	
	/*
	 * my solution: 设计一个辅助栈，为栈中每个状态维护一个min. 或把这个辅助信息直接封装在栈的元素中
	 * 
	 *  (1) 若把数组第0个位置不存放栈元素，则top=0时表示栈为空，这里把top=-1作为空
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
			// 如果满栈，动态分配存储空间
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
	 * solution 2: 追踪每一个栈状态的最小元，没必要分配一个与原stack元素值大小一样的mins
	 *  只要维护mins的顶部元素，在栈stack中，从等于mins顶部元素值到栈顶元素的最小即可；
	 *  在push或pop时要维护mins中的最要元素
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
			if (val_top == 0) {    // 第一个元素
				mins[++mins_top] = val;
			} else {
				if (val < mins[mins_top]) {
					mins[++mins_top] = val;
				}
			}
			*/
			/*
			if (val_top == 0 || val < mins[mins_top]) {    // 第一个元素 或当前元素小于mins栈顶元素
				mins[++mins_top] = val;
			}
			*/
			if (val_top == 0 || val < min()) {    // 第一个元素 或当前元素小于mins栈顶元素
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
