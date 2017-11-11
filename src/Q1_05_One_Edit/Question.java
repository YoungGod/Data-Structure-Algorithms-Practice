package Q1_05_One_Edit;


/**
 * 判断两个字符串是否只有一个差别（或插入一个字符，或删除一个字符，或替换一个字符）
 * @author Young
 *
 */
public class Question {
	
	/*
	 * my solution: 1. 统计字符串中各个字符出现频率
	 * 				2. 判断：如果两个频率表中频率差异为1，则两个字符串只有一个差别
	 */
	public static boolean isOneEditAway(String s, String t) {
		if (Math.abs(s.length() - t.length()) > 1)
			return false;
		
		boolean diff = false;
		int[] char_set = new int[128];
		for (char c: s.toCharArray()) {
			char_set[c]++;
		}
		for (char c: t.toCharArray()) {
			char_set[c]--;
			if (char_set[c] < 0) {
				if (diff == true) {
					return false;
				}
				diff = true;
			}
		}
		diff = false;
		int sum = 0;
		for (int i = 0; i < char_set.length; i++) {
			if (char_set[i] > 0) {
				if (diff == true) {
					return false;
				}
				diff = true;
			}
			sum += char_set[i];
		}
		if (sum == 0) return false;
		return true;
	}
	
	/*
	 * solution 2: 方法1有些繁琐，实际上是没有必要统计字符频率!!；
	 * 				可以顺序比较，只要有一个不同差别即可；分别对不同的差异进行处理
	 * 				根据长度的不同，分为三种基本情况！！
	 * 				模块化！！
	 */
	public static boolean isOneEditAway1(String first, String second) {
		if (first.length() == second.length()) { //如果长度相等，判别是否是替换差异
			return oneEditReplace(first, second);
		} else if (first.length() + 1 == second.length()) { //不相等，判别是否插入差异
			return oneEditInsert(first, second);			//后者后字符插入
		} else if (first.length() - 1 == second.length()) {
			return oneEditInsert(second, first);
		}
		return false;
	}
	
	private static boolean oneEditInsert(String first, String second) {
		boolean foundDifference = false;
		for (int i = 0, j = 0; i < first.length(); j++) {
			if (first.charAt(i) != second.charAt(j)) {
				if (foundDifference == true) {
					return false;
				}
				foundDifference = true;
			} else {
				i++;
			}
		}
		return true;
	}

	private static boolean oneEditReplace(String first, String second) {
		int diffCount = 0;
		for (int i = 0; i < first.length(); i++) {
			if (first.charAt(i) != second.charAt(i)) {
				diffCount++;
			}
		}
		if (diffCount != 1) return false;
		else return true;
	}

	public static void main(String args[]) {
		String t = "young";
		String s = "youngdd";
		System.out.println(isOneEditAway1(s, t));
	}

}
