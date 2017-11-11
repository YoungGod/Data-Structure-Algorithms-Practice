package Q9_01_Stairs;

import java.util.Arrays;
import java.util.Stack;

/**
 * 问题：有个小孩上楼梯，楼梯有n阶台阶，小孩一次可以上1阶，2阶，3阶。计算小孩有多少种上楼梯方式。
 * @author Young
 *
 */
public class Question {
	
	/* my solution
	 * solution 1: 穷举法，采用了深度优先搜索方式，自下而上
	 */
	public static class Result {
		public int count = 0;
		public int sum = 0;
		Stack<Integer> path = new Stack<Integer>();
	}
	
	public static void upStairMethod(int[] steps, int n, Result result) {
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
			upStairMethod(steps, n, result);
			result.sum -= steps[i];
			result.path.pop();
		}
	}
	
	/*
	 * solution 2: 采用自上而下，逆向思维解决
	 *             并采用动态规划思想，记录中间重复计算的值
	 */
	public static int countWays(int n) {
		int[] memo = new int[n+1];
		Arrays.fill(memo, -1);
		return countWays(n, memo);
	}
	private static int countWays(int n, int[] memo) {
		if (n < 0) return 0;
		else if (n == 0) return 1;
		else if (memo[n] != -1) return memo[n];
		memo[n] = countWays(n-1, memo) + countWays(n-2, memo) + countWays(n-3, memo);
		return memo[n];
	}
	
	public static void main(String args[]) {
		int[] steps = {1,2,3};
		
		for (int i = 1; i < 5; i++) {
			Result result = new Result();
			upStairMethod(steps, i, result);
			System.out.println(i+": "+result.count);
			System.out.println(i+": "+countWays(i));
		}
	}

}
