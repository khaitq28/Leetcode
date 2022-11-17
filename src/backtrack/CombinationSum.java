package backtrack;

import java.util.*;

/**
 * @author Quang-Khai TRAN
 * @date 28/06/2022
 */

public class CombinationSum {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> a;

    public static void main(String ...args) {
        List<Integer> a = Arrays.asList(15, 8, 15, 10, 19, 18, 10, 3, 11, 7, 17 );
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(a, 33));
    }

    public List<List<Integer>> combinationSum(List<Integer> a, int b) {
        Collections.sort(a);
        System.out.println(a);
        this.a = a;
        boolean[] visited = new boolean[a.size()];
        List<Integer> path = new ArrayList<>();
        for(int i = 0; i< a.size(); i++ ) {
            if (i >0 && a.get(i) == a.get(i - 1)) continue;

            path.add(a.get(i));
            backtrack(path, i, visited, b);
            path.remove(path.size()-1);
        }
        return res;
    }

    private void backtrack(List<Integer> path, int i, boolean[] visited, int b) {

    if (sum(path) == b) {
            res.add(new ArrayList<>(path));
            System.out.println(path);
            return;
        }
        if (sum(path) > b) {
            return;
        }
        for (int j = i+1; j < this.a.size(); j++){
            path.add(a.get(j));
            backtrack(path, j, visited, b);
            path.remove(path.size()-1);
        }

    }

    private int sum(List<Integer> arr) {
        int sum = 0;
        for (int i: arr) sum+= i;
        return sum;
    }

}
