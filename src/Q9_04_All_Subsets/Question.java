package Q9_04_All_Subsets;

import java.util.ArrayList;

/**
 * 问题： 计算某集合的所有子集。（包括空集）
 * @author Young
 *
 */
public class Question {
	
	/*
	 * solution 1: 构造法，为求p(n)的子集，先求p(n-1)的子集，然后使用p(n-1)的子集与{n}构造另一部分p(n)的子集。
	 * 算法： （1）求p(n-1)的子集；
	 * 		（2）使用p(n-1)的子集与{n}构建p(n)的包含{n}的子集；
	 * 		（3）合并（1），（2）;
	 * 		（4）递归，直至子集为空.
	 * 
	 * 常规思路：正向构建
	 */
	
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> arrSets = new ArrayList<ArrayList<Integer>>();
		if (index < 0) {
			arrSets.add(new ArrayList<Integer>());
			return arrSets;
		}
		
		/*（1）求p(n-1)的子集*/
		arrSets = getSubsets(set, index - 1);
		
		/*（2）使用p(n-1)的子集与{n}构建p(n)的包含{n}的子集*/
		ArrayList<ArrayList<Integer>> arrSetsMore = new ArrayList<ArrayList<Integer>>();
		
/*
		for (ArrayList<Integer> s: arrSets) {

			ArrayList<Integer> newSubset = new ArrayList<Integer>();   //求并集的时候要注意，需要重新指派一个arraylist，python不需要！
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
	 * solution 2：枚举二进制数，每一位0或1代表某个元素是否在该集合中
	 */
	
	public static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		int max = 1 << set.size();  // 计算所有子集数2^n
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
			                    // NOTE！！！
			s.add(0);			// s的操作修改了arrList中的元素!!!!这是使用引用需要注意的问题，s为arrList中元素的引用，并非复制
			arrList1.add(s);    // 使用java，python时需要特别注意这点，当使用嵌套列表时，这里为动态数组！！！
			
		}
		System.out.println("resutl:");
		System.out.println("1: "+arrList1);
		System.out.println("2: "+arrList);
		arrList.addAll(arrList1);
		System.out.println("1+2: "+arrList);		
		
	}
}