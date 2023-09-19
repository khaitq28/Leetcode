package dp;

/**
 * @author Quang-Khai TRAN
 * @date 19/09/2023
 */

public class InterleavingString {

    /*
    Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
    An interleaving of two strings s and t is a configuration where s and t are divided into n and m substrings respectively, such that:
    s = s1 + s2 + ... + sn
    t = t1 + t2 + ... + tm
    |n - m| <= 1
    The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
    Note: a + b is the concatenation of strings a and b.

    Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Split s1 into s1 = "aa" + "bc" + "c",
  and s2 into s2 = "dbbc" + "a".
Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
     */
    String s1; String s2;String s3;
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1= s1; this.s2= s2;this.s3 =s3;
        return check(0,0, 0);
    }

    public static void main(String[] args) {
        String  s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        System.out.println(new InterleavingString().isInterleave(s1, s2, s3));
    }
    boolean check(int i, int j, int k) {
        if(i == s1.length() && j == s2.length() && k == s3.length()) {
            return true;
        }
        if (i <s1.length() && k< s3.length() && s1.charAt(i) == s3.charAt(k) && (j == s2.length() || s2.charAt(j) != s3.charAt(k))) {
            return check(i+1, j, k+1);
        } else if(j < s2.length() && k < s3.length() && s2.charAt(j) == s3.charAt(k) && (i == s1.length() || s1.charAt(i) != s3.charAt(k))) {
            return check(i, j+1, k+1);
        } else if(i < s1.length() && j <s2.length() && k < s3.length() && s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)) {
            return check(i+1, j, k+1) || check(i, j+1, k+1);
        }
        return false;
    }

}
