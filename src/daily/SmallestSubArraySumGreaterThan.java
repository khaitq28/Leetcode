package daily;

/**
 * @author Quang-Khai TRAN
 * @date 30/03/2024
 */

public class SmallestSubArraySumGreaterThan {

    public static void main(String[] args) {
        SmallestSubArraySumGreaterThan main = new SmallestSubArraySumGreaterThan();
        System.out.println(main.smallestSumSubArrayGreaterThanK(7, new int[]{2,3,1,2,4,3}));
    }

    private int smallestSumSubArrayGreaterThanK(int k, int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while( j < n) {
            sum += arr[j];
            if (sum > k)
                min = Math.min(min, sum);
        }
        return min;
    }


}
