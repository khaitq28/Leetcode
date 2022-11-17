package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Quang-Khai TRAN
 * @date 30/08/2022
 */

public class ShortestBridge {

    public static void main(String ...args) {

//        int[][] grid = {{1,1,1,1,1},
//                        {1,0,0,0,1},
//                        {1,0,1,0,1},
//                        {1,0,0,0,1},
//                        {1,1,1,1,1}};
        int[][] grid = {{0,1,0},
                        {0,0,0},
                        {0,0,1}};
        ShortestBridge bridge = new ShortestBridge();
        int k = bridge.shortestBridge(grid);

        System.out.println(k);
    }


    boolean [][] marked;
    int[][] grid;
    int n;

    public int shortestBridge(int[][] grid) {

        n = grid.length;
        this.grid = grid;
        this.marked = new boolean[n][n];

        for (int i = 0; i <n && island.size() == 0; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    marked[i][j] = true;
                    Node node = new Node(i,j);
                    getFirstIsland(node);
                    break;
                }
            }
        }

        while (!island.isEmpty() && !found) {
            int size = island.size();
            boolean touch = false;
            for (int k = 0;k <size && !found; k++) {
                Node node = island.poll();
                int i = node.i;
                int j = node.j;
                if (test(i, j+1) | test(i, j-1) | test(i+1, j) | test(i-1, j)) touch = true;
            }
            if (!touch) this.c ++; else return this.c;
        }

        return this.c;
    }

    private boolean found;

    private boolean test(int i, int j) {
        if (i >= 0 & i < n && j>= 0 && j<n && !marked[i][j]) {
            marked[i][j] = true;
            if (grid[i][j] == 0) {
                Node node = new Node(i,j);
                island.add(node);
                return false;
            } else {
                found = true;
                return true;
            }
        }
        return false;
    }


    Queue<Node> island = new ArrayDeque<>();

    int c = 0;

    private void getFirstIsland(Node node) {
        Queue<Node> qu = new ArrayDeque<>();
        qu.add(node);
        while(!qu.isEmpty()) {
            Node t = qu.poll();
            int i = t.i;
            int j = t.j;
            check(i, j+1, qu);
            check(i, j-1, qu);
            check(i+1, j, qu);
            check(i-1, j, qu);
            island.add(t);
        }
    }

    private void check(int i, int j, Queue<Node> qu) {
        if (i >= 0 & i < n && j>= 0 && j<n && grid[i][j] == 1 && !marked[i][j]) {
            Node node = new Node(i,j);
            qu.add(node);
            marked[i][j] = true;
        }
    }


    public class Node {
        int i; int j;
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

}
