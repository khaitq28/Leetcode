package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Quang-Khai TRAN
 * @date 27/06/2022
 */

public class AllPath {

    private int[][] graph;
    int d;
    List<List<Integer>> res  = new ArrayList<>();

    public AllPath() {
        graph = new int[][]{{1,2},{3},{3},{}};

        System.out.println(this.resolve());
    }

    public List<List<Integer>> resolve() {
        d = graph.length;
        List<Integer> path = new ArrayList<>();
        path.add(0);
        backtrack(0, path);
        return res;
    }

    private void backtrack(int current, List<Integer> path) {
        if (current == d) {
            res.add(new ArrayList<>(path));
            System.out.println(path);
            return;
        }
        for (int neighbor: this.graph[current]) {
            path.add(neighbor);
            backtrack(neighbor, path);
            path.remove(path.size() -1);
        }
    }

    public static void main(String ...args) {
        AllPath allPath = new AllPath();
    }
}
