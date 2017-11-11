package Q1_04_Palindrome_Permutation;

/**
 * 判断一个字符串是否是回文字符串的一个排列
 * 如 "abccba" : "aabbcc"(true)
 * @author Young
 *
 */
public class Question {
	
	/*
	 * solution 1: 
	 * 第一步： 建立词频表
	 * 第二步：判断词频为奇数的字符个数是否超过1个
	 */
	public static boolean isPermutationOfPalindrome(String phrase) {
		int[] table = buildCharFrequencyTable(phrase);
		return checkMaxOneOdd(table);
	}

	private static boolean checkMaxOneOdd(int[] table) {
		if (table == null)
			return true;
		
		int oddCount = 0;
		for (int i = 0; i < table.length; i++) {
			if (table[i] % 2 != 0) {
				oddCount++;
				if (oddCount > 1) 
					return false;
			}

		}
		return true;
	}

	private static int[] buildCharFrequencyTable(String phrase) {
		if (phrase == null) 
			return null;
		
		int[] char_set = new int[128];
		for (int i = 0; i < phrase.length(); i++) {
			char_set[phrase.charAt(i)]++;
		}
		return char_set;
	}
	/*
	 * solution 1: 修改：
	 * 1. 两种状态标识用布尔值，可以节省内存
	 * 2. 逻辑判断尽量整合，减少判断次数
	 */
	public static boolean isPermutationOfPalindrome1(String str) {
		int[] table = Common.buildCharFrequencyTable(str);
		return checkMaxOneOdd1(table);
	}
	
	private static boolean checkMaxOneOdd1(int[] table) {
		boolean foundOdd = false;
		for (int count: table) {
			if (count % 2 == 1) {
				if (foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}
	
	/*
	 * solution 2: 两步同时进行,不一定优于1
	 * 第一步： 建立词频表
	 * 第二步：判断词频为奇数的字符个数是否超过1个
	 * 时间复杂度O(n)
	 * 空间复杂度O(n)
	 */
	public static boolean isPermuationOfPalidrome2(String str) {
		int countOdd = 0;
		int[] table = new int[Common.getCharNumber('z') - 
		                    Common.getCharNumber('a') + 1];
		for (char c: str.toCharArray()) {
			int x = Common.getCharNumber(c);
			table[x]++;
			if (table[x] % 2 == 1) {
				countOdd++;
			} else {
				countOdd--;
			}
		}
		return countOdd <= 1;
	}
	
	/*
	 * solution 3: 实际上我们不需要计算字符频率，只需要知道各个字符出现的次数为偶数次或奇数次
	 * 			我们又可以使用位向量来存储各个字符出现是否为偶数次或奇数次，分别用0和1表示即可；
	 *          然后，遍历这个位向量，如果至少出现了两个位为1，则其不是回文的一个排列
	 *          
	 *          可以使用一个int来存储位向量
	 */
	public static boolean isPermutaionOfPalindrome3(String str) {
		boolean odd = false;
		int vec = buildCharFreqOddEvenBitVector(str);
		for (int i = 0; i < 26; i++) {
			if ( (vec & (1 << i)) != 0) {
				if (odd == true) {
					return false;
				}
				odd = true;
			}
		}
		return true;
	}
	
	private static int buildCharFreqOddEvenBitVector(String str) {
		int vec = 0;
		for (char c: str.toCharArray()) {
			int mask = (1 << Common.getCharNumber(c));
			vec ^= mask;  //一个位与0亦或为其本身，与1亦或为其相反
		}
		return vec;
	}


	public static void main(String args[]) {
		String str = "abccdbaaaaaddc";
		System.out.println(str+": "+isPermutaionOfPalindrome3(str));
	}
}
