package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinMoveToSortArrayV2 {


    public static void main(String ...args) {
        List<Integer> arr = Arrays.asList(2,4,1,3);
        System.out.println(sort(arr));
    }


    public static int sort(List<Integer> arr) {
        List<Integer> sorted = getSorted(arr);
        int max = sorted.get(sorted.size() - 1);


        int t = arr.size() -1;

        for (int i = t; i > 0; i --) {

        }

        return 0;
    }


    //  9 3 7 5 =
    //
    //  3 5 7 9
    private static int getMoves(List<Integer> arr, List<Integer> sorted) {
        int result = 0;




        return result;
    }

    private static List<Integer> getSorted(List<Integer> arr) {
        List<Integer> sorted = new ArrayList<>(arr);
        Collections.sort(sorted);
        return sorted;

    }
}
