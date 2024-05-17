package daily;

/**
 * @author Quang-Khai TRAN
 * @date 17/05/2024
 */

public class GetMaximumGold {

    public static void main(String[] args) {

    }
    /*
    Return the maximum amount of gold you can collect under the conditions:
        Every time you are located in a cell you will collect all the gold in that cell.
        From your position, you can walk one step to the left, right, up, or down.
        You can't visit the same cell more than once.
        Never visit a cell with 0 gold.
        You can start and stop collecting gold from any position in the grid that has some gold.

        Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
        Output: 24
        Explanation:
        [[0,6,0],
         [5,8,7],
         [0,9,0]]
        Path to get the maximum gold, 9 -> 8 -> 7.

     */
    int[][]arr;
    private int getMaximumGold(int[][] arr) {
       this.arr = arr;
       this.visited = new boolean[arr.length][arr[0].length];
       int res = 0;
       for (int i = 0; i< arr.length; i++) {
           for (int j = 0; j < arr[0].length; j++) {
               if (arr[i][j] != 0) {
                   int v = dfs(i, j,0);
                     res = Math.max(res, v);
               }
           }
       }
         return res;
    }

    boolean[][] visited;
    private int dfs(int i, int j, int cur) {
        cur += arr[i][j];
        visited[i][j] = true;
        int max = 0;
        if (i > 0 && !visited[i-1][j] && arr[i-1][j] != 0) {
            int v =  dfs(i-1, j, cur);
            visited[i-1][j] = false;
            max = Math.max(max, v);
        }
        if (i < arr.length - 1 && !visited[i+1][j] && arr[i+1][j] != 0) {
            int v = dfs(i + 1, j, cur);
            visited[i+1][j] = false;
            max = Math.max(max, v);
        }
        if (j > 0 && !visited[i][j-1] && arr[i][j-1] != 0) {
            int v = dfs(i, j-1, cur);
            visited[i][j-1] = false;
            max = Math.max(max, v);
        }
        if (j < arr[0].length - 1 && !visited[i][j+1] && arr[i][j+1] != 0) {
            int v = dfs(i, j+1, cur);
            visited[i][j+1] = false;
            max = Math.max(max, v);
        }
        visited[i][j] = false;
        return cur + max;
    }

    /*
         [[0,6,0],
         [5,8,7],
         [0,9,0]]
        Path to get the maximum gold, 9 -> 8 -> 7.
     */
}
