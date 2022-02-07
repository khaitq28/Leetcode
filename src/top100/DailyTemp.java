package top100;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class DailyTemp {
	
	
	/**
	 * Given an array of integers temperatures represents the daily temperatures, 
	 * return an array answer such that answer[i] is the number of days you have to wait after the ith day 
	 * to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

		Input: temperatures = [73,74,75,71,69,72,76,73]
		Output: [1,1,4,2,1,1,0,0]
	 */
	
	public static void main(String[] ars) {
		
		int[] temperatures = new int[] {73,74,75,71,69,72,76,73};
		
		//[8,1,5,4,3,2,1,1,0,0]
		
		System.out.print(Arrays.stream(dailyTemperatures2(temperatures)).boxed().collect(Collectors.toList()));
	
		
		String s = "abcdefg";
		
		reverseString(s.toCharArray());
		
	}
	
    public static void reverseString(char[] s) {
    	revert(s, 0, s.length - 1);
    	
    	System.out.println("");
    	
    	for (char c: s) {
    		System.out.println(c);
    	}
    }
	
	private static void revert(char[] s, int i, int j) {
		if (i == j) return;
		char c = s[i];
		s[i] = s[j];
		s[j] = c;
		revert(s, i +1, j - 1);
	}

	public static class Node {
		int v;
		int i;
		public Node(int v, int i) {
			this.v= v;
			this.i= i;
		}
	}
    public static int[] dailyTemperatures2(int[] temperatures) {
        
    	int[] res = new int[temperatures.length];
    	Stack<Node> st = new Stack<Node>();
    	
    	for (int i = res.length - 1; i >= 0; i --) {
    		int curr = temperatures[i];
    		
    		while (st.size() > 0 && st.peek().v <= curr) {
    			st.pop();
    		}
    		if (st.empty()) {
    			res[i]  = 0;
    			st.push( new Node(curr,i));
    			continue;
    		}
    		
    		Node tem = st.peek();
    		res[i] = tem.i - i;
    		st.push( new Node(curr,i));
    	}
    	
    	
    	return res;
    }
	
    public static int[] dailyTemperatures(int[] temperatures) {
        
    	int[] res = new int[temperatures.length];
    	
    	for (int i = 0;i < temperatures.length; i ++) {
    		if(i == temperatures.length) break;
    		
    		for (int j = i+1; j < temperatures.length; j++) {
    			if (temperatures[j] > temperatures[i]) {
    				res[i] = j-i;
    				break;
    			}
    		}
    	}
    	return res;
    }
    

}
