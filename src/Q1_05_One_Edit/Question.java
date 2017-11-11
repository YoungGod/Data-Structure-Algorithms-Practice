package Q1_05_One_Edit;


/**
 * �ж������ַ����Ƿ�ֻ��һ����𣨻����һ���ַ�����ɾ��һ���ַ������滻һ���ַ���
 * @author Young
 *
 */
public class Question {
	
	/*
	 * my solution: 1. ͳ���ַ����и����ַ�����Ƶ��
	 * 				2. �жϣ��������Ƶ�ʱ���Ƶ�ʲ���Ϊ1���������ַ���ֻ��һ�����
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
	 * solution 2: ����1��Щ������ʵ������û�б�Ҫͳ���ַ�Ƶ��!!��
	 * 				����˳��Ƚϣ�ֻҪ��һ����ͬ��𼴿ɣ��ֱ�Բ�ͬ�Ĳ�����д���
	 * 				���ݳ��ȵĲ�ͬ����Ϊ���ֻ����������
	 * 				ģ�黯����
	 */
	public static boolean isOneEditAway1(String first, String second) {
		if (first.length() == second.length()) { //���������ȣ��б��Ƿ����滻����
			return oneEditReplace(first, second);
		} else if (first.length() + 1 == second.length()) { //����ȣ��б��Ƿ�������
			return oneEditInsert(first, second);			//���ߺ��ַ�����
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
