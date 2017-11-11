package Q9_09_Eight_Queen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ���⣺8�ʺ�����.
 * @author Young
 *
 */
public class Question {
	
	public static int GRID_SIZE = 8;
	
	public static void EightQueen(int[] columns, int row, int col, ArrayList<int[]> result) {
		if (row == GRID_SIZE) {
			result.add(columns.clone());  // ������ֹ��������ӡ���лʺ����λ����Ϣ
		}
		for (col = 0; col < GRID_SIZE; col++) {
			if (isValid(columns, row, col)) {
				columns[row] = col;		// �����ǰλ�ÿ��԰ڷŻ��󣬼�¼����������λ��
				EightQueen(columns, row + 1, col, result);
			}
		}
	}
	
	private static boolean isValid(int[] columns, int row, int col) {
		int row_before, col_before;
		for (row_before = 0; row_before < row; row_before++) {
			col_before = columns[row_before];
			
			/* ͬ�� */
			if (col_before == col) {
				return false;
			}
			
			/* ͬ�Խ��� ���о�����оࣩ*/
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
		
		// array ת list
		List list1;
		// ԭ�������Ϊlist��һ��Ԫ��
		list1 = Arrays.asList(columns);
		System.out.println(list1);
		
		// ԭ������Ԫ�س�Ϊlist��Ԫ��
		List list2 = new ArrayList<Integer>();
		for (int i = 0; i < columns.length; i++) {
			list2.add(columns[i]);
		}
		System.out.println(list2);
		
		// listԪ��ֻ��ת��Ϊ��������Ԫ��
		Integer[] columns2 = new Integer[list2.size()];
		list2.toArray(columns2);
		System.out.println(columns2);
		
		Object[] columns3 = list2.toArray();
		System.out.println(columns3);
		
		// ��������ת��Ϊԭ������Ԫ�أ�����
		for (int i = 0; i < columns3.length; i++) {
			columns[i] = (int)columns3[i];			// ����
		}
	}
}
