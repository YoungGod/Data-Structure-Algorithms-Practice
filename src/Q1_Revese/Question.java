package Q1_Revese;

/**
 * 1. 反转字符串，使用字符数组
 * 2. 反转单词：you are pig -> pig are you
 * @author Young
 *
 */
public class Question {
	
	public static void reverseStr(char[] str) {
		int end = str.length-1;
		int start = 0;
		while (start < end) {
			char temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}
	
	public static String reverseSentence(String str) {
		char[] arr = str.toCharArray();
		reverseStr(arr);
		int end = 0;
		int start = 0;
		char temp;
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] == ' ') || ((i+1) >= arr.length)) {
				if (i+1>=arr.length)
					end = i;
				else 
					end = i - 1;
				while(start < end) {
					temp = arr[start];
					arr[start] = arr[end];
					arr[end] = temp;
					start++;
					end--;
				}
				start = i + 1;			
			}
		}
		return new String(arr, 0, arr.length);
	}
	
	public static void main(String args[]) {
		String str = "you are pig.";
		char[] arr = str.toCharArray();
		reverseStr(arr);
		System.out.println(arr);
		
		String sentence = "you are pig.";
		System.out.println(reverseSentence(sentence));
	}

}
