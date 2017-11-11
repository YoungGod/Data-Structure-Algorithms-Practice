package Q1_06_Compression;


/**
 * 字符串压缩：aaabbccc -> a3b2c3
 * @author Young
 *
 */
public class Question {
	
	public static String strCompression(String str) {
		if (str.length() <= 2) return str;
		
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			// 连续计数从1开始
			countConsecutive++;
			
			//如果下一个字符不同于当前字符或当前字符为最后一个字符，拷贝
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i+1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.length() < str.length() ? compressed.toString() : str;
	}
	
	public static int countCompression(String str) {
		int compressedLength = 0;
		//int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			//countConsecutive++;
			if (i+1>=str.length() || str.charAt(i) != str.charAt(i+1)) {
				compressedLength += 1 + 1;
				//countConsecutive = 0;
			}
		}
		return compressedLength;
	}
	
	public static void main(String args[]) {
		String str = "aabbcc111122";
		System.out.println(countCompression(str));
		System.out.println(strCompression(str));
	}

}
