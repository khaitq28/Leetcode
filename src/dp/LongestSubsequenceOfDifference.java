package dp;

import java.util.Arrays;

/**
 * @author Quang-Khai TRAN
 * @date 20/09/2023
 */

public class LongestSubsequenceOfDifference {


    int[] arr;
    int diff;
    public int longestSubsequence(int[] arr, int difference) {
        this.arr= arr;
        this.diff =difference;
        memo = new int[arr.length];
        int c = Integer.MIN_VALUE;
        for (int i = 0; i< arr.length; i++) {
            int v = get(i);
            c = Math.max(v, c);
        }
        return c;
    }

    //longest sequence from i
    int[] memo ;
    private int get(int i) {
        if (i >= arr.length) return 0;
        if (i == arr.length - 1) return 1;
        int v= arr[i];
        int next = v + diff;
        int j = i+1;
        while (j < arr.length) {
            if (v + diff ==arr[j])
                memo[i] = 1 + get(j);
            else
                memo[i] = Math.max(memo[i],get(j));
            j++;
        }
        return memo[i];
    }
//Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
    //Explanation: The longest arithmetic subsequence is [7,5,3,1].  => 4
    /*
    [1,2,3,4,5,6,7], difference = 2 => 1,3,5,7   2,4,6
     */
}
