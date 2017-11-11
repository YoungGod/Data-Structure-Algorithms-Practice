package Q9_02_Robot;

import java.util.ArrayList;

/**
 * ���⣺�����˴�(0,0) -> (X,Y)���ж������߷���ֻ�����ϻ������ƶ���
 *       ���ĳЩ��Ϊ�����أ�
 * @author Young
 *
 */
public class Question {
	
	/*
	 * solution 1:��ٷ������������������������
	 *            ���Թ�����
	 */
	public static class Result {
		public int count = 0;
	}
	/*״̬����s������0��ʾ���ң�����1��ʾ����*/
	public static void movePath(int[] state, int X, int Y, Result result) {
		if (state[0] == X || state[1] == Y) {
			result.count++;
			return;
		}
		for (int i = 0; i < state.length;  i++) {
			state[i] += 1;
			movePath(state, X, Y, result);
			state[i] -= 1;
		}
	}
	
	/*��Щ��Ϊ����: ��(1,1),(1,2)*/
	public static void movePath2(int[] state, int X, int Y, int[] xforbidden, int[] yforbidden, Result result) {
		/*
		if (state[0] == X && state[1] == Y) {
			result.count++;
			return;
		}
		*/
		if (state[0] == X && state[1] != Y) {
			for (int i = 0; i < Y - state[1]; i++) {
				if (isForbidden(state[1], yforbidden)) return;
				else state[1] += 1;
			}
			result.count++;
			return;
		}
		if (state[1] == Y && state[0] != X) {
			for (int i = 0; i < X - state[0]; i++) {
				if (isForbidden(state[0], xforbidden)) return;
				else state[0] += 1;
			}
			result.count++;
			return;
		}
		
		for (int i = 0; i < state.length;  i++) {
			state[i] += 1;
			if (!isSForbidden(state, xforbidden, yforbidden))
				movePath2(state, X, Y, xforbidden, yforbidden, result);
			state[i] -= 1;
		}
	}
	/*����ʱ״̬����ȡֵ�Ƿ�Ϊ�����㣬������ʹ������һά�����ʾ*/
	private static boolean isSForbidden(int[] state, int[] xforbidden, int[] yforbidden) {
		return isForbidden(state[0], xforbidden) && isForbidden(state[1], yforbidden);
	}

	private static boolean isForbidden(int s, int[] xforbidden) {
		for (int i = 0; i < xforbidden.length; i++) {
			if (s == xforbidden[i]) {
				//System.out.println(s);
				return true;
			}
		}
		return false;
	}
	
	/*
	 * solution 2: ����˼ά�����϶��£����յ�ݹ鵽���
	 */
	public static ArrayList<Point> getPath(boolean[][] maze) {
		if (maze == null || maze.length ==0) return null;
		ArrayList<Point> path = new ArrayList<Point>();
		if (getPath(maze, maze.length - 1, maze[0].length - 1, path)) {
			return path;
		}
		
		return null;
	}

	
	private static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path) {
		// if out of bounds or not available, return
		if (col < 0 || row < 0 || !maze[row][col]) {
			return false;
		}
		
		boolean isAtOrigin = (row == 0) && (col == 0);
		
		// if there's path from the start to current location, add this location
		if (isAtOrigin || getPath(maze, row, col - 1, path) || getPath(maze, row - 1, col, path)) {
			Point p = new Point(row, col);
			path.add(p);
			return true;
		}
		
		return false;
	}

	public static void main(String args[]) {
		int[] state = {0,0};
		Result result1 = new Question.Result();
		
		movePath(state, 3, 3, result1);
		System.out.println(result1.count);
		
		int[] xforbidden = {1,1};
		int[] yforbidden = {1,2};
		
		Result result2 = new Question.Result();
		movePath2(state, 3, 3, xforbidden, yforbidden, result2);
		System.out.println(result2.count);
	}

}
 