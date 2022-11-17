package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Quang-Khai TRAN
 * @date 22/09/2022
 */

public class Knapsack {

    public static void main(String[] args) {

        int[] v = { 30 ,20, 10, 10 };
        int[] w = { 1, 2, 2, 2};
        int W = 6;

        System.out.println(knapsack(v, w, 3, W));
    }


    public static int knapsack(int[] v, int[] w, int n, int W) {
        if (W < 0) return Integer.MIN_VALUE;
        if (n < 0 || W == 0) {
            return 0;
        }
        int include = v[n] + knapsack(v, w, n-1, W - w[n]);
        int exclude = knapsack(v,w,n-1, W);
        return Math.max(include, exclude);
    }


}
