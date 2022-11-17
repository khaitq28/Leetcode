package dp;

import java.util.HashMap;

/**
 * @author Quang-Khai TRAN
 * @date 05/10/2022
 */

public class MatrixSquare {

    public static void main(String[] args) {
        char[][] v =  {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

//        char[][] v =  {{'1','1','0'},{'1','1','0'},{'0','1','0'}};

        System.out.println("t = " + new MatrixSquare().maximalSquare(v));
    }

    HashMap<String, Integer> memo = new HashMap<>();
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length -1;
        int n = matrix[0].length -1;
        return dp(matrix,  m, n);
    }

    private int dp(char[][] matrix, int m, int n) {
        if (m < 0 || n < 0) return 0;
        if (m == 0 && n == 0) return matrix[0][0] == '1' ? 1 : 0;

        if (memo.get(m + "," + n) ==  null) {

            int v = 0;
            if (matrix[m][n] == '1') {
                v =  Math.min(dp(matrix, m-1, n), dp(matrix, m, n-1));
                v =  Math.min(v, dp(matrix, m -1, n-1)) + 1;
            } else {
                v =  Math.max(dp(matrix, m-1, n), dp(matrix, m, n-1));
//                v =  Math.min(v, dp(matrix, m -1, n-1));
            }
            System.out.println("m,n,v = " + m + "," + n + "," + v);
            memo.put(m + "," + n,  v);
        }
        return memo.get(m + "," + n);

    }

    private boolean isOk(char[][] matrix, int m, int n, int k) {
        
        if ( m-k >= 0) {
            int t = n-k >= 0 ? n-k : 0;
            for (int j = t; j <= n; j++) {
                if (matrix[m-k][j] == '0') return false;
            }
        }

        if ( n-k >= 0) {
            int t = m-k >= 0 ? m-k : 0;
            for (int i = t; i <= m; i ++ ) {
                if (matrix[i][n-k] == '0') return false;
            }
        }

        return true;
    }
}