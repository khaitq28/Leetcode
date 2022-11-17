package backtrack;

import java.util.*;

/**
 * @author Quang-Khai TRAN
 * @date 28/06/2022
 */

public class Subset {

    public static void main(String ...args) {
        Subset allPath = new Subset();
        allPath.subsetsWithDup(new ArrayList<Integer>(Arrays.asList(1,3,5,4)));
        System.out.println(allPath.res);
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    Set<ArrayList<Integer>> set = new HashSet<>();

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
        for (int i = 0; i <A.size(); i++) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(A.get(i));
            backtrack(A,i, path);
        }
        res.add(new ArrayList<>());
        res.addAll(set);

        return res;
    }

    private void backtrack(ArrayList<Integer> a, int i, ArrayList<Integer> path) {
        set.add(new ArrayList<>(path));
        if (path.size() == a.size()) {
            return;
        }
        for (int j = i+1; j < a.size(); j++) {
            path.add(a.get(j));
            backtrack(a,j, path);
            path.remove(path.size()-1);
        }
    }
}
