package dp;

/**
 * @author Quang-Khai TRAN
 * @date 07/10/2022
 */

public class CalculSum {

    public static void main(String[] args) {
        int[] arr = {2,4};
        int k = 10;

        System.out.println(check(arr, k));
    }

    private static boolean check(int[] arr, int k) {
        if (k ==0) return true;
        boolean res =false;
        for (int i : arr) {
            if (i <= k) {
                res = res || check(arr, k -i);
            }
        }
        return res;
    }

}
