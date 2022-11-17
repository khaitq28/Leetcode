package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Quang-Khai TRAN
 * @date 27/06/2022
 */

public class Permu {

    private int[] arr;
    public Permu() {
        arr = new int[] {0,1,2};
        this.resolve(arr);
    }

    private void resolve(int[] arr) {

        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];
        for (int i: arr) {
            visited[i] = true;
            path.add(i);
            backtrack(i, path, visited);
            path.remove(path.size()-1);
            visited[i]= false;
        }
    }

    private void backtrack(int i, List<Integer> path, boolean[] visited) {
        if (path.size() == arr.length) {
            System.out.println(path);
            return;
        }
        for (int k : arr) {
            if (!visited[k]) {
                path.add(k);
                visited[k] = true;
                backtrack(k, path,visited);
                path.remove(path.size()-1);
                visited[k]= false;
            }
        }

    }

    public static void main(String ...args) {
        Permu allPath = new Permu();
    }
}
