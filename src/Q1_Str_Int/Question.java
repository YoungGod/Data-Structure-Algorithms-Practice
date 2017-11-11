package Q1_Str_Int;

/**
 * 字符串转整数，整数转字符串
 * "1234" -> 1234
 * "-1234" -> -1234   （不要忘记负号！！）
 * @author Young
 *
 */
public class Question {
	
	public static int strToInt(String str) {
		int num = 0;
		int temp = 0;
		int i = 0;
		boolean neg = false;
		if (str.charAt(0) == '-') {
			i = 1;
			neg = true;
		}
		while (i < str.length()) {
			temp = str.charAt(i) - '0';
			num = num * 10 + temp;
			i++;
		}
		return neg ? -num : num;
	}
	
	public static String intToStr(int num) {
		
		if (num < 0) num = -num;
		
		
		return String.valueOf(num);
	}
	
	public static void main(String args[]) {
		String str = "-12345";
		int num = 12345;
		System.out.println(strToInt(str));
		System.out.println(intToStr(num));
	}
}
