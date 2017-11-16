package Q7_Pow_xn;

import javax.print.attribute.standard.RequestingUserName;
import javax.xml.transform.Templates;

/**
 * ���⣺����X^n��x��n��Ϊ������Ҫ��ʱ�临�Ӷ�O(logn)��
 * @author Young
 *
 */
public class Question {
	
	/*
	 * ���淽��O(n)
	 */
	public static int pow(int x, int n) {
		int p = 1;
		for (int i = 1; i <= n; i++) {
			p *= x;
		}
		return p;
	}
	
	/*
	 * �ֶ���֮
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
	 * ���ö�̬�滮˼�룬�����м���
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
