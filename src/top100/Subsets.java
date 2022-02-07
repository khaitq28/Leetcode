package top100;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Subsets {

	public static void main(String[] args) {
		
		
		int[] arr = new int[] {3,2,4,1};
		 List<Integer> t =  Arrays.stream(arr).boxed().collect(Collectors.toList());
		
		System.out.println(subsets(t));
		
		
	}

	/**
	 * Given an integer array nums of unique elements, return all possible subsets (the power set).
	The solution set must not contain duplicate subsets. Return the solution in any order.
	
	Example 1:
	Input: nums = [1,2,3]
	Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
	
 {3,2,4,1};
 32 24 41
 12 24 43

	 */
	
    public static List<List<Integer>> subsets(List<Integer> nums) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	for (int i = 1; i <= nums.size(); i ++) {
    		res.addAll(allSubOfKElement(i, nums));
    	}
    	return res;
    }

	private static List<List<Integer>> allSubOfKElement(int k,List<Integer> nums) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (k == nums.size()) {
			res.add(nums);
			return res;
		}
		List<Integer> sub = new  ArrayList<Integer>(nums.subList(0, k - 1));
		List<Integer> both = new ArrayList<Integer>(nums);
		both.addAll(sub);
		
		for (int i = 0; i < nums.size(); i ++) {
			List<Integer> list = new  ArrayList<Integer>(both.subList(i, i + k));
			res.add(list);
			
		}
		return res;
	}
	
	// 1 2 3 4 => 12 13 14 23 24 34
	// 1 2 => 12 
	// 1 2 3 => 13 23
	private static List<List<Integer>> allSubOfK(int k,List<Integer> nums) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		
		
		return res;
	}
    
	
}
