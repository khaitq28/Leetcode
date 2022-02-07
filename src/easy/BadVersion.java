package easy;

public class BadVersion {

	public static void main(String[] args) {
		
		int r = firstBadVersion2(2126753390);
		
		System.out.print( r);
	}
	
	
	public static int firstBadVersion2(int n) {
        int x = 1,  y = n;
        while (x <= y) {
        	 if (x == y) return x;
        	 int i = x + (y-x)/2;
        	 if (isBadVersion(i)) {
        		 y =i;
        	 } else {
        		 x = i+ 1;
        	 }
        }
        
        return 0;
            
    }
	
	public static int firstBadVersion(int n) {
        int x = 1,  y = n;
        int i = x + (y-x)/2;
        
        if (isBadVersion(1)) return 1;

        if (n == 2) return isBadVersion(1) ? 1: n;
        if (isBadVersion(n) && !isBadVersion(n-1)) return n;
        
        boolean current = true;
        while (current || (i> (x +1) && i < (y - 1))) {
            current = isBadVersion(i);
            if (current) {
                if (!isBadVersion(i -1)) return i;
                if (i ==(x+1)) return i;
                y =i;
            } else {
                if (i ==(y -1)) return y;
                x =i;
            }
            i = x + (y-x)/2;
        }
        return i;              
    }
	
	// 1 2 3  4  5 6 7 
	
	
	private static boolean isBadVersion(int i) {
		if (i >= 1702766719) return true;
		return false;
	}

}
