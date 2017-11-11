package Q9_04_All_Subsets;

import java.util.ArrayList;

/**
 * ���⣺ ����ĳ���ϵ������Ӽ����������ռ���
 * @author Young
 *
 */
public class Question {
	
	/*
	 * solution 1: ���취��Ϊ��p(n)���Ӽ�������p(n-1)���Ӽ���Ȼ��ʹ��p(n-1)���Ӽ���{n}������һ����p(n)���Ӽ���
	 * �㷨�� ��1����p(n-1)���Ӽ���
	 * 		��2��ʹ��p(n-1)���Ӽ���{n}����p(n)�İ���{n}���Ӽ���
	 * 		��3���ϲ���1������2��;
	 * 		��4���ݹ飬ֱ���Ӽ�Ϊ��.
	 * 
	 * ����˼·�����򹹽�
	 */
	
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> arrSets = new ArrayList<ArrayList<Integer>>();
		if (index < 0) {
			arrSets.add(new ArrayList<Integer>());
			return arrSets;
		}
		
		/*��1����p(n-1)���Ӽ�*/
		arrSets = getSubsets(set, index - 1);
		
		/*��2��ʹ��p(n-1)���Ӽ���{n}����p(n)�İ���{n}���Ӽ�*/
		ArrayList<ArrayList<Integer>> arrSetsMore = new ArrayList<ArrayList<Integer>>();
		
/*
		for (ArrayList<Integer> s: arrSets) {

			ArrayList<Integer> newSubset = new ArrayList<Integer>();   //�󲢼���ʱ��Ҫע�⣬��Ҫ����ָ��һ��arraylist��python����Ҫ��
			newSubset.addAll(s);
			System.out.println(newSubset);
			
			newSubset.add(set.get(index));
			System.out.println(newSubset);
			
			arrSetsMore.add(newSubset);
			System.out.println(arrSetsMore);
		}
*/		
		
		for (int i = 0; i < arrSets.size(); i++) {
			ArrayList<Integer> s = arrSets.get(i);
			System.out.println("s:"+s);
			s.add(set.get(index));
			System.out.println("s.add: "+s);
			arrSetsMore.add(s);
			System.out.println("arrSetsMore:"+s);
		}
		
		arrSets.addAll(arrSetsMore);
		return arrSets;
	}
	
	/*
	 * solution 2��ö�ٶ���������ÿһλ0��1����ĳ��Ԫ���Ƿ��ڸü�����
	 */
	
	public static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size();  // ���������Ӽ���2^n
		for (int k = 0; k < max; k++) {
			ArrayList<Integer> subset = convertIntToSet(k, set);
			allsubsets.add(subset);
		}
		return allsubsets;
	}
	
	private static ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int index = 0;
		for (int k = x; k > 0; k >>= 1) {
			if ((k&1) == 1) {
				subset.add(set.get(index));
			}
			index++;
		}
		return null;
	}

	public static void main(String args[]) {
		ArrayList<Integer> set = new ArrayList<Integer>();
		System.out.println(set.size());
		set.add(1);
		set.add(2);
		set.add(3);
		ArrayList<ArrayList<Integer>> arrSets;
		arrSets = getSubsets(set, set.size()-1);
		System.out.println(arrSets.toString());
		
		ArrayList<ArrayList<Integer>> arrList = new ArrayList<ArrayList<Integer>>();
		arrList.add(set);
		
		ArrayList<Integer> set1 = new ArrayList<Integer>();
		set1.add(4);
		set1.add(5);
		
		arrList.add(set1);
		System.out.println(arrList);
		
		//set1.addAll(set);
		//System.out.println(set1);
		
		ArrayList<ArrayList<Integer>> arrList1 = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> s: arrList) {
			/*
			ArrayList<Integer> news = new ArrayList<Integer>();
			news.addAll(s);
			news.add(0);
			arrList1.add(news);
			*/
			                    // NOTE������
			s.add(0);			// s�Ĳ����޸���arrList�е�Ԫ��!!!!����ʹ��������Ҫע������⣬sΪarrList��Ԫ�ص����ã����Ǹ���
			arrList1.add(s);    // ʹ��java��pythonʱ��Ҫ�ر�ע����㣬��ʹ��Ƕ���б�ʱ������Ϊ��̬���飡����
			
		}
		System.out.println("resutl:");
		System.out.println("1: "+arrList1);
		System.out.println("2: "+arrList);
		arrList.addAll(arrList1);
		System.out.println("1+2: "+arrList);		
		
	}
}