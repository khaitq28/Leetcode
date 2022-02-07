package dp;

public class Base1 {

	public static void main(String[] args) {

		System.out.println(fib(6));

	}
	
	// 0 1 1 2 3 5 8 
	
	// 5 => 4 + 3
	// 4 => 3 + 2  
	// 3 => 2 + 1
	// 
	public static int fib( int n) {
		int[] arr = new int[n + 1];
		
		if(n < 2)     return n;
		
		arr[0] = 0;
		arr[1] = 1;
		
		int k =  get(n, arr);
		
		return k;
	}
	
	private static int get(int i, int[] arr) {

		if (i <= 1) return i;
		if (arr[i] != 0) return arr[i];
		
		int ret = get(i - 1, arr) +  get(i - 2, arr);
		arr[i] = ret;
		
		return ret;
	}
	
	

}
