package dp;

import java.util.Arrays;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @author Quang-Khai TRAN
 * @date 27/10/2022
 */

public class CoinChange2 {

    /*
    You are given an integer array coins representing coins of different denominations
     and an integer amount representing a total amount of money.

    Return the number of combinations that make up that amount.
    If that amount of money cannot be made up by any combination of the coins, return 0.

     */

    public static void main(String[] args) {

        TreeSet<Integer[]> keys = new TreeSet<>( (a,b) -> {
             int s = - a[0].compareTo(b[0]);
             if (s == 0) return - a[1].compareTo(b[1]);
            return s;
        });

        keys.add(new Integer[]{5,0});
        keys.add(new Integer[]{1,1});
        keys.add(new Integer[]{5,2});

        TreeSet<Integer[]>  stack = new TreeSet<>( (a,b) -> -a[0].compareTo(b[0]));


        int[] coins = {2,5};
  //      System.out.println(new CoinChange2().change(5, coins));
    }

    int[] arr;
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        this.arr = coins;
        return dp(amount, 0);
    }

    /*
    Input: amount = 5, coins = [1,2,5]
    Output: 4
    Explanation: there are four ways to make up the amount:
    5=5
    5=2+2+1
    5=2+1+1+1
    5=1+1+1+1+1

        Input: amount = 3, coins = [2]
        Output: 0
     */

    private int dp(int amount, int i) {
        if (amount == 0) return 1;

        if (i == this.arr.length || amount < 0) return 0;

         //   with a coin C, we can choose/ not choose for amount

        int c = this.arr[i];
        int include = dp(amount - c, i);
        int exclude = dp (amount,i+1);

        return include + exclude;
    }

}
