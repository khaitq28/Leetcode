package recursive;

public class Factorial {

	public static void main(String[] args) {
		
		System.out.println(fact(4, 1));
		
		
//		0.00001
//		2147483647
		
		System.out.println(myPow3(0.00001, 2147483647));

	}
	
	// 2 ^ 5 = 2 
	
	// n! = 1.2.3.4.5...n
	
	private static double fact(int n, double s) {
		if (n == 0) return s;
		
		s = s * n;
		
		return fact(n - 1, s);
	}
	
	// x^n = x* x * x...
    public static double myPow3(double x, int n) {
    	if (n == 0) return 1;
    	if (n == 1) return x;
    	return n%2 == 0 ?   myPow3(x*x, n/2): x*myPow3(x*x, n/2);
    }
    
	
	// x^n = x* x * x...
    public static double myPow(double x, int n) {
    	return myPow(x, n , 1);
    }

    public static double myPow(double x, int n, double val) {
    	if (n == 0) return 1;
    	if (n == 1) return val * x;
    	
        return myPow(x, n -1,  val * x);
    }
}
