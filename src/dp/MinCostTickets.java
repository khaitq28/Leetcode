package dp;

import java.util.Arrays;

/**
 * @author Quang-Khai TRAN
 * @date 19/09/2023
 */

public class MinCostTickets {

    /*
    You have planned some train traveling one year in advance.
     The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.
Train tickets are sold in three different ways:
a 1-day pass is sold for costs[0] dollars,
a 7-day pass is sold for costs[1] dollars, and
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.
For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
Return the minimum number of dollars you need to travel every day in the given list of days.
     */
    int[] days;
    int[] costs;
    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        this.days =days; this.memo = new int[365][365];
        for(int[] a: this.memo) Arrays.fill(a, -1);
        // for day i: 3 posibility: ticket 1,7,30  or 0 (has already tickets)
        return cost(0, -1);
    }
    int[][]memo;
    int cost(int i, int expireDate) {
        if (i == days.length - 1) {
            return expireDate >= days[i] ? 0: Math.min(Math.min(costs[0], costs[1]), costs[2]);
        }
        if(expireDate >= days[i]) {
            return cost(i+1, expireDate);
        }
        if (expireDate != -1 && memo[i][expireDate] != -1) return memo[i][expireDate];
        int v1 = costs[0] + cost(i+1, days[i]);
        int v2 = costs[1] + cost(i+1, days[i]+ 6);
        int v3 = costs[2] + cost(i+1, days[i] + 29);
        int v = Math.min(Math.min(v1,v2), v3);
        if(expireDate != -1) memo[i][expireDate] = v;
        return v;
    }
    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};  int[] cost = {7,2,15};
        System.out.println(new MinCostTickets().mincostTickets(days, cost));
    }
}
