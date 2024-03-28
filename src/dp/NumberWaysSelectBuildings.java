package dp;

import java.util.Arrays;

/**
 * @author Quang-Khai TRAN
 * @date 17/10/2023
 */

public class NumberWaysSelectBuildings {

    public static void main(String[] args) {
        NumberWaysSelectBuildings main = new NumberWaysSelectBuildings();
        System.out.println(main.numberOfWays("0001100100"));
    }
    char[] arr;
    public long numberOfWays(String s) {
        this.arr = s.toCharArray();
        this.n01 = new long[arr.length];
        this.n10 = new long[arr.length];
        this.n0 = new long[arr.length]; // number of 0 at index
        this.n1 = new long[arr.length]; // number of 1 at index
        Arrays.fill(n01, -1);
        Arrays.fill(n10, -1);
        n0[0] = arr[0] == '0'? 1: 0;
        n1[0] = arr[0] == '1'? 1: 0;
        for (int i = 1; i < arr.length; i++) {
            char c = arr[i];
            if (c == '0') {
                n0[i] = n0[i-1] + 1;
                n1[i] = n1[i-1];
            } else {
                n0[i] = n0[i-1];
                n1[i] = n1[i-1] + 1;
            }
        }
        get01(arr.length -1);
        get10(arr.length -1);
        long ret = 0L;
        long[]n010 = new long[arr.length];
        long[]n101 = new long[arr.length];
        for (int i = 2; i < n01.length; i++) {
            n010[i] = arr[i] == '1' ? n010[i-1] : n010[i-1]+ n01[i-1];
        }
        for (int i = 2; i < n01.length; i++) {
            n101[i] = arr[i] == '0' ? n101[i-1] : n101[i-1] + n10[i-1];
        }
        return n010[n010.length-1] + n101[n101.length-1]; //001101
    }
    long[] n0;
    long[] n1;
    long[] n01;
    long[] n10;
    //number of way to construct n01 at last index i
    long get01(int i) {
        if (i <= 0) return 0;
        if (n01[i] != -1) return n01[i];
        if (arr[i] == '0'){
            n01[i] = get01(i-1);
            return n01[i];
        }
        n01[i] = get01(i-1) + n0[i-1];
        return n01[i];
    }

    long get10(int i) {
        if (i <= 0) return 0;
        if (n10[i] != -1) return n10[i];
        if (arr[i] == '1') {
            n10[i] = get10(i-1);
            return n10[i];
        }
        n10[i] = get10(i-1) + n1[i-1];
        return n10[i];
    }

}
