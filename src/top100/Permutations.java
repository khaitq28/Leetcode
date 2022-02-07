package top100;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(1);list.add(2); list.add(3);list.add(4);
//		System.out.print(permute(list));
		
		int[] nums = new int[]{1,2,3};
		List<List<Integer>> res = permute(nums);
		System.out.print(res);
	}

	// 1  2 3  
	// 1  3 2
    public  static List<List<Integer>> permute(List<Integer> nums) {
     
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	
    	if (nums.size() == 2) {
    		List<Integer> l1 = new ArrayList<>(Arrays.asList(nums.get(0), nums.get(1)));  
    		List<Integer> l2 = new ArrayList<>(Arrays.asList(nums.get(1), nums.get(0))); 
    		res.add(l1); res.add(l2);
    		return res;
    	}
    	
    	for (Integer c : nums) {
    		
    		List<Integer> t = new ArrayList<Integer>(nums);
    		t.remove(c);
    		
    		List<List<Integer>> sub = permute(t);
    		for (List<Integer> subsub : sub) {
    			List<Integer> l1 = new ArrayList<Integer>(subsub);
    			l1.add(c);
    			res.add(l1);
    		}
    	}
    	
    	return res;
    }
    
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, result, new ArrayList<Integer>(), new HashSet<Integer>());
        
        return result;
    }
    
    private static void backtracking(int[] nums, List<List<Integer>> result, List<Integer> permutation, Set<Integer> memory) {
        if(permutation.size() == nums.length) {
            result.add(new ArrayList<Integer>(permutation));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            
            if(!memory.contains(curr)) {
                memory.add(curr);
                permutation.add(curr);
                
                backtracking(nums, result, permutation, memory);
                
                memory.remove(curr);
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
