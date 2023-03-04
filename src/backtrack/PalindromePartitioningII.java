package backtrack;

/**
 * @author Quang-Khai TRAN
 * @date 04/03/2023
 */

public class PalindromePartitioningII {

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioningII().minCut("abcaaabbc"));
    }

    String s;

    public int minCut(String s) {
        this.s = s;
        int l = s.length();
        memo = new Integer[l][l+1];
        memoValid = new Boolean[l][l];
        return dp(0, l);
    }

    Integer[][] memo;
    Boolean[][] memoValid;

    private int dp(int i, int j) {

        if (memo[i][j] != null) return memo[i][j];
        if (isValid (i,j-1)) return 0;

        int min = Integer.MAX_VALUE;

        for (int k = i+1; k < j; k++)  {
            if (isValid(i,k-1)) {
                int temp = 1 +  dp(k,j);
                min = Math.min(min, temp);
            }
        }

        memo[i][j]= min;
        return min;
    }

    private boolean isValid(int i, int j) {
        if (i >= j) return true;
        if (memoValid[i][j] != null)  return memoValid[i][j];
        return memoValid[i][j] = s.charAt(i) == s.charAt(j) && isValid(i+1, j-1);
    }
}
