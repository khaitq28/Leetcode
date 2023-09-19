package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Quang-Khai TRAN
 * @date 19/09/2023
 */

public class MaximumLengthPairChain {
    public static void main(String[] args) {
//        int[][] v= {{1,2} , {7,8}, {4,5}};
        int[][] v = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(new MaximumLengthPairChain().findLongestChain(v));
    }
    int[][] arr;
    public int findLongestChain(int[][] pairs) {
        this.arr = pairs;
        Arrays.sort(arr, (o1, o2) -> o1[0] > o2[0] ? 1 : -1);
        int v = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
            v = Math.max(v, test(i));
        return v;
    }
    Map<Integer, Integer> map = new HashMap<>();
    private int test(int i) {
        if (i == arr.length) return 1;
        if (map.containsKey(i)) {
            return map.get(i);
        }
        int v = 1;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[i][1] < arr[j][0]) {
                v = Math.max(1 + test(j), v);
            }
        }
        map.put(i, v);
        return v;
    }
}
