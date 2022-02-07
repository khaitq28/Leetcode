package recursive;

import java.util.Arrays;

public class Combination {

	
	/**
	 * Find all combinations of elements satisfying given constraints
		
		
		Input: n = 3
		Output:
		3 1 2 1 3 2
		2 3 1 2 1 3
		
		1 x 1 x x x
		
		
		Input: n = 4
		Output:
		4 1 3 1 2 4 3 2
		2 3 4 2 1 3 1 4
	 */
	public static void main(String[] args) {
			
	      int n = 3;
	      
	        // create an input array double the size of a given number with
	        // all its elements initialized by -1
	        int[] arr = new int[2*n];
	        Arrays.fill(arr, -1);
	 
	        // start from element 1
	        int x = 1;
	        findAllCombinations(arr, x, n);
		
	}
	
	public static void findAllCombinations(int[] arr, int x, int n) {
		
	      if (x > n){
	            System.out.println(Arrays.toString(arr));
	            return;
	        }
	 
	        // try all possible combinations for element `x`
	        for (int i = 0; i < 2*n; i++)
	        {
	            // if position `i` and `i+x+1` are not occupied in the input
	            if (arr[i] == -1 && (i + x + 1) < 2*n && arr[i + x + 1] == -1)
	            {
	                // place `x` at position `i` and `i+x+1`
	                arr[i] = x;
	                arr[i + x + 1] = x;
	 
	                // recur for the next element
	                findAllCombinations(arr, x + 1, n);
	 
	                // backtrack (remove `x` from position `i` and `i+x+1`)
	                arr[i] = -1;
	                arr[i + x + 1] = -1;
	            }
	        }
		
	}

}
