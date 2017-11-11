package Q1_Int_Str;


/**
 * ����ת�ַ�����
 * -1234 -> "-1234"
 * @author Young
 *
 */
public class Question {
	public static final int MAX_DIGITS = 10;
	
	/* bug: ��numIntΪ0ʱ��Ϊ���ַ�����ʹ��do..while*/
	public static String intToStr(int numInt) {
		boolean neg = false;
		if (numInt < 0) {
			neg = true;
			numInt = -numInt;
		}
		char[] ch = new char[MAX_DIGITS];
		int index = ch.length;
		char c;
		while(numInt != 0) {
			c = (char)(numInt % 10  + '0');
			ch[--index] = c;
			numInt /= 10;
		}
		if (neg) {
			ch[--index] = '-';
		}
		return new String(ch, index, ch.length-index);
	}
	
	public static String intToStrNoBug(int numInt) {
		boolean neg = false;
		if (numInt < 0) {
			neg = true;
			numInt = -numInt;
		}
		char[] ch = new char[MAX_DIGITS];
		int index = ch.length;
		char c;
		do {
			c = (char)(numInt % 10  + '0');
			ch[--index] = c;
			numInt /= 10;
		} while(numInt != 0);
		if (neg) {
			ch[--index] = '-';
		}
		return new String(ch, index, ch.length-index);
	}
	
	public static void main(String args[]) {
		int num = -12345;
		System.out.println(intToStr(num));
	}
}
