package dp;

/**
 * @author Quang-Khai TRAN
 * @date 20/09/2023
 */

public class MinInsertStringPalindrome {

    /*
        Given a string s. In one step you can insert any character at any index of the string.
    Return the minimum number of steps to make s palindrome.
    A Palindrome String is one that reads the same backward as well as forward.

    Input: s = "zzazz"
    Output: 0

    Input: s = "mbadm"
    Output: 2
    Explanation: String can be "mbdadbm" or "mdbabdm".
     */
    public static void main(String[] args) {
        System.out.println(new MinInsertStringPalindrome().minInsertions("mbadm"));  //leetcodocteel
    }
    public int minInsertions(String s) {
//        while (s.length() >= 2 && s.charAt(0) == s.charAt(s.length()-1)) {
//            s = s.substring(1, s.length()-1);
//        }
        memo = new Integer[s.length()+1][s.length()+1];
        this.s = s;
//        return process(s);
        return dp(0, s.length()-1);
    }

    Integer[][]memo;
    String s;
    private int dp(int i, int j) {
        if (j == i) return 0;
        if (i+1 ==j) return s.charAt(i) == s.charAt(j) ? 0: 1;
        if(memo[i][j] != null) return memo[i][j];
        if(s.charAt(i) != s.charAt(j)) {
            memo[i][j] = 1 + Math.min(dp(i+1, j), dp(i, j-1));
            return memo[i][j];
        }
        return dp(i+1, j-1);
    }

    // a a b a c
    private int process(String s) {
        if (s.length() <=1) return 0;
        if (s.charAt(0) != s.charAt(s.length()-1)) {
            int v1 = 1 + process(s.substring(1)); //add to last index then remove head+tail
            int v2 = 1 + process(s.substring(0, s.length()-1));
            return Math.min(v1,v2);
        }
        return process(s.substring(1, s.length()-1));
    }

}
