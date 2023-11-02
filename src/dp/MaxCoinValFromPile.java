package dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Quang-Khai TRAN
 * @date 02/10/2023
 */

public class MaxCoinValFromPile {
    int k;
    Map<Integer, Integer> visit = new HashMap<>();
    Integer ret = Integer.MIN_VALUE;
    List<List<Integer>> sum = new ArrayList<>();
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        for (List<Integer> pile: piles) {
            List<Integer> l = new ArrayList<>();
            int last = 0;
            for (Integer i: pile) {
                l.add(i + last);
                last = l.get(l.size()-1);
            }
            sum.add(l);
        }
        this.k = k;
        for(int i = 0; i < sum.size(); i++) {
            visit.clear();
            get(i, k);
        }
        return ret;
    }

    public static void main(String[] args) {
        MaxCoinValFromPile pile = new MaxCoinValFromPile();
        List<List<Integer>> piles = new ArrayList<>();
        List<Integer> p1 = List.of(1,20,3);piles.add(p1);
        List<Integer> p2 = List.of(7, 80);piles.add(p2);
//        List<Integer> p1 = List.of(10,100,3);piles.add(p1);
//        List<Integer> p2 = List.of(700,80,9);piles.add(p2);
        System.out.println(pile.maxValueOfCoins(piles, 3));
    }
    void get(int col,  int n) { //col, rest n times
        if (n == 0) {
            int point = 0;
            for (int pile: visit.keySet()) {
                int po = visit.getOrDefault(pile, 0);
                point += sum.get(pile).get(po);
            }
            ret = Math.max(ret, point);
            return;
        }
        if (visit.get(col) == null) {
            visit.put(col,0);
        } else {
            if (visit.get(col) + 1 >= sum.get(col).size()) return;
            visit.put(col, visit.get(col) + 1);
        }
        for (int j = 0; j< sum.size(); j++) {
            get(j, n-1);
        }
        if(visit.get(col) == 0) visit.remove(col);
        else visit.put(col, visit.get(col) - 1);
    }

}
