package Q1_01_Is_Unique;

import java.util.HashMap;

/**
 * 串中是否有重复字符
 * @author Young
 *
 */
public class Question {
	
	/**
	 * 位向量技巧
	 * 使用一个int 4字节，共32位，可表示32种状态
	 * @param str
	 * @return
	 */
	public static boolean isUniqueChars(String str) {
		if (str.length() > 128) { // ascii字符数为0 - 2^7-1
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) 
				return false;
			checker |= (1 << val);
		}
		return true;
	}
	
	/**
	 * 获取32字节整数num的第i位，0或1
	 */
	public static boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);
	}
	
	/**
	 * 设置32字节整数num的第i位，0或1
	 */
	public static int setBit(int num, int i) {
		return num | (1 << i);
	}
	
	/**
	 * 使用辅助数据结构哈希表，或数组
	 * @param str
	 * @return
	 */
	public static boolean isUniqueChars2(String str) {
		if (str.length() > 128) {
			return false;
		}
		boolean[] char_set = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val] == true)
				return false;
			char_set[val] = true;
		}
		return true;
	}
	
	public static boolean isUniqueChars3(String str) {
		if (str.length() > 128)
			return false;
		HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (map.containsKey(ch))
				return false;
			map.put(ch, true);
		}
		return true;
	}
	
	/*
	 * 任意字符集合
	 */
	public static boolean isUniqueChars4(String str) {
		HashMap<Integer, Object> charHash = new HashMap<Integer, Object>();
		Object seen = new Object();
		int i;
		final int length = str.length();
		for (i = 0; i < length;) {
			final int cp = str.codePointAt(i);
			i += Character.charCount(cp);
			if (charHash.containsKey(cp))
				return false;
			charHash.put(cp, seen);
		}
		return true;
	}
	
	public static void main(String[] args) {
		String words[] = {"abcde", "hello", "kite", "padle"};
		//String[] words = {"abcde", "hello", "kite", "padle"};
		for (String word: words) {
			System.out.println(word + ": " + isUniqueChars(word) + " " + isUniqueChars2(word) + " " + isUniqueChars3(word));
		}
		
		String wordsUnicode[] = {"大重重", "中国中", "回家"};
		for (String word: wordsUnicode) {
			System.out.println(word + ": " + isUniqueChars4(word));
		}		
	}

}
