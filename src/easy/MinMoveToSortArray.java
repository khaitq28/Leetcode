package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinMoveToSortArray {


    public static void main(String ...args) {

        List<Integer> arr = Arrays.asList(2,4,1,3);

        System.out.println(sort(arr));

    }


    public static int sort(List<Integer> arr) {
        List<Integer> sorted = getSorted(arr);
        return getMoves(arr, sorted, 0 ,0);
    }


    //  2 4 1 3 = 4 1 3 2 = 1 4 3 2
    //
    //  1 2 3 4
    private static int getMoves(List<Integer> arr, List<Integer> sorted, int i ,int j) {

        if (arr.equals(sorted)) return 0;

        if (i >= arr.size() || j >= sorted.size())
            return 0;

        if (arr.get(i) < sorted.get(j)) {
            return 1 + getMoves(arr, sorted, i + 1, j + 1);
        } else {
           return  Math.max(getMoves(arr, sorted, i, j + 1), getMoves(arr, sorted, i + 1, j));
        }
    }

    private static List<Integer> getSorted(List<Integer> arr) {
        List<Integer> sorted = new ArrayList<>(arr);
        Collections.sort(sorted);
        return sorted;

    }
}
