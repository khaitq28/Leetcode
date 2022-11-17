package dp;

/**
 * @author Quang-Khai TRAN
 * @date 26/09/2022
 */

public class PerformingMultiplicationOperations {
    int n;
    int m;
    public static void main(String[] args) {
        int[] nums = {-5,-3,-3,-2,7,1};
        int[] mul = {-10,-5,3,4,6};
        System.out.println(new PerformingMultiplicationOperations().maximumScore(nums, mul));
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        n = nums.length;
        m = multipliers.length;
        return dp(nums, 0, multipliers, 0);
    }
    private int dp(int[] nums, int b, int[] mul, int i) {
        if (i == m)
            return 0;

        int e = n-1 - i + b;

        int start = mul[i] * nums[b] + dp(nums, b+1, mul, i+1);
        int end = mul[i] * nums[e] + dp(nums, b, mul, i+1);

        return Math.max(start, end);
    }

}
