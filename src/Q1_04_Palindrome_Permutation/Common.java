package Q1_04_Palindrome_Permutation;
/**
 * 1. ����һ���ַ�ӳ���'a'-'z' ӳ�䵽��ֵ 0-25
 * 2. ����һ���ַ�Ƶ��ͳ�Ʊ������鱣��
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
