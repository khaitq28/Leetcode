package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Quang-Khai TRAN
 * @date 16/11/2022
 */

public class WordSearch {


    public static void main(String[] args) {
        char[][] arr = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        String s = "ABCCED";

        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(arr, s));
    }

    char[][] board;
    char[] arr;
    int m; int n;
    public boolean exist(char[][] board, String word) {

        this.m = board.length;
        this.n = board[0].length;
        check = new boolean[m][n];
        this.board = board;
        this.arr = word.toCharArray();

        for (int i = 0; i< board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dp(i,j,0,-1)) return true;
            }
        }
        return false;
    }
    boolean[][] check;
    //dir : 1,2,3,4  = up down left right
    boolean dp(int i, int j, int c, int dir) {

        if (i <0 || j < 0|| i >=m || j >=n||  board[i][j] != arr[c] ||  check[i][j]) return false;

        if (c == arr.length -1) return true;
        check[i][j] = true;

        boolean up = dir != 2 && dp(i -1, j, c +1,1);
        boolean down = dir != 1 && dp(i +1, j, c +1, 2);
        boolean left = dir!= 4 && dp(i , j -1, c +1, 3);
        boolean right = dir != 3 && dp(i , j + 1, c +1, 4);

        check[i][j] = false;

        return (up || down || left || right);
    }

    List<char[]> arrs = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {

        for (String word : words) {
            arrs.add(word.toCharArray());
        }

        return null;

    }

}
