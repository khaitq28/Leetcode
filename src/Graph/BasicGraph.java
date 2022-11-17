package Graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Quang-Khai TRAN
 * @date 22/06/2022
 */

public class BasicGraph {

    private static int[][] arr = new int[5][5];

    static {
        arr[0] = new int[] {0,1,2,3,4};
        arr[1] = new int[] {5,6,7,8,9};
        arr[2] = new int[] {10,11,12,13,14};
        arr[3] = new int[] {15,16,17,1,0};
        arr[4] = new int[] {0,0,0,1,0};
    }

    public static void main(String[] args) {
            dfs();
    }

    public static void dfs() {

        int count = 0;
        Stack<String> stack = new Stack<>();
        Set<String> visited = new HashSet<>();
        stack.push("0,0");
        while (!stack.isEmpty()) {
            String e  = stack.pop();
            isIsland(e, stack, visited);
            visited.add(e);
        }

        System.out.println(count);

    }

    private static void isIsland(String e, Stack<String> stack, Set<String> visited) {
        String[] s=  e.split(",");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        Integer v = arr[x][y];
        if (x+1 < arr.length && !visited.contains(x+1 + ","+y)) stack.add(x+1 + "," + (y));
        if (y+1 < arr.length && !visited.contains(x + ","+ (y+1))) stack.add(x + "," + (y+1));
        System.out.print(v + ",");
    }


}
