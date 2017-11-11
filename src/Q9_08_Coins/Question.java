package Q9_08_Coins;

import java.util.Arrays;
import java.util.Stack;

/**
 * ���⣺ �����������޵�Ӳ�ң���ֵΪ25�֣�10�֣�5�ֺ�1�֣�����n���м��ֱ�ʾ������
 * @author Young
 *
 */
public class Question {
	
	/*ʱ�临�Ӷ�ָ��������*/
	public static int countMethods(int n) {
		if (n < 0) return 0;
		else if (n == 0) return 1;
		else return countMethods(n-1) + countMethods(n-5) + countMethods(n-10) + countMethods(n-25);
	}
	
	/*���ö�̬�滮����������м����������ظ�����*/
	public static int countMethodsDynamicPrograming(int n) {
		int[] count = new int[n+1];
		Arrays.fill(count, -1);
		return countMethods(n, count);
	}
	public static int countMethods(int n,int[] count) {
		if (n < 0) return 0;
		else if (n == 0) return 1;
		if (count[n] != -1) return count[n];
		count[n] = countMethods(n-1, count) + countMethods(n-5, count) +
				countMethods(n-10, count) + countMethods(n-25, count);
		return count[n];
	}
	
	/*���������˳����û�й�ϵ�ģ���������������¥�����⣨����һ�����뵱ǰ���������*/
	public static int makeChange(int n, int denom) {
		int next_denom = 0;
		switch (denom) {
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}
		
		int ways = 0;
		for (int i = 0; i * denom <= n; i++) {
			ways += makeChange(n - i*denom, next_denom);
		}
		return ways;
	}
	
	/* my solution
	 * solution : ��ٷ����������������������ʽ�����¶���!! �Ƿ���˳���йأ����ڲ����Ƿ���˳���ϵ����
	 * ��̬�滮��������ݹ�������Ĭ�ϴ�������˳���ϵ����
	 * ������Ϊ����Ǯ��û��˳���ϵ������
	 * ��ˣ�ֻҪ��Ϊ��Ǯ������������ֵ���������
	 * ����Ϊ��
	 * 		x + 5y + 10z + 25w = n
	 * ���ĸ�����
	 * 
	 * ��xi = n, xi �� {1,2,3}
	 * 
	 */
	public static class Result {
		public int count = 0;
		public int sum = 0;
		Stack<Integer> path = new Stack<Integer>();
	}
	
	public static void countsMethod(int[] steps, int n, Result result) {
		if (result.sum == n) {
			result.count++;
			System.out.print("path: ");
			for (Integer s: result.path) {
				System.out.print(s+"+");
			}
			System.out.print("; ");
			return;
		}
		if (result.sum > n) {
			return;
		}
		
		for (int i = 0; i < steps.length; i++) {
			result.sum += steps[i];
			result.path.push(steps[i]);
			countsMethod(steps, n, result);
			result.sum -= steps[i];
			result.path.pop();
		}
	}
	public static void main(String args[]) {
		int n = 10;
		//System.out.println(countMethods(n));
		System.out.println(countMethodsDynamicPrograming(n));
		System.out.println(makeChange(n, 25));
		
		int[] steps = {1,5,10,25};
		Result result = new Result();
		countsMethod(steps, n, result);
		System.out.println(n+": "+result.count);
	}
}