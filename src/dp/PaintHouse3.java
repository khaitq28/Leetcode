package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Quang-Khai TRAN
 * @date 18/09/2023
 */

public class PaintHouse3 {

    public static void main(String[] args) {
        int[] houses = new int[] {0,2,1,2,0};
        int[][]cost = {{1,10},{10,1},{10,1},{1,10},{5,1}};
        int m = 5; int n= 2;int t =3;

        System.out.println(new PaintHouse3().minCost(houses, cost, m, n, t));
    }

    int [] houses;
    int[][] cost;
    int m;
    int n;
    int t;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.m = m;
        this.n = n;
        this.cost = cost;
        this.houses = houses;
        this.t = target;

        int precolor = -1;
        int ret = Integer.MAX_VALUE;
        //color 1-n
        for (int i = 1; i <= n; i++) {
            int price = price(precolor, 0, i, 0);
            if (price == -1) continue;
            ret = Math.min(ret, price);
        }
        return ret == Integer.MAX_VALUE ? -1: ret;
    }
    Map<String, Integer> memo = new HashMap<>();
    int price(int precolor, int house, int color, int g) { // created group g

        String key = precolor + ";" + house+ ";" + color + ";" + g ;
        if (memo.containsKey(key)) return memo.get(key);

        if (house == houses.length) {
            int ret = g == t ? 0 : -1;
            memo.put(key,ret);
            return ret;
        }

        boolean painted = false;
        if (houses[house] != 0) {
            painted = true;
            color = houses[house];
        }
        int cost = painted ? 0: this.cost[house][color-1];

        int nextcost = Integer.MAX_VALUE;
        boolean inc = color != precolor;

        for (int i = 1; i <= n; i++) {
            int v = price(color, house+1, i, inc ? g+1: g);
            if (v == -1) {
                memo.put(key,-1);
                continue;
            }
            nextcost = Math.min(nextcost, v);
        }

        int ret = nextcost == Integer.MAX_VALUE? -1: cost + nextcost;

        memo.put(key,ret);
        return ret;
    }
}

