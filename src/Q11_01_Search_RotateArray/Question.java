package Q11_01_Search_RotateArray;

/**
 * 问题：给定排序后的一个数组，包含n个整数，但这个数组已被旋转过很多次。找出数组中某个元素。
 * 输入：13，14，15， 16， 19， 1，2，3，8，10
 * 输出：4 （查找2）
 * @author Young
 *
 */
public class Question {

	/*
	 * solution: 采用修改的二分搜索算法
	 * 		1. 计算mid = (low+high) / 2
	 * 		2. 如果mid元素小于high元素，且mid小于key，则在(mid+1, high)区间进行二分搜索；
	 * 			否则，在(low, mid-1)进行递归搜索		
	 * 		3. 如果mid元素大于high元素，且mid大于key，则在(low, mid-1)区间进行二分搜索
	 * 			否则，在(mid+1, high)进行 递归搜索
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
