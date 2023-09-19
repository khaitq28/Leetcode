package dp;

/**
 * @author Quang-Khai TRAN
 * @date 07/02/2023
 */

public class Pizza {

    int row;
    int col;
    String[] p;

    public int ways(String[] pizza, int k) {
        row = pizza.length;
        col = pizza[0].length();
        p = pizza;
        return dp(0, 0, k -1);
    }

    public static void main(String[] args) {
        String[] pizza = new String[]{"A..","AAA","..."};
        int k = 3;
        System.out.println(new Pizza().ways(pizza, k));
    }

    //ways to cut from row/col a/b with m cut
    private int dp(int a, int b, int m) {

            int ret = 0;

        boolean xa = hasrow(a);
        if (xa) {
            if (m ==0) return 1;
            ret = dp (a+1, b, m-1);
        }

        if (m == 0) return restOk(a,b)? 1 : 0;

        boolean xb = hascol(b);
        if (xb) {
            if (m ==0) return 1;
            ret += dp(a, b+1, m -1);
        }

        if (!xa && !xb) {
            if (m ==0) return 0;
            ret = dp(a+1, b+1, m);
        }

        return ret;

    }

    private boolean restOk(int a, int b) {
        for(int i = a; i < row; i ++ ) {
            for (int j = b; j <col; j ++) {
                if (p[i].charAt(j) == 'A') return true;
            }
        }
        return false;
    }

    private boolean hascol(int i) {
        for (String s: p) {
            if (s.charAt(i) == 'A') return true;
        }
        return false;
    }

    private boolean hasrow(int i) {
        for (char c:  p[i].toCharArray()) {
            if (c == 'A') return true;
        }
        return false;
    }
}
