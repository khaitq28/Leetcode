package recursive;

import java.util.Arrays;

/**
 * @author Quang-Khai TRAN
 * @date 31/05/2022
 */

public class Matrix2d {

    public static void main(String ...args) {

        int[][] arr = { {1,4,7,11,15 },{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};

        int t = 20;

        System.out.println(search(arr,t));

    }

    public static boolean search(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        if (m == 1 && n==1) return matrix[0][0] == target;

        int L = Math.min(m,n);

        for (int i = 0; i <L; i++) {
            boolean v = binarySearch(matrix, target, i, true);
            boolean h = binarySearch(matrix, target, i, false);
            if (v || h) return true;
        }
        return false;
    }

    public static boolean binarySearch(int[][] arr, int target, int start, boolean v) {
        int end = v ? arr[0].length -1 : arr.length - 1;

        int c = start;

        while (start <= end) {

            int mid = (end + start) / 2;

            if (v) {
                if ((start + 1) == end || start == end) {
                    return arr[c][start] == target || arr[c][end] == target ;
                }
                if (arr[c][mid] < target) {
                    start = mid;
                } else if (arr[c][mid] > target) {
                    end = mid;
                } else {
                    return true;
                }
            } else {
                if ( (start + 1) == end || start == end) {
                    return arr[start][c] == target || arr[end][c] == target ;
                }
                if (arr[mid][c] < target) {
                    start = mid;
                } else if (arr[mid][c] > target) {
                    end = mid;
                } else {
                    return true;
                }
            }

        }
        return false;
    }



    public static boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        if (matrix[0][0] > target || target > matrix[m-1][n-1]) return false;
        if (matrix[0][0] == target || target == matrix[m-1][n-1]) return true;

        int x = m%2 == 0 ? m/2-1:m/2;
        int y = n%2 == 0 ? n/2-1:n/2;


        boolean x1 =  searchMatrix( getSub(matrix,0,0, x, y), target);

        boolean x2 =  searchMatrix( getSub(matrix,0,y+1, x, n-1), target);

        boolean x3 =  searchMatrix( getSub(matrix,x+1,0, m-1, y), target);

        boolean x4 =  searchMatrix( getSub(matrix,x+1,y+1, m-1, n-1), target);

        return x1 || x2 || x3 || x4;
    }


    private static int[][] getSub(int[][] matrix, int a, int b, int c, int d) {

        int[][] sub = new int[c - a + 1][ d - b + 1];
        if (a == c && b == d) {
            sub[0] = new  int[] {matrix[a][b]};
            return sub;
        }
        int k = 0;
        for (int i = a; i < c + 1; i++) {
            sub[k++] = Arrays.copyOfRange(matrix[i], b, d + 1);
        }
        return sub;
    }

}
