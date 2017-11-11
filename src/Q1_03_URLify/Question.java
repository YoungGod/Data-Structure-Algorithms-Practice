package Q1_03_URLify;


/**
 *  �ַ������
 *  ����  20% ��� "you are pig"�еĿհ� "you20%are20%pig"
 *
 * @author Young
 *
 */
public class Question {

	public static void replaceSpaces(char[] str, int trueLength) {
		// ����հ��ַ�����
		int spaceCount = 0;
		for (int i = 0; i < trueLength; i++) {
			if (str[i] == ' ')
				spaceCount++;
		}
		//�����滻���ַ�������
		int length = trueLength + spaceCount*2;
		
		//���ַ������ʼ���ν����滻
		for (int i = trueLength-1, j = length-1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[j--] = '%';
				str[j--] = '0';
				str[j--] = '2';
			} else {
				str[j--] = str[i];				
			}
		}
	}
	
	public static void replaceSpacesAny(char[] str, int trueLength, String tostr) {
		// ����հ��ַ�����
		int spaceCount = 0;
		for (int i = 0; i < trueLength; i++) {
			if (str[i] == ' ')
				spaceCount++;
		}
		//�����滻���ַ�������
		int length = trueLength + spaceCount*2;
		
		//���ַ������ʼ���ν����滻
		for (int i = trueLength-1, j = length-1; i >= 0; i--) {
			if (str[i] == ' ') {
				// ��tostr���һ���ַ���ʼ��ǰ���
				for (int k = tostr.length()-1; k >= 0;) {
					str[j--] = tostr.charAt(k--);
				}
			} else {
				str[j--] = str[i];				
			}
		}
	}
	
	public static int findLastCharcter(char[] str) {
		for (int i = str.length - 1; i >= 0; i--) {
			if (str[i] != ' ') {
				return i+1;
			}
		}
		return -1;
	}
	
	public static void main(String args[]) {
		String str = "you are pig       ";
		char[] arr = str.toCharArray();
		//replaceSpaces(arr, findLastCharcter(arr));
		System.out.println(new String(arr));
		replaceSpacesAny(arr, findLastCharcter(arr), "%%%");
		System.out.println(new String(arr));
	}
}
