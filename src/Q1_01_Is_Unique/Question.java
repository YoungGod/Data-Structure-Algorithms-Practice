package Q1_01_Is_Unique;

import java.util.HashMap;

/**
 * �����Ƿ����ظ��ַ�
 * @author Young
 *
 */
public class Question {
	
	/**
	 * λ��������
	 * ʹ��һ��int 4�ֽڣ���32λ���ɱ�ʾ32��״̬
	 * @param str
	 * @return
	 */
	public static boolean isUniqueChars(String str) {
		if (str.length() > 128) { // ascii�ַ���Ϊ0 - 2^7-1
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
	 * ��ȡ32�ֽ�����num�ĵ�iλ��0��1
	 */
	public static boolean getBit(int num, int i) {
		return ((num & (1 << i)) != 0);
	}
	
	/**
	 * ����32�ֽ�����num�ĵ�iλ��0��1
	 */
	public static int setBit(int num, int i) {
		return num | (1 << i);
	}
	
	/**
	 * ʹ�ø������ݽṹ��ϣ��������
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
	 * �����ַ�����
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
		
		String wordsUnicode[] = {"������", "�й���", "�ؼ�"};
		for (String word: wordsUnicode) {
			System.out.println(word + ": " + isUniqueChars4(word));
		}		
	}

}
