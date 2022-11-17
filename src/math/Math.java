package math;

/**
 * @author Quang-Khai TRAN
 * @date 13/06/2022
 */

public class Math {

    public static void main(String[] args) {

        System.out.println(countPrimes(10));

    }

    public static int countPrimes(int n) {
        boolean[] v = new boolean[n];
        if (n <= 2) return 0;
        int c = 0;
        v[0]= false;
        v[1] = false;
        for (int i = 2; i <= java.lang.Math.sqrt(n); i++) {
            int j = i+1;
            while(i * j < n ) {
                v[i*j] = true;
                j ++;
            }
        }

        for (boolean i: v) {
            if (i) {
                c++;
            }
        }
        return c;
    }

}
