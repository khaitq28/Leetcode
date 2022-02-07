package recursive;

public class ClimbingStairs {

	public static void main(String[] args) {

		
		System.out.println();
	}

	
	/**
	 *  n = 2
	 *  => (1,1)  (2)
	 *  
	 *  n = 3 =>   
	 *   1 1 1
	 *   1 2
	 *   2 1
	 *   
	 *   n = 3
	 *   f(n) = 2 f(n-1) - 1 = 3
	 *  
	 *  n = 4 
	 *    1 1 1 1
	 *    1 1 2
	 *    1 2 1
	 *    2 1 1
	 *    2 2
	 *    
	 *    n= 4
	 *    f(4) = 2 * f(n-1) - 1 =  2 * 3 - 1 = 5  
	 *    
	 *    f(5) = 2 * f(n-1) - 2 = 8
	 *    
	 *    
	 *    1 1 1 1 1
	 *    1 1 1 2
	 *    1 1 2 1
	 *    1 2 1 1
	 *    1 2 2
	 *    1 1 2 1
	 *    2 1 1 1
	 *    2 2 1
	 *    
	 *    1 1 1 1 1 1     f(6) = 10;
	 *    1 1 1 1 2
	 *    1 1 1 2 1
	 *    1 1 2 1 1
	 *    1 1 2 2
	 *    1 2 1 1 1
	 *    1 2 2 1
	 *    2 1 1 1 1
	 *    2 2 1 1
	 *    2 2 2
	 *    
	 *    You are climbing a staircase. It takes n steps to reach the top.
		  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
			Input: n = 3
			Output: 3
			Explanation: There are three ways to climb to the top.
			1. 1 step + 1 step + 1 step
			2. 1 step + 2 steps
			3. 2 steps + 1 step
	 */
	
    public int climbStairs(int n) {
        if (n <= 3) return n;
        return climbStairs(n-1) * 2 -1;
    }
}
