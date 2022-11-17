package Graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author Quang-Khai TRAN
 * @date 20/07/2022
 */

public class ShortestPathBinaryMatrix {

    int[][] grid;
    public static void main(String  ...args) {
        int[][] arr = new int[3][3];
        arr[0] = new int[] {0,0,1};
        arr[1] = new int[] {0,1,0};
        arr[2] = new int[] {0,1,0};

        System.out.println(shortestPathBinaryMatrix(arr));
    }

    public static class Node {
        int d;
        String xy;
        public Node(String xy, int d) {
            this.xy = xy;
            this.d = d;
        }
    }
    static Set<String> visited = new HashSet<>();

    /*
        [0,0,1],
        [0,1,0],
        [1,1,0]
     */

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n-1][n-1] ==1) return -1;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0+","+0, 1));
        visited.add(0+","+0);
        while (queue.size() > 0) {
            Node current = queue.poll();
            String[] s = current.xy.split(",");
            System.out.println(current.xy + ", d = " +current.d);
            if (current.xy.equals(n-1 +"," + (n-1))) {
                return current.d;
            }
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            isValidNode(x+1, y+1, n, grid, queue, current.d);
            isValidNode(x+1, y, n, grid,queue,current.d);
            isValidNode(x, y+1, n, grid, queue, current.d);
            isValidNode(x, y - 1, n, grid, queue, current.d);
            isValidNode(x-1, y, n, grid,queue, current.d);
            isValidNode(x+1, y-1, n, grid, queue, current.d);
            isValidNode(x-1, y-1, n, grid, queue, current.d);
            isValidNode(x-1, y+1, n, grid, queue, current.d);
        }
        return -1;
    }

    private static void isValidNode(int x, int y, int n, int[][]grid, Queue<Node> queue, int d) {
        if(!visited.contains(x+"," +y) && x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 0){
            queue.add(new Node(x+ "," + y,d +1 ));
            visited.add(x+ "," + y);
        }
    }


}
