package Q9_09_Eight_Queen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 问题：8皇后问题.
 * @author Young
 *
 */
public class Question {
	
	public static int GRID_SIZE = 8;
	
	public static void EightQueen(int[] columns, int row, int col, ArrayList<int[]> result) {
		if (row == GRID_SIZE) {
			result.add(columns.clone());  // 搜索终止，保存或打印各行皇后的列位置信息
		}
		for (col = 0; col < GRID_SIZE; col++) {
			if (isValid(columns, row, col)) {
				columns[row] = col;		// 如果当前位置可以摆放还后，记录其所处的列位置
				EightQueen(columns, row + 1, col, result);
			}
		}
	}
	
	private static boolean isValid(int[] columns, int row, int col) {
		int row_before, col_before;
		for (row_before = 0; row_before < row; row_before++) {
			col_before = columns[row_before];
			
			/* 同列 */
			if (col_before == col) {
				return false;
			}
			
			/* 同对角线 （列距等于行距）*/
			int colDistance = Math.abs(col_before - col);
			int rowDistance = row - row_before;
			if (colDistance == rowDistance) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]) {
		int[] columns = new int[GRID_SIZE];
		ArrayList<int[]> result = new ArrayList<int[]>();
		EightQueen(columns, 0, 0, result);
		System.out.println("counts: "+result.size());
		for (int[] item: result) {
			System.out.println(Arrays.toString(item));
		}
		
		ArrayList<Integer> arrInt = new ArrayList<Integer>();
		arrInt.add(1);
		arrInt.add(2);
		System.out.println(arrInt);
		System.out.println(Arrays.toString(columns));
		
		// array 转 list
		List list1;
		// 原型数组成为list的一个元素
		list1 = Arrays.asList(columns);
		System.out.println(list1);
		
		// 原型数组元素成为list的元素
		List list2 = new ArrayList<Integer>();
		for (int i = 0; i < columns.length; i++) {
			list2.add(columns[i]);
		}
		System.out.println(list2);
		
		// list元素只能转化为对象数组元素
		Integer[] columns2 = new Integer[list2.size()];
		list2.toArray(columns2);
		System.out.println(columns2);
		
		Object[] columns3 = list2.toArray();
		System.out.println(columns3);
		
		// 对象数组转化为原型数组元素，拆箱
		for (int i = 0; i < columns3.length; i++) {
			columns[i] = (int)columns3[i];			// 拆箱
		}
	}
}
