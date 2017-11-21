package Q11_01_Search_RotateArray;

/**
 * ���⣺����������һ�����飬����n������������������ѱ���ת���ܶ�Ρ��ҳ�������ĳ��Ԫ�ء�
 * ���룺13��14��15�� 16�� 19�� 1��2��3��8��10
 * �����4 ������2��
 * @author Young
 *
 */
public class Question {

	/*
	 * solution: �����޸ĵĶ��������㷨
	 * 		1. ����mid = (low+high) / 2
	 * 		2. ���midԪ��С��highԪ�أ���midС��key������(mid+1, high)������ж���������
	 * 			������(low, mid-1)���еݹ�����		
	 * 		3. ���midԪ�ش���highԪ�أ���mid����key������(low, mid-1)������ж�������
	 * 			������(mid+1, high)���� �ݹ�����
	 */
	public static int searchRotateArray(int[] arr, int key, int low, int high) {
		if (low > high) return -1;
		int mid = (low + high) / 2;
		if (arr[mid] < arr[high]) {
			if (arr[mid] < key) {
				return binarySearch(arr, key, mid+1, high);
			} else if (arr[mid] > key) {
				return searchRotateArray(arr, key, low, mid-1);
			} else return mid;
		} else {
			if (arr[mid] > key) {
				return binarySearch(arr, key, low, mid-1);
			} else if (arr[mid] < key) {
				return searchRotateArray(arr, key, mid+1, high);
			} else return mid;
		}
	}

	private static int binarySearch(int[] arr, int key, int low, int high) {
		if (low > high) return -1;
		int mid = (low + high) / 2;
		if (arr[mid] < key) return binarySearch(arr, key, mid+1, high);
		else if (arr[mid] > key) return binarySearch(arr, key, low, mid-1);
		else return mid;
	}
	
	public static void main(String args[]) {
		int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		System.out.println(searchRotateArray(arr, 5, 0, arr.length-1));
	}
}
