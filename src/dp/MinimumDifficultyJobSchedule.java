package dp;

/**
 * @author Quang-Khai TRAN
 * @date 10/10/2022
 */

public class MinimumDifficultyJobSchedule {

    public static void main(String[] args) {

        int[] arr = {6,5,4,3,2,1};
        int d = 3;
        D = d;
        N = arr.length;
        jobs = arr;
        System.out.println(dp(0, 1));
    }

    static int[] jobs;
    static int D;
    static int N;
    private static int dp(int i, int day) {
        if (day == D) {
            return max(i, N-1);
        }
        int j = N - (D - day);
        int res = Integer.MAX_VALUE;
        int max = -1;
        for (int x = i; x < j; x ++) {
            max = Math.max(max, jobs[x]);
            res = Math.min(res, max + dp( x + 1, day + 1));
        }
        return res;
    }

    private static int max(int i, int x) {
        int max = -1;
        for (int k = i;k <= x; k++) {
            max = Math.max(max, jobs[k]);
        }
        return max;
    }


}
