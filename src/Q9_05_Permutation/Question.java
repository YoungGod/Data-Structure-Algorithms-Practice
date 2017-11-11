package Q9_05_Permutation;

import java.util.ArrayList;

/**
 * ���⣺����һ���ַ��������ظ��ַ���������������������ϡ�
 * @author Young
 * ������ظ��ַ����� ��ô�죿���ѽ��������hash���У�Ȼ���ٹ���pemutation�����в����Ƿ���������hash���У�
 * ab ba
 * bab abb abb
 * bba bba bab
 * bab abb bba
 */
public class Question {
	
	public static ArrayList<String> strPermutation(String str, int index) {
		ArrayList<String> permutation = new ArrayList<String>();
		if (index == 0) {
			//permutation.add(String.valueOf(str.charAt(index)));
			permutation.add(str.substring(0,1));
			return permutation;
		}
		permutation = strPermutation(str, index - 1);
		ArrayList<String> result = new ArrayList<String>();
		for (String substr: permutation) {
			ArrayList<String> arrStr = subPermutation(substr, str.charAt(index));
			result.addAll(arrStr);
		}
		return result;
	}

	private static ArrayList<String> subPermutation(String substr, char ch) {
		/*���ַ�ch�����ַ���subStr������λ��*/
		ArrayList<String> arrStr = new ArrayList<String>();
		for (int i = 0; i <= substr.length(); i++) {
			arrStr.add(insertChar1(substr, ch, i));
		}
		//System.out.println(arrStr.toString());
		return arrStr;
	}
	
    /*ʹ���������*/
	private static String insertChar(String substr, char ch, int index) {
		/*���ַ�ch�����ַ���subStr��indexλ��*/
		//System.out.println(substr);
		StringBuffer strBuffer = new StringBuffer();
		for (int i = 0; i < index; i++) {
			strBuffer.append(substr.charAt(i));
		}
		strBuffer.append(ch);
		//System.out.println(strBuffer.toString());
		for (int i = index; i < substr.length(); i++) {
			strBuffer.append(substr.charAt(i));
		}
		//System.out.println(strBuffer.toString());
		return strBuffer.toString();
	}
	
	/*ʹ���ַ�������*/
	private static String insertChar1(String subStr, char ch, int index) {
		String start = subStr.substring(0,index);
		String end = subStr.substring(index);
		return start + ch + end;
	}
	
	
	public static void main(String args[]) {
		String str = "are";
		ArrayList<String> result = strPermutation(str, str.length()-1);
		System.out.println(result.size());
		System.out.println(result.toString());
		System.out.println(str.substring(1));
		char ch = 'c';
		System.out.println(""+ch);
	}
}