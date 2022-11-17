package backtrack;

import java.util.ArrayList;

/**
 * @author Quang-Khai TRAN
 * @date 28/06/2022
 */

public class Combination {


    public static void main(String ...args) {
        Combination allPath = new Combination();
        allPath.combine(2,1);

        System.out.println(allPath.res);
    }

    int a = 0;
    int b = 0;

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        a = A;
        b = B;

        for (int i = 1; i <= A; i++) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(i);
            backtrack(path,i);
        //    path.remove(path.size() - 1);
        }

        return res;
    }

    private void backtrack(ArrayList<Integer> path, int i) {
        if (path.size() == b) {
            res.add(new ArrayList<>(path)); return;
        }
        for (int j = i+1; j <= a; j++) {
            path.add(j);
            backtrack(path,j);
            path.remove(path.size() - 1);
        }

    }

}
