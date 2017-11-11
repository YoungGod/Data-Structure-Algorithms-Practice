package Q9_08_Coins;

import java.util.Arrays;
import java.util.Stack;

/**
 * 问题： 给定数量不限的硬币，币值为25分，10分，5分和1分，计算n分有几种表示方法。
 * @author Young
 *
 */
public class Question {
	
	/*时间复杂度指数级增长*/
	public static int countMethods(int n) {
		if (n < 0) return 0;
		else if (n == 0) return 1;
		else return countMethods(n-1) + countMethods(n-5) + countMethods(n-10) + countMethods(n-25);
	}
	
	/*利用动态规划方法，存放中间结果，避免重复工作*/
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
	
	/*这个问题与顺序是没有关系的！！！。区别于上楼梯问题（其下一步都与当前步相关联）*/
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
	 * solution : 穷举法，采用了深度优先搜索方式，自下而上!! 是否与顺序有关，相邻步骤是否有顺序关系！！
	 * 动态规划，迭代或递归搜索都默认存在这种顺序关系！！
	 * 该问题为换零钱：没有顺序关系！！！
	 * 因此，只要和为总钱数，求各个币种的数量！！
	 * 问题为：
	 * 		x + 5y + 10z + 25w = n
	 * 求解的个数？
	 * 
	 * Σxi = n, xi ∈ {1,2,3}
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