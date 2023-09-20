package dp;

/**
 * @author Quang-Khai TRAN
 * @date 20/09/2023
 */

public class UncrossedLines {

    int ret;
    /*
    You are given two integer arrays nums1 and nums2. We write the integers of nums1 and nums2 (in the order they are given) on two separate horizontal lines.
    We may draw connecting lines: a straight line connecting two numbers nums1[i] and nums2[j] such that:
    nums1[i] == nums2[j], and
    the line we draw does not intersect any other connecting (non-horizontal) line.
    Note that a connecting line cannot intersect even at the endpoints (i.e., each number can only belong to one connecting line).
    Return the maximum number of connecting lines we can draw in this way.
    Input: nums1 = [1, 4, 2],
           nums2 = [1, 2, 4]
Output: 2
     */
    int[]a1;int[]a2;
    public int maxUncrossedLines(int[] a1, int[] a2) {
        this.a1= a1;this.a2=a2;
        this.memo = new Integer[a1.length][a2.length];
        return test(0,0);
    }
    Integer[][] memo;
    // number of connecting lines of 2 arrays from i,j
    private int test(int i, int j) {
        if (i == a1.length || j ==a2.length) return 0;
        if(memo[i][j] != null) {
            return memo[i][j];
        }
        if(a1[i] == a2[j]) {
            return 1 +test(i +1, j+1);
        }
        int v1 = test(i +1, j);
        int v2 = test(i , j+1);
        int v = Math.max(v1, v2);
        memo[i][j] = v;
        return v;
    }

}
