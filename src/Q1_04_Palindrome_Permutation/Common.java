package Q1_04_Palindrome_Permutation;
/**
 * 1. 构建一个字符映射表：'a'-'z' 映射到数值 0-25
 * 2. 构建一个字符频率统计表，用数组保存
 * @author Young
 *
 */
public class Common {
	
	public static int getCharNumber(Character c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		
		int val = Character.getNumericValue(c);
		if (a <= val && val <= z)
			return val - a;
		return -1;
	}
	
	public static int[] buildCharFrequencyTable(String str) {
		int[] table = new int[getCharNumber('z') - 
		                      getCharNumber('a') + 1];
		for (char c: str.toCharArray()) {
			int x = getCharNumber(c);
			if (x != -1)
				table[getCharNumber(c)]++;
		}
		return table;
	}
}
