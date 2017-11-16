package Q7_Pow_xn;

import javax.print.attribute.standard.RequestingUserName;
import javax.xml.transform.Templates;

/**
 * 问题：计算X^n，x，n均为整数。要求时间复杂度O(logn)。
 * @author Young
 *
 */
public class Question {
	
	/*
	 * 常规方法O(n)
	 */
	public static int pow(int x, int n) {
		int p = 1;
		for (int i = 1; i <= n; i++) {
			p *= x;
		}
		return p;
	}
	
	/*
	 * 分而治之
	 */
	public static int pow_divide_conque(int x, int n) {
		if (n == 0) return 1;
		if (n % 2 == 0) {
			return pow_divide_conque(x, n/2);
		} else {
			return x*pow_divide_conque(x, n/2)*pow_divide_conque(x, n/2);
		}
	}
	
	/*
	 * 采用动态规划思想，保存中间结果
	 */
	public static int pow_opt(int x, int n) {
		if (n == 0) return 1;
		
		int temp = pow_opt(x, n/2);
		if (n % 2 == 0) return temp*temp;
		else return x*temp*temp;
	}
	 
	/* Iterative Function to calculate (x^y) in O(logy) */
	public static int power(int x, int y)
	{
		int res = x;
		while (y > 1) {
			res = res * res;
			y /= 2;
		}
		if (y % 2 == 0) return res;
		else return res * x; 
	}
	
	public static void main(String args[]) {
		int x = 3;
		int n = 5;
		System.out.println(power(x, n));
		System.out.println(3*3*3*3*3);
	}
}
