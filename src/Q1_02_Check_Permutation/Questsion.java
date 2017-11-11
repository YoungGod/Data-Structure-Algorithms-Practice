package Q1_02_Check_Permutation;

/**
 * �ж������ַ����Ƿ������ͬ���ַ�
 * @author Young
 *
 */

public class Questsion {
	
	/*
	 * solution 1: ͨ������Ȼ���ٱȽ��ַ��Ƿ���ͬ
	 */
	public static String sort(String s) {
		char[] content = s.toCharArray();
		java.util.Arrays.sort(content);
		return new String(content);
	}
	
	public static boolean permutation1(String s, String t) {
		return sort(s).equals(sort(t));
	}
	
	/*
	 * solution 2: �ж������ַ������Ƿ������ͬ���ַ�����
	 */
	public static boolean permutation2(String s, String t) {
		if (s.length() != t.length())
			return false;
		
		int[] letters = new int[128];  //�ַ�����
		
		for (int i = 0; i < s.length(); i++) {
			letters[s.charAt(i)]++;
		}
		
		for (int i = 0; i < t.length(); i++) {
			if (--letters[t.charAt(i)] < 0)
				return false;
		}
		return true;
	}
	
	public static void main(String args[]) {
		String s = "ddog";
		String t = "godd";
		System.out.println(s+" & "+t+": "+permutation1(s, t));
		System.out.println(s+" & "+t+": "+permutation2(s, t));
	}

}
