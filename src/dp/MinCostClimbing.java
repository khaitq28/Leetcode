package dp;

/**
 * @author Quang-Khai TRAN
 * @date 23/10/2022
 */

public class MinCostClimbing {

    int [] m;

    public static void main(String[] args) {

        int[] arr= {1,100,1,1,1,100,1,1,100,1};

        System.out.println(new MinCostClimbing().minCostClimbingStairs(arr));
    }

    public int minCostClimbingStairs(int[] cost) {
        m = new int[cost.length+1];
        return dp2(cost);
    }
    private int dp2(int[] cost)  {
        if(cost.length <= 1) return 0;
        int pre2 = 0;
        int pre1 = 0;
        int i;
        for (i = 2; i <= cost.length; i ++) {
            int current  = Math.min(pre1 + cost[i -1], pre2 + cost[i -2]);
            pre2 = Math.min(pre1 , pre2 + cost[i -2]);
            pre1 = current;
        }
        return pre1 ;
    }

}
