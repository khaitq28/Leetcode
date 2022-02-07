package top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {

	public static void main(String[] args) {

		String s = "ababcbacadefegdehijhklij";
		
		
		System.out.print(partitionLabels2(s));
		
	}
	
	/**
	 * You are given a string s. 
	 *  We want to partition the string into as many parts as possible so that each letter appears in at most one part.
		Return a list of integers representing the size of these parts.
		Input: s = "ababcbaca defegde hijhklij"
		Output: [9,7,8]
		Explanation:
		The partition is "ababcbaca", "defegde", "hijhklij".
	 */
	
    public static List<Integer> partitionLabels(String s) {
    	
    	List<Integer> res = new ArrayList<Integer>();
    	Map<Character, int[]> map = new HashMap<Character,  int[]>();
    	char[] arr = s.toCharArray();
    	for (int i = 0; i < arr.length; i ++) {
    		char c = arr[i];
    		if(map.get(c) == null) {
    			map.put(c, new  int[2]);
    			map.get(c)[0] = i;
    			map.get(c)[1] = i;
    		} else {
    			map.get(c)[1] = Math.max(i, map.get(c)[1]);
    		}
    	}
    	
    	int a = Integer.MAX_VALUE; int b = 0;
    	for (int i = 0; i < arr.length; i ++) {
    		char c = arr[i];
    		int[] list = map.get(c);
    		a = Math.min(a,list[0]);
    		b = Math.max(b,list[1]);
    		if (i == b) {
    			res.add(b - a + 1);
    			a = Integer.MAX_VALUE; 
    			b = 0;
    			continue;
    		}
    	}
    	return res;
    }
    
    /**
     *  Input: s = "ababcbacadefegdehijhklij"
		Output: [9,7,8]
		Explanation:
		The partition is "ababcbaca", "defegde", "hijhklij".
     * @param s
     * @return
     */
    public static List<Integer> partitionLabels2(String s) {
    	List<Integer> res = new ArrayList<Integer>();
    	
    	char[] arr = s.toCharArray();
    	int a = 0;
    	int b = -1;
    	for(int i = 0; i < arr.length; i++) {
    		char c = arr[i];
    		b = Math.max(b, s.lastIndexOf(c));
    		if (i== b) {
    			res.add(b - a + 1);
    			a = i + 1;
    			b = -1;
    			continue;
    		}
    	}
    	return res;
    }
    
    
}
