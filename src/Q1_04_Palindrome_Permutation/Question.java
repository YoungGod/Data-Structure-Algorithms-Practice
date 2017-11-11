package Q1_04_Palindrome_Permutation;

/**
 * �ж�һ���ַ����Ƿ��ǻ����ַ�����һ������
 * �� "abccba" : "aabbcc"(true)
 * @author Young
 *
 */
public class Question {
	
	/*
	 * solution 1: 
	 * ��һ���� ������Ƶ��
	 * �ڶ������жϴ�ƵΪ�������ַ������Ƿ񳬹�1��
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
	 * solution 1: �޸ģ�
	 * 1. ����״̬��ʶ�ò���ֵ�����Խ�ʡ�ڴ�
	 * 2. �߼��жϾ������ϣ������жϴ���
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
	 * solution 2: ����ͬʱ����,��һ������1
	 * ��һ���� ������Ƶ��
	 * �ڶ������жϴ�ƵΪ�������ַ������Ƿ񳬹�1��
	 * ʱ�临�Ӷ�O(n)
	 * �ռ临�Ӷ�O(n)
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
	 * solution 3: ʵ�������ǲ���Ҫ�����ַ�Ƶ�ʣ�ֻ��Ҫ֪�������ַ����ֵĴ���Ϊż���λ�������
	 * 			�����ֿ���ʹ��λ�������洢�����ַ������Ƿ�Ϊż���λ������Σ��ֱ���0��1��ʾ���ɣ�
	 *          Ȼ�󣬱������λ������������ٳ���������λΪ1�����䲻�ǻ��ĵ�һ������
	 *          
	 *          ����ʹ��һ��int���洢λ����
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
			vec ^= mask;  //һ��λ��0���Ϊ�䱾����1���Ϊ���෴
		}
		return vec;
	}


	public static void main(String args[]) {
		String str = "abccdbaaaaaddc";
		System.out.println(str+": "+isPermutaionOfPalindrome3(str));
	}
}
