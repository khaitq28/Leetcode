package Graph;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Quang-Khai TRAN
 * @date 21/06/2022
 */

public class UnionFind {


    public static void main(String[] args) {

        int[][] logs = {{0,1},{1,2},{6,3},{3,4}};

        Arrays.sort(logs, (a, b) -> a[0] >= b[0] ? 1: - 1);

        Arrays.asList(logs).forEach(a -> System.out.println(IntStream.of(a).boxed().collect(Collectors.toList())));

    }


    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0] >= b[0] ? 1: - 1);
        int[] idx = new int[n];
        for (int i = 0; i < n; i ++)
            idx[i] = i;

        int count = n;
        for (int[] log: logs) {
            int t = log[0];
            int a=  log[1];
            int b = log[2];
            if (find(a, idx) != find (b,idx)) {
                idx[a] = b;
                count --;
                if (count == 1) return t;
            }
        }
        return -1;
    }
    private int find(int a, int[]idx) {
        while(a != idx[a]) {
            a = idx[a];
        }
        return a;
    }

}
